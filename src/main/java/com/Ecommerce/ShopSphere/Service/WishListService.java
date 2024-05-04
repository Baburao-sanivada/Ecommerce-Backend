package com.Ecommerce.ShopSphere.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.ShopSphere.DTO.ProductDto;
import com.Ecommerce.ShopSphere.Model.Product;
import com.Ecommerce.ShopSphere.Model.User;
import com.Ecommerce.ShopSphere.Model.WishList;
import com.Ecommerce.ShopSphere.Repository.WishListRepo;

@Service
public class WishListService {
    
    @Autowired
    private WishListRepo wishListRepo;

    @Autowired
    private ProductService productService;

    public void AddItemToWishList(User user,Product product){
        WishList instance = new WishList(user, product);
        wishListRepo.save(instance);
    }

    public List<ProductDto> getWishListItems(User user) {
       List<WishList> wishListItems=wishListRepo.findAllByUserOrderByCreatedDateDesc(user);
       List<ProductDto> productDtos = new ArrayList<>();
       for(WishList item:wishListItems){
        productDtos.add(productService.getProductDto(item.getProduct()));
       }
       return productDtos;
    }
}
