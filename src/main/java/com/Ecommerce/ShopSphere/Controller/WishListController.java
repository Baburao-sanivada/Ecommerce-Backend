package com.Ecommerce.ShopSphere.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.ShopSphere.Common.ApiResponse;
import com.Ecommerce.ShopSphere.DTO.ProductDto;
import com.Ecommerce.ShopSphere.Model.Product;
import com.Ecommerce.ShopSphere.Model.User;
import com.Ecommerce.ShopSphere.Service.TokenService;
import com.Ecommerce.ShopSphere.Service.WishListService;

import springfox.documentation.swagger.web.ApiResourceController;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/wishlist")
public class WishListController {
    
    @Autowired
    WishListService wishListService;

    @Autowired
    TokenService tokenService;

    //Add item to wishList
    @PostMapping("/add")
    public ResponseEntity<ApiResponse> AddWishListItem(@RequestHeader("token") String token,@RequestBody Product product) {
        //Authorize the token
        tokenService.authenticateUser(token);

        //Get the user
        User user = tokenService.getUserWithToken(token);

        //Save the item in wishlist
        wishListService.AddItemToWishList(user,product);

        return new ResponseEntity<>(new ApiResponse(true, "Added Item to wishList"),HttpStatus.OK);
    }

    //Get all WishList items
    @GetMapping("/items/{token}")
    public ResponseEntity<List<ProductDto>> getWishListItems(@PathVariable("token") String token) {

        //Authorize the token
        tokenService.authenticateUser(token);

        //Get the user
        User user = tokenService.getUserWithToken(token);

        List<ProductDto> products=wishListService.getWishListItems(user);

        return new ResponseEntity<List<ProductDto>>(products, HttpStatus.OK);

    }
    
    
    
}
