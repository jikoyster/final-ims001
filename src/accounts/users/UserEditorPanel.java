/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accounts.users;

import config.Functions;

/**
 *
 * @author Jake-LAPTOP
 */
public class UserEditorPanel extends javax.swing.JPanel {

    /**
     * Creates new form userNewPanel
     */
    public UserEditorPanel() {
        initComponents();
                
        this.BGtype.add(RBadmin);
        this.BGtype.add(RBencoder);
        this.BGtype.add(RBsecretary);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BGtype = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        usernameTF = new javax.swing.JTextField();
        passwordTF = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        RBadmin = new javax.swing.JRadioButton();
        RBsecretary = new javax.swing.JRadioButton();
        RBencoder = new javax.swing.JRadioButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText("Username");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Password");

        usernameTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        passwordTF.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Type");

        RBadmin.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RBadmin.setText("Admin");
        RBadmin.setActionCommand("1");
        RBadmin.setName("usertype"); // NOI18N

        RBsecretary.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RBsecretary.setText("Secretary");
        RBsecretary.setActionCommand("2");
        RBsecretary.setName("usertype"); // NOI18N

        RBencoder.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RBencoder.setText("Encoder");
        RBencoder.setActionCommand("3");
        RBencoder.setName("usertype"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(RBadmin)
                            .addComponent(RBsecretary)
                            .addComponent(RBencoder))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usernameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordTF, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(RBadmin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RBsecretary)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 5, Short.MAX_VALUE)
                .addComponent(RBencoder)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    
    public void set_usernameNotUpdateable(){
        this.usernameTF.setEditable(false);
    }

    public void set_username(String updated_username){
        this.usernameTF.setText(updated_username);
    }
    
    public void set_password(String updated_password){
        this.passwordTF.setText(updated_password);
    }
    
    public void set_type(int type){
        switch(type){
            case 1:
                this.RBadmin.setSelected(true);
                break;
            case 2:
                this.RBsecretary.setSelected(true);
                break;
            case 3:
                this.RBencoder.setSelected(true);
                break;
            default:
                break;
        }
    }
        
    public String get_username(){
        return this.usernameTF.getText();
    }
    
    public boolean isPasswordEmpty(){
        String pass = this.passwordTF.getText();
        return pass.isEmpty();
    }
    
    public String get_passwordMD5(){
//        String pass = String.valueOf(this.passwordTF.getPassword());
        String pass = this.passwordTF.getText();
        String pass2 = Functions.strToMD5(pass);
        return pass2;
    }
    
    public UserType get_type(){
        String type = this.BGtype.getSelection().getActionCommand();
        UserType typeObj = new UserType(Integer.valueOf(type));
        return typeObj;
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup BGtype;
    private javax.swing.JRadioButton RBadmin;
    private javax.swing.JRadioButton RBencoder;
    private javax.swing.JRadioButton RBsecretary;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField passwordTF;
    private javax.swing.JTextField usernameTF;
    // End of variables declaration//GEN-END:variables
}
