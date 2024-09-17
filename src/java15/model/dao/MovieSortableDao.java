package java15.model.dao;

import java15.model.models.Movie;

import java.util.List;


public interface MovieSortableDao {

    void sortMovieByName (String ascOrDesc);
    void sortMovieByYear (String ascOrDesc);
    void sortByProducer (String nameOrLastName);


}
