package com.Ecommerce.ShopSphere.DTO.Cart;

import java.util.List;

public class CartItemResponse {
    private List<CartDto> cartdtos;
    private double price;
    public List<CartDto> getCartdtos() {
        return cartdtos;
    }
    public void setCartdtos(List<CartDto> cartdtos) {
        this.cartdtos = cartdtos;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public CartItemResponse(List<CartDto> cartdtos, double price) {
        this.cartdtos = cartdtos;
        this.price = price;
    }
    
}
