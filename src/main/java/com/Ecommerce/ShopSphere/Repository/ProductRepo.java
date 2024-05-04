package com.Ecommerce.ShopSphere.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Ecommerce.ShopSphere.Model.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {

    
} 
