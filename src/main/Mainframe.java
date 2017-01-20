/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import warehouse.stocks.StocksPanel;

/**
 *
 * @author Jake-LAPTOP
 */
public class Mainframe extends javax.swing.JFrame {

    private Connection conn;
    private Statement statement;
    
    JPanel currentPanel;
    
    /**
     * Creates new form Mainframe
     */
    public Mainframe(Connection connection) {
        initComponents();
        this.conn = connection;
        
        this.setCriticalPanel();
    }
    
    public void setCriticalPanel(){
        try {
            this.mainPanel.setVisible(false);
            if( this.currentPanel != null){
                this.getContentPane().removeAll();
            }
            
            StocksPanel criticalLevel = new warehouse.stocks.StocksPanel(this.conn);
            criticalLevel.stocksTitleLbl.setText("Stocks in Critical Level");
            criticalLevel.stocksTitleLbl.setForeground(Color.red);
            ImageIcon icon = new ImageIcon( getClass().getResource("/main/icons/warning.png") );
            criticalLevel.stocksTitleLbl.setIcon(icon);
            
            criticalLevel.btnPanel.setVisible(false);
            criticalLevel.update_criticalStocks_table();
            this.currentPanel = criticalLevel;            
            
            getContentPane().add(this.currentPanel);
            validate();
            repaint();
        } catch (Exception e) {
            System.out.println("STOCKS PAGE");
            e.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        mainPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        criticalLevelM = new javax.swing.JMenu();
        transactionsM = new javax.swing.JMenu();
        invoiceMI = new javax.swing.JMenuItem();
        ordersMI = new javax.swing.JMenuItem();
        warehouseM = new javax.swing.JMenu();
        warehouseMI = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        stocksMI = new javax.swing.JMenuItem();
        categoryMI = new javax.swing.JMenuItem();
        accountsM = new javax.swing.JMenu();
        usersMI = new javax.swing.JMenuItem();
        customersMI = new javax.swing.JMenuItem();
        suppliersMI = new javax.swing.JMenuItem();
        criticalLevelM1 = new javax.swing.JMenu();
        salesReportMI = new javax.swing.JMenuItem();
        inventoryMI = new javax.swing.JMenuItem();
        logoutMI = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventory Management System");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        getContentPane().setLayout(new javax.swing.BoxLayout(getContentPane(), javax.swing.BoxLayout.PAGE_AXIS));

        mainPanel.setBackground(new java.awt.Color(102, 102, 102));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1300, Short.MAX_VALUE)
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 680, Short.MAX_VALUE)
        );

        getContentPane().add(mainPanel);

        criticalLevelM.setMnemonic('c');
        criticalLevelM.setText("Critical Level");
        criticalLevelM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        criticalLevelM.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                criticalLevelMMenuSelected(evt);
            }
        });
        jMenuBar1.add(criticalLevelM);

        transactionsM.setMnemonic('t');
        transactionsM.setText("Transactions");
        transactionsM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        transactionsM.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                transactionsMMenuSelected(evt);
            }
        });

        invoiceMI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        invoiceMI.setMnemonic('i');
        invoiceMI.setText("Invoices");
        invoiceMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceMIActionPerformed(evt);
            }
        });
        transactionsM.add(invoiceMI);

        ordersMI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ordersMI.setMnemonic('o');
        ordersMI.setText("Orders");
        ordersMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ordersMIActionPerformed(evt);
            }
        });
        transactionsM.add(ordersMI);

        jMenuBar1.add(transactionsM);

        warehouseM.setMnemonic('w');
        warehouseM.setText("Warehouse Management");
        warehouseM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        warehouseM.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                warehouseMMenuSelected(evt);
            }
        });

        warehouseMI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        warehouseMI.setMnemonic('w');
        warehouseMI.setText("Warehouse");
        warehouseMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warehouseMIActionPerformed(evt);
            }
        });
        warehouseM.add(warehouseMI);
        warehouseM.add(jSeparator1);

        stocksMI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        stocksMI.setMnemonic('s');
        stocksMI.setText("Stocks Management");
        stocksMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stocksMIActionPerformed(evt);
            }
        });
        warehouseM.add(stocksMI);

        categoryMI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        categoryMI.setMnemonic('c');
        categoryMI.setText("Category");
        categoryMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryMIActionPerformed(evt);
            }
        });
        warehouseM.add(categoryMI);

        jMenuBar1.add(warehouseM);

        accountsM.setMnemonic('a');
        accountsM.setText("Accounts");
        accountsM.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        usersMI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        usersMI.setMnemonic('u');
        usersMI.setText("Users");
        usersMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usersMIActionPerformed(evt);
            }
        });
        accountsM.add(usersMI);

        customersMI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        customersMI.setMnemonic('c');
        customersMI.setText("Customers");
        customersMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customersMIActionPerformed(evt);
            }
        });
        accountsM.add(customersMI);

        suppliersMI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        suppliersMI.setMnemonic('s');
        suppliersMI.setText("Suppliers");
        suppliersMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suppliersMIActionPerformed(evt);
            }
        });
        accountsM.add(suppliersMI);

        jMenuBar1.add(accountsM);

        criticalLevelM1.setMnemonic('r');
        criticalLevelM1.setText("Reports");
        criticalLevelM1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        criticalLevelM1.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                criticalLevelM1MenuSelected(evt);
            }
        });

        salesReportMI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        salesReportMI.setMnemonic('s');
        salesReportMI.setText("Sales Report");
        salesReportMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salesReportMIActionPerformed(evt);
            }
        });
        criticalLevelM1.add(salesReportMI);

        inventoryMI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        inventoryMI.setMnemonic('i');
        inventoryMI.setText("Inventory Report");
        inventoryMI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inventoryMIActionPerformed(evt);
            }
        });
        criticalLevelM1.add(inventoryMI);

        jMenuBar1.add(criticalLevelM1);

        logoutMI.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        logoutMI.setMnemonic('o');
        logoutMI.setText("Logout");
        logoutMI.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        logoutMI.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        logoutMI.addMenuListener(new javax.swing.event.MenuListener() {
            public void menuCanceled(javax.swing.event.MenuEvent evt) {
            }
            public void menuDeselected(javax.swing.event.MenuEvent evt) {
            }
            public void menuSelected(javax.swing.event.MenuEvent evt) {
                logoutMIMenuSelected(evt);
            }
        });
        jMenuBar1.add(logoutMI);

        setJMenuBar(jMenuBar1);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void logoutMIMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_logoutMIMenuSelected
        try {
            this.setVisible(false);
            LoginFrame loginFrame = new LoginFrame( this.conn );
            loginFrame.resetFields();
            loginFrame.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(Mainframe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_logoutMIMenuSelected

    private void usersMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usersMIActionPerformed
        try {
            this.mainPanel.setVisible(false);
            if( this.currentPanel != null){
                this.getContentPane().removeAll();
            }
            
            this.currentPanel = new accounts.users.UsersPanel(this.conn);
            getContentPane().add(this.currentPanel);
            validate();
            repaint();
        } catch (Exception e) {
            System.out.println("USERPAGE");
            e.printStackTrace();
        }
    }//GEN-LAST:event_usersMIActionPerformed

    private void criticalLevelMMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_criticalLevelMMenuSelected
        this.setCriticalPanel();
    }//GEN-LAST:event_criticalLevelMMenuSelected

    private void customersMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_customersMIActionPerformed
        try {
            this.mainPanel.setVisible(false);
            if( this.currentPanel != null){
                this.getContentPane().removeAll();
            }
            
            this.currentPanel = new accounts.customers.CustomersPanel(this.conn);
            getContentPane().add(this.currentPanel);
            validate();
            repaint();
        } catch (Exception e) {
            System.out.println("CUSTOMERPAGE");
            e.printStackTrace();
        }
    }//GEN-LAST:event_customersMIActionPerformed

    private void warehouseMMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_warehouseMMenuSelected
        // TODO add your handling code here:
    }//GEN-LAST:event_warehouseMMenuSelected

    private void stocksMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stocksMIActionPerformed
        try {
            this.mainPanel.setVisible(false);
            if( this.currentPanel != null){
                this.getContentPane().removeAll();
            }
            
            this.currentPanel = new warehouse.stocks.StocksPanel(this.conn);
            getContentPane().add(this.currentPanel);
            validate();
            repaint();
        } catch (Exception e) {
            System.out.println("STOCKS PAGE");
            e.printStackTrace();
        }
    }//GEN-LAST:event_stocksMIActionPerformed

    private void warehouseMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_warehouseMIActionPerformed
        try {
            this.mainPanel.setVisible(false);
            if( this.currentPanel != null){
                this.currentPanel.removeAll();
            }
            
            this.currentPanel = new warehouse.WarehousePanel(this.conn);
            getContentPane().add(this.currentPanel);
            
            validate();
            repaint();
        } catch (Exception e) {
            System.out.println("WAREHOUSE PAGE");
            e.printStackTrace();
        }
    }//GEN-LAST:event_warehouseMIActionPerformed

    private void categoryMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryMIActionPerformed
        try {
            this.mainPanel.setVisible(false);
            if( this.currentPanel != null){
                this.getContentPane().removeAll();
            }
            
            this.currentPanel = new warehouse.category.CategoryPanel(this.conn);
            getContentPane().add(this.currentPanel);
            validate();
            repaint();
        } catch (Exception e) {
            System.out.println("CATEGORY PAGE");
            e.printStackTrace();
        }
    }//GEN-LAST:event_categoryMIActionPerformed

    private void suppliersMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suppliersMIActionPerformed
        try {
            this.mainPanel.setVisible(false);
            if( this.currentPanel != null){
                this.getContentPane().removeAll();
            }
            
            this.currentPanel = new accounts.suppliers.SuppliersPanel(this.conn);
            getContentPane().add(this.currentPanel);
            validate();
            repaint();
        } catch (Exception e) {
            System.out.println("SUPPLIERS PAGE");
            e.printStackTrace();
        }
    }//GEN-LAST:event_suppliersMIActionPerformed

    private void transactionsMMenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_transactionsMMenuSelected
        // TODO add your handling code here:
    }//GEN-LAST:event_transactionsMMenuSelected

    private void invoiceMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_invoiceMIActionPerformed
        try {
            this.mainPanel.setVisible(false);
            if( this.currentPanel != null){
                this.currentPanel.removeAll();
            }
            
            this.currentPanel = new transactions.invoices.InvoicesPanel(this.conn);
            getContentPane().add(this.currentPanel);
            
            validate();
            repaint();
        } catch (Exception e) {
            System.out.println("INVOICES PAGE");
            e.printStackTrace();
        }
    }//GEN-LAST:event_invoiceMIActionPerformed

    private void ordersMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ordersMIActionPerformed
        try {
            this.mainPanel.setVisible(false);
            if( this.currentPanel != null){
                this.currentPanel.removeAll();
            }
            
            this.currentPanel = new transactions.orders.OrdersPanel(this.conn);
            getContentPane().add(this.currentPanel);
            
            validate();
            repaint();
        } catch (Exception e) {
            System.out.println("ORDERS PAGE");
            e.printStackTrace();
        }
    }//GEN-LAST:event_ordersMIActionPerformed

    private void criticalLevelM1MenuSelected(javax.swing.event.MenuEvent evt) {//GEN-FIRST:event_criticalLevelM1MenuSelected
        // TODO add your handling code here:
    }//GEN-LAST:event_criticalLevelM1MenuSelected

    private void salesReportMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salesReportMIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_salesReportMIActionPerformed

    private void inventoryMIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inventoryMIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_inventoryMIActionPerformed
    
    public void logoutMenuItem_setText(String status){
        this.logoutMI.setText(status);
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Mainframe().setVisible(true);
//            }
//        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu accountsM;
    private javax.swing.JMenuItem categoryMI;
    private javax.swing.JMenu criticalLevelM;
    private javax.swing.JMenu criticalLevelM1;
    private javax.swing.JMenuItem customersMI;
    private javax.swing.JMenuItem inventoryMI;
    private javax.swing.JMenuItem invoiceMI;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenu logoutMI;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuItem ordersMI;
    private javax.swing.JMenuItem salesReportMI;
    private javax.swing.JMenuItem stocksMI;
    private javax.swing.JMenuItem suppliersMI;
    private javax.swing.JMenu transactionsM;
    private javax.swing.JMenuItem usersMI;
    private javax.swing.JMenu warehouseM;
    private javax.swing.JMenuItem warehouseMI;
    // End of variables declaration//GEN-END:variables
}
