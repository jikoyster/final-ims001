package warehouse.stocks;

import javax.swing.DefaultComboBoxModel;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import warehouse.Warehouse;
import warehouse.category.Category;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jake-LAPTOP
 */
public class StocksEditorPanel extends javax.swing.JPanel {
    private Connection conn;
    private ResultSet rs = null;
    private Statement statement = null;
    
    private String tblCategory = "CATEGORY";
    private String tblWarehouse = "WAREHOUSE";
    private Category category = null;
    private Warehouse warehouse = null;
    private String code = "";
    
    /**
     * Creates new form StocksEditorPanel
     */
    public StocksEditorPanel(Connection connection) {
        try {
            initComponents();
            this.conn = connection;
            this.statement = this.conn.createStatement();
            
            fill_category();
            fill_warehouse();
        } catch (SQLException ex) {
            Logger.getLogger(StocksEditorPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void fill_category() throws SQLException{
        DefaultComboBoxModel model = (DefaultComboBoxModel) this.categoryCB.getModel();
        model.removeAllElements();
        String sql = "SELECT NAME FROM "+ tblCategory;
        this.rs = this.statement.executeQuery(sql);

        while(rs.next()){
            model.addElement(rs.getString("NAME"));
        }
    }
    
    public void fill_warehouse() throws SQLException{
        DefaultComboBoxModel model = (DefaultComboBoxModel) this.warehouseCB.getModel();
        model.removeAllElements();
        String sql = "SELECT NAME FROM "+ tblWarehouse;
        this.rs = this.statement.executeQuery(sql);

        while(rs.next()){
            model.addElement(rs.getString("NAME"));
        }
    }
    
    //setters
    public void set_code(String code){
        this.codeTF.setText(code);
    }
    public void set_name(String name){
        this.nameTF.setText(name);
    }
    public void set_category(Category category){
        this.category = category;
        this.categoryCB.setSelectedItem(category.getName());
    }
    public void set_warehouse(Warehouse warehouse){
        this.warehouse = warehouse;
        this.warehouseCB.setSelectedItem(warehouse.getName());
    }
    public void set_unit(String unit){
        this.unitTF.setText(unit);
    }
    public void set_amountPerUnit(int amtPerUnit){
        this.amountTF.setText(String.valueOf(amtPerUnit));
    }
    
    public void set_cost(double cost){
        this.costTF.setText( String.format("%,.2f", cost) );
    }
    public void set_less(int less){
        this.lessTF.setText(String.valueOf(less));
    }
    public void set_netPrice(double netPrice){
//        this.netPriceTF.setText(String.format("%,.2f", netPrice));
        this.netPriceTF.setText( String.format("%,.2f", this.compute_netPrice()) );
    }
    
    public void set_wholesaleMarkupPercentage(int wMarkup){
        this.wholesaleMarkupPercentageTF.setText(String.valueOf(wMarkup));
    }
    public void set_wholesalePrice(double wPrice){
        this.wholesalePriceTF.setText(String.format("%,.2f", wPrice));
    }
    
    public void set_retailMarkupPercentage(int rMarkup){
        this.retailMarkupPercentageTF.setText(String.valueOf(rMarkup));
    }
    public void set_retailPrice(double rPrice){
        this.retailPriceTF.setText(String.format("%,.2f", rPrice));
//        this.retailPriceTF.setText( String.format("%,.2f", this.compute_netPrice()) );
    }
    
    
    //getters
    public String get_code(){
        return this.codeTF.getText();
    }
    public String get_productName(){
        return this.nameTF.getText();
    }
    public String get_category(){
        return (String) this.categoryCB.getSelectedItem();
    }
    public String get_warehouse(){
        return (String) this.warehouseCB.getSelectedItem();
    }
    public String get_unit(){
        return this.unitTF.getText();
    }
    public int get_amountPerUnit(){
        return Integer.parseInt( this.amountTF.getText() );
    }
    //COST
    public double get_cost(){
        return Double.parseDouble( this.costTF.getText().replace(",", "") );
    }
    public int get_less(){
        return Integer.parseInt( this.lessTF.getText() );
    }
    public double get_netPrice(){
        return Double.parseDouble( this.netPriceTF.getText().replace(",", "") );
    }
    //WHOLESALE DETAILS
    public int get_wholesaleMarkupPercentage(){
        return Integer.parseInt( this.wholesaleMarkupPercentageTF.getText() );
    }
    public double get_wholesalePrice(){
        return Double.parseDouble( this.wholesalePriceTF.getText().replace(",", "") );
    }
    //RETAIL DETAILS
    public int get_retailMarkupPercentage(){
        return Integer.parseInt( this.retailMarkupPercentageTF.getText() );
    }
    public double get_retailPrice(){
        return Double.parseDouble( this.retailPriceTF.getText().replace(",", "") );
    }
    
    //auto computations
    public double compute_netPrice(){
        double cost = Double.parseDouble(this.costTF.getText().replace(",", ""));
        double less = Double.parseDouble(this.lessTF.getText());
        double netPrice = cost - (cost*(less/100));
        return netPrice;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        genInfoPanel = new javax.swing.JPanel();
        nameTF = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        codeTF = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        categoryCB = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        unitTF = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        amountTF = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        warehouseCB = new javax.swing.JComboBox<>();
        genInfoPanel1 = new javax.swing.JPanel();
        costTF = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lessTF = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        netPriceTF = new javax.swing.JTextField();
        wholesaleDetailsPanel = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        wholesaleMarkupPercentageTF = new javax.swing.JTextField();
        wholesalePriceTF = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        wholesaleDetailsPanel1 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        retailMarkupPercentageTF = new javax.swing.JTextField();
        retailPriceTF = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();

        genInfoPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "General Information", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N

        nameTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Product Code");

        codeTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Name");

        categoryCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Category");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Unit");

        unitTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Amount per Unit");

        amountTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel13.setText("Warehouse");

        warehouseCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout genInfoPanelLayout = new javax.swing.GroupLayout(genInfoPanel);
        genInfoPanel.setLayout(genInfoPanelLayout);
        genInfoPanelLayout.setHorizontalGroup(
            genInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(genInfoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(genInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(genInfoPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(unitTF, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(amountTF, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(genInfoPanelLayout.createSequentialGroup()
                        .addGroup(genInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, genInfoPanelLayout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(nameTF))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, genInfoPanelLayout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(codeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(genInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(genInfoPanelLayout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(categoryCB, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(genInfoPanelLayout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(warehouseCB, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        genInfoPanelLayout.setVerticalGroup(
            genInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(genInfoPanelLayout.createSequentialGroup()
                .addGroup(genInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codeTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(categoryCB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(genInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(warehouseCB, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(genInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(genInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(amountTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(genInfoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(unitTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        genInfoPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Pricing Information", javax.swing.border.TitledBorder.LEFT, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N

        costTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Cost");

        lessTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lessTF.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lessTFKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lessTFKeyReleased(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Less");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Net Price");

        netPriceTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        wholesaleDetailsPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Wholesale Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel9.setText("Markup Percentage");

        wholesaleMarkupPercentageTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        wholesalePriceTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Price");

        javax.swing.GroupLayout wholesaleDetailsPanelLayout = new javax.swing.GroupLayout(wholesaleDetailsPanel);
        wholesaleDetailsPanel.setLayout(wholesaleDetailsPanelLayout);
        wholesaleDetailsPanelLayout.setHorizontalGroup(
            wholesaleDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wholesaleDetailsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wholesaleMarkupPercentageTF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(wholesalePriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        wholesaleDetailsPanelLayout.setVerticalGroup(
            wholesaleDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wholesaleDetailsPanelLayout.createSequentialGroup()
                .addGroup(wholesaleDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(wholesaleDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(wholesalePriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(wholesaleDetailsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(wholesaleMarkupPercentageTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        wholesaleDetailsPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Retail Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 16))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel11.setText("Markup Percentage");

        retailMarkupPercentageTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        retailPriceTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel12.setText("Price");

        javax.swing.GroupLayout wholesaleDetailsPanel1Layout = new javax.swing.GroupLayout(wholesaleDetailsPanel1);
        wholesaleDetailsPanel1.setLayout(wholesaleDetailsPanel1Layout);
        wholesaleDetailsPanel1Layout.setHorizontalGroup(
            wholesaleDetailsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wholesaleDetailsPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(retailMarkupPercentageTF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(retailPriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        wholesaleDetailsPanel1Layout.setVerticalGroup(
            wholesaleDetailsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(wholesaleDetailsPanel1Layout.createSequentialGroup()
                .addGroup(wholesaleDetailsPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(retailMarkupPercentageTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(retailPriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout genInfoPanel1Layout = new javax.swing.GroupLayout(genInfoPanel1);
        genInfoPanel1.setLayout(genInfoPanel1Layout);
        genInfoPanel1Layout.setHorizontalGroup(
            genInfoPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(genInfoPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(genInfoPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(genInfoPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(costTF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lessTF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(netPriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(wholesaleDetailsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(wholesaleDetailsPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        genInfoPanel1Layout.setVerticalGroup(
            genInfoPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(genInfoPanel1Layout.createSequentialGroup()
                .addGroup(genInfoPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(netPriceTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lessTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(costTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(wholesaleDetailsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(wholesaleDetailsPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(genInfoPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(genInfoPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(genInfoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(genInfoPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void lessTFKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lessTFKeyPressed
        
    }//GEN-LAST:event_lessTFKeyPressed

    private void lessTFKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lessTFKeyReleased
        this.netPriceTF.setText( String.format("%,.2f", this.compute_netPrice()) );
    }//GEN-LAST:event_lessTFKeyReleased
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amountTF;
    private javax.swing.JComboBox<String> categoryCB;
    private javax.swing.JTextField codeTF;
    private javax.swing.JTextField costTF;
    private javax.swing.JPanel genInfoPanel;
    private javax.swing.JPanel genInfoPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField lessTF;
    private javax.swing.JTextField nameTF;
    private javax.swing.JTextField netPriceTF;
    private javax.swing.JTextField retailMarkupPercentageTF;
    private javax.swing.JTextField retailPriceTF;
    private javax.swing.JTextField unitTF;
    private javax.swing.JComboBox<String> warehouseCB;
    private javax.swing.JPanel wholesaleDetailsPanel;
    private javax.swing.JPanel wholesaleDetailsPanel1;
    private javax.swing.JTextField wholesaleMarkupPercentageTF;
    private javax.swing.JTextField wholesalePriceTF;
    // End of variables declaration//GEN-END:variables
}
