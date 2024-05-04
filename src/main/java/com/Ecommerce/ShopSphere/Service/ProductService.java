package com.Ecommerce.ShopSphere.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Ecommerce.ShopSphere.DTO.ProductDto;
import com.Ecommerce.ShopSphere.Model.Category;
import com.Ecommerce.ShopSphere.Model.Product;
import com.Ecommerce.ShopSphere.Repository.ProductRepo;

@Service
public class ProductService {
    
    @Autowired
    ProductRepo productRepo;

    public void CreateProduct(ProductDto productDto, Category category) {
        Product product = new Product();
        product.setProductName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageURL());
        product.setPrice(productDto.getPrice());
        product.setCategory(category);
        productRepo.save(product);
    }
    public ProductDto getProductDto(Product product){
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getProductName());
        productDto.setDescription(product.getDescription());
        productDto.setImageURL(product.getImageUrl());
        productDto.setPrice(product.getPrice());
        productDto.setCategoryId(product.getCategory().getId());
        return productDto;
    }
    public List<ProductDto> getProductsList() {
        List<Product> products = productRepo.findAll();
        List<ProductDto> response = new ArrayList<>();
        for(Product product:products){
            response.add(getProductDto(product));
        }
        return response;
    }
    public void updateProduct(ProductDto productDto,Integer productId) {
        Product product = productRepo.getReferenceById(productId);
        product.setProductName(productDto.getName());
        product.setDescription(productDto.getDescription());
        product.setImageUrl(productDto.getImageURL());
        product.setPrice(productDto.getPrice());
        productRepo.save(product);
    }
}
