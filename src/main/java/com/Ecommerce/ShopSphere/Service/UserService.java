package com.Ecommerce.ShopSphere.Service;


import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.Ecommerce.ShopSphere.Common.ApiResponse;
import com.Ecommerce.ShopSphere.DTO.User.UserDto;
import com.Ecommerce.ShopSphere.Exceptions.CustomException;
import com.Ecommerce.ShopSphere.Model.User;
import com.Ecommerce.ShopSphere.Repository.UserRepo;


import jakarta.transaction.Transactional;

@Service
public class UserService {
    
    @Autowired
    UserRepo userRepo;

    
    @Transactional //Make sure that complete function executes
    public ResponseEntity<ApiResponse> addNewUser(UserDto userDto) {
        //Check if User Already Exists
        if(Objects.nonNull(userRepo.findByEmail(userDto.getEmail()))){
            throw new CustomException("User already Exists");
        }
        //hash the password
        String EncryptedPassword=userDto.getPassword();
        
        //Store the user
        User user = new User(userDto.getFirstName(), userDto.getLastName(), userDto.getEmail(), EncryptedPassword);
        userRepo.save(user);

        //Store the token corresponding to user



        return new ResponseEntity<>(new ApiResponse(true, "User Created"),HttpStatus.OK);
    }
    
    
}
