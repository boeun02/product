package com.example.webserviceclient.webClient.client;

import com.example.webserviceclient.webClient.dto.ResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

@Slf4j
@Component
@RequiredArgsConstructor
public class WebserviceClient {

    private final WebClient webClient;

    public Mono<ResponseDto> getDataFromApi(String param) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/endpoint")
                        .queryParam("param", param)
                        .build())
                .retrieve()
                .bodyToMono(ResponseDto.class)
                .doOnSuccess(response -> log.info("API 호출 성공: {}", response))
                .doOnError(WebClientResponseException.class, ex -> log.error("API 호출 실패: {}", ex.getResponseBodyAsString()))
                .onErrorResume(ex -> {
                    log.error("예기치 않은 오류 발생: {}", ex.getMessage());
                    return Mono.empty();
                });
    }
}