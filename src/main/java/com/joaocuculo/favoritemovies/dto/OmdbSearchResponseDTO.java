package com.joaocuculo.favoritemovies.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class OmdbSearchResponseDTO implements Serializable {

    @JsonProperty("Search")
    private List<OmdbMovieSearchItemDTO> search;

    @JsonProperty("totalResults")
    private String totalResults;

    @JsonProperty("Response")
    private String response;

    public OmdbSearchResponseDTO() {
    }

    public List<OmdbMovieSearchItemDTO> getSearch() {
        return search;
    }

    public void setSearch(List<OmdbMovieSearchItemDTO> search) {
        this.search = search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
