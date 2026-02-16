package com.joaocuculo.favoritemovies.services;

import com.joaocuculo.favoritemovies.entities.Movie;
import com.joaocuculo.favoritemovies.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public List<Movie> findAll() {
        return repository.findAll();
    }
}
