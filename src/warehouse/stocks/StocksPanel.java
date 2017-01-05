/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package warehouse.stocks;

import warehouse.category.*;
import warehouse.priceCode.*;
import accounts.customers.*;
import config.Functions;
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
import warehouse.Warehouse;

/**
 *
 * @author Jake-LAPTOP
 */
public class StocksPanel extends javax.swing.JPanel {
    private Connection conn;
    private ResultSet rs = null;
    private Statement statement = null;
    
    private String tblStocks = "STOCKS";
    private String tblCategory = "CATEGORY";
    private String tblWarehouse = "WAREHOUSE";
    /**
     * Creates new form CustomersPanel
     */
    public StocksPanel(Connection connection) {
        try {
            initComponents();
            
            this.conn = connection;
            this.statement = this.conn.createStatement();
            update_table();
        } catch (SQLException ex) {
            Logger.getLogger(StocksPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void update_table(){
        try { 
//            String sql = "SELECT * FROM "+this.tblStocks;
            String sql = "SELECT "+tblStocks+".CODE as CODE, "+tblStocks+".NAME, "+tblCategory+".NAME as CATEGORY, "+tblWarehouse+".NAME as WAREHOUSE, UNIT, AMOUNT_PER_UNIT, CRITICAL_LEVEL, BALANCE, WHOLESALE_PRICE, RETAIL_PRICE, CRITICAL_LEVEL, BALANCE, "+tblStocks+".DATEADDED as Date "
                    + "FROM "+tblStocks +", "+tblCategory+", "+ tblWarehouse +" "
                    + "WHERE "+tblStocks+".CATEGORY="+tblCategory+".ID "
                    + "AND "+tblStocks+".WAREHOUSE="+tblWarehouse+".CODE ";
            System.out.println("QUERY::: "+sql);
            rs = statement.executeQuery(sql);
                
            DefaultTableModel model = (DefaultTableModel) this.StocksTable.getModel();
            model.setRowCount(0); //clearn table
            while( rs.next() ){
               Object[] rowData = {
                                    rs.getString("CODE"), 
                                    rs.getString("NAME"), 
                                    rs.getString("CATEGORY"),
//                        rs.getInt("CATEGORY"),
                                    rs.getString("WAREHOUSE"),
//                        rs.getInt("WAREHOUSE"),
                                    rs.getString("UNIT"),
                                    rs.getInt("AMOUNT_PER_UNIT"),
                                    String.format("%,.2f", rs.getDouble("WHOLESALE_PRICE")),
                                    String.format("%,.2f", rs.getDouble("RETAIL_PRICE")),
                                    "<HTML><SPAN COLOR='RED'>"+rs.getString("CRITICAL_LEVEL")+"</SPAN></HTML>",
                                    "<HTML><SPAN COLOR='GREEN'>"+rs.getString("BALANCE")+"</SPAN></HTML>",
                                    "<HTML>"+ new SimpleDateFormat("MMMM dd, yyyy\nEEEE hh:mm a").format(rs.getTimestamp("DATE")).replace("\n", "<BR>")+"</HTML>"
               };
               model.addRow(rowData);
            }
            
            this.StocksTable.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 16));

            DefaultTableCellRenderer usercolRenderer = new DefaultTableCellRenderer();
            usercolRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
//            this.CustomersTable.getColumnModel().getColumn(0).setMaxWidth(200);
            this.StocksTable.getColumnModel().getColumn(6).setCellRenderer(usercolRenderer);
            this.StocksTable.getColumnModel().getColumn(7).setCellRenderer(usercolRenderer);
            
            DefaultTableCellRenderer idcolRenderer = new DefaultTableCellRenderer();
            idcolRenderer.setHorizontalAlignment(SwingConstants.CENTER);
            this.StocksTable.getColumnModel().getColumn(0).setCellRenderer(idcolRenderer);
            this.StocksTable.getColumnModel().getColumn(4).setCellRenderer(idcolRenderer);
            this.StocksTable.getColumnModel().getColumn(5).setCellRenderer(idcolRenderer);
            this.StocksTable.getColumnModel().getColumn(8).setCellRenderer(idcolRenderer);
            this.StocksTable.getColumnModel().getColumn(9).setCellRenderer(idcolRenderer);
            
            config.Functions.updateRowHeights(StocksTable);
            this.StocksTable.repaint();
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
        StocksTable = new javax.swing.JTable();
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
        updateBtn.setMnemonic('p');
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

        StocksTable.setAutoCreateRowSorter(true);
        StocksTable.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        StocksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Code", "Name", "Category", "Warehouse", "Unit", "Amount per Unit", "Wholesale Price", "Retail Price", "Critical Lvl", "Balance", "Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        StocksTable.setFocusable(false);
        StocksTable.setIntercellSpacing(new java.awt.Dimension(10, 10));
        StocksTable.setMinimumSize(new java.awt.Dimension(100, 120));
        StocksTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(StocksTable);

        jLabel1.setFont(new java.awt.Font("Anton", 0, 36)); // NOI18N
        jLabel1.setText("Stocks");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1135, Short.MAX_VALUE)
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
        StocksEditorPanel panel = new StocksEditorPanel(this.conn);
        
        Object[] options = {"Submit", "Cancel"};
        int returnVal = JOptionPane.showOptionDialog(null, panel, "Enter new stock information: ",
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
            null, options, null);
        if( returnVal == 0 ){
            //get category id based on selected item from category comboBox
            String strCat = panel.get_category();
            String strWarehouse = panel.get_warehouse();
            int catId = this.get_categoryId(strCat);
            String warehouseCode = this.get_warehouseCode(strWarehouse);
                System.out.println("selected:"+ strCat +" categoryId:"+catId);
            
            Stocks newStock = new Stocks();
                newStock.setCode( panel.get_code() );
                newStock.setName(panel.get_productName());
                newStock.setCategory(new Category(catId));
                newStock.setWarehouse(new Warehouse(warehouseCode));
                newStock.setUnit(panel.get_unit());
                newStock.setAmountPerUnit(panel.get_amountPerUnit());
                newStock.setCriticalLevel(panel.get_criticalLevel());
                newStock.setBalance(panel.get_balance());
                
                newStock.setCost(panel.get_cost());
                newStock.setLess(panel.get_less());
                newStock.setNetPrice(panel.get_netPrice());
                newStock.setWholesaleMarkupPercentage(panel.get_wholesaleMarkupPercentage());
                newStock.setWholesalePrice(panel.get_wholesalePrice());
                newStock.setRetailMarkupPercentage(panel.get_retailMarkupPercentage());
                newStock.setRetailPrice(panel.get_retailPrice());
            
                String sql = "INSERT INTO "+tblStocks+" "
                        + "(CODE, NAME, CATEGORY, WAREHOUSE, UNIT, AMOUNT_PER_UNIT, CRITICAL_LEVEL, BALANCE, "
                        + "COST, LESS, NET_PRICE, "
                        + "WHOLESALE_MARKUP_PERCENTAGE, WHOLESALE_PRICE, RETAIL_MARKUP_PERCENTAGE, RETAIL_PRICE, "
                        + "DATEADDED) "
                        + "VALUES ('"+newStock.getCode()+"', '"+newStock.getName()+"', "+newStock.getCategory().getId()+", '"+newStock.getWarehouse().getCode()+"', '"+newStock.getUnit()+"', "+newStock.getAmountPerUnit()+", "+newStock.getCriticalLevel()+", "+newStock.getBalance()+", "
                        + newStock.getCost()+", "+newStock.getLess()+", "+newStock.getNetPrice()+", "
                        + newStock.getWholesaleMarkupPercentage()+", "+newStock.getWholesalePrice()+", "+newStock.getRetailMarkupPercentage()+", "+newStock.getRetailPrice()+", "
                        + "CURRENT_TIMESTAMP)";
                System.out.println(sql);
            try {
                statement.execute(sql);
            } catch (SQLException ex) {
                Logger.getLogger(StocksPanel.class.getName()).log(Level.SEVERE, null, ex);
            } 
           
        }

            update_table();
    }//GEN-LAST:event_newBtnActionPerformed
    
    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        int srow = this.StocksTable.getSelectedRow();
        System.out.println(srow); //display selected row
        String code = "";
        try {
            code = (String) this.StocksTable.getValueAt(srow, 0);
        } catch(java.lang.IndexOutOfBoundsException outOfBoundsException){
            JOptionPane.showMessageDialog(null, "No Record Selected.");
        }
        
        StocksEditorPanel panel = new StocksEditorPanel(this.conn);
            Stocks selectedStock = this.get_stockInfo(code);
            panel.set_code(selectedStock.getCode());
            panel.set_name(selectedStock.getName());
            panel.set_category(selectedStock.getCategory());
            panel.set_warehouse(selectedStock.getWarehouse());
            panel.set_unit(selectedStock.getUnit());
            panel.set_amountPerUnit(selectedStock.getAmountPerUnit());
            panel.set_criticalLevel(selectedStock.getCriticalLevel());
            panel.set_balance(selectedStock.getBalance());
            
            
            panel.set_cost(selectedStock.getCost());
            panel.set_less(selectedStock.getLess());
            panel.set_netPrice(selectedStock.getNetPrice());
            
            panel.set_wholesaleMarkupPercentage(selectedStock.getWholesaleMarkupPercentage());
            panel.set_wholesalePrice(selectedStock.getWholesalePrice());
            
            panel.set_retailMarkupPercentage(selectedStock.getRetailMarkupPercentage());
            panel.set_retailPrice(selectedStock.getRetailPrice());
            
        Object[] options = {"Submit", "Cancel"};
        int returnVal = JOptionPane.showOptionDialog(null, panel, "Enter a Number",
            JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE,
            null, options, null);
        if( returnVal == 0 ){
            try {
                String sql = "UPDATE "+tblStocks 
                        + " SET CODE='"+panel.get_code()+"', NAME='"+panel.get_productName()+"', CATEGORY="+this.get_categoryId(panel.get_category())+", WAREHOUSE='"+this.get_warehouseCode(panel.get_warehouse())+"',"
                        + " UNIT='"+panel.get_unit()+"', AMOUNT_PER_UNIT="+panel.get_amountPerUnit()+", "
                        + " COST="+panel.get_cost()+", LESS="+panel.get_less()+", NET_PRICE="+panel.get_netPrice()+", "
                        + " CRITICAL_LEVEL="+panel.get_criticalLevel()+", BALANCE="+panel.get_balance()+", "
                        + " WHOLESALE_MARKUP_PERCENTAGE="+panel.get_wholesaleMarkupPercentage()+", WHOLESALE_PRICE="+panel.get_wholesalePrice()+","
                        + " RETAIL_MARKUP_PERCENTAGE="+panel.get_retailMarkupPercentage()+", RETAIL_PRICE="+panel.get_retailPrice()
                        + " WHERE CODE='"+selectedStock.getCode()+"'";
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
            int srow = this.StocksTable.getSelectedRow();
            String code = String.valueOf( this.StocksTable.getValueAt(srow, 0) );
            String sql = "DELETE FROM "+tblStocks+" WHERE CODE='"+code+"'";
            System.out.println(sql);
            statement.execute(sql);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        update_table();
    }//GEN-LAST:event_deleteBtnActionPerformed
    
    public int get_categoryId(String strCat){
        int catId = 0;
        try {
            rs = this.statement.executeQuery("SELECT ID FROM "+ this.tblCategory +" WHERE NAME='"+strCat+"'");
            while(rs.next()){ 
                catId = rs.getInt("ID"); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(StocksPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return catId;
    }
    
    public String get_warehouseCode(String strWarehouse){
        String code = "";
        try {
            rs = this.statement.executeQuery("SELECT CODE FROM "+ this.tblWarehouse +" WHERE NAME='"+strWarehouse+"'");
            while(rs.next()){ 
                code = rs.getString("CODE"); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(StocksPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return code;
    }
    
    public String get_categoryName(int id){
        String name = "";
        try {
            rs = this.statement.executeQuery("SELECT NAME FROM "+ this.tblCategory +" WHERE ID="+id);
            while(rs.next()){ 
                name = rs.getString("NAME"); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(StocksPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return name;
    }
    
    public String get_warehouseName(String code){
        String name = "";
        try {
            rs = this.statement.executeQuery("SELECT NAME FROM "+ this.tblWarehouse +" WHERE CODE='"+code+"'");
            while(rs.next()){ 
                name = rs.getString("NAME"); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(StocksPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return name;
    }
    
    public Stocks get_stockInfo(String code){
        System.out.println(code);
        Stocks stock = new Stocks();
        
        try {
            String sql = "SELECT * FROM "+tblStocks+" WHERE CODE='"+code+"'";
                System.out.println("udpate: "+sql);
            rs = this.statement.executeQuery(sql);
            
            while(rs.next()){
                stock.setCode(rs.getString("CODE"));
                stock.setName(rs.getString("NAME"));
                stock.setUnit(rs.getString("UNIT"));
                stock.setAmountPerUnit(rs.getInt("AMOUNT_PER_UNIT"));
                stock.setCriticalLevel(rs.getInt("CRITICAL_LEVEL"));
                stock.setBalance(rs.getInt("BALANCE"));
                
                stock.setCost(rs.getDouble("COST"));
                stock.setLess(rs.getInt("LESS"));
                stock.setNetPrice(rs.getDouble("NET_PRICE"));
                stock.setWholesaleMarkupPercentage(rs.getInt("WHOLESALE_MARKUP_PERCENTAGE"));
                stock.setWholesalePrice(rs.getDouble("WHOLESALE_PRICE"));
                stock.setRetailMarkupPercentage(rs.getInt("RETAIL_MARKUP_PERCENTAGE"));
                stock.setRetailPrice(rs.getDouble("RETAIL_PRICE"));
                
                Warehouse warehouse = new Warehouse(rs.getString("WAREHOUSE"));
                Category category = new Category(rs.getInt("CATEGORY"));
                
                warehouse.setName( get_warehouseName(warehouse.getCode()) );
                stock.setWarehouse(warehouse);
               
                category.setName( get_categoryName(category.getId()) );
                stock.setCategory(category);
            }
        } catch (SQLException ex) {
            Logger.getLogger(StocksPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return stock;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable StocksTable;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton newBtn;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
