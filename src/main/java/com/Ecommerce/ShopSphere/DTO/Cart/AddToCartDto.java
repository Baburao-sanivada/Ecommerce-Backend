package com.Ecommerce.ShopSphere.DTO.Cart;

public class AddToCartDto {

    private Integer id;
    private Integer productId;
    private Integer quantity;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getProductId() {
        return productId;
    }
    public void setProductId(Integer productId) {
        this.productId = productId;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public AddToCartDto() {
    }
    
}
