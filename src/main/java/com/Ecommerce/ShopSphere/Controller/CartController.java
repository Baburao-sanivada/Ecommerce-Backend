package com.Ecommerce.ShopSphere.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.ShopSphere.Common.ApiResponse;
import com.Ecommerce.ShopSphere.DTO.Cart.AddToCartDto;
import com.Ecommerce.ShopSphere.DTO.Cart.CartItemsResponse;
import com.Ecommerce.ShopSphere.Model.User;
import com.Ecommerce.ShopSphere.Service.CartService;
import com.Ecommerce.ShopSphere.Service.TokenService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> addItemToCart(@RequestBody AddToCartDto addToCartDto,@RequestHeader("token") String token) {
        //Validate user
        tokenService.authenticateUser(token);
        //Get the user
        User user = tokenService.getUserWithToken(token);

        //add Item To cart
        cartService.addItemToCart(addToCartDto,user);

        return new ResponseEntity<>(new ApiResponse(true,"Added Item To Cart"),HttpStatus.OK);
    }
    
    @GetMapping("/list")
    public ResponseEntity<CartItemsResponse> getCartItems(@RequestHeader("token") String token) {
        //Validate user
        tokenService.authenticateUser(token);
        //Get the user
        User user = tokenService.getUserWithToken(token);

        CartItemsResponse items = cartService.getAllCartItems(user);
        return new ResponseEntity<>(items,HttpStatus.OK);
    }
    

}
