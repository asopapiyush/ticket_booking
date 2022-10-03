package com.simple.ticketing.services;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.simple.ticketing.exceptions.NotFoundException;
import com.simple.ticketing.model.Movie;

import lombok.NonNull;

public class MovieService {

    private final Map<String, Movie> movies;

    public MovieService() {
        this.movies = new HashMap<>();
    }

    public Movie getMovie(@NonNull final String movieId) {
        if (!movies.containsKey(movieId)) {
            throw new NotFoundException();
        }
        return movies.get(movieId);
    }

    public Movie createMovie(@NonNull final String movieName) {
        String movieId = UUID.randomUUID().toString();
        Movie movie = new Movie(movieId, movieName);
        movies.put(movieId, movie);
        return movie;
    }

}
