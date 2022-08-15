package bg.softuni.exam.model.service;

import bg.softuni.exam.model.entity.enums.CategoryEnum;

public class ModelServiceModel {
    private Long id;
    private String name;
    private CategoryEnum category;
    private String imageUrl;

    public Long getId() {
        return id;
    }

    public ModelServiceModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public ModelServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public ModelServiceModel setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelServiceModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }


}