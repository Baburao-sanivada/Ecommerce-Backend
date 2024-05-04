package com.Ecommerce.ShopSphere.DTO.User;

public class SignInResponseDto {
    private String Status;
    private String token;
    public String getStatus() {
        return Status;
    }
    public void setStatus(String status) {
        Status = status;
    }
    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public SignInResponseDto(String status, String token) {
        Status = status;
        this.token = token;
    }


}
