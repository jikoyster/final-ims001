/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reports;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jake-LAPTOP
 */
public class IncomeStatementPanel extends javax.swing.JPanel {

    private Connection conn;
    private ResultSet rs = null;
    private Statement statement = null;
    
    private String tblInvoices = "INVOICES";
    
    /**
     * Creates new form IncomeStatementPanel
     */
    public IncomeStatementPanel(Connection connection) {
        try {
            initComponents();
            
            this.conn = connection;
            this.statement = this.conn.createStatement();
            
            this.updateYearCB();
            this.update_table();
        } catch (SQLException ex) {
            Logger.getLogger(SalesPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void update_table(){
        this.incomeStatementTable.setTableHeader(null);
        setCellRendererRight();
        
        DefaultTableModel model = (DefaultTableModel) this.incomeStatementTable.getModel();
        model.setRowCount(0);
        
        //get total sales from INVOICES table
        try {
            String salesQuery = "SELECT SUM(TOTAL_AMOUNT) AS TOTALSALES "
                    + "FROM "+ this.tblInvoices +" "
                    + "WHERE YEAR(DATEADDED) = "+ this.getSelectedYear();
            ResultSet rs = statement.executeQuery(salesQuery);
            while(rs.next()){
                model.addRow( new Object[]{"<HTML><B COLOR='GREEN'>Sales</B></HTML>", "", String.format("%,.2f", rs.getDouble("TOTALSALES")) } );
            }
        } catch (SQLException ex) {
            Logger.getLogger(IncomeStatementPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        String longline = "-----------------------";
        //Cost Of Sales
        model.addRow(new Object[]{"<HTML><B>Cost of Sales</B></HTML>","", "" });
        //Beginning Inventory
        model.addRow(new Object[]{"Beginning Inventory", "x", ""});
        //Add: Purchases
        model.addRow(new Object[]{"Add: Purchases", "x", ""});
        model.addRow(new Object[]{"", longline, ""});
        //Cost of Goods Available for Sale
        model.addRow(new Object[]{"Cost of Goods Available for Sale", "x", ""});
        //Less: Ending Inventory
        model.addRow(new Object[]{"Less: Ending Inventory", "", ""});
        //Gross Sales
        model.addRow(new Object[]{"Gross Sales", longline, longline});
        //Less: Operating Expenses
        model.addRow(new Object[]{"Less: Operating Expenses", "", ""});
            //Salaries & Wages
            model.addRow(new Object[]{"<HTML>&EMSP;Salaries & Wages</HTML>", 0, ""});
            //Taxes & Licenses
            model.addRow(new Object[]{"<HTML>&EMSP;Taxes & Licenses</HTML>", 0, ""});
            //Rental
            model.addRow(new Object[]{"<HTML>&EMSP;Rental</HTML>", 0, ""});
            //Freight
            model.addRow(new Object[]{"<HTML>&EMSP;Freight</HTML>", 0, ""});
            //SSS/PHIC/PAG IBIG
            model.addRow(new Object[]{"<HTML>&EMSP;SSS/PHIC/PAG IBIG</HTML>", 0, ""});
            //Light & Power
            model.addRow(new Object[]{"<HTML>&EMSP;Light & Power</HTML>", 0, ""});
            //Donations
            model.addRow(new Object[]{"<HTML>&EMSP;Donations</HTML>", 0, ""});
            //Christmas Gifts
            model.addRow(new Object[]{"<HTML>&EMSP;Christmas Gifts</HTML>", 0, ""});
            //Bookkeeping Fee
            model.addRow(new Object[]{"<HTML>&EMSP;Bookkeeping Fee</HTML>", 0, ""});
            
            model.addRow(new Object[]{"", longline, longline});
        //Net Income
        model.addRow(new Object[]{"Net Income", "", "xxx"});
        model.addRow(new Object[]{"", "", "======================"});
                
        //Display total sales
        model.addRow(new Object[]{"","","---"});
        
        this.incomeStatementTable.setModel(model);
    }
    
    public void setCellRendererRight(){
        DefaultTableCellRenderer textAlignment = new DefaultTableCellRenderer();
        textAlignment.setHorizontalAlignment(SwingConstants.RIGHT);
        this.incomeStatementTable.getColumnModel().getColumn(1).setCellRenderer(textAlignment);
        this.incomeStatementTable.getColumnModel().getColumn(2).setCellRenderer(textAlignment);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        incomeStatementTable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        yearCB = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Anton", 0, 36)); // NOI18N
        jLabel1.setText("INCOME STATEMENT");

        incomeStatementTable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        incomeStatementTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "", "", ""
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        incomeStatementTable.setIntercellSpacing(new java.awt.Dimension(5, 5));
        incomeStatementTable.setRowHeight(35);
        incomeStatementTable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                incomeStatementTableKeyTyped(evt);
            }
        });
        jScrollPane1.setViewportView(incomeStatementTable);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Select a year");

        yearCB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        yearCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        yearCB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                yearCBItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 767, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(yearCB, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(yearCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 385, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public void updateYearCB(){
        Calendar now = Calendar.getInstance();
        DateFormat format = new SimpleDateFormat("yyyy");
        DefaultComboBoxModel model = (DefaultComboBoxModel) this.yearCB.getModel();
        model.removeAllElements();
        for(int i=0; i<=10; i++){
            model.addElement( String.valueOf(now.get(Calendar.YEAR)-i) );
        }
        this.yearCB.setModel(model);
    }
    
    public int getSelectedYear(){
        int year = 0;
        try {
            year = Integer.parseInt((String) this.yearCB.getSelectedItem());
        } catch (NumberFormatException numberFormatException) {
        }
        
        return year;
    }
    
    private void yearCBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_yearCBItemStateChanged
        this.update_table();
    }//GEN-LAST:event_yearCBItemStateChanged

    private void incomeStatementTableKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_incomeStatementTableKeyTyped
        this.setTotal_OperatingExpenses( this.getTotal_OperatingExpenses() );
    }//GEN-LAST:event_incomeStatementTableKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable incomeStatementTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> yearCB;
    // End of variables declaration//GEN-END:variables

    private double getTotal_OperatingExpenses() {
        double totalOE = 0;
        //9-17 rows for Operating Expenses
        for (int i=9; i<=17; i++){
            try {
                System.out.println("row0"+i);
                totalOE += Double.parseDouble( String.valueOf(this.incomeStatementTable.getValueAt(i, 1)) );
            } catch (NumberFormatException numberFormatException) {
            }
        }
        
        return totalOE;
    }

    private void setTotal_OperatingExpenses(double totalOE) {
        this.incomeStatementTable.setValueAt( String.format("%,.2f", totalOE), 17, 2);
    }
}
