package bg.softuni.exam.service;

import bg.softuni.exam.model.view.BrandViewModel;
import java.util.List;

public interface BrandService {

    void initializeBrand();

    List<BrandViewModel> getAllBrands();
}