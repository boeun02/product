package com.example.webserviceclient.webClient.dto;


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseDto {

    private String status;
    private String message;

    @Builder
    public ResponseDto(String status, String message) {
        this.status = status;
        this.message = message;
    }
}