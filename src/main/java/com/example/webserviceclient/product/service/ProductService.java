package com.example.webserviceclient.product.service;


import com.example.webserviceclient.product.dto.GetDto;
import com.example.webserviceclient.product.dto.SaveDto;
import com.example.webserviceclient.product.dto.UpdateDto;
import com.example.webserviceclient.product.entity.Product;
import com.example.webserviceclient.product.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    @Transactional
    public Long createProduct(SaveDto saveProductDto) {
        Product product = Product.builder()
                .name(saveProductDto.getName())
                .price(saveProductDto.getPrice())
                .build();
        return productRepository.save(product).getId();
    }

    @Transactional
    public void updateProduct(Long id, UpdateDto updateDto) {
        Product product = findMenuById(id);
        product.update(updateDto.getName(), updateDto.getPrice());
    }

    @Transactional
    public void deleteProduct(Long id) {
        Product product = findMenuById(id);
        productRepository.delete(product);
    }

    public List<GetDto> getAllProducts() {
        List<GetDto> products = productRepository.findAll().stream()
                .map(product -> GetDto.builder()
                        .id(product.getId())
                        .name(product.getName())
                        .price(product.getPrice())
                        .build())
                .collect(Collectors.toList());
        return products;
    }

    public Product findMenuById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 아이디가 없습니다. id =" + id));
    }
}