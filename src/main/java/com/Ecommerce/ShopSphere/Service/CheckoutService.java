package com.Ecommerce.ShopSphere.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.Ecommerce.ShopSphere.DTO.Checkout.CheckoutItemDto;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import com.stripe.param.checkout.SessionCreateParams.LineItem;
import com.stripe.param.checkout.SessionCreateParams.LineItem.PriceData;
import com.stripe.param.checkout.SessionCreateParams.LineItem.PriceData.ProductData;

@Service
public class CheckoutService {

    @Value("${STRIPE_SECRET_KEY}")
    private String StripeSecretKey;

    @Value("${BASE_URL}")
    private String BASE_URL;

    public Session CreateSession(List<CheckoutItemDto> checkoutItems) throws StripeException {
        Stripe.apiKey = StripeSecretKey;
        List<SessionCreateParams.LineItem> sessionItemList = new ArrayList<>();
        for(CheckoutItemDto checkoutItem:checkoutItems){
            sessionItemList.add(createSessionListItem(checkoutItem));
        }
        String success_url = "http://sitename.com/checkout-success";
        String cancel_url = "http://sitename.com/checkout-cancel";
        SessionCreateParams params = SessionCreateParams.builder()
                .addPaymentMethodType(SessionCreateParams.PaymentMethodType.CARD)
                .setMode(SessionCreateParams.Mode.PAYMENT)
                .setCancelUrl(success_url)
                .addAllLineItem(sessionItemList)
                .setSuccessUrl(cancel_url)
                .build();
        return Session.create(params);
    }

    private LineItem createSessionListItem(CheckoutItemDto checkoutItem) {
        return SessionCreateParams.LineItem.builder().setPriceData(CreatePriceData(checkoutItem)).setQuantity((long)checkoutItem.getQuantity()).build();
    }

    private PriceData CreatePriceData(CheckoutItemDto checkoutItem) {
        return SessionCreateParams.LineItem.PriceData.builder().setCurrency("usd").setUnitAmount((long)checkoutItem.getPrice()).setProductData(getProductData(checkoutItem)).build();
    }

    private ProductData getProductData(CheckoutItemDto checkoutItem) {
        return SessionCreateParams.LineItem.PriceData.ProductData.builder()
                            .setName(checkoutItem.getProductName())
                            .build();
    }
    
}
