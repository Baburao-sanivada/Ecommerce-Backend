package com.Ecommerce.ShopSphere.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ecommerce.ShopSphere.Model.Category;
import com.Ecommerce.ShopSphere.Repository.CategoryRepo;

@Service
public class CategoryService {
    
    @Autowired
    CategoryRepo categoryRepo;

    public String createCategory(Category category){
        categoryRepo.save(category);
        return "Success";
    }

    public List<Category> getCategoryList(){
        return categoryRepo.findAll();
    }
}
