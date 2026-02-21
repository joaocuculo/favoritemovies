package com.joaocuculo.favoritemovies.services;

import com.joaocuculo.favoritemovies.dto.UserRequestDTO;
import com.joaocuculo.favoritemovies.dto.UserResponseDTO;
import com.joaocuculo.favoritemovies.entities.User;
import com.joaocuculo.favoritemovies.repositories.UserRepository;
import com.joaocuculo.favoritemovies.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserResponseDTO> findAll() {
        return repository.findAll()
                .stream()
                .map(user -> new UserResponseDTO(user.getId(), user.getName(), user.getEmail()))
                .collect(Collectors.toList());
    }

    public UserResponseDTO findById(Long id) {
        User obj = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return new UserResponseDTO(obj.getId(), obj.getName(), obj.getEmail());
    }
}
