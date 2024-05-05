package com.Ecommerce.ShopSphere.DTO.Cart;

import com.Ecommerce.ShopSphere.Model.Product;

public class CartDto {
    private Integer id;
    private Integer quantity;
    private Product product;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public CartDto() {
    }
    public CartDto(Integer id, Product product, Integer quantity) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
    }
    
}
