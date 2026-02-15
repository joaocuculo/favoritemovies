package com.joaocuculo.favoritemovies.repositories;

import com.joaocuculo.favoritemovies.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
