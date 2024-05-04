package com.Ecommerce.ShopSphere.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ecommerce.ShopSphere.Model.WishList;

@Repository
public interface WishListRepo extends JpaRepository<WishList,Integer> {

    
}
