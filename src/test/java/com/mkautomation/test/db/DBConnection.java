package com.mkautomation.test.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnection {

    public static void main(String args[]) throws Exception {

        Connection connection=null;
        Statement statement=null;

        String DB_URL="";
        String DB_Username="";
        String DB_Password="";

        String db_driver_class="";
        Class.forName(db_driver_class).getDeclaredConstructor().newInstance();
        connection= DriverManager.getConnection(DB_URL,DB_Username,DB_Password);
        statement=connection.createStatement();

        ResultSet resultSet=statement.getResultSet();
        while(resultSet.next()){
            resultSet.getString("");
        }



    }


}
