package com.Ecommerce.ShopSphere.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.ShopSphere.Common.StripeResponse;
import com.Ecommerce.ShopSphere.DTO.Checkout.CheckoutItemDto;
import com.Ecommerce.ShopSphere.Service.CheckoutService;
import com.Ecommerce.ShopSphere.Service.TokenService;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/checkout")
public class CheckoutController {
    
    @Autowired
    private TokenService tokenService;

    @Autowired
    private CheckoutService checkoutService;

    @PostMapping("/stripe")
    public ResponseEntity<StripeResponse> checkout(@RequestBody List<CheckoutItemDto> checkoutItems) throws StripeException {
        Session session = checkoutService.CreateSession(checkoutItems);
        StripeResponse stripeResponse= new StripeResponse(session.getId());
        return new ResponseEntity<>(stripeResponse,HttpStatus.OK);
    }
    

}
