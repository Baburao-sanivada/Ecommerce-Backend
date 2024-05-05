package com.Ecommerce.ShopSphere.Common;

public class StripeResponse {
    private String Session;

    public StripeResponse() {
    }

    public StripeResponse(String session) {
        Session = session;
    }

    public String getSession() {
        return Session;
    }

    public void setSession(String session) {
        Session = session;
    }

}
