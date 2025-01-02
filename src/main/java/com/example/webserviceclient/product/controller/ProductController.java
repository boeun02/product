package com.example.webserviceclient.product.controller;

import com.example.webserviceclient.product.dto.GetDto;
import com.example.webserviceclient.product.dto.SaveDto;
import com.example.webserviceclient.product.dto.UpdateDto;
import com.example.webserviceclient.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<Long> createProduct(@RequestBody SaveDto saveProductDto) {
        return ResponseEntity.ok(productService.createProduct(saveProductDto));
    }

    @GetMapping
    public ResponseEntity<List<GetDto>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id, @RequestBody UpdateDto updateProductDto) {
        productService.updateProduct(id, updateProductDto);
        return ResponseEntity.ok("수정 완료");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok("삭제 완료");
    }
}