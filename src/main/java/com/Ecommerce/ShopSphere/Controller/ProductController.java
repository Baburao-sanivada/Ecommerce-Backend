package com.Ecommerce.ShopSphere.Controller;

import java.util.List;
import java.util.Optional;
import com.Ecommerce.ShopSphere.Model.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Ecommerce.ShopSphere.Common.ApiResponse;
import com.Ecommerce.ShopSphere.DTO.ProductDto;
import com.Ecommerce.ShopSphere.Repository.CategoryRepo;
import com.Ecommerce.ShopSphere.Service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;



@RestController
@RequestMapping("/product")
public class ProductController {
    
    @Autowired
    ProductService productService;

    @Autowired
    CategoryRepo categoryRepo;

    @PostMapping("/add")
    public ResponseEntity<ApiResponse> createProduct(@RequestBody ProductDto productDto) {
        Optional<Category> optionalCategory=categoryRepo.findById(productDto.getCategoryId());
        if(!optionalCategory.isPresent()){
            return new ResponseEntity<>(new ApiResponse(false, "Category not found"),HttpStatus.NOT_FOUND);
        }
        productService.CreateProduct(productDto,optionalCategory.get());
        return new ResponseEntity<>(new ApiResponse(true, "Product added"),HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProductDto>> getProductsList() {
        List<ProductDto> productDtos = productService.getProductsList();
        return new ResponseEntity<>(productDtos,HttpStatus.OK);
    }
    
    
}
