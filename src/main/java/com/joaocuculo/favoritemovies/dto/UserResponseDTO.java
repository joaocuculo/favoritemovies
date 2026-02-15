package com.joaocuculo.favoritemovies.dto;

import java.io.Serializable;

public class UserResponseDTO implements Serializable {

    private Long id;
    private String name;
    private String email;

    public UserResponseDTO() {
    }

    public UserResponseDTO(Long id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}
