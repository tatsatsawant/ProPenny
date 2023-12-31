package com.ProPenny;
import io.github.cdimascio.dotenv.Dotenv;
import java.sql.SQLException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        dataBase.getConnection();
        Dotenv dotenv = Dotenv.load();
        String adminPassword = dotenv.get("Admin_Password");

        if (dataBase.getConnection() == null) {
            System.out.println();
            System.out.println();
            System.out.println("Connection Not Established :(");
        } else {
            System.out.println("------------------------");
            System.out.println("Welcome to ProPenny!");

            while (true) {

                System.out.println("------------------------");
                System.out.println("1. Sign In For User.");
                System.out.println("2. Sign Up To Register.");
                System.out.println("3. Exit. \n------------------------");
                System.out.print("Choice: ");

                int choice;

                if (scanner.hasNextInt()) {

                    choice = scanner.nextInt();
                    switch (choice) {

                        case 1:
                            SignIn signIn = new SignIn();
                            signIn.getUserName();
                            signIn.searchDataBase();
                            break;

                        case 2:
                            SignUp signUp = new SignUp();
                            signUp.registerDetails();
                            break;

                        case 3:
                            System.out.println("Exiting The Application!");
                            System.exit(0);

                        default:
                            System.out.println("------------------------\nPlease Enter Valid Input :(");

                    }

                } else {
                    System.out.println("------------------------\nPlease Enter Valid Input :(");
                    scanner.nextLine();
                }

            }

        }

    }
}





