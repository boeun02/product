package com.example.webserviceclient.webClient.controller;

import com.example.webserviceclient.webClient.dto.ResponseDto;
import com.example.webserviceclient.webClient.service.WebserviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class WebserviceController {

    private final WebserviceService webserviceService;

    @Autowired
    public WebserviceController(WebserviceService webserviceService) {
        this.webserviceService = webserviceService;
    }

    @GetMapping("/fetchData")
    public Mono<ResponseEntity<ResponseDto>> fetchData(@RequestParam String param) {
        return webserviceService.getResponse(param)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}
