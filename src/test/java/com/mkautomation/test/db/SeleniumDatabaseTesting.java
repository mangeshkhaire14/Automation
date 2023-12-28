package com.mkautomation.test.db;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.sql.*;

public class SeleniumDatabaseTesting {

    //Connection object
    static Connection connection = null;
    //Statement object
    private static Statement statement;
    // Constant for database URL
    public static String DB_URL="jdbc:mysql://localhost/mydatabase";
    // Database username
    public static String DB_USER="root";
    static String DB_PASSWORD="mySql@Gslab#2023";

    @BeforeTest
    public static void setup() throws Exception {
        //Database Connection
        String dbClass="com.mysql.cj.jdbc.driver";
        //loads a class and creates an instance of the loaded class.
        Class.forName(dbClass);
        //.getDeclaredConstructor().newInstance();
        //Get Connection to DB
        Connection connection= DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD);
        //Statement object to sent sql to database
        statement=connection.createStatement();
    }

    @Test
    public void test(){
        try{
            String query="Select * from testcase";
            //Get content of testcase table from DB
            ResultSet resultSet = statement.executeQuery(query);
            //.getResultSet();
            //Print the resultset until all records are printed
            //resultSet.next() returns true if there is any next record else returns false
            while(resultSet.next()){
                System.out.println(resultSet.getString(1));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void whenUseClassForNameCreatedInstanceOfClassClass() throws Exception {
        Class instance = Class.forName("com.mkautomation.test.db.SeleniumDatabaseTesting");
        //assertInstanceOf(Class.class, instance, "instance should be of Class.class");
    }

    @AfterTest
    public void tearDown() throws Exception{
        //Close DB Connection
        if(connection!=null){
            connection.close();
        }
    }

}
