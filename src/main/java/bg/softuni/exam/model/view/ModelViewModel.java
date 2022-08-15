package bg.softuni.exam.model.view;

import bg.softuni.exam.model.entity.enums.CategoryEnum;

public class ModelViewModel {

    private Long id;
    private String name;
    private CategoryEnum category;
    private String imageUrl;

    public String getName() {
        return name;
    }

    public ModelViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ModelViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public ModelViewModel setCategory(CategoryEnum category) {
        this.category = category;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ModelViewModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

}