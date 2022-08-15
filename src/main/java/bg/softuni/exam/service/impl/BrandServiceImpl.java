package bg.softuni.exam.service.impl;

import bg.softuni.exam.model.entity.BrandEntity;
import bg.softuni.exam.model.entity.ModelEntity;
import bg.softuni.exam.model.view.BrandViewModel;
import bg.softuni.exam.model.view.ModelViewModel;
import bg.softuni.exam.repository.BrandRepository;
import bg.softuni.exam.service.BrandService;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements BrandService {

    private final BrandRepository brandRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(BrandRepository brandRepository, ModelMapper modelMapper) {
        this.brandRepository = brandRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public void initializeBrand() {
        if (brandRepository.count() == 0) {
            BrandEntity clothes = new BrandEntity();
            clothes.setName("Clothes");

            brandRepository.save(clothes);
        }
    }

    @Override
    public List<BrandViewModel> getAllBrands() {
        return brandRepository.findAll()
                .stream()
                .map(brandEntity -> {
                    BrandViewModel brandViewModel = new BrandViewModel().
                            setName(brandEntity.getName());

                    brandViewModel.setModels(
                            brandEntity.
                                    getModels().
                                    stream().
                                    map(this::map).
                                    collect(Collectors.toList()));
                    return brandViewModel;
                })
                .collect(Collectors.toList());
    }

    private ModelViewModel map(ModelEntity modelEntity) {
        return modelMapper.map(modelEntity, ModelViewModel.class);
    }
}