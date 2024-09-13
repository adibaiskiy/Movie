package java15.dao;

import java15.model.Movie;

import java.util.Set;
import java.util.TreeSet;

public interface MovieSortableDao {

    void sortMovieByName(String ascOrDesc);

    void sortByYear(String ascOrDesc);

    void sortByProducer(String nameOrLastName);

}
