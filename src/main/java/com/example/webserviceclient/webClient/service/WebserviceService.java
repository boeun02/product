package com.example.webserviceclient.webClient.service;

import com.example.webserviceclient.webClient.client.WebserviceClient;
import com.example.webserviceclient.webClient.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class WebserviceService {

    private final WebserviceClient webserviceClient;

    public Mono<ResponseDto> getResponse(String param) {
        return webserviceClient.getDataFromApi(param);
    }
}