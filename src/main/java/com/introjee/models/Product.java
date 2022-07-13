package com.introjee.models;

public class Product {
    private int id;
    private String name;
    private String brand;
    private String category;
    private double price;

    public Product(int id, String name, String marque, String category, double price) {
        this.id = id;
        this.name = name;
        this.brand = marque;
        this.category = category;
        this.price = price;
    }
    public Product(String name, String marque, String category, double price) {
        this.name = name;
        this.brand = marque;
        this.category = category;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarque() {
        return brand;
    }

    public void setMarque(String marque) {
        this.brand = marque;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                '}';
    }
}
