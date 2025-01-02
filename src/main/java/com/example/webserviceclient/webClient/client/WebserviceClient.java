package com.example.webserviceclient.webClient.client;

import com.example.webserviceclient.webClient.dto.ResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class WebserviceClient {

    private final WebClient webClient;

    @Autowired
    public WebserviceClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public Mono<ResponseDto> getDataFromApi(String param) {
        return webClient.get()
                .uri("/endpoint?param={param}", param)
                .retrieve()
                .bodyToMono(ResponseDto.class)
                .doOnError(WebClientResponseException.class, ex -> {
                    log.error("API 호출 실패: {}", ex.getMessage());
                })
                .onErrorResume(ex -> {
                    log.error("예기치 않은 오류 발생: {}", ex.getMessage());
                    return Mono.empty();
                });
    }
}
