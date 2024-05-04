package com.Ecommerce.ShopSphere.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.ShopSphere.Model.Product;
import com.Ecommerce.ShopSphere.Model.User;
import com.Ecommerce.ShopSphere.Model.WishList;
import com.Ecommerce.ShopSphere.Repository.WishListRepo;

@Service
public class WishListService {
    
    @Autowired
    private WishListRepo wishListRepo;

    public void AddItemToWishList(User user,Product product){
        WishList instance = new WishList(user, product);
        wishListRepo.save(instance);
    }
}
