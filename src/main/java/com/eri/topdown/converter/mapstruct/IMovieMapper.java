package com.eri.topdown.converter.mapstruct;

import com.eri.model.Movie;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IMovieMapper {
    Movie generatedToModel(com.eri.topdown.movie_api.Movie generated);
    com.eri.topdown.movie_api.Movie modelToGenerated(Movie model);
}
