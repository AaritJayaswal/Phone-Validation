package com.example.Phone.Validation.repository;

import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class PVRepository {
    private final WebClient webClient;

    private static final String baseUrl = "https://phonevalidation.abstractapi.com/v1/";

    public PVRepository() {
        webClient = WebClient
                .builder()
                .baseUrl(baseUrl)
                .build();
    }

    public String validateNumber(String query){
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("api_key","f56dfefdd9e2408d8845ad9c0e1b7a0c")
                        .queryParam("phone","18582619192")
                        .build()
                )
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

}
