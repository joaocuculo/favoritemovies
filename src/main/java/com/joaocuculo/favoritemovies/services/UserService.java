package com.joaocuculo.favoritemovies.services;

import com.joaocuculo.favoritemovies.dto.UserRequestDTO;
import com.joaocuculo.favoritemovies.dto.UserResponseDTO;
import com.joaocuculo.favoritemovies.entities.User;
import com.joaocuculo.favoritemovies.entities.enums.UserRole;
import com.joaocuculo.favoritemovies.repositories.UserRepository;
import com.joaocuculo.favoritemovies.exceptions.BusinessException;
import com.joaocuculo.favoritemovies.exceptions.DatabaseException;
import com.joaocuculo.favoritemovies.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Page<UserResponseDTO> findAll(Pageable pageable) {
        Page<User> users = repository.findAll(pageable);
        return users.map(user -> new UserResponseDTO(user.getId(), user.getName(), user.getEmail()));
    }

    public UserResponseDTO findById(Long id) {
        User obj = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
        return new UserResponseDTO(obj.getId(), obj.getName(), obj.getEmail());
    }

    public UserResponseDTO register(UserRequestDTO userDto) {
        if (repository.findByEmail(userDto.email()) != null) {
            throw new BusinessException("This e-mail already exists");
        }

        User newUser = new User(
                userDto.name(),
                userDto.email(),
                passwordEncoder.encode(userDto.password()),
                UserRole.USER);

        repository.save(newUser);

        return new UserResponseDTO(newUser.getId(), newUser.getName(), newUser.getEmail());
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public UserResponseDTO update(Long id, UserRequestDTO userDto) {
        try {
            User entity = repository.getReferenceById(id);
            updateData(entity, userDto);
            repository.save(entity);
            return new UserResponseDTO(entity.getId(), entity.getName(), entity.getEmail());
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(User entity, UserRequestDTO userDto) {
        entity.setName(userDto.name());
        entity.setEmail(userDto.email());
        if (userDto.password() != null) {
            entity.setPassword(passwordEncoder.encode(userDto.password()));
        }
    }
}
