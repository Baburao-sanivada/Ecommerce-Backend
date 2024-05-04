package com.Ecommerce.ShopSphere.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ecommerce.ShopSphere.Model.AuthenticationToken;
import com.Ecommerce.ShopSphere.Model.User;


@Repository
public interface TokenRepo extends JpaRepository<AuthenticationToken,Integer> {

    AuthenticationToken findByUser(User user);

    
} 
