package java15.model.dao.impl;

import java15.model.dao.MovieSortableDao;
import java15.model.database.Database;
import java15.model.models.Movie;

import java.util.*;

public class MovieSortableDaoImpl implements MovieSortableDao {

    @Override

    public void sortMovieByName(String ascOrDesc) {
        if (ascOrDesc.equalsIgnoreCase("asc")) {
            Collections.sort(Database.movies, Comparator.comparing(movie -> movie.getName()));
        } else if (ascOrDesc.equalsIgnoreCase("desc")) {
            Collections.sort(Database.movies, Comparator.comparing(Movie::getName).reversed());
        }
    }


    @Override
    public void sortMovieByYear(String ascOrDesc) {
        if (ascOrDesc.equalsIgnoreCase("asc")) {
            Collections.sort(Database.movies, Comparator.comparing(movie -> movie.getYear()));
        } else if (ascOrDesc.equalsIgnoreCase("desc")) {
            Collections.sort(Database.movies, Comparator.comparing(Movie::getYear).reversed());
        }
    }

    @Override
    public void sortByProducer(String nameOrLastName) {
        if (nameOrLastName.equalsIgnoreCase("name")) {
            Collections.sort(Database.movies, Comparator.comparing(movie -> movie.getProducer().getFirstName()));
        } else if (nameOrLastName.equalsIgnoreCase("Last name")){
            Collections.sort(Database.movies, Comparator.comparing(movie -> movie.getProducer().getLastName()));
        }
    }
}


