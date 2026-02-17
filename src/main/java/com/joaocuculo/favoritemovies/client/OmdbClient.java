package com.joaocuculo.favoritemovies.client;

import com.joaocuculo.favoritemovies.dto.OmdbMovieResponseDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@Component
public class OmdbClient {

    private final WebClient webClient;

    @Value("${omdb.api.key}")
    private String apiKey;

    public OmdbClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public OmdbMovieResponseDTO findByImdbId(String imdbId) {
        return webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .queryParam("i", imdbId)
                        .queryParam("apikey", apiKey)
                        .build())
                .retrieve()
                .bodyToMono(OmdbMovieResponseDTO.class)
                .block();
    }
}
