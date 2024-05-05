package com.Ecommerce.ShopSphere.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.ShopSphere.DTO.Cart.AddToCartDto;
import com.Ecommerce.ShopSphere.Model.Cart;
import com.Ecommerce.ShopSphere.Model.Product;
import com.Ecommerce.ShopSphere.Model.User;
import com.Ecommerce.ShopSphere.Repository.CartRepo;

@Service
public class CartService {
    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private ProductService productService;

    public void addItemToCart(AddToCartDto addToCartDto, User user) {
        //check if valid product id
        Product product=productService.getProductById(addToCartDto.getProductId());

        Cart cart = new Cart(product, user, addToCartDto.getQuantity());

        cartRepo.save(cart);
    }
}
