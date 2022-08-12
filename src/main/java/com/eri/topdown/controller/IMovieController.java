package com.eri.topdown.controller;


import com.eri.topdown.movie_api.AddMovieRequest;
import com.eri.topdown.movie_api.DeleteMovieRequest;
import com.eri.topdown.movie_api.ListMoviesRequest;
import com.eri.topdown.movie_api.ListMoviesResponse;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

public interface IMovieController {
    ListMoviesResponse listMovies(@RequestPayload ListMoviesRequest request);
    void addMovie(@RequestPayload AddMovieRequest request);
    void deleteMovie(@RequestPayload DeleteMovieRequest request);
}
