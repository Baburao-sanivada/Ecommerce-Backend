package com.Ecommerce.ShopSphere.Exceptions;

public class InvalidCartId extends IllegalArgumentException {
    public InvalidCartId(String msg){
        super(msg);
    }
}
