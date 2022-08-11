package com.eri.topdown.controller;

import io.localhost.movie_api.web_service.AddMovieRequest;
import io.localhost.movie_api.web_service.DeleteMovieRequest;
import io.localhost.movie_api.web_service.ListMoviesRequest;
import io.localhost.movie_api.web_service.ListMoviesResponse;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

public interface IMovieController {
    ListMoviesResponse listMovies(@RequestPayload ListMoviesRequest request);
    void addMovie(@RequestPayload AddMovieRequest request);
    void deleteMovie(@RequestPayload DeleteMovieRequest request);
}
