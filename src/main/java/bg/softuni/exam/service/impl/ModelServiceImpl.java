package bg.softuni.exam.service.impl;

import bg.softuni.exam.model.entity.BrandEntity;
import bg.softuni.exam.model.entity.ModelEntity;
import bg.softuni.exam.model.entity.enums.CategoryEnum;
import bg.softuni.exam.repository.BrandRepository;
import bg.softuni.exam.repository.ModelRepository;
import bg.softuni.exam.service.ModelService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class ModelServiceImpl implements ModelService {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;

    public ModelServiceImpl(ModelRepository modelRepository, BrandRepository brandRepository) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
    }

    @Override
    public void initializeModels() {
        if (modelRepository.count() == 0) {
            BrandEntity clothes = brandRepository.findByName("Clothes")
                    .orElseThrow(IllegalArgumentException::new);

            ModelEntity dress = new ModelEntity();
            dress
                    .setName("Dress")
                    .setCategory(CategoryEnum.DRESS)
                    .setImageUrl("https://assets.vogue.com/photos/60b109a2c34d796be0491186/1:1/w_1013,h_1013,c_limit/slide_20.jpg")
                    .setBrand(clothes);

            ModelEntity jean = new ModelEntity();
            jean
                    .setName("Jean")
                    .setCategory(CategoryEnum.JEAN)
                    .setImageUrl("https://media.gq.com/photos/60da183718480638c840cc4d/master/w_1280%2Cc_limit/Carhartt-relaxed-fit-tapered-leg-jean.jpg")
                    .setBrand(clothes);

            modelRepository.saveAll(List.of(dress, jean));
        }
    }
}