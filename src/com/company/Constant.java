package com.company;

/**
 * Constant class to facilitate JDBC CRUD operation.
 */
public class Constant {
    /**
     * Database name reference with constant variable.
     */
    public static final String DATABASE_NAME = "testjava.db";

    /**
     * Constant to hold the file path to Java application
     */
    public static final String javaApplicationFilePath = "Users/swopnilacharya/Documents/TestDb";

    /**
     * Connection string to connect java application with Database driver.
     * This string is fed into DriverManager.getConnection("connectionString");
     */
    public  static final String CONNECTION_STRING = "jdbc:sqlite:/" +javaApplicationFilePath+ "/" +DATABASE_NAME;

    /**
     * Constant for database table name.
     */
    public static final String TABLE_CONTACTS = "contacts";

    /**
     * Constants defined for column name of contacts table.
     */
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_PHONE = "phone";
    public static final String COLUMN_EMAIL = "email";


    /**
     * Define Constructor.
     */
    private Constant() { }  // Prevents instantiation
}
