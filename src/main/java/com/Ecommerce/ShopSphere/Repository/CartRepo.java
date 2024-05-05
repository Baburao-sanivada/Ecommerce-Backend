package com.Ecommerce.ShopSphere.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Ecommerce.ShopSphere.Model.Cart;
import com.Ecommerce.ShopSphere.Model.User;

@Repository
public interface CartRepo extends JpaRepository<Cart,Integer> {

   List<Cart> getAllItemsByUserOrderByCreatedDateDesc(User user);
    
}
