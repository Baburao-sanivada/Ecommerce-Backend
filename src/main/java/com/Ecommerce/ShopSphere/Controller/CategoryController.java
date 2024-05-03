package com.Ecommerce.ShopSphere.Controller;

import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.ShopSphere.Common.ApiResponse;
import com.Ecommerce.ShopSphere.Model.Category;
import com.Ecommerce.ShopSphere.Service.CategoryService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/category")
public class CategoryController {
     
    @Autowired
    CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createCategory(@RequestBody Category category) {
        //TODO: process POST request
        categoryService.createCategory(category);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "category created"),HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<Category> getCategoryList() {
        return categoryService.getCategoryList();
    }

    @PostMapping("/update/{categoryId}")
    public ResponseEntity<ApiResponse> postMethodName(@PathVariable("categoryId") int categoryId,@RequestBody Category category) {
        //TODO: process POST request
        if(!categoryService.findById(categoryId)){
            return new ResponseEntity<ApiResponse>(new ApiResponse(false, "category does not exist"),HttpStatus.NOT_FOUND);
        }
        categoryService.updateCategory(categoryId,category);
        return new ResponseEntity<ApiResponse>(new ApiResponse(true, "category updated"),HttpStatus.OK);

    }
    
    
    
}
