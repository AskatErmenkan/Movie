package java15.model.dao;

import java15.model.models.Genre;
import java15.model.models.Movie;

import java.time.LocalDate;
import java.util.List;

public interface MovieFindableDao {
    List<Movie> getAllMovies();
    List<Movie> findMovieByFullNameOrPartName(String name);
    List<Movie> findMovieByActorName(String actorName);
    List<Movie> findMovieByYear(LocalDate year);
    List<Movie> findMovieByProducer(String producerFullName);
    List<Movie> findMovieByGenre(Genre genre);
    String findRoleByRoleAndMoveName(String moveName, String actorFullName);

}
