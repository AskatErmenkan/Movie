package java15.model.dao.impl;

import java15.model.models.Actor;
import java15.model.models.Genre;
import java15.model.models.Movie;
import java15.model.dao.MovieFindableDao;
import java15.model.database.Database;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java15.model.database.Database.movies;

public class MovieFindableDaoImpl implements MovieFindableDao {

    @Override
    public List<Movie> getAllMovies() {
        return movies;
    }

    @Override
    public List<Movie> findMovieByFullNameOrPartName(String name) {
        List<Movie> movies = new LinkedList<>();
        if (name != null && !name.isEmpty()) {
            for (Movie movie : Database.movies) {
                if (movie.getName().toLowerCase().contains(name.toLowerCase())) {
                    movies.add(movie);
                }
            }
        }
        return movies;
    }

    @Override
    public List<Movie> findMovieByActorName(String actorName) {
        List<Movie> movies = new LinkedList<>();
        if (actorName != null && !actorName.isEmpty()) {
            for (Movie movie : Database.movies) {
                if (movie.getActors().getFirst().getActorFullName().toLowerCase().trim().contains(actorName.toLowerCase().trim())) {
                    movies.add(movie);
                }
            }
        }
        return movies;
    }

    @Override
    public List<Movie> findMovieByYear(LocalDate year) {
        List<Movie> movies = new LinkedList<>();
        if (year.getYear() > 0 && year.getYear() <= 2024) {
            for (Movie movie : Database.movies) {
                if (movie.getYear().getYear() == year.getYear()) {
                    movies.add(movie);
                }
                return movies;
            }
        }
        return null;
    }

    @Override
    public List<Movie> findMovieByProducer(String producerFullName) {
        List<Movie> moviesByProducer = new ArrayList<>();
        if (producerFullName != null && !producerFullName.isEmpty()) {
            String lowerCaseProducerFullName = producerFullName.toLowerCase();
            for (Movie movie : Database.movies) {
                String movieProducerFullName = movie.getProducer().getFirstName().toLowerCase() + " " +
                                               movie.getProducer().getLastName().toLowerCase();
                if (movieProducerFullName.equals(lowerCaseProducerFullName)) {
                    moviesByProducer.add(movie);
                }
            }
        }
        return moviesByProducer.isEmpty() ? null : moviesByProducer;
    }

    @Override
    public List<Movie> findMovieByGenre(Genre genre) {
        List<Movie> moviesByGenre = new ArrayList<>();
        for (Movie movie : Database.movies) {
            if (movie.getGenre().equals(genre)) {
                moviesByGenre.add(movie);
            }
        }
        return moviesByGenre;
    }

    @Override
    public String findRoleByRoleAndMoveName(String movieName, String actorFullName) {
        for (Movie movie : Database.movies) {
            if (movie.getName().contains(movieName)) {
                for (Actor actor : movie.getActors()) {
                    if (actor.getActorFullName().contains(actorFullName)) {
                        return  "Role: " + actor.getRole();
                    }
                }
            }
        }
        return "Not found";
    }

}

