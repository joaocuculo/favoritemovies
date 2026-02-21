package com.joaocuculo.favoritemovies.controllers;

import com.joaocuculo.favoritemovies.dto.AuthenticationDTO;
import com.joaocuculo.favoritemovies.dto.UserRequestDTO;
import com.joaocuculo.favoritemovies.entities.User;
import com.joaocuculo.favoritemovies.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @PostMapping(value = "/login")
    public ResponseEntity<Void> login(@RequestBody @Valid AuthenticationDTO data) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.email(), data.password());
        var auth = this.authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/register")
    public ResponseEntity<Void> register(@RequestBody @Valid UserRequestDTO data) {
        if (this.repository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.name(), data.email(), encryptedPassword, data.role());

        this.repository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
