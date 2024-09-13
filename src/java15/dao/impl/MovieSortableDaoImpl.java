package java15.dao.impl;

import java15.dao.MovieSortableDao;
import java15.database.Database;
import java15.model.Movie;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class MovieSortableDaoImpl implements MovieSortableDao {

    private List<Movie> movies = new LinkedList<>(Database.movies); // Создаём копию списка фильмов из базы данных

    @Override
    public void sortMovieByName(String ascOrDesc) {
        Comparator<Movie> comparator = Comparator.comparing(Movie::getName);
        if ("desc".equalsIgnoreCase(ascOrDesc)) {
            comparator = comparator.reversed();
        }
        movies.sort(comparator);
        // Обновление базы данных
        Database.movies = new LinkedList<>(movies);
    }

    @Override
    public void sortByYear(String ascOrDesc) {
        Comparator<Movie> comparator = Comparator.comparing(Movie::getYear);
        if ("desc".equalsIgnoreCase(ascOrDesc)) {
            comparator = comparator.reversed();
        }
        movies.sort(comparator);
        // Обновление базы данных
        Database.movies = new LinkedList<>(movies);
    }

    @Override
    public void sortByProducer(String nameOrLastName) {
        Comparator<Movie> comparator;
        if ("name".equalsIgnoreCase(nameOrLastName)) {
            comparator = Comparator.comparing(movie -> movie.getProducer().getFirstName());
        } else if ("lastname".equalsIgnoreCase(nameOrLastName)) {
            comparator = Comparator.comparing(movie -> movie.getProducer().getLastName());
        } else {
            throw new IllegalArgumentException("Invalid sorting criterion: " + nameOrLastName);
        }
        movies.sort(comparator);
        // Обновление базы данных
        Database.movies = new LinkedList<>(movies);
    }
}