package com.ProPenny;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
public class SignIn {
    private String username;
    private String password;
    Scanner scanner = new Scanner(System.in);


    public String getUserName(){

        System.out.print("Enter Username: ");
        this.username = scanner.nextLine();
        return username;
    }


    public void searchDataBase(){
        Connection connect = dataBase.getConnection();
        Statement statement;
        ResultSet resultSet;

        try{
            String searchDB = String.format("SELECT * FROM userdata WHERE username = '%s';",username);
            statement = connect.createStatement();
            resultSet = statement.executeQuery(searchDB);


            if(resultSet.next()){

                String dbPassword = resultSet.getString("password");

                System.out.print("Enter Password: ");
                this.password = scanner.nextLine();

                if((dbPassword).equals(password)){
                    System.out.println("------------------------");
                    System.out.println("Hi! "+resultSet.getString("firstname")+" "+resultSet.getString("lastname"));
                    controllerSignIn.userAct(username);


                }else{
                    System.out.println("------------------------");
                    System.out.println("Password entered is incorrect!");
                }

            }else{
                System.out.println("No Data Found!");
            }

        }catch(Exception e){
            System.out.println(e);
        }
    }

}
