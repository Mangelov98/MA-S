package bg.softuni.exam.service.impl;

import bg.softuni.exam.model.binding.ClothesAddBindModel;
import bg.softuni.exam.model.entity.ModelEntity;
import bg.softuni.exam.model.entity.ClothesEntity;
import bg.softuni.exam.model.entity.UserEntity;
import bg.softuni.exam.model.entity.UserRoleEntity;
import bg.softuni.exam.model.entity.enums.EngineEnum;
import bg.softuni.exam.model.entity.enums.UserRoleEnum;
import bg.softuni.exam.model.service.ClothesAddServiceModel;
import bg.softuni.exam.model.service.ClothesUpdateServiceModel;
import bg.softuni.exam.model.view.ClothesDetailsView;
import bg.softuni.exam.model.view.ClothesSummaryView;
import bg.softuni.exam.repository.ModelRepository;
import bg.softuni.exam.repository.ClothesRepository;
import bg.softuni.exam.repository.UserRepository;
import bg.softuni.exam.service.ClothesService;
import bg.softuni.exam.web.exception.ObjectNotFoundException;
import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ClothesServiceImpl implements ClothesService {

    private final ClothesRepository clothesRepository;
    private final ModelMapper modelMapper;
    private final ModelRepository modelRepository;
    private final UserRepository userRepository;

    public ClothesServiceImpl(ClothesRepository clothesRepository, ModelMapper modelMapper,
                              ModelRepository modelRepository, UserRepository userRepository) {
        this.clothesRepository = clothesRepository;
        this.modelMapper = modelMapper;
        this.modelRepository = modelRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void initializeClothes() {

        if (clothesRepository.count() == 0) {
            ClothesEntity clothes1 = new ClothesEntity();
            clothes1
                    .setModel(modelRepository.findById(1L).orElse(null))
                    .setEngine(EngineEnum.FEMALE)
                    .setPrice(140)
                    .setDescription("Staud Ida smocked poplin midi-dress.")
                    .setSeller(userRepository.findByUsername("pesho")
                            .orElse(null)) // or currentUser.getUserName()
                    .setImageUrl(
                            "https://assets.vogue.com/photos/60b109a2c34d796be0491186/1:1/w_1013,h_1013,c_limit/slide_20.jpg");

            ClothesEntity clothes2 = new ClothesEntity();
            clothes2
                    .setModel(modelRepository.findById(2L).orElse(null))
                    .setEngine(EngineEnum.MALE)
                    .setPrice(550)
                    .setDescription("Back by popular demand, our All American Classic Jean fits just like your old favorites used to. This is a regular (not relaxed) fit jean with a slightly tapered leg.")
                    .setSeller(userRepository.findByUsername("admin")
                            .orElse(null)) // or currentUser.getUserName()
                    .setImageUrl(
                            "https://media.gq.com/photos/60da183718480638c840cc4d/master/w_1280%2Cc_limit/Carhartt-relaxed-fit-tapered-leg-jean.jpg");

            clothesRepository.saveAll(List.of(clothes1, clothes2));
        }
    }

    @Override
    public List<ClothesSummaryView> getAllClothes() {
        return clothesRepository.
                findAll().
                stream().
                map(this::map).
                collect(Collectors.toList());
    }

    @Override
    public ClothesDetailsView findById(Long id, String currentUser) {
        ClothesDetailsView clothesDetailsView = this.clothesRepository.
                findById(id).
                map(o -> mapDetailsView(currentUser, o))
                .get();
        return clothesDetailsView;
    }

    @Override
    public void deleteClothes(Long id) {
        clothesRepository.deleteById(id);
    }

    public boolean isOwner(String userName, Long id) {
        Optional<ClothesEntity> clothesOpt = clothesRepository.
                findById(id);
        Optional<UserEntity> caller = userRepository.
                findByUsername(userName);

        if (clothesOpt.isEmpty() || caller.isEmpty()) {
            return false;
        } else {
            ClothesEntity clothesEntity = clothesOpt.get();

            return isAdmin(caller.get()) ||
                    clothesEntity.getSeller().getUsername().equals(userName);
        }
    }

    private boolean isAdmin(UserEntity user) {
        return user.
                getRoles().
                stream().
                map(UserRoleEntity::getRole).
                anyMatch(r -> r == UserRoleEnum.ADMIN);
    }


    @Override
    public void updateClothes(ClothesUpdateServiceModel clothesModel) {

        ClothesEntity clothesEntity =
                clothesRepository.findById(clothesModel.getId()).orElseThrow(() ->
                        new ObjectNotFoundException("Clothes with id " + clothesModel.getId() + " not found!"));

        clothesEntity.setPrice(clothesModel.getPrice())
                .setDescription(clothesModel.getDescription())
                .setEngine(clothesModel.getEngine())
                .setImageUrl(clothesModel.getImageUrl());

        clothesRepository.save(clothesEntity);
    }

    @Override
    public ClothesAddServiceModel addClothes(ClothesAddBindModel clothesAddBindModel, String ownerId) {
        UserEntity userEntity = userRepository.findByUsername(ownerId).orElseThrow();
        ClothesAddServiceModel clothesAddServiceModel = modelMapper.map(clothesAddBindModel,
                ClothesAddServiceModel.class);
        ClothesEntity newClothes = modelMapper.map(clothesAddServiceModel, ClothesEntity.class);
        newClothes.setCreated(Instant.now());
        newClothes.setSeller(userEntity);
        ModelEntity model = modelRepository.getById(clothesAddBindModel.getModelId());
        newClothes.setModel(model);

        ClothesEntity savedClothes = clothesRepository.save(newClothes);
        return modelMapper.map(savedClothes, ClothesAddServiceModel.class);
    }

    private ClothesSummaryView map(ClothesEntity clothesEntity) {
        ClothesSummaryView summaryView = this.modelMapper
                .map(clothesEntity, ClothesSummaryView.class);

        summaryView.setModel(clothesEntity.getModel().getName());
        summaryView.setBrand(clothesEntity.getModel().getBrand().getName());

        return summaryView;
    }

    private ClothesDetailsView mapDetailsView(String currentUser, ClothesEntity clothes) {
        ClothesDetailsView clothesDetailsView = this.modelMapper.map(clothes, ClothesDetailsView.class);
        clothesDetailsView.setCanDelete(isOwner(currentUser, clothes.getId()));
        clothesDetailsView.setModel(clothes.getModel().getName());
        clothesDetailsView.setBrand(clothes.getModel().getBrand().getName());
        clothesDetailsView.setSellerFullName(
                clothes.getSeller().getFirstName() + " " + clothes.getSeller().getLastName());
        return clothesDetailsView;
    }

    public long getTotal(){
       return clothesRepository.
               findAll().
               stream().
               map(this::map).count();
    }
}