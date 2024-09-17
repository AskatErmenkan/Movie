package java15.model.commands;

import java15.model.dao.MovieFindableDao;
import java15.model.dao.MovieSortableDao;
import java15.model.dao.impl.MovieFindableDaoImpl;
import java15.model.dao.impl.MovieSortableDaoImpl;
import java15.model.models.Genre;

import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.Scanner;

public class Commands {
    public void run(Scanner scanner) {
        MovieFindableDao movieFindableDao = new MovieFindableDaoImpl();
        MovieSortableDao movieSortableDao = new MovieSortableDaoImpl();
        while (true) {
            System.out.print("""
                    Enter find's commands:
                    All movies                              -> 1
                    Find movie by full name or part name    -> 2
                    Find movie by actor name                -> 3
                    Find movie by year                      -> 4
                    Find movie by producer                  -> 5
                    Find movie by genre                     -> 6
                    Find movie by role or  movie name       -> 7
                    ____________________________________________
                    
                    Enter sortable commands:
                    Sort movie's by movie name              -> 8
                    Sort movie's by movie year              -> 9
                    Sort by name or last name               -> 10
                    Exit                                    -> 11
                    """);
            String choice = scanner.nextLine();
            switch (choice) {
                case "1" -> {
                    System.out.println("movieFindableDao.getAllMovies(): " + movieFindableDao.getAllMovies());
                }
                case "2" -> {
                    System.out.println("Write movie's name:");
                    System.out.println("movieFindableDao " + movieFindableDao.findMovieByFullNameOrPartName(scanner.nextLine()));
                }
                case "3" -> {
                    System.out.print("Write actor name: ");
                    System.out.println("movieFindableDao.findMovieByActorName(): " + movieFindableDao.findMovieByActorName(scanner.nextLine()));
                }
                case "4" -> {
                    System.out.print("Write movie's year: ");
                    if (scanner.hasNextInt()) { // Жылдын туура киргизилгенин текшерүү
                        int year = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("movie find by year: " + movieFindableDao.findMovieByYear(LocalDate.of(year, 1, 1)));
                    } else {
                        System.out.println("Please enter a valid year.");
                        scanner.next(); // Туура эмес киргизүүнү өткөрүп жиберүү
                    }
                }
                case "5" -> {
                    System.out.print("Write producer's name: ");
                    System.out.println(movieFindableDao.findMovieByProducer(scanner.nextLine()));
                }

                case "6" -> {
                    System.out.println("Write genre: ");
                    String genre = scanner.nextLine().trim().toUpperCase();
                    Genre movieGenre = Genre.valueOf(genre);
                    System.out.println(movieFindableDao.findMovieByGenre(movieGenre));
                }

                case "7" -> {
                    System.out.println("Write movie name: ");
                    String movieName = scanner.nextLine();
                    System.out.println("Write name actor: ");
                    String actorFullName = scanner.nextLine();
                    System.out.println(movieFindableDao.findRoleByRoleAndMoveName(movieName, actorFullName));
                }
                case "8" -> {
                    System.out.println("Sort asc or desc: ");
                    String movieName = scanner.nextLine();
                    movieSortableDao.sortMovieByName(movieName);
                    movieFindableDao.getAllMovies().forEach(System.out::println);
                }
                case "9" -> {
                    System.out.println("Sort asc or desc: ");
                    String movieYear = scanner.nextLine();
                    movieSortableDao.sortMovieByYear(movieYear);
                    movieFindableDao.getAllMovies().forEach(System.out::println);
                }
                case "10" -> {
                    System.out.println("Sort by name or last name");
                    String movieYear = scanner.nextLine();
                    movieSortableDao.sortByProducer(movieYear);
                    movieFindableDao.getAllMovies().forEach(System.out::println);
                }
                case "11" ->{
                    System.out.println("Exit");
                    return;
                }
            }
        }
    }
}



