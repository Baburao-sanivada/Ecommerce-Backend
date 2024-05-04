package com.Ecommerce.ShopSphere.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.ShopSphere.Repository.UserRepo;

@Service
public class UserService {
    
    @Autowired
    UserRepo userRepo;
}
