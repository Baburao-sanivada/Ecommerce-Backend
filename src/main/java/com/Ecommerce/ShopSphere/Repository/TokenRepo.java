package com.Ecommerce.ShopSphere.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ecommerce.ShopSphere.Model.AuthenticationToken;


@Repository
public interface TokenRepo extends JpaRepository<AuthenticationToken,Integer> {

    
} 
