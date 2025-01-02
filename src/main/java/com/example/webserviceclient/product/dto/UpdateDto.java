package com.example.webserviceclient.product.dto;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UpdateDto {
    private String name;
    private double price;

    @Builder
    public UpdateDto(String name, double price) {
        this.name = name;
        this.price = price;
    }
}
