package com.example.webserviceclient.product.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

@Entity
@Table(name = "product")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Comment("아이디")
    private Long id;

    @Column(name = "name", nullable = false, length = 64)
    @Comment("이름")
    private String name;

    @Column(name = "price", nullable = false, length = 64)
    @Comment("가격")
    private double price;

    @Builder
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public void update(String name, double price) {
        this.name = name;
        this.price = price;
    }
}