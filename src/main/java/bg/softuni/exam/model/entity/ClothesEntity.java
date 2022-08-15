package bg.softuni.exam.model.entity;

import bg.softuni.exam.model.entity.enums.EngineEnum;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "clothes")
public class ClothesEntity extends BaseEntity {

    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private EngineEnum engine;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String imageUrl;
    private int price;
    @ManyToOne
    private ModelEntity model;
    @ManyToOne
    private UserEntity seller;

    public String getDescription() {
        return description;
    }

    public ClothesEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public ClothesEntity setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ClothesEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }


    public int getPrice() {
        return price;
    }

    public ClothesEntity setPrice(int price) {
        this.price = price;
        return this;
    }


    public ModelEntity getModel() {
        return model;
    }

    public ClothesEntity setModel(ModelEntity model) {
        this.model = model;
        return this;
    }

    public UserEntity getSeller() {
        return seller;
    }

    public ClothesEntity setSeller(UserEntity seller) {
        this.seller = seller;
        return this;
    }

}