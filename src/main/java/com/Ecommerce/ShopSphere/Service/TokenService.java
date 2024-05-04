package com.Ecommerce.ShopSphere.Service;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Ecommerce.ShopSphere.Exceptions.AuthenticationFailedExcep;
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

    public User getUserWithToken(String token){
        AuthenticationToken authToken = tokenRepo.findByToken(token);
        if(Objects.isNull(authToken)) throw new AuthenticationFailedExcep("Invalid Token3");
        User user = authToken.getUser();
        return user;
    }

    public void authenticateUser(String token) {
        if(Objects.isNull(token)) {
            // throw an exception
            throw new AuthenticationFailedExcep("Invalid Token1");
        }
        AuthenticationToken authToken = tokenRepo.findByToken(token);
        if(Objects.isNull(authToken)) throw new AuthenticationFailedExcep("Invalid Token2");
    }
    
}
