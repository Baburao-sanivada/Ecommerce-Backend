package com.Ecommerce.ShopSphere.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ecommerce.ShopSphere.Model.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {
    
}
