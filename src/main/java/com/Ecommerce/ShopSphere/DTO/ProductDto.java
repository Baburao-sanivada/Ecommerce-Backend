package com.Ecommerce.ShopSphere.DTO;

import jakarta.validation.constraints.NotBlank;

public class ProductDto {
    
    @NotBlank(message = "product name is mandatory")
    private String name;
     @NotBlank(message = "product Image is mandatory")
    private String imageURL;
     @NotBlank(message = "product price is mandatory")
    private double price;
     @NotBlank(message = "product description is mandatory")
    private String description;
     @NotBlank(message = "product category is mandatory")
    private Integer categoryId;

    public ProductDto(){

    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getImageURL() {
        return imageURL;
    }
    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
