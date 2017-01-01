/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package transactions.invoices;

import config.Functions;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import warehouse.Warehouse;
import warehouse.category.Category;
import warehouse.stocks.Stocks;
import warehouse.stocks.StocksEditorPanel;
import warehouse.stocks.StocksPanel;

/**
 *
 * @author Jake-LAPTOP
 */
public class InvoiceEditorPanel extends javax.swing.JPanel {

    private Connection conn = null;
    private Statement statement = null;
    
    private String tblStocks = "STOCKS";
    private String tblInvoice = "INVOICES";
    private String tblInvoiceItems = "INVOICE_ITEMS";
    private DefaultTableModel model = new DefaultTableModel();
    
    private String customerCode, customerName;
    
    /**
     * Creates new form InvoiceEditorPanel
     */
    public InvoiceEditorPanel(Connection connection) {
        initComponents();
        
        try {
            this.conn = new config.Database().get_connection();
            this.statement = this.conn.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceEditorPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        DateFormat  savingDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"),
                    displayDateFormat = new SimpleDateFormat("MMM dd, yyyy hh:mm a");
        Date date = new Date();
//        System.out.println( "INVOICE DATE: "+displayDateFormat.format(date) );
        this.dateTF.setText( displayDateFormat.format(date) );
        
        model.addColumn("CODE");
        model.addColumn("NAME");
        model.addColumn("QTY");
        model.addColumn("PRICE");
        model.addColumn("SUBTOTAL");
        
        this.update_table();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        invoiceTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        customerTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceTable = new javax.swing.JTable();
        dateTF = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btn_addItem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        totalTF = new javax.swing.JTextField();
        btn_setCustomer = new javax.swing.JButton();
        btn_remove = new javax.swing.JButton();

        invoiceTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Invoice #");

        customerTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        customerTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                customerTFKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("ITEMS");
        jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        invoiceTable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Product Name", "Qty", "Price", "Subtotal"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        invoiceTable.setIntercellSpacing(new java.awt.Dimension(5, 5));
        invoiceTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(invoiceTable);
        invoiceTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        if (invoiceTable.getColumnModel().getColumnCount() > 0) {
            invoiceTable.getColumnModel().getColumn(0).setMinWidth(20);
            invoiceTable.getColumnModel().getColumn(0).setPreferredWidth(20);
            invoiceTable.getColumnModel().getColumn(1).setMinWidth(300);
            invoiceTable.getColumnModel().getColumn(1).setPreferredWidth(300);
            invoiceTable.getColumnModel().getColumn(2).setMinWidth(20);
            invoiceTable.getColumnModel().getColumn(2).setPreferredWidth(20);
        }

        dateTF.setEditable(false);
        dateTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Date");

        btn_addItem.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_addItem.setText("Add item to list");
        btn_addItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addItemActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("TOTAL AMOUNT");

        totalTF.setEditable(false);
        totalTF.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        totalTF.setHorizontalAlignment(javax.swing.JTextField.RIGHT);

        btn_setCustomer.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_setCustomer.setText("Customer");
        btn_setCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_setCustomerActionPerformed(evt);
            }
        });

        btn_remove.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_remove.setText("Remove Selected Item(s)");
        btn_remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_removeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(totalTF, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(58, 58, 58)
                                        .addComponent(btn_setCustomer)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(invoiceTF)
                                    .addComponent(customerTF)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_addItem, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dateTF, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(invoiceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel6)
                        .addComponent(dateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_setCustomer)
                    .addComponent(customerTF, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_addItem, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_remove, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(totalTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    void update_table(){
        this.invoiceTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16));
        
        DefaultTableCellRenderer subtotalCol = new DefaultTableCellRenderer(); 
            subtotalCol.setHorizontalAlignment(SwingConstants.RIGHT);
            subtotalCol.setPreferredSize( new Dimension(100,35) );
        DefaultTableCellRenderer centerCol = new DefaultTableCellRenderer();
            centerCol.setHorizontalAlignment(SwingConstants.CENTER);
        DefaultTableCellRenderer leftCol = new DefaultTableCellRenderer();
            leftCol.setHorizontalAlignment(SwingConstants.LEFT);
            leftCol.setVerticalAlignment(SwingConstants.VERTICAL);
        
        this.invoiceTable.getColumnModel().getColumn(1).setCellRenderer(leftCol);
        this.invoiceTable.getColumnModel().getColumn(2).setCellRenderer(centerCol);
        this.invoiceTable.getColumnModel().getColumn(3).setCellRenderer(subtotalCol);
        this.invoiceTable.getColumnModel().getColumn(4).setCellRenderer(subtotalCol);
        
        
        this.invoiceTable.getColumnModel().getColumn(2).setPreferredWidth(5);
        
        this.invoiceTable.setModel(model);
        Functions.updateRowHeights(invoiceTable);
    }
    
    private void customerTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_customerTFKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_customerTFKeyReleased

    private void btn_addItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addItemActionPerformed
        AddItemEditorPanel panel = new AddItemEditorPanel(this.conn);
        
        Object[] options = {"Submit", "Cancel"};
        int returnVal = JOptionPane.showOptionDialog(null, panel, "Set Stock for this invoice: ",
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
            null, options, null);
        if( returnVal == 0 ){
                        
            String code     = panel.getCode();
            String name     = panel.getStockName();
            int qty         = panel.getQty();
            double price    = panel.getPrice();
            double subtotal = panel.getSubtotal();
            
            Object[] rowData = {code, "<HTML><B>"+name.trim()+"</B></HTML>", qty, String.format("%,.2f",price), String.format("%,.2f", subtotal)};
            model.addRow( rowData );
        }//if condition

        update_table();
        
        this.setTotal();
    }//GEN-LAST:event_btn_addItemActionPerformed

    private void btn_setCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_setCustomerActionPerformed
        SetCustomerEditorPanel panel = new SetCustomerEditorPanel(this.conn);
        
        Object[] options = {"Submit", "Cancel"};
        int returnVal = JOptionPane.showOptionDialog(null, panel, "Set Customer: ",
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
            null, options, null);
        if( returnVal == 0 ){
            this.customerCode = panel.getSelectedCustomerCode();
            this.customerName = panel.getSelectedCustomerName();
            this.customerTF.setText( this.customerName );
        }//if condition
    }//GEN-LAST:event_btn_setCustomerActionPerformed

    private void btn_removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_removeActionPerformed
        int[] srows = this.invoiceTable.getSelectedRows();
        DefaultTableModel model = (DefaultTableModel) this.invoiceTable.getModel();
        
        for( int i=0; i<srows.length; i++){
            model.removeRow( srows[i] );
        }
        
        this.invoiceTable.setModel(model);
    }//GEN-LAST:event_btn_removeActionPerformed

    public void setTotal(){
        double total = 0;
        for(int i=0; i<this.invoiceTable.getRowCount(); i++){
            total += Double.valueOf(String.valueOf(this.invoiceTable.getValueAt(i, 4)).replace(",", "")) ;
        }
        this.totalTF.setText( String.format("%,.2f", total) );
    }
    
    
    /***************** SETTERS ************************************/
    public void setInvoiceNumber(String invoiceNumber){
        this.invoiceTF.setText(invoiceNumber);
    }
    public void setCustomer(String customer){
        this.customerTF.setText(customer);
    }
    public void setDate(String invoiceDate){
        this.dateTF.setText(invoiceDate);
    }
    public void setTotal(Double total){
        this.totalTF.setText(String.format("%,.2f", total));
    }
    
    public void setItems(String invoiceID){
        String sql = "SELECT * FROM "+this.tblInvoiceItems+", "+this.tblStocks+" "
                + "WHERE INVOICE='"+invoiceID+"' AND "+this.tblInvoiceItems+".CODE="+this.tblStocks+".CODE";
        try {
            DefaultTableModel model = (DefaultTableModel) this.invoiceTable.getModel();
            ResultSet rs = this.statement.executeQuery(sql);
            while( rs.next() ){
                String  code        = rs.getString("CODE");
                String  name        = rs.getString("NAME");
                int     qty         = rs.getInt("QUANTITY");
                double  price       = rs.getDouble("PRICE");
                double  subtotal    = rs.getDouble("SUBTOTAL");
                
                Object[] rowData = {code, "<HTML><B>"+name+"</B></HTML>",  // "<HTML><B>"+nameRS.getString("NAME")+"</B></HTML>", 
                    qty, String.format("%,.2f", price), String.format("%,.2f", subtotal)};
                
                model.addRow(rowData);
            }//while
            config.Functions.updateRowHeights(invoiceTable);
//            this.invoiceTable.setModel(model);
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceEditorPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /***************** GETTERS ************************************/
    public String getInvoiceNumber(){
        return this.invoiceTF.getText().toString();
    }
    public String getCustomer(){
        return this.customerTF.getText().toString();
    }
    public String getDate(){
        return this.dateTF.getText().toString();
    }
    public double getTotal(){
        return Double.valueOf(this.totalTF.getText().replace(",", ""));
    }
    
    public JTable getItems(){
        return this.invoiceTable;
    }
    
    public int getInvoiceTableRows(){
        return this.invoiceTable.getRowCount();
    }
    
    public String getCustomerCode(){
        return this.customerCode;
    }
    public String getCustomerName(){
        return this.customerName;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addItem;
    private javax.swing.JButton btn_remove;
    private javax.swing.JButton btn_setCustomer;
    private javax.swing.JTextField customerTF;
    private javax.swing.JTextField dateTF;
    private javax.swing.JTextField invoiceTF;
    private javax.swing.JTable invoiceTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField totalTF;
    // End of variables declaration//GEN-END:variables
}
