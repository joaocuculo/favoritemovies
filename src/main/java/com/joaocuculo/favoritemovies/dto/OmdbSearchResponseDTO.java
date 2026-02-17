package com.joaocuculo.favoritemovies.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OmdbSearchResponseDTO {

    @JsonProperty("Search")
    private List<OmdbMovieResponseDTO> search;

    public OmdbSearchResponseDTO() {
    }

    public List<OmdbMovieResponseDTO> getSearch() {
        return search;
    }

    public void setSearch(List<OmdbMovieResponseDTO> search) {
        this.search = search;
    }
}
