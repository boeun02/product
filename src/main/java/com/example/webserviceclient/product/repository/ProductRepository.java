package com.example.webserviceclient.product.repository;

import com.example.webserviceclient.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}