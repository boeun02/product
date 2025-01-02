package com.example.webserviceclient.webClient.service;

import com.example.webserviceclient.webClient.client.WebserviceClient;
import com.example.webserviceclient.webClient.dto.ResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class WebserviceService {

    private final WebserviceClient webserviceClient;

    @Autowired
    public WebserviceService(WebserviceClient webserviceClient) {
        this.webserviceClient = webserviceClient;
    }

    public Mono<ResponseDto> getResponse(String param) {
        return webserviceClient.getDataFromApi(param);
    }
}
