package com.example.webserviceclient.webClient.confing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;

import java.time.Duration;

@Configuration
public class WebClientConfig {

    @Value("${webclient.base-url}")
    private String baseUrl;

    @Value("${webclient.connect-timeout}")
    private int connectTimeout;

    @Value("${webclient.read-timeout}")
    private int readTimeout;

    @Bean
    public WebClient webClient() {
        try {
            // HttpClient 생성 및 타임아웃 설정
            HttpClient httpClient = HttpClient.create()
                    .responseTimeout(Duration.ofMillis(readTimeout))
                    .option(io.netty.channel.ChannelOption.CONNECT_TIMEOUT_MILLIS, connectTimeout);

            // WebClient 생성 및 설정
            return WebClient.builder()
                    .baseUrl(baseUrl)
                    .clientConnector(new ReactorClientHttpConnector(httpClient))
                    .exchangeStrategies(ExchangeStrategies.builder()
                            .codecs(configurer -> configurer.defaultCodecs().maxInMemorySize(16 * 1024 * 1024)) // 16MB
                            .build())
                    .build();
        } catch (Exception e) {
            System.err.println("Error initializing WebClient: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }
}