package com.Ecommerce.ShopSphere.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.ShopSphere.DTO.Cart.AddToCartDto;
import com.Ecommerce.ShopSphere.DTO.Cart.CartDto;
import com.Ecommerce.ShopSphere.DTO.Cart.CartItemsResponse;
import com.Ecommerce.ShopSphere.Exceptions.InvalidCartId;
import com.Ecommerce.ShopSphere.Model.Cart;
import com.Ecommerce.ShopSphere.Model.Product;
import com.Ecommerce.ShopSphere.Model.User;
import com.Ecommerce.ShopSphere.Repository.CartRepo;

@Service
public class CartService {
    @Autowired
    private CartRepo cartRepo;

    @Autowired
    private ProductService productService;

    public void addItemToCart(AddToCartDto addToCartDto, User user) {
        //check if valid product id
        Product product=productService.getProductById(addToCartDto.getProductId());

        Cart cart = new Cart(product, user, addToCartDto.getQuantity());

        cartRepo.save(cart);
    }

    public CartItemsResponse getAllCartItems(User user) {
        List<Cart> cartItems = cartRepo.getAllItemsByUserOrderByCreatedDateDesc(user);

        List<CartDto> cartDtos = new ArrayList<>();
        double price = 0;
        for(Cart cartItem: cartItems){
            CartDto cartDto = new CartDto(cartItem.getId(), cartItem.getProduct(), cartItem.getQuantity());
            price += cartDto.getQuantity() * cartDto.getProduct().getPrice();
            cartDtos.add(cartDto);
        }

        CartItemsResponse cartItemResponse = new CartItemsResponse(cartDtos, price);
        return cartItemResponse;
    }

    public void deleteCartItem(Integer cartId) {
        Optional<Cart> cartItem = cartRepo.findById(cartId);
        if(cartItem.isEmpty()){
            throw new InvalidCartId("There is no cart item present with id: "+cartId);
        }
        cartRepo.deleteById(cartId);
    }

}
