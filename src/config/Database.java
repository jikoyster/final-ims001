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
        
        
        
        
        //ORDERS
        createOrdersTable();
        createOrderItemsTable();

        //INVOICES
        createInvoicesTable();
        createInvoiceItemsTable();

        //STOCKS
        createStocksTable();

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
    }

    private void createUserTypes() {
        try {
            Statement statement = this.conn.createStatement();
            
            statement.execute("INSERT INTO USER_TYPE "
                    + "(TYPEID, TYPESTRING) VALUES(1, 'admin') ");
            statement.execute("INSERT INTO USER_TYPE "
                    + "(TYPEID, TYPESTRING) VALUES(2, 'secretary') ");
            statement.execute("INSERT INTO USER_TYPE "
                    + "(TYPEID, TYPESTRING) VALUES(3, 'encoder') ");
        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    private void createTableUser() {
        try {
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
        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createTableUserType() {
        try {
            Statement statement = this.conn.createStatement();
            statement.execute(""
                    + "CREATE TABLE USER_TYPE "
                    + "("
                    + "TYPEID INTEGER PRIMARY KEY,"
                    + "TYPESTRING VARCHAR(25)"
                    + ")");
        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createCustomersTable() {
        try {
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
        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createSuppliersTable() {
        try {
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
        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createWarehouseTable() {
        try {
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
        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createCategoryTable() {
        try {
            Statement statement = this.conn.createStatement();
            statement.execute(""
                    + "CREATE TABLE CATEGORY "
                    + "("
                    + "ID INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "NAME VARCHAR(25),"
                    + "DATEADDED TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
                    + ")");
        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createStocksTable() {
        try {
            Statement statement = this.conn.createStatement();
            statement.execute(""
                    + "CREATE TABLE STOCKS "
                    + "("
                    + "CODE VARCHAR(25) PRIMARY KEY,"
                    + "NAME VARCHAR(50),"
                    + "CATEGORY INTEGER REFERENCES CATEGORY(ID),"
                    + "UNIT VARCHAR(25),"
                    + "AMOUNT_PER_UNIT INTEGER,"
                    + "COST DOUBLE,"
                    + "LESS DOUBLE,"
                    + "NET_PRICE DOUBLE,"
                    + "WHOLESALE_MARKUP_PERCENTAGE INTEGER,"
                    + "WHOLESALE_PRICE DOUBLE,"
                    + "RETAIL_MARKUP_PERCENTAGE INTEGER,"
                    + "RETAIL_PRICE DOUBLE,"
                    + "WAREHOUSE VARCHAR(25) REFERENCES WAREHOUSE(CODE),"
                    + "CRITICAL_LEVEL INTEGER,"
                    + "BALANCE INTEGER,"
                    + "DATEADDED TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
                    + ")");
        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createInvoicesTable() {
        try {
            Statement statement = this.conn.createStatement();
            statement.execute(""
                    + "CREATE TABLE INVOICES "
                    + "("
                    + "ID VARCHAR(25) PRIMARY KEY,"
                    + "CUSTOMER VARCHAR(25) REFERENCES CUSTOMERS(CODE),"
                    + "TOTAL_AMOUNT DOUBLE,"
                    + "DATEADDED TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
                    + ")");
        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createInvoiceItemsTable() {
        try {
            Statement statement = this.conn.createStatement();
            statement.execute(""
                    + "CREATE TABLE INVOICE_ITEMS "
                    + "("
                    + "ITEMID INTEGER PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "INVOICE VARCHAR(25) REFERENCES INVOICES(ID),"
                    + "CODE VARCHAR(25) REFERENCES STOCKS(CODE),"
                    + "QUANTITY INTEGER,"
                    + "PRICE DOUBLE,"
                    + "SUBTOTAL DOUBLE"
                    + ")");
        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createOrdersTable() {
        try {
            Statement statement = this.conn.createStatement();
            statement.execute(""
                    + "CREATE TABLE ORDERS "
                    + "("
                    + "ID VARCHAR(25) PRIMARY KEY,"
                    + "SUPPLIER VARCHAR(25) REFERENCES SUPPLIERS(CODE),"
                    + "TOTAL_AMOUNT DOUBLE,"
                    + "STATUS VARCHAR(25) DEFAULT 'PENDING',"
                    + "DATEADDED TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
                    + ")");
        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createOrderItemsTable() {
        try {
            Statement statement = this.conn.createStatement();
            statement.execute(""
                    + "CREATE TABLE ORDER_ITEMS "
                    + "("
                    + "ITEMID INTEGER PRIMARY KEY NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1),"
                    + "ORDER_REF VARCHAR(25) REFERENCES ORDERS(ID),"
                    + "CODE VARCHAR(25) REFERENCES STOCKS(CODE),"
                    + "QUANTITY INTEGER,"
                    + "PRICE DOUBLE,"
                    + "SUBTOTAL DOUBLE"
                    + ")");
        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}//endClass
