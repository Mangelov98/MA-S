package bg.softuni.exam.model.service;

import bg.softuni.exam.model.entity.enums.EngineEnum;

public class ClothesUpdateServiceModel {

    private String description;
    private EngineEnum engine;
    private String imageUrl;
    private int price;
    private Long id;

    public String getDescription() {
        return description;
    }

    public ClothesUpdateServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public ClothesUpdateServiceModel setEngine(
            EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ClothesUpdateServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }


    public int getPrice() {
        return price;
    }

    public ClothesUpdateServiceModel setPrice(int price) {
        this.price = price;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ClothesUpdateServiceModel setId(Long id) {
        this.id = id;
        return this;
    }
}