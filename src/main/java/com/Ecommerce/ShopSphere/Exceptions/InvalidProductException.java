package com.Ecommerce.ShopSphere.Exceptions;

public class InvalidProductException extends IllegalArgumentException{
    
    public InvalidProductException(String msg){
        super(msg);
    }
}
