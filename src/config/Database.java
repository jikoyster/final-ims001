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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jake-LAPTOP
 */
public class Database {
    private Connection conn;
    
    public String dbname, username, password; 
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
                    System.out.println("Database: "+dbname);
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
        this.dbname = databaseName;
    }
    
    public void set_username(String databaseUsername){
        this.username = databaseUsername;
    }
    
    public void set_password(String databasePassword){
        this.password = databasePassword;
    }
    //getters
    public String get_dbname(){
        return this.dbname;
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
    
    public void loadDatabase() throws SQLException {
        try {
            this.conn = DriverManager.getConnection(
                    "jdbc:derby://localhost:1527/" + this.dbname,
                    this.username, this.password);
            System.out.println("Database Connected!");
        } catch (SQLException sQLException) {
            this.conn = DriverManager.getConnection(
                    "jdbc:derby:" + this.dbname,
                    this.username, this.password);
        }
    }
}//endClass
