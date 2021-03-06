/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transactions.invoices;

import accounts.customers.*;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jake-LAPTOP
 */
public class InvoicesPanel extends javax.swing.JPanel {
    private Connection conn;
    private ResultSet rs = null;
    private Statement statement = null;
    
    private String tblInvoices = "INVOICES";
    private String tblInvoiceItems = "INVOICE_ITEMS";
    private String tblCustomers = "CUSTOMERS";
    
    public boolean isUpdate = false;
    /**
     * Creates new form CustomersPanel
     */
    public InvoicesPanel(Connection connection) {
        try {
            initComponents();
            
            this.conn = connection;
            this.statement = this.conn.createStatement();
            update_table();
        } catch (SQLException ex) {
            Logger.getLogger(InvoicesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void update_table(){
        try { 
            String sql = ""
                    + "SELECT ID, TOTAL_AMOUNT, "+this.tblCustomers+".NAME AS CUSTOMER, "+this.tblInvoices+".DATEADDED as DATE "
                    + "FROM "+this.tblInvoices+" INNER JOIN "+this.tblCustomers+" "
                    + "ON "+this.tblCustomers+".CODE="+this.tblInvoices+".CUSTOMER";
            rs = statement.executeQuery(sql);
            
            DefaultTableModel model = (DefaultTableModel) this.InvoicesTable.getModel();
            model.setRowCount(0); //clearn table
            while( rs.next() ){
               Object[] rowData = {
                                    rs.getString("ID"), 
                                    String.format("%,.2f", rs.getDouble("TOTAL_AMOUNT")),
                                    rs.getString("CUSTOMER"),
                                    "<HTML>"+ new SimpleDateFormat("MMMM dd, yyyy\nEEEE hh:mm a").format(rs.getTimestamp("DATE")).replace("\n", "<BR>")+"</HTML>"
               };
               model.addRow(rowData);
            }
            
            this.InvoicesTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16));

            DefaultTableCellRenderer usercolRenderer = new DefaultTableCellRenderer();
            usercolRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
            
            DefaultTableCellRenderer idcolRenderer = new DefaultTableCellRenderer();
            idcolRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            this.InvoicesTable.getColumnModel().getColumn(0).setCellRenderer(idcolRenderer);
            
            config.Functions.updateRowHeights(InvoicesTable);
            this.InvoicesTable.repaint();
        } catch (SQLException ex) {
            ex.printStackTrace();
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

        newBtn = new javax.swing.JButton();
        updateBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        InvoicesTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        newBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        newBtn.setForeground(new java.awt.Color(0, 153, 0));
        newBtn.setMnemonic('n');
        newBtn.setText("New");
        newBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newBtnActionPerformed(evt);
            }
        });

        updateBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(0, 0, 153));
        updateBtn.setMnemonic('u');
        updateBtn.setText("Update Selected Record");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        deleteBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deleteBtn.setForeground(new java.awt.Color(153, 0, 0));
        deleteBtn.setMnemonic('d');
        deleteBtn.setText("Delete Selected Record");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        InvoicesTable.setAutoCreateRowSorter(true);
        InvoicesTable.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        InvoicesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Total Amount", "Customer", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        InvoicesTable.setFocusable(false);
        InvoicesTable.setIntercellSpacing(new java.awt.Dimension(10, 10));
        InvoicesTable.setMinimumSize(new java.awt.Dimension(100, 120));
        InvoicesTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(InvoicesTable);

        jLabel1.setFont(new java.awt.Font("Anton", 0, 36)); // NOI18N
        jLabel1.setText("INVOICES PAGE MANAGEMENT");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 796, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(newBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(updateBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(deleteBtn))
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(newBtn)
                        .addComponent(deleteBtn)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 262, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBtnActionPerformed
        InvoiceEditorPanel panel = new InvoiceEditorPanel(this.conn);
        
        Object[] options = {"Submit", "Cancel"};
        int returnVal = JOptionPane.showOptionDialog(null, panel, "Enter new Invoice: ",
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
            null, options, null);
        if( returnVal == 0 ){
            //create the invoice 1st
            String invoiceID        = panel.getInvoiceNumber();
            String customer         = panel.getCustomerCode();
            Double total            = panel.getTotal();
            
            String sqlInvoice = "INSERT INTO "+this.tblInvoices+" "
                    + "(ID, TOTAL_AMOUNT, CUSTOMER, DATEADDED) "
                    + "VALUES ('"+invoiceID+"', "+total+", '"+customer+"', CURRENT_TIMESTAMP)";
            System.out.println(sqlInvoice);
            try {
                this.statement.execute(sqlInvoice);
            } catch (SQLException ex) {
                Logger.getLogger(InvoicesPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            //create the items of this invoice
            int rows                = panel.getInvoiceTableRows();
            System.out.println("INV-ROWS: "+rows);
            for(int i=0; i<rows; i++){
                String itemCode     = (String) panel.getItems().getValueAt(i, 0);
                String itemName     = (String) panel.getItems().getValueAt(i, 1);
                int    itemQty      = (int) panel.getItems().getValueAt(i, 2);
                double itemPrice    = Double.valueOf( ((String)panel.getItems().getValueAt(i, 3)).replace(",", "") );
                double itemSubtotal = Double.valueOf( ((String)panel.getItems().getValueAt(i, 4)).replace(",", "") );
                
                String sqlItem = "INSERT INTO "+ this.tblInvoiceItems +" "
                        +"(INVOICE, CODE, QUANTITY, PRICE, SUBTOTAL) "
                        + "VALUES ('"+invoiceID+"', '"+itemCode+"', "+itemQty+", "+itemPrice+", "+itemSubtotal+" )";
                System.out.println(sqlItem);
                try {
                    this.statement.execute(sqlItem);
                } catch (SQLException ex) {
                    Logger.getLogger(InvoicesPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }//INVOICE ITEMS LOOP //FOR

        }//IF 

            update_table();
    }//GEN-LAST:event_newBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        this.isUpdate = true;
        
        int srow = this.InvoicesTable.getSelectedRow();
        System.out.println("SELECTED ROW: "+srow);
        
        InvoiceEditorPanel panel = new InvoiceEditorPanel(this.conn);
        panel.isUpdate = true;
        ResultSet rs = null;
        /*
        * set the fields
        */
        String rowID = (String) this.InvoicesTable.getValueAt(srow, 0);
        String updateSql = "SELECT * FROM "+this.tblInvoices+" "
                + "INNER JOIN "+this.tblCustomers+" "
                + "ON "+this.tblCustomers+".CODE="+this.tblInvoices+".CUSTOMER "
                + "AND "+this.tblInvoices+".ID='"+rowID+"'";
        try {
            rs = this.statement.executeQuery(updateSql);
            rs.next();
            
            panel.setInvoiceNumber( rowID );
            panel.setCustomer(rs.getString("NAME"));
            panel.setDate(rs.getString("DATEADDED"));
            panel.setTotal(rs.getDouble("TOTAL_AMOUNT"));
            
            panel.setItems(rowID);
            
        } catch (SQLException ex) {
            Logger.getLogger(InvoicesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        //*************
        Object[] options = {"Submit", "Cancel"};
        int returnVal = JOptionPane.showOptionDialog(null, panel, "Update Invoice: ",
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
            null, options, null);
        if( returnVal == 0 ){
            //create the invoice 1st
            String invoiceID        = panel.getInvoiceNumber();
            String customer         = panel.getCustomerCode();
            Double total            = panel.getTotal();
            
            
            String sqlInvoice = "";
            if(!this.isUpdate){
                sqlInvoice = "INSERT INTO "+this.tblInvoices+" "
                        + "(ID, TOTAL_AMOUNT, CUSTOMER, DATEADDED) "
                        + "VALUES ('"+invoiceID+"', "+total+", '"+customer+"', CURRENT_TIMESTAMP)";
            }else{
                sqlInvoice = "UPDATE "+this.tblInvoices+" "
                    + "SET TOTAL_AMOUNT="+total+", DATEADDED=CURRENT_TIMESTAMP "
                    + "WHERE ID='"+invoiceID+"' ";
            }
                   
            try {
                System.out.println("EXECUTE UPDATE: "+sqlInvoice);
                this.statement.execute(sqlInvoice);
            } catch (SQLException ex) {
                Logger.getLogger(InvoicesPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            if(this.isUpdate){
                //#1
                String deleteAllItemsFromInvoice = "DELETE FROM "+this.tblInvoiceItems+" WHERE INVOICE='"+invoiceID+"'";
                try {
                    this.statement.execute(deleteAllItemsFromInvoice);
                } catch (SQLException ex) {
                    Logger.getLogger(InvoicesPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            //create the items of this invoice
            int rows                = panel.getInvoiceTableRows();
            System.out.println("INV-ROWS: "+rows);
            for(int i=0; i<rows; i++){
                String itemCode     = (String) panel.getItems().getValueAt(i, 0);
                String itemName     = (String) panel.getItems().getValueAt(i, 1);
                int    itemQty      = (int) panel.getItems().getValueAt(i, 2);
                double itemPrice    = Double.valueOf( ((String)panel.getItems().getValueAt(i, 3)).replace(",", "") );
                double itemSubtotal = Double.valueOf( ((String)panel.getItems().getValueAt(i, 4)).replace(",", "") );
                
                
                
                String sqlItem = "INSERT INTO "+ this.tblInvoiceItems +" "
                            +"(INVOICE, CODE, QUANTITY, PRICE, SUBTOTAL) "
                            + "VALUES ('"+invoiceID+"', '"+itemCode+"', "+itemQty+", "+itemPrice+", "+itemSubtotal+" )";
                
                
                try {
                    this.statement.execute(sqlItem);
                } catch (SQLException ex) {
                    Logger.getLogger(InvoicesPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }//INVOICE ITEMS LOOP //FOR

        }//IF 

            update_table();
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        try {
            int srow = this.InvoicesTable.getSelectedRow();
            String invoiceID = String.valueOf( this.InvoicesTable.getValueAt(srow, 0) );
            
            String invoiceItemsDelSql = "DELETE FROM "+this.tblInvoiceItems+" WHERE INVOICE='"+invoiceID+"'";
            statement.execute(invoiceItemsDelSql);
            String invoiceDelSql = "DELETE FROM "+this.tblInvoices+" WHERE ID='"+invoiceID+"'";
            statement.execute(invoiceDelSql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        update_table();
    }//GEN-LAST:event_deleteBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable InvoicesTable;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newBtn;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
