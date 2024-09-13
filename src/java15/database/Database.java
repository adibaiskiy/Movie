package java15.database;

import java15.model.Actor;
import java15.model.Genre;
import java15.model.Movie;
import java15.model.Producer;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Database {
    public static List<Movie> movies = new LinkedList<>(List.of(
            new Movie(1L, "Troia",
                    new LinkedList<>(List.of(new Actor(1L, "Babakhan", "Achilles"))),
                    Genre.HISTORY,
                    new Producer("James", "Cameron"),
                    LocalDate.of(2000, 2, 22)
            ),
            new Movie(2L, "300 Spartans",
                    new LinkedList<>(List.of(new Actor(2L, "Atay", "Leonid"))),
                    Genre.HISTORY,
                    new Producer("Kevin", "Beloron"),
                    LocalDate.of(2006, 2, 22)
            ),
            new Movie(3L, "Inception",
                    new LinkedList<>(List.of(new Actor(3L, "Leonardo", "DiCaprio"))),
                    Genre.SCI_FI,
                    new Producer("Christopher", "Nolan"),
                    LocalDate.of(2010, 7, 16)
            ),
            new Movie(4L, "Avatar",
                    new LinkedList<>(List.of(new Actor(4L, "Sam", "Worthington"))),
                    Genre.SCI_FI,
                    new Producer("James", "Cameron"),
                    LocalDate.of(2009, 12, 18)
            ),
            new Movie(5L, "The Godfather",
                    new LinkedList<>(List.of(new Actor(5L, "Marlon", "Brando"), new Actor(6L, "Al", "Pacino"))),
                    Genre.CRIME,
                    new Producer("Francis", "Coppola"),
                    LocalDate.of(1972, 3, 24)
            ),
            new Movie(6L, "The Dark Knight",
                    new LinkedList<>(List.of(new Actor(7L, "Christian", "Bale"), new Actor(8L, "Heath", "Ledger"))),
                    Genre.ACTION,
                    new Producer("Christopher", "Nolan"),
                    LocalDate.of(2008, 7, 18)
            ),
            new Movie(7L, "Pulp Fiction",
                    new LinkedList<>(List.of(new Actor(9L, "John", "Travolta"), new Actor(10L, "Samuel", "Jackson"))),
                    Genre.CRIME,
                    new Producer("Quentin", "Tarantino"),
                    LocalDate.of(1994, 10, 14)
            ),
            new Movie(8L, "The Lord of the Rings: The Return of the King",
                    new LinkedList<>(List.of(new Actor(11L, "Elijah", "Wood"), new Actor(12L, "Viggo", "Mortensen"))),
                    Genre.FANTASY,
                    new Producer("Peter", "Jackson"),
                    LocalDate.of(2003, 12, 17)
            ),
            new Movie(9L, "Forrest Gump",
                    new LinkedList<>(List.of(new Actor(13L, "Tom", "Hanks"))),
                    Genre.DRAMA,
                    new Producer("Robert", "Zemeckis"),
                    LocalDate.of(1994, 7, 6)
            ),
            new Movie(10L, "The Matrix",
                    new LinkedList<>(List.of(new Actor(14L, "Keanu", "Reeves"))),
                    Genre.SCI_FI,
                    new Producer("Lana", "Wachowski"),
                    LocalDate.of(1999, 3, 31)
            ),
            new Movie(11L, "Gladiator",
                    new LinkedList<>(List.of(new Actor(15L, "Russell", "Crowe"))),
                    Genre.HISTORY,
                    new Producer("Ridley", "Scott"),
                    LocalDate.of(2000, 5, 5)
            ),
            new Movie(12L, "Fight Club",
                    new LinkedList<>(List.of(new Actor(16L, "Brad", "Pitt"), new Actor(17L, "Edward", "Norton"))),
                    Genre.DRAMA,
                    new Producer("David", "Fincher"),
                    LocalDate.of(1999, 10, 15)
            ),
            new Movie(13L, "Interstellar",
                    new LinkedList<>(List.of(new Actor(18L, "Matthew", "McConaughey"))),
                    Genre.SCI_FI,
                    new Producer("Christopher", "Nolan"),
                    LocalDate.of(2014, 11, 7)
            ),
            new Movie(14L, "The Shawshank Redemption",
                    new LinkedList<>(List.of(new Actor(19L, "Tim", "Robbins"), new Actor(20L, "Morgan", "Freeman"))),
                    Genre.DRAMA,
                    new Producer("Frank", "Darabont"),
                    LocalDate.of(1994, 9, 23)
            ),
            new Movie(15L, "Jurassic Park",
                    new LinkedList<>(List.of(new Actor(21L, "Sam", "Neill"))),
                    Genre.SCI_FI,
                    new Producer("Steven", "Spielberg"),
                    LocalDate.of(1993, 6, 11)
            ),
            new Movie(16L, "The Silence of the Lambs",
                    new LinkedList<>(List.of(new Actor(22L, "Jodie", "Foster"), new Actor(23L, "Anthony", "Hopkins"))),
                    Genre.THRILLER,
                    new Producer("Jonathan", "Demme"),
                    LocalDate.of(1991, 2, 14)
            ),
            new Movie(17L, "Psycho",
                    new LinkedList<>(List.of(new Actor(24L, "Anthony", "Perkins"))),
                    Genre.THRILLER,
                    new Producer("Alfred", "Hitchcock"),
                    LocalDate.of(1960, 9, 8)
            ),
            new Movie(18L, "Casablanca",
                    new LinkedList<>(List.of(new Actor(25L, "Humphrey", "Bogart"), new Actor(26L, "Ingrid", "Bergman"))),
                    Genre.DRAMA,
                    new Producer("Michael", "Curtiz"),
                    LocalDate.of(1942, 11, 26)
            ),
            new Movie(19L, "Gone with the Wind",
                    new LinkedList<>(List.of(new Actor(27L, "Clark", "Gable"), new Actor(28L, "Vivien", "Leigh"))),
                    Genre.DRAMA,
                    new Producer("Victor", "Fleming"),
                    LocalDate.of(1939, 12, 15)
            ),
            new Movie(20L, "The Usual Suspects",
                    new LinkedList<>(List.of(new Actor(29L, "Kevin", "Spacey"))),
                    Genre.THRILLER,
                    new Producer("Bryan", "Singer"),
                    LocalDate.of(1995, 8, 16)
            ),
            new Movie(21L, "The Social Network",
                    new LinkedList<>(List.of(new Actor(30L, "Jesse", "Eisenberg"))),
                    Genre.DRAMA,
                    new Producer("David", "Fincher"),
                    LocalDate.of(2010, 10, 1)
            ),
            new Movie(22L, "Se7en",
                    new LinkedList<>(List.of(new Actor(31L, "Brad", "Pitt"), new Actor(32L, "Morgan", "Freeman"))),
                    Genre.THRILLER,
                    new Producer("David", "Fincher"),
                    LocalDate.of(1995, 9, 22)
            ),
            new Movie(23L, "The Big Lebowski",
                    new LinkedList<>(List.of(new Actor(33L, "Jeff", "Bridges"))),
                    Genre.COMEDY,
                    new Producer("Joel", "Coen"),
                    LocalDate.of(1998, 3, 6)
            ),
            new Movie(24L, "Goodfellas",
                    new LinkedList<>(List.of(new Actor(34L, "Ray", "Liotta"))),
                    Genre.CRIME,
                    new Producer("Martin", "Scorsese"),
                    LocalDate.of(1990, 9, 19)
            ),
            new Movie(25L, "Léon: The Professional",
                    new LinkedList<>(List.of(new Actor(35L, "Jean", "Reno"))),
                    Genre.ACTION,
                    new Producer("Luc", "Besson"),
                    LocalDate.of(1994, 9, 14)
            ),
            new Movie(26L, "Memento",
                    new LinkedList<>(List.of(new Actor(36L, "Guy", "Pearce"))),
                    Genre.THRILLER,
                    new Producer("Christopher", "Nolan"),
                    LocalDate.of(2000, 10, 11)
            ),
            new Movie(27L, "Oldboy",
                    new LinkedList<>(List.of(new Actor(37L, "Choi", "Min-sik"))),
                    Genre.THRILLER,
                    new Producer("Park", "Chan-wook"),
                    LocalDate.of(2003, 11, 21)
            )
    ));

        public static List<Movie> getAllMovies() {
        return movies;
        }

        // Здесь можно добавить методы для управления фильмами, если это потребуется
}