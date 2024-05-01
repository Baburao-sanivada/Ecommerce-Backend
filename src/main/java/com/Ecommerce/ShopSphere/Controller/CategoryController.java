package com.Ecommerce.ShopSphere.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.ShopSphere.Model.Category;
import com.Ecommerce.ShopSphere.Service.CategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;




@RestController
@RequestMapping("/category")
public class CategoryController {
     
    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public String createCategory(@RequestBody Category category) {
        //TODO: process POST request
        categoryService.createCategory(category);
        return "Success";
    }

    @GetMapping("/list")
    public List<Category> getCategoryList() {
        return categoryService.getCategoryList();
    }
    
    
}
