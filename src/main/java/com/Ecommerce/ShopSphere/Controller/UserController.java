package com.Ecommerce.ShopSphere.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.ShopSphere.Common.ApiResponse;
import com.Ecommerce.ShopSphere.DTO.User.UserDto;
import com.Ecommerce.ShopSphere.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService userService;

    //SignUp

    //SignUp
    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> signUpUser(@RequestBody UserDto userDto){
        return userService.addNewUser(userDto);
    } 
}
