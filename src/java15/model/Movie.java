package java15.model;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public class Movie {
    private Long id;
    private String name;
    private LocalDate year;
    private Genre genre;
    private Producer producer;
    private List<Actor> actors;

    public Movie() {
    }

    public Movie(Long id, String name, List<Actor> actors, Genre genre, Producer producer, LocalDate year) {
        this.id = id;
        this.name = name;
        this.actors = actors;
        this.genre = genre;
        this.producer = producer;
        this.year = year;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public LocalDate getYear() {
        return year;
    }

    public void setYear(LocalDate year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "\nMovie{" +
                "name='" + name + '\'' +
                ", year=" + year.getYear() +
                ", genre=" + genre +
                ", producer=" + producer.getFirstName() + " " + producer.getLastName() +
                ", actors=" + actors.stream().map(Actor::getActorFullName).toList() +
                '}';
    }
}

