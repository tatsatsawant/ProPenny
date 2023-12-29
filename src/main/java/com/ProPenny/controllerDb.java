package com.ProPenny;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;

public class  controllerDb{
    Connection connect = dataBase.getConnection();
    Statement statement;

    public void addUserData (String userName, LocalDateTime transactionDate, String description, double amount, String type){

        try {
            // SQL query to insert a row
            String insertRowQuery = String.format("insert into %s(transactionDate, description, amount, cr_dr) values('%s','%s','%s','%s');", userName, transactionDate, description, amount, type);
            statement = connect.createStatement();
            statement.executeUpdate(insertRowQuery);
            System.out.println("------------------------");
            System.out.println("Data Added Successfully!");
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void readUserData(String userName){

        ResultSet resultSet;
        try {
            // SQL query to fetch data from table
            String fetchTableQuery = String.format("Select * from %s", userName);
            statement = connect.createStatement();
            resultSet = statement.executeQuery(fetchTableQuery);

            while (resultSet.next()) {
                System.out.print(resultSet.getString("transactionDate") + " ");
                System.out.print(resultSet.getString("Description") + " ");
                System.out.print(resultSet.getString("Amount") + " ");
                System.out.println(resultSet.getString("cr_dr") + " ");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public int checkData(String userName){

        ResultSet resultSet;
        int count = 0;
        try {
            // SQL query to insert a row
            String checkDataQuery = String.format("Select count(*) from %s", userName);
            statement = connect.createStatement();
            resultSet = statement.executeQuery(checkDataQuery);
            resultSet.next();// to move the cursor to next row
            count = resultSet.getInt(1);
        } catch (Exception e) {
            System.out.println(e);
        }

        return count;
    }


    public double checkBalance (String userName){

        ResultSet resultSet;
        double sum = 0;
        try {
            // SQL query to insert a row
            String sumDataQuery = String.format("Select sum(amount) from %s", userName);
            statement = connect.createStatement();
            resultSet = statement.executeQuery(sumDataQuery);
            resultSet.next();// to move the cursor to next row
            sum = resultSet.getDouble(1);
        } catch (Exception e) {
            System.out.println(e);
        }

        return sum;
    }





}
