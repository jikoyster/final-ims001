/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts.customers;

import java.awt.Font;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jake-LAPTOP
 */
public class CustomersPanel extends javax.swing.JPanel {
    private Connection conn;
    private ResultSet rs = null;
    private Statement statement = null;
    
    private String table = "CUSTOMERS";
    /**
     * Creates new form CustomersPanel
     */
    public CustomersPanel(Connection connection) {
        try {
            initComponents();
            
            this.conn = connection;
            this.statement = this.conn.createStatement();
            update_table();
        } catch (SQLException ex) {
            Logger.getLogger(CustomersPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void update_table(){
        try { 
            rs = statement.executeQuery(""
                    + "SELECT CODE, NAME, ADDRESS, "
                    + "PHONE, FAX, EMAIL, DATEADDED as Date "
                    + "from "+table );
//            this.CustomersTable.setModel( DbUtils.resultSetToTableModel(rs) );


            DefaultTableModel model = (DefaultTableModel) this.CustomersTable.getModel();
            model.setRowCount(0); //clearn table
            while( rs.next() ){
               Object[] rowData = {
                                    rs.getString("CODE"), 
                                    rs.getString("NAME"), 
                                    "<HTML>"+ (rs.getString("ADDRESS")).replace("\n", "<BR>") +"</HTML>", 
                                    rs.getString("PHONE"),
                                    rs.getString("FAX"),
                                    rs.getString("EMAIL"),
//                                    String.format(Locale.US, "%,.2f", rs.getDouble("BALANCE")), 
                                    "<HTML>"+ new SimpleDateFormat("MMMM dd, yyyy\nEEEE hh:mm a").format(rs.getTimestamp("DATE")).replace("\n", "<BR>")+"</HTML>"
               };
               model.addRow(rowData);
            }
            
            this.CustomersTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16));
            
//            DefaultTableCellRenderer testR = new DefaultTableCellRenderer();
//            testR.setText("bang");

            DefaultTableCellRenderer usercolRenderer = new DefaultTableCellRenderer();
            usercolRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
            
//            this.CustomersTable.getColumnModel().getColumn(0).setMaxWidth(200);
//            this.CustomersTable.getColumnModel().getColumn(1).setCellRenderer(usercolRenderer);
//            this.CustomersTable.getColumnModel().getColumn(2).setCellRenderer(usercolRenderer);
            
//            this.CustomersTable.getColumnModel().getColumn(2).setCellRenderer(testR);
            
            DefaultTableCellRenderer idcolRenderer = new DefaultTableCellRenderer();
            idcolRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            this.CustomersTable.getColumnModel().getColumn(0).setCellRenderer(idcolRenderer);
            
            config.Functions.updateRowHeights(CustomersTable);
            this.CustomersTable.repaint();
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
        CustomersTable = new javax.swing.JTable();
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

        CustomersTable.setAutoCreateRowSorter(true);
        CustomersTable.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        CustomersTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Name", "Address", "Phone", "FAX", "Email", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        CustomersTable.setFocusable(false);
        CustomersTable.setIntercellSpacing(new java.awt.Dimension(10, 10));
        CustomersTable.setMinimumSize(new java.awt.Dimension(100, 120));
        CustomersTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(CustomersTable);

        jLabel1.setFont(new java.awt.Font("Anton", 0, 36)); // NOI18N
        jLabel1.setText("Customers");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 854, Short.MAX_VALUE)
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(newBtn)
                    .addComponent(updateBtn)
                    .addComponent(deleteBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 333, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void newBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newBtnActionPerformed
        CustomerEditorPanel panel = new CustomerEditorPanel();
        
        Object[] options = {"Submit", "Cancel"};
        int returnVal = JOptionPane.showOptionDialog(null, panel, "Enter new customer information: ",
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
            null, options, null);
        if( returnVal == 0 ){
            Customers newCustomer = new Customers();
            try {
                newCustomer.setCode(panel.get_code() );
                newCustomer.setName( panel.get_name()    );
                newCustomer.setAddress( panel.get_address() );
                
                newCustomer.setPhone(panel.get_phone());
                newCustomer.setFax(panel.get_fax());
                newCustomer.setEmail(panel.get_email());

//                newCustomer.setBalance( panel.get_balance() );
                
//                String code = panel.get_customerCode(),
//                        name = panel.get_name(),
//                        contact = panel.get_contact(),
//                        dateAdded = panel.get_dateAdded();
//                double balance = 100.10;
                
                

                String sql = "INSERT INTO "+table+" "
                        + "(CODE, NAME, ADDRESS, PHONE, EMAIL, FAX, DATEADDED) "
                        + "VALUES ('"+newCustomer.getCode()+"','"+newCustomer.getName()+"', '" + newCustomer.getAddress() +"', '"
                        + newCustomer.getPhone()+"', '"+ newCustomer.getEmail() +"', '"+ newCustomer.getFax() +"',"
                        + " CURRENT_TIMESTAMP)";
                System.out.println(sql  );
                statement.execute(sql);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

            update_table();
    }//GEN-LAST:event_newBtnActionPerformed

    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        int srow = this.CustomersTable.getSelectedRow();
        System.out.println(srow); //display selected row
        
        
        
        CustomerEditorPanel panel = new CustomerEditorPanel();
            panel.set_code((String) this.CustomersTable.getValueAt(srow, 0));
            panel.set_name((String) this.CustomersTable.getValueAt(srow, 1));
            panel.set_address((String) this.CustomersTable.getValueAt(srow, 2));
            panel.set_phone((String) this.CustomersTable.getValueAt(srow, 3));
            panel.set_fax((String) this.CustomersTable.getValueAt(srow, 4));
            panel.set_email((String) this.CustomersTable.getValueAt(srow, 5));
//            panel.set_balance((String) this.CustomersTable.getValueAt(srow, 6));
        
        
        Object[] options = {"Submit", "Cancel"};
        int returnVal = JOptionPane.showOptionDialog(null, panel, "Enter a Number",
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
            null, options, null);
        if( returnVal == 0 ){

            try {
                String sql = "UPDATE "+table 
                        + " SET NAME='"+ panel.get_name() +"', ADDRESS='"+ panel.get_address()+"', "
                        + " PHONE='"+ panel.get_phone() +"', EMAIL='"+ panel.get_email() +"', FAX='"+ panel.get_fax() +"' "
//                        + " BALANCE="+ panel.get_balance()
                        + " WHERE CODE='"+ panel.get_code() +"'";
                System.out.println("THE QUERY: "+sql);
                statement.execute(sql);
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            update_table();
        }       
    }//GEN-LAST:event_updateBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        try {
            int srow = this.CustomersTable.getSelectedRow();
            String id = String.valueOf( this.CustomersTable.getValueAt(srow, 0) );
            String sql = "DELETE FROM "+table+" WHERE CODE='"+id+"'";
            System.out.println(id);
            statement.execute(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        update_table();
    }//GEN-LAST:event_deleteBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable CustomersTable;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newBtn;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}