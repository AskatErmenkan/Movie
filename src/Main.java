import java15.model.commands.Commands;
import java15.model.database.Database;

import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//        System.out.println("Database.movies = " + Database.movies);
        Commands commands = new Commands();
        Scanner scanner = new Scanner(System.in);
        commands.run(scanner);
    }
}
