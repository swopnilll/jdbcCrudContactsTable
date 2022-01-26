package com.company;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        try {
            // Set up a connection. We call DriverManager.getConnection() that accepts the connection string
            // and returns the connection instance.
            Connection connectionObject = DriverManager.getConnection(Constant.CONNECTION_STRING);

            // After getting a connection instance (connectionObject), we are creating
            // statement instance (statementObject) and then
            // we are calling the execute method, and we are passing the sql command
            // in this to create a contact table.
            Statement statementObject = connectionObject.createStatement();

            statementObject.execute("CREATE TABLE IF NOT EXISTS " + Constant.TABLE_CONTACTS +
                                        " (" + Constant.COLUMN_NAME + " text, " +
                                               Constant.COLUMN_PHONE + " int, " +
                                               Constant.COLUMN_EMAIL + " text" +
                                       ")");

            insertContact(statementObject,"User1", 12345, "user1@gmail.com");
            insertContact(statementObject,"User2", 67891, "user2@gmail.com");
            insertContact(statementObject,"User3", 56789, "user3@gmail.com");
            insertContact(statementObject,"User4", 98765, "user4@gmail.com");
            insertContact(statementObject,"User5", 88888, "user5@gmail.com");

            statementObject.execute("UPDATE " + Constant.TABLE_CONTACTS + " SET " +
                    Constant.COLUMN_PHONE + "=0000" +
                    " WHERE " + Constant.COLUMN_NAME + "='User4'");

            statementObject.execute("DELETE FROM " +Constant.TABLE_CONTACTS +
                    " WHERE " + Constant.COLUMN_NAME + "='User5'");

            ResultSet results = statementObject.executeQuery("SELECT * FROM " + Constant.TABLE_CONTACTS);
            while(results.next()) {
                System.out.println(results.getString(Constant.COLUMN_NAME) + " " +
                        results.getInt(Constant.COLUMN_PHONE) + " " +
                        results.getString(Constant.COLUMN_EMAIL));
            }

            results.close();

            statementObject.close();
            connectionObject.close();
        }catch (SQLException exception){
            // DriverManager.getConnection() may throw a sql exception.
            // If JDBC driver is not in the classPath then you actually get a class not found exception.
            System.out.println("Something went wrong: " +exception.getMessage());

        }
    }

    public static void insertContact(Statement statementObject, String name, int phone, String email ) throws SQLException{
        statementObject.execute("INSERT INTO " + Constant.TABLE_CONTACTS +
                " (" + Constant.COLUMN_NAME + ", " +
                Constant.COLUMN_PHONE + ", " +
                Constant.COLUMN_EMAIL +
                " ) " +
                "VALUES('" + name + "', " + phone + ", '" + email + "')");
    }
}
