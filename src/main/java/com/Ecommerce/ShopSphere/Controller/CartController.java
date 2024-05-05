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
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    

    //Get all cart items
    @GetMapping("/list")
    public ResponseEntity<CartItemsResponse> getCartItems(@RequestHeader("token") String token) {
        //Validate user
        tokenService.authenticateUser(token);
        //Get the user
        User user = tokenService.getUserWithToken(token);

        CartItemsResponse items = cartService.getAllCartItems(user);
        return new ResponseEntity<>(items,HttpStatus.OK);
    }
    
    //delete cart item
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse> deleteCartItem(@RequestHeader("token") String token,@PathVariable("id") Integer cartItemId){
        //Validate user
        tokenService.authenticateUser(token);
        //Get the user
        User user = tokenService.getUserWithToken(token);
        
        cartService.deleteCartItem(cartItemId,user);
        return new ResponseEntity<>(new ApiResponse(true, "Successfully deleted the item"),HttpStatus.OK);
    }

}
