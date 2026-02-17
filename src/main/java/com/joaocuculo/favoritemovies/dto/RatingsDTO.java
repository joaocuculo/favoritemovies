package com.joaocuculo.favoritemovies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class RatingsDTO implements Serializable {

    @JsonProperty("Source")
    private String source;

    @JsonProperty("Value")
    private String value;

    public RatingsDTO() {
    }

    public RatingsDTO(String source, String value) {
        this.source = source;
        this.value = value;
    }

    public String getSource() {
        return source;
    }

    public String getValue() {
        return value;
    }
}
