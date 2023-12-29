package com.ProPenny;
import java.sql.Connection;
import java.sql.DriverManager;
import io.github.cdimascio.dotenv.Dotenv;

public class dataBase{

    static Dotenv dotenv = Dotenv.load();

    private static final String dbUrl = dotenv.get("DB_URL");
    private static final String dbUsername = dotenv.get("DB_USERNAME");
    private static final String dbPassword = dotenv.get("DB_PASSWORD");

    public static Connection getConnection(){
        Connection connect = null;

        try{

            Class.forName("org.postgresql.Driver");
            connect = DriverManager.getConnection(dbUrl, dbUsername, dbPassword);


        }catch (Exception e){
            System.out.print(e);
        }

        return connect;
    }


}
