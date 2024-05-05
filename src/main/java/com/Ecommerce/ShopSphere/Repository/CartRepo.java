package com.Ecommerce.ShopSphere.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ecommerce.ShopSphere.Model.Cart;

@Repository
public interface CartRepo extends JpaRepository<Cart,Integer> {
    
}
