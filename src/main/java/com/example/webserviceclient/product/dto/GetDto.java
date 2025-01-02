package com.example.webserviceclient.product.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GetDto {
    private Long id;
    private String name;
    private double price;

    @Builder
    public GetDto(Long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}