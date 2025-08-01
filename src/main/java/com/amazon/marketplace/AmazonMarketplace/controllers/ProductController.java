package com.amazon.marketplace.AmazonMarketplace.controllers;

import com.amazon.marketplace.AmazonMarketplace.dtos.ProductDto;
import com.amazon.marketplace.AmazonMarketplace.services.impl.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productDto));
    }

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @GetMapping("/seller/{sellerId}")
    public ResponseEntity<List<ProductDto>> getProductsBySellerId(@PathVariable int sellerId) {
        List<ProductDto> products = productService.getProductsBySellerId(sellerId);
        return ResponseEntity.ok(products);
    }

    @PutMapping("{id}")
    public ResponseEntity<ProductDto> updateProductById(@PathVariable int id, @RequestBody ProductDto productDto) {
        ProductDto updatedProductDto = productService.updateProductById(id, productDto);
        return ResponseEntity.ok(updatedProductDto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable int id) {
        return ResponseEntity.ok(productService.deleteProductById(id));
    }

}
