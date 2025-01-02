package com.example.webserviceclient.product.service;

import com.example.webserviceclient.product.dto.SaveDto;
import com.example.webserviceclient.product.dto.UpdateDto;
import com.example.webserviceclient.product.entity.Product;
import com.example.webserviceclient.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product createProduct(SaveDto saveProductDto) {
        Product product = Product.builder()
                .name(saveProductDto.getName())
                .price(saveProductDto.getPrice())
                .build();
        return productRepository.save(product);
    }

    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(Long id, UpdateDto updateProductDto) {
        return productRepository.findById(id)
                .map(product -> {
                    product.update(updateProductDto.getName(), updateProductDto.getPrice());
                    return productRepository.save(product);
                })
                .orElseThrow(() -> new IllegalArgumentException("Product id를 찾을 수 없습니다: " + id));
    }

    public void deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
        } else {
            throw new IllegalArgumentException("Product id를 찾을 수 없습니다:" + id);
        }
    }
}
