package bg.softuni.exam.service;


import bg.softuni.exam.model.binding.ClothesAddBindModel;
import bg.softuni.exam.model.service.ClothesAddServiceModel;
import bg.softuni.exam.model.service.ClothesUpdateServiceModel;
import bg.softuni.exam.model.view.ClothesDetailsView;
import bg.softuni.exam.model.view.ClothesSummaryView;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface ClothesService {


    void initializeClothes();

    List<ClothesSummaryView> getAllClothes();

    ClothesDetailsView findById(Long id, String currentUser);

    void deleteClothes(Long id);

    boolean isOwner(String userName, Long id);

    void updateClothes(ClothesUpdateServiceModel offerModel);

    ClothesAddServiceModel addClothes(ClothesAddBindModel clothesAddBindModel, String ownerId);

    long getTotal();

}