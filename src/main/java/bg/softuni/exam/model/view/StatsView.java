package bg.softuni.exam.model.view;

import bg.softuni.exam.service.ClothesService;

public class StatsView {


    private final ClothesService clothesService;

    public StatsView(ClothesService clothesService) {

        this.clothesService = clothesService;
    }

    public long getTotalProducts() {
        return clothesService.getTotal();
    }


}