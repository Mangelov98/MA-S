package bg.softuni.exam.model.binding;

import bg.softuni.exam.model.entity.enums.CategoryEnum;
import bg.softuni.exam.model.entity.enums.EngineEnum;

import java.math.BigDecimal;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

public class ClothesAddBindModel {
    private Long id;
    @NotNull
    private Long modelId;
    @NotNull
    @DecimalMin("100")
    private BigDecimal price;
    @NotNull
    private EngineEnum engine;
    @NotEmpty
    private String description;
    @NotEmpty
    private String imageUrl;

    public Long getModelId() {
        return modelId;
    }

    public ClothesAddBindModel setModelId(Long modelId) {
        this.modelId = modelId;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ClothesAddBindModel setId(Long id) {
        this.id = id;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public ClothesAddBindModel setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public ClothesAddBindModel setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }


    public String getDescription() {
        return description;
    }

    public ClothesAddBindModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ClothesAddBindModel setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }
}