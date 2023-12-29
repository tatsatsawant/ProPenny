package com.ProPenny;
import java.sql.SQLException;
import java.util.*;


public class Main {
    public static void main(String[] args) throws SQLException {

        Scanner scanner = new Scanner(System.in);
        dataBase.getConnection();

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
                System.out.println("3. Sign in For Admin");
                System.out.println("4. Exit. \n------------------------");
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

                            System.out.print("Enter The Password: ");
                            String passwordAdminEntered = scanner.next();

                            if ("Tatsat@1234".equals(passwordAdminEntered)) {
                                System.out.println("Welcome Tatsat Sawant!");
                            } else {
                                System.out.println("Password is incorrect");
                            }
                            break;


                        case 4:
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





