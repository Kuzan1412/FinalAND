package com.example.user.finaltest;

import java.io.Serializable;

public class ProductModel implements Serializable {
    private int id;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    private String product_name;
    private String producer;
    private String description;
    private int price;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ProductModel() {
    }

    public ProductModel(int id, String product_name, String producer, String description, int price) {

        this.id = id;
        this.product_name = product_name;
        this.producer = producer;
        this.description = description;
        this.price = price;
    }
}
