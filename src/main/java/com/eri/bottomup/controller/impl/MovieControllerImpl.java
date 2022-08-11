package com.eri.bottomup.controller.impl;

import com.eri.bottomup.controller.IMovieController;
import com.eri.bottomup.configuration.ws.WebApplicationContextLocator;
import com.eri.model.Movie;
import com.eri.service.IMovieManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.AutowiredAnnotationBeanPostProcessor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.context.WebApplicationContext;

import javax.jws.WebService;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


@WebService(endpointInterface = "com.eri.bottomup.controller.IMovieController")
public class MovieControllerImpl implements IMovieController {

    @Autowired
    @Qualifier("movieManagerFileService")
    IMovieManagerService movieManagerService;

    public MovieControllerImpl() {
        AutowiredAnnotationBeanPostProcessor bpp = new AutowiredAnnotationBeanPostProcessor();
        WebApplicationContext currentContext = WebApplicationContextLocator.getCurrentWebApplicationContext();
        bpp.setBeanFactory(currentContext.getAutowireCapableBeanFactory());
        bpp.processInjection(this);
    }

    @Override
    public List<Movie> listMovies(Integer id) {
        if(id != null){
            Movie movie = movieManagerService.findMovieById(id);
            return movie == null ? Collections.emptyList() : Arrays.asList(movie);
        }
        return movieManagerService.getMovies();
    }

    @Override
    public void addMovie(Movie movie) {
        movieManagerService.addMovie(movie);
    }

    @Override
    public void deleteMovie(Integer id) {
        movieManagerService.removeMovieById(id);
    }
}
