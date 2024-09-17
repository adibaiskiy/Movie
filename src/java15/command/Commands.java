package java15.command;

import java15.dao.MovieFindableDao;
import java15.dao.MovieSortableDao;
import java15.dao.impl.MovieFindableDaoImpl;
import java15.dao.impl.MovieSortableDaoImpl;
import java15.database.Database;
import java15.model.Genre;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Commands {
    public void run(Scanner scanner) {
        MovieFindableDao movieFindableDao = new MovieFindableDaoImpl();
        MovieSortableDao movieSortableDao = new MovieSortableDaoImpl();
        while (true) {
            System.out.println("""
                    Enter commands:
                    1 - All movies
                    2 - Find movie by name
                    3 - Find movie by actor
                    4 - Find movie by year
                    5 - Find movie by producer
                    6 - Find movie by genre
                    7 - Find actor by role and movie name
                    8 - Sort movie by name
                    9 - Sort movie by year
                    10 - Sort Producer by name or lastname
                    11 - Exit
                    """);
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> {
                    System.out.println("All movies:");
                    System.out.println(movieFindableDao.getAllMovies());
                }
                case "2" -> {
                    System.out.print("Write movie's name: ");
                    String name = scanner.nextLine().trim();
                    try {
                        System.out.println(movieFindableDao.findMovieByFullNameOrPartName(name));
                    } catch (RuntimeException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case "3" -> {
                    System.out.print("Write actor's name: ");
                    String name = scanner.nextLine().trim();
                    try {
                        System.out.println(movieFindableDao.findMovieByActorName(name));
                    } catch (RuntimeException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case "4" -> {
                    System.out.print("Write the year of the movie: ");
                    try {
                        int year = scanner.nextInt();
                        scanner.nextLine();
                        if (year > 1888 && year <= LocalDate.now().getYear()) {
                            LocalDate date = LocalDate.of(year, 1, 1);
                            System.out.println(movieFindableDao.findMovieByYear(date));
                        } else {
                            System.out.println("Invalid year. Please enter a year between 1888 and the current year.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter a valid year.");
                        scanner.nextLine();
                    } catch (RuntimeException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case "5" -> {
                    System.out.print("Write producer's full name: ");
                    String producerName = scanner.nextLine().trim();
                    try {
                        System.out.println(movieFindableDao.findMovieByProducer(producerName));
                    } catch (RuntimeException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case "6" -> {
                    System.out.print("Write genre: ");
                    String genre = scanner.nextLine().trim().toUpperCase();
                    try {
                        Genre movieGenre = Genre.valueOf(genre);
                        System.out.println(movieFindableDao.findMovieByGenre(movieGenre));
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid genre. Please try again.");
                    } catch (RuntimeException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case "7" -> {
                    System.out.print("Write actor's full name: ");
                    String actorFullName = scanner.nextLine().trim();
                    System.out.print("Write movie name: ");
                    String movieName = scanner.nextLine().trim();

                    try {
                        String role = movieFindableDao.findActorByRoleAndMovieName(actorFullName, movieName);
                        System.out.println("Actor's role: " + role);
                    } catch (RuntimeException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                }
                case "8" -> {
                    System.out.print("White 'asc' or 'desc': ");
                    String ascOrDesc = scanner.nextLine().trim().toLowerCase();
                    try {
                        movieSortableDao.sortMovieByName(ascOrDesc);
                        System.out.println("Movie sorted by name " + ascOrDesc);
                    } catch (RuntimeException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    System.out.println("Movies before sorting:");
                    System.out.println(Database.movies);
                }
                case "9" -> {
                    System.out.print("Write 'asc' or 'desc': ");
                    String ascOrDesc = scanner.nextLine().trim().toLowerCase();
                    try {
                        movieSortableDao.sortByYear(ascOrDesc);
                        System.out.println("Movies sorted by year " + ascOrDesc);
                    } catch (RuntimeException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    System.out.println("Movies before sorting:");
                    System.out.println(Database.movies);
                }
                case "10" -> {
                    System.out.print("Sort by 'name' or 'lastname': ");
                    String criterion = scanner.nextLine().trim().toLowerCase();
                    try {
                        movieSortableDao.sortByProducer(criterion);
                        System.out.println("Movies sorted by producer " + criterion);
                    } catch (RuntimeException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    System.out.println("Movies before sorting:");
                    System.out.println(Database.movies);
                }
                case "11" -> {
                    System.out.println("Exiting the program...");
                    return;
                }
                default -> System.out.println("Unknown command. Please try again.");
            }
        }
    }
}