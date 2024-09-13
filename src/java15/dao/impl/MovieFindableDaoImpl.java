package java15.dao.impl;

import java15.dao.MovieFindableDao;
import java15.database.Database;
import java15.model.Actor;
import java15.model.Genre;
import java15.model.Movie;
import java15.model.Producer;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class MovieFindableDaoImpl implements MovieFindableDao {


    @Override
    public List<Movie> getAllMovies() {
        return Database.movies;
    }

    @Override
    public List<Movie> findMovieByFullNameOrPartName(String name) {
        List<Movie> movie = new LinkedList<>();
        if (name != null && !name.isEmpty()) {
            try {
                for (Movie movie1 : Database.movies) {
                    if (movie1.getName().toLowerCase().contains(name.toLowerCase())) {
                        movie.add(movie1);
                    }
                }
                if (movie.isEmpty()) {
                    System.out.println("Movie not fount");
                }
            } catch (Exception e) {
                System.out.println("An error occuredd:" + e.getMessage());
            }
        } else System.out.println("Movie name is null or empty");
        return movie;
    }

    @Override
    public List<Movie> findMovieByActorName(String actorName) {
        List<Movie> movies = new LinkedList<>();
        if (actorName != null && !actorName.isEmpty()) {
            try {
                for (Movie movie : Database.movies) {
                    for (Actor actor : movie.getActors()) {
                        if (actor.getActorFullName().toLowerCase().contains(actorName.toLowerCase())) {
                            movies.add(movie);
                            break;
                        }
                    }
                }
                if (movies.isEmpty()) {
                    System.out.println("andai ACTOR jook");
                }
            } catch (Exception e) {
                System.out.println("An error occurred " + e.getMessage());
            }
        } else System.out.println("Name is null or empty");
        return movies;
    }

    @Override
    public List<Movie> findMovieByYear(LocalDate year) {
        List<Movie> movies = new LinkedList<>();
        if (year != null) {
            try {
                for (Movie movie : Database.movies) {
                    if (movie.getYear().getYear() == year.getYear()) {
                        movies.add(movie);
                    }
                }
                if (movies.isEmpty()) {
                    System.out.println("andai jyly menen kino jook");
                }
            } catch (Exception e) {
                System.out.println("An error occurred " + e.getMessage());
            }
        } else System.out.println("Data is null or empty");
        return movies;
    }

    @Override
    public List<Movie> findMovieByProducer(String producerFullName) {
        List<Movie> movies = new LinkedList<>();
        if (producerFullName == null || producerFullName.isEmpty()) {
            System.out.println("Producer name is null or empty");
            return movies;
        }

        try {
            String lowerCaseProducerFullName = producerFullName.toLowerCase();

            for (Movie movie : Database.movies) {
                Producer producer = movie.getProducer();
                if (producer != null) {
                    String fullName = (producer.getFirstName() + " " + producer.getLastName()).toLowerCase();
                    if (fullName.contains(lowerCaseProducerFullName)) {
                        movies.add(movie);
                    }
                }
            }

            if (movies.isEmpty()) {
                System.out.println("Producer not found");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        return movies;
    }

    @Override
    public List<Movie> findMovieByGenre(Genre genre) {
        List<Movie> movies = new LinkedList<>();
        if (genre != null) {
            try {
                for (Movie movie : Database.movies) {
                    if (movie.getGenre().equals(genre)) {
                        movies.add(movie);
                    }
                }
                if (movies.isEmpty()) {
                    System.out.println("Movies with this genre were not found.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred: " + e.getMessage());
            }
        } else {
            System.out.println("Genre is null.");
        }
        return movies;
    }

    @Override
    public String findActorByRoleAndMovieName(String actorFullName, String movieName) {
        if (actorFullName == null || actorFullName.isEmpty() || movieName == null || movieName.isEmpty()) {
            return "Actor name or movie name is null or empty";
        }
        try {
            for (Movie movie : Database.movies) {
                if (movie.getName().trim().toLowerCase().equalsIgnoreCase(movieName)) {
                    for (Actor actor : movie.getActors()) {
                        if (actor.getActorFullName().toLowerCase().trim().equalsIgnoreCase(actorFullName)) {
                            return "Role" + actor.getRole();
                        }
                    }
                    return "Actor not found in this movie: " + movieName;
                }
            }return "Movie not found: " + movieName;
        } catch (Exception e) {
            return "An error occurred: " + e.getMessage();
        }
    }
}
