package java15.dao;

import java15.model.Genre;
import java15.model.Movie;

import java.time.LocalDate;
import java.util.List;

public interface MovieFindableDao {
    abstract List<Movie> getAllMovies();

    List<Movie> findMovieByFullNameOrPartName(String name);

    List<Movie> findMovieByActorName(String actorName);

    List<Movie> findMovieByYear(LocalDate year);

    List<Movie> findMovieByProducer(String producerFullName);

    List<Movie> findMovieByGenre(Genre genre);

    String findActorByRoleAndMovieName(String actorFullName, String movieName);
}
