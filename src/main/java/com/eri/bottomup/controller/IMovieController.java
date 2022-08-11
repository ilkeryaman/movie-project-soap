package com.eri.bottomup.controller;

import com.eri.model.Movie;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface IMovieController {
    @WebMethod
    List<Movie> listMovies(Integer id);

    @WebMethod
    void addMovie(Movie movie);

    @WebMethod
    void deleteMovie(Integer id);
}
