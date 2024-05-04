package com.Ecommerce.ShopSphere.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.ShopSphere.Common.ApiResponse;
import com.Ecommerce.ShopSphere.DTO.User.SignInDto;
import com.Ecommerce.ShopSphere.DTO.User.SignInResponseDto;
import com.Ecommerce.ShopSphere.DTO.User.UserDto;
import com.Ecommerce.ShopSphere.Service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserService userService;

    //SignUp
    @PostMapping("/signup")
    public ResponseEntity<ApiResponse> signUpUser(@RequestBody UserDto userDto){
        return userService.addNewUser(userDto);
    } 

    //SignIn
    @PostMapping("/signin")
    public SignInResponseDto postMethodName(@RequestBody SignInDto signInDto) {
        return userService.signin(signInDto);
    }
    

}
