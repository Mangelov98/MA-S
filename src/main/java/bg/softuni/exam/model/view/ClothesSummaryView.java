package bg.softuni.exam.model.view;

import bg.softuni.exam.model.entity.enums.EngineEnum;

public class ClothesSummaryView {

    private long id;
    private String description;
    private EngineEnum engine;
    private String imageUrl;
    private int price;
    private String model;
    private String brand;

    public long getId() {
        return id;
    }

    public ClothesSummaryView setId(long id) {
        this.id = id;
        return this;
    }

    public String getBrand() {
        return brand;
    }

    public ClothesSummaryView setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public ClothesSummaryView setDescription(String description) {
        this.description = description;
        return this;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public ClothesSummaryView setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public ClothesSummaryView setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }


    public int getPrice() {
        return price;
    }

    public ClothesSummaryView setPrice(int price) {
        this.price = price;
        return this;
    }


    public String getModel() {
        return model;
    }

    public ClothesSummaryView setModel(String model) {
        this.model = model;
        return this;
    }

}