/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jake-LAPTOP
 */
public class Database {
    private Connection conn = null;
    
    public String dbName, username, password; 
    /*
    * initialize Database() and connect to the named database on config.txt file
    * dbname    = ""
    * username  = ""
    * password  = ""
    * from this object you can get the connection to create Statement to call executeQuery()
    */
    public Database() throws SQLException{
        
        try {
            File file = new File("config.txt");
            Scanner input = new Scanner(file);
            
            while( input.hasNext() ){
                String line = input.nextLine();
                
                if( line.contains("dbname = ") ){
                    String[] dbnameArr = line.split("dbname = ");
                    this.set_dbname(dbnameArr[1]);
                    System.out.println("Database: "+dbName);
                }else if( line.contains("username = ") ){
                    String[] usernameArr = line.split("username = ");
                    this.set_username(usernameArr[1]);
                    System.out.println("username: "+username);
                }else if( line.contains("password = ") ){
                    String[] passwordArr = line.split("password = ");
                    this.set_password(passwordArr[1]);
                    System.out.println("password: "+password);
                }
            }
            
            loadDatabase();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
        
    //setters
    public void set_dbname(String databaseName){
        this.dbName = databaseName;
    }
    
    public void set_username(String databaseUsername){
        this.username = databaseUsername;
    }
    
    public void set_password(String databasePassword){
        this.password = databasePassword;
    }
    //getters
    public String get_dbname(){
        return this.dbName;
    }
    
    public String get_username(){
        return this.username;
    }
    
    public String get_password(){
        return this.password;
    }
    
    public Connection get_connection(){
        return this.conn;
    }
    
    public void loadDatabase() throws SQLException{
        try {
//            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            this.conn = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/" + this.dbName + ";create=true",
                    this.username, this.password);
            
            System.out.println("Database Connected!");
        } catch (SQLException sQLException) {
            sQLException.printStackTrace();
        } 
//        catch (ClassNotFoundException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
        
        try {
            //WAREHOUSE
            createCategoryTable();
            
            //WAREHOUSE
            createWarehouseTable();
            
            
            //USERS
            createTableUserType();
            createTableUser();
            createUserTypes();
            
            //CUSTOMERS
            createCustomersTable();
            
            //SUPPLIERS
            createSuppliersTable();
        } catch (SQLException sQLException) {
        }
        
    }

    private void createUserTypes() throws SQLException {
        Statement statement = this.conn.createStatement();
        
        statement.execute("INSERT INTO USER_TYPE "
                + "(TYPEID, TYPESTRING) VALUES(1, 'admin') ");
        statement.execute("INSERT INTO USER_TYPE "
                + "(TYPEID, TYPESTRING) VALUES(2, 'secretary') ");
        statement.execute("INSERT INTO USER_TYPE "
                + "(TYPEID, TYPESTRING) VALUES(3, 'encoder') ");
    }
    
    

    private void createTableUser() throws SQLException {
        Statement statement = this.conn.createStatement();
        
        statement.execute(""
                + "CREATE TABLE USERS("
                + "ID INTEGER PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                + "USERNAME VARCHAR(50),"
                + "PASSWORD VARCHAR(50),"
                + "DATEADDED TIMESTAMP DEFAULT CURRENT_TIMESTAMP,"
                + "TYPEID INTEGER REFERENCES USER_TYPE(TYPEID),"
                + "LOG VARCHAR(1000)"
                + ")");
    }

    private void createTableUserType() throws SQLException {
        Statement statement = this.conn.createStatement();
        statement.execute(""
                + "CREATE TABLE USER_TYPE "
                + "("
                + "TYPEID INTEGER PRIMARY KEY,"
                + "TYPESTRING VARCHAR(25)"
                + ")");
    }

    private void createCustomersTable() throws SQLException {
        Statement statement = this.conn.createStatement();        
        statement.execute(""
                + "CREATE TABLE CUSTOMERS "
                + "("
                + "CODE VARCHAR(25) PRIMARY KEY,"
                + "NAME VARCHAR(25),"
                + "ADDRESS VARCHAR(500),"
                + "PHONE VARCHAR(25),"
                + "EMAIL VARCHAR(25),"
                + "FAX VARCHAR(25),"
                + "DATEADDED TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
                + ")");
    }

    private void createSuppliersTable() throws SQLException {
        Statement statement = this.conn.createStatement();        
        statement.execute(""
                + "CREATE TABLE SUPPLIERS "
                + "("
                + "CODE VARCHAR(25) PRIMARY KEY,"
                + "NAME VARCHAR(25),"
                + "ADDRESS VARCHAR(500),"
                + "PHONE VARCHAR(25),"
                + "EMAIL VARCHAR(25),"
                + "FAX VARCHAR(25),"
                + "DATEADDED TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
                + ")");
    }

    private void createWarehouseTable() throws SQLException {
        Statement statement = this.conn.createStatement();        
        statement.execute(""
                + "CREATE TABLE WAREHOUSE "
                + "("
                + "CODE VARCHAR(25) PRIMARY KEY,"
                + "NAME VARCHAR(25),"
                + "ADDRESS VARCHAR(500),"
                + "PHONE VARCHAR(25),"
                + "EMAIL VARCHAR(25),"
                + "FAX VARCHAR(25),"
                + "DATEADDED TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
                + ")");
    }

    private void createCategoryTable() throws SQLException {
        Statement statement = this.conn.createStatement();        
        statement.execute(""
                + "CREATE TABLE CATEGORY "
                + "("
                + "ID INTEGER PRIMARY KEY,"
                + "NAME VARCHAR(25),"
                + "DATEADDED TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
                + ")");
    }
    
}//endClass
