package bg.softuni.exam.model.binding;

import bg.softuni.exam.model.entity.enums.EngineEnum;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class ClothesUpdateBindingModel {

    @NotNull
    @Min(100)
    private Integer price;

    private Long id;

    @NotBlank
    private String description;

    @NotNull
    private EngineEnum engine;

    @NotBlank
    private String imageUrl;


    public Long getId() {
        return id;
    }

    public ClothesUpdateBindingModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ClothesUpdateBindingModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public ClothesUpdateBindingModel setEngine(
            EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ClothesUpdateBindingModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }


    public Integer getPrice() {
        return price;
    }

    public ClothesUpdateBindingModel setPrice(Integer price) {
        this.price = price;
        return this;
    }

}