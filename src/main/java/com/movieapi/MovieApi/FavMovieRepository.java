package com.movieapi.MovieApi;

import org.springframework.data.jpa.repository.JpaRepository;


public interface FavMovieRepository extends JpaRepository<FavMovie, Integer>{

}
