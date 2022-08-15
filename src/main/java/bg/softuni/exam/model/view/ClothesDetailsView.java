package bg.softuni.exam.model.view;

import bg.softuni.exam.model.entity.enums.EngineEnum;

import java.time.Instant;

public class ClothesDetailsView {
    private String description;

    private EngineEnum engine;

    private Instant created;

    private Instant modified;

    private String imageUrl;

    private String sellerFullName;

    private int price;

    private String model;

    private String brand;

    private Long id;

    private boolean canDelete;

    public ClothesDetailsView() {
    }

    public boolean isCanDelete() {
        return canDelete;
    }

    public ClothesDetailsView setCanDelete(boolean canDelete) {
        this.canDelete = canDelete;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public ClothesDetailsView setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getSellerFullName() {
        return sellerFullName;
    }

    public ClothesDetailsView setSellerFullName(String sellerFullName) {
        this.sellerFullName = sellerFullName;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ClothesDetailsView setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public ClothesDetailsView setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public Instant getCreated() {
        return created;
    }

    public ClothesDetailsView setCreated(Instant created) {
        this.created = created;
        return this;
    }

    public Instant getModified() {
        return modified;
    }

    public ClothesDetailsView setModified(Instant modified) {
        this.modified = modified;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ClothesDetailsView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }


    public int getPrice() {
        return price;
    }

    public ClothesDetailsView setPrice(int price) {
        this.price = price;
        return this;
    }


    public String getModel() {
        return model;
    }

    public ClothesDetailsView setModel(String model) {
        this.model = model;
        return this;
    }

    public Long getId() {
        return id;
    }

    public ClothesDetailsView setId(Long id) {
        this.id = id;
        return this;
    }
}