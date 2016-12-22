/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.awt.Component;
import java.util.Locale;

/**
 *
 * @author Jake-LAPTOP
 */
public class Functions {
    
    public static String LoggedUser = "DEFAULT";
    
    public static void updateRowHeights(javax.swing.JTable table)
    {
        for (int row = 0; row < table.getRowCount(); row++)
        {
            int rowHeight = table.getRowHeight();

            for (int column = 0; column < table.getColumnCount(); column++)
            {
                Component comp = table.prepareRenderer(table.getCellRenderer(row, column), row, column);
                rowHeight = Math.max(rowHeight, comp.getPreferredSize().height);
            }

            table.setRowHeight(row, rowHeight+10);
        }
    }
    
    public static String strToMD5(String md5) {
        try {
             java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
             byte[] array = md.digest(md5.getBytes());
             StringBuffer sb = new StringBuffer();
             for (int i = 0; i < array.length; ++i) {
               sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
            }
             return sb.toString();
         } catch (java.security.NoSuchAlgorithmException e) {
         }
         return null;
     }
    
    public static double strToDouble(String strAP){
        strAP = strAP.replace(" ", "");
        strAP = strAP.replace(",", "");
        return java.lang.Double.parseDouble(strAP);
    }
    
    public static String doubleToStr(double AP){
        return String.format(Locale.US, "%,.2f", AP);
    }
    
}//endClass
