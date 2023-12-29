package com.ProPenny;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Objects;
import java.util.Scanner;

public class SignUp {

    public void registerDetails() throws SQLException {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            Statement statement;
            Connection connect = dataBase.getConnection();

            System.out.println("------------------------");
            System.out.print("Enter Your First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter Your Last Name: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter New Username: ");
            String username = scanner.nextLine();

            String searchDB = String.format("SELECT * FROM userdata WHERE username = '%s';", username);
            statement = connect.createStatement();
            ResultSet resultSet = statement.executeQuery(searchDB);

            if (resultSet.next()) {
                System.out.println("------------------------");
                System.out.println("User already Exists!");
                break;

            }else{

                System.out.print("Enter Strong Password: ");
                String password = scanner.nextLine();

                System.out.print("Confirm Password: ");
                String confirmPassword = scanner.nextLine();

                System.out.println("------------------------");

                if (!Objects.equals(password, confirmPassword)) {

                    System.out.println("Password Not Matching!");
                    break;

                }else try {
                    //create row in userdata for new user
                    String newUser = String.format("INSERT INTO userdata (firstName, lastName, username, password) VALUES ('%s', '%s', '%s', '%s');", firstName, lastName, username, password);
                    statement = connect.createStatement();
                    statement.executeUpdate(newUser);

                    //create separate passbook for new user
                    String insertTableQuery = "CREATE TABLE " + username + "(transactionDate VARCHAR(255) NOT NULL,description VARCHAR(255) NOT NULL,amount NUMERIC(10, 2) NOT NULL,cr_dr CHAR(2) CHECK (cr_dr IN ('CR', 'DR')), PRIMARY KEY (transactionDate));";
                    statement = connect.createStatement();
                    statement.executeUpdate(insertTableQuery);

                    System.out.println("Registration Successful!");
                    break;
                } catch (Exception e) {
                    System.out.println(e);
                }

            }

        }

    }
}

