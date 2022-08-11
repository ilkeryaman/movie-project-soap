package com.eri.topdown.converter.mapstruct;

import com.eri.model.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IMovieMapper {
    Movie generatedToModel(io.localhost.movie_api.web_service.Movie generated);
    io.localhost.movie_api.web_service.Movie modelToGenerated(Movie model);
}
