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

    public void updateCategory(int categoryId, Category newCategory) {
        Category category = categoryRepo.getReferenceById(categoryId);
        category.setCategoryName(newCategory.getCategoryName());
        category.setDescription(newCategory.getDescription());
        category.setImageUrl(newCategory.getImageUrl());
        categoryRepo.save(category);
    }

    public boolean findById(int categoryId){
        return categoryRepo.findById(categoryId).isPresent();
    }
}
