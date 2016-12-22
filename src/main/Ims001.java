/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import config.Database;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jake-LAPTOP
 */
public class Ims001 {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Database db;
        try {
            db = new Database();
//            LoginFrame frame = new LoginFrame(db.get_connection());
            Mainframe frame = new Mainframe(db.get_connection());
            frame.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Ims001.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
