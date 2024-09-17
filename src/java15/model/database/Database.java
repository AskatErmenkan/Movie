package java15.model.database;

import java15.model.models.Actor;
import java15.model.models.Genre;
import java15.model.models.Movie;
import java15.model.models.Producer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Database {
    public static List<Movie> movies = new ArrayList<>(List.of(
            new Movie("Troia", LocalDate.of(2004, 1, 1), Genre.HISTORY,
                    new Producer("James", "Cameron"),
                    new ArrayList<>(List.of(new Actor("Brad Pitt", "Achilles")))),
            new Movie("Inception", LocalDate.of(2010, 7, 16), Genre.HISTORY,
                    new Producer("Christopher", "Nolan"),
                    new ArrayList<>(List.of(new Actor("Leonardo DiCaprio", "Cobb")))),
            new Movie("The Matrix", LocalDate.of(1999, 3, 31), Genre.DRAMA,
                    new Producer("Lana", "Wachowski"),
                    new ArrayList<>(List.of(new Actor("Keanu Reeves", "Neo")))),
            new Movie("The Godfather", LocalDate.of(1972, 3, 24), Genre.DRAMA,
                    new Producer("Francis", "Coppola"),
                    new ArrayList<>(List.of(new Actor("Marlon Brando", "Vito Corleone")))),
            new Movie("Titanic", LocalDate.of(1997, 12, 19), Genre.ROMANCE,
                    new Producer("James", "Cameron"),
                    new ArrayList<>(List.of(new Actor("Leonardo DiCaprio", "Jack"), new Actor("Kate Winslet", "Rose")))),
            new Movie("Gladiator", LocalDate.of(2000, 5, 5), Genre.HISTORY,
                    new Producer("Ridley", "Scott"),
                    new ArrayList<>(List.of(new Actor("Russell Crowe", "Maximus")))),
            new Movie("The Dark Knight", LocalDate.of(2008, 7, 18), Genre.ACTION,
                    new Producer("Christopher", "Nolan"),
                    new ArrayList<>(List.of(new Actor("Christian Bale", "Bruce Wayne")))),
            new Movie("Avatar", LocalDate.of(2009, 12, 18), Genre.FANTASY,
                    new Producer("James", "Cameron"),
                    new ArrayList<>(List.of(new Actor("Sam Worthington", "Jake Sully")))),
            new Movie("Pulp Fiction", LocalDate.of(1994, 10, 14), Genre.CRIME,
                    new Producer("Quentin", "Tarantino"),
                    new ArrayList<>(List.of(new Actor("John Travolta", "Vincent Vega")))),
            new Movie("Braveheart", LocalDate.of(1995, 5, 24), Genre.HISTORY,
                    new Producer("Mel", "Gibson"),
                    new ArrayList<>(List.of(new Actor("Mel Gibson", "William Wallace"))))
    ));

}
