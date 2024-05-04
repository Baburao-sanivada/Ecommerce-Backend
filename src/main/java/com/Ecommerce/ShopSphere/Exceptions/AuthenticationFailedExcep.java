package com.Ecommerce.ShopSphere.Exceptions;

public class AuthenticationFailedExcep extends IllegalArgumentException {
    
    public AuthenticationFailedExcep(String msg){
        super(msg);
    }
}
