package bg.softuni.exam.model.service;

import bg.softuni.exam.model.entity.enums.CategoryEnum;
import bg.softuni.exam.model.entity.enums.EngineEnum;

public class ClothesAddServiceModel {
    private Long id;
    private CategoryEnum modelId;
    private String description;
    private EngineEnum engine;
    private String imageUrl;
    private int price;

    public Long getId() {
        return id;
    }

    public ClothesAddServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public CategoryEnum getModelId() {
        return modelId;
    }

    public ClothesAddServiceModel setModelId(CategoryEnum modelId) {
        this.modelId = modelId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ClothesAddServiceModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public ClothesAddServiceModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ClothesAddServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }


    public int getPrice() {
        return price;
    }

    public ClothesAddServiceModel setPrice(int price) {
        this.price = price;
        return this;
    }



}