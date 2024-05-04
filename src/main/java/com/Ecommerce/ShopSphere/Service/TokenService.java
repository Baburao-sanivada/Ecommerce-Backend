package com.Ecommerce.ShopSphere.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.ShopSphere.DTO.User.SignInResponseDto;
import com.Ecommerce.ShopSphere.Model.AuthenticationToken;
import com.Ecommerce.ShopSphere.Model.User;
import com.Ecommerce.ShopSphere.Repository.TokenRepo;

@Service
public class TokenService {

    @Autowired
    TokenRepo tokenRepo;

    public void saveToken(AuthenticationToken authenticationToken) {
        tokenRepo.save(authenticationToken);
    }

    public AuthenticationToken getAuthToken(User user) {
        return tokenRepo.findByUser(user);
    }
    
}
