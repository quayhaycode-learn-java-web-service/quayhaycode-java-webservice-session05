package com.reptithcm.edu.assign.controller;

import com.reptithcm.edu.assign.entity.Product;
import com.reptithcm.edu.assign.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1")
@AllArgsConstructor
@RestController
public class ProductController {
    private final ProductRepository productRepository;
    @GetMapping("/products")
    public List<Product> getProduct(){
        return productRepository.findAll();
    }

    @PostMapping("/products")
    public Product postProduct(@RequestBody Product request){
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        return productRepository.save(product);
    }

    @PutMapping("/products/{id}")
    public Product putProduct(@PathVariable long id, @RequestBody Product request){
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        return productRepository.save(product);
    }

    @DeleteMapping("/products/{id}")
    public boolean deleteProduct(@PathVariable Long id){
        Product product = productRepository.findById(id).orElseThrow(() -> new RuntimeException(""));
        productRepository.delete(product);
        return true;
    }

}
