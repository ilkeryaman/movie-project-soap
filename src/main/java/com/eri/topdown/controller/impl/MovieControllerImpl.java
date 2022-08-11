package com.eri.topdown.controller.impl;

import com.eri.model.Movie;
import com.eri.service.IMovieManagerService;
import com.eri.topdown.controller.IMovieController;
import com.eri.topdown.converter.mapstruct.IMovieMapper;
import io.localhost.movie_api.web_service.AddMovieRequest;
import io.localhost.movie_api.web_service.DeleteMovieRequest;
import io.localhost.movie_api.web_service.ListMoviesRequest;
import io.localhost.movie_api.web_service.ListMoviesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import javax.annotation.Resource;
import java.util.List;

@Endpoint
public class MovieControllerImpl implements IMovieController {
    protected static final String NAMESPACE_URI = "http://localhost.io/movie-api/web-service";

    @Resource(name="movieManagerFileService")
    IMovieManagerService movieManagerService;

    @Autowired
    IMovieMapper movieMapper;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "listMoviesRequest")
    @ResponsePayload
    public ListMoviesResponse listMovies(@RequestPayload ListMoviesRequest request) {
        ListMoviesResponse response = new ListMoviesResponse();

        if(request.getId() != null){
            Movie movie = movieManagerService.findMovieById(request.getId().intValue());
            if(movie != null){
                response.getMovies().add(movieMapper.modelToGenerated(movie));
            }
        } else {
            List<Movie> movies = movieManagerService.getMovies();
            for(Movie movie : movies){
                response.getMovies().add(movieMapper.modelToGenerated(movie));
            }
        }
        return response;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addMovieRequest")
    @ResponsePayload
    public void addMovie(@RequestPayload AddMovieRequest request) {
        movieManagerService.addMovie(movieMapper.generatedToModel(request.getMovie()));
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "deleteMovieRequest")
    @ResponsePayload
    public void deleteMovie(@RequestPayload DeleteMovieRequest request) {
        movieManagerService.removeMovieById(request.getId().intValue());
    }

}
