/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class Admin extends javax.swing.JFrame {

    public Admin() {
        initComponents();
        showUser();
        showEmployee();
    }

    /****This method for display user's date in the table***/
    public void showUser(){
      Connection conn = null;
try {
    // db parameters ptest is the name of the database
    String url       = "jdbc:mariadb://localhost:3307/cinema";
    String user      = "root";
    String password  = "";
    
    // create a connection to the database
    conn = DriverManager.getConnection(url, user, password);
    // more processing here
    // ...    
    Statement stmt=conn.createStatement();  
    //table
   
    String []tab= {"ID", "Name", "Email", "Phone", "Access"};
    String []users= new String[5];//array who will stock data 
    //My default table
    DefaultTableModel mod= new DefaultTableModel(null, tab);

    //cust is the name of the table
  ResultSet rs=stmt.executeQuery("select * from user where permission=0");  
while(rs.next())  {
  users[0]=  rs.getString("id");
  users[1]= rs.getString("name");
  users[2]= rs.getString("email");
  users[3]= rs.getString("Tel");
  users[4]= rs.getString("permission");
  mod.addRow(users);
}


table6.setModel(mod);
conn.close(); 

} catch(SQLException e) {
   System.out.println(e.getMessage());
} finally {
    try{
           if(conn != null)
             conn.close();
    }catch(SQLException ex){
           System.out.println(ex.getMessage());
    }

    }
    }
    
    
    /**This method is use for show employee's date in the table .**/
    public void showEmployee(){
             Connection conn = null;
try {
    // db parameters ptest is the name of the database
    String url       = "jdbc:mariadb://localhost:3307/cinema";
    String user      = "root";
    String password  = "";
    
    // create a connection to the database
    conn = DriverManager.getConnection(url, user, password);
    // more processing here
    // ...    
    Statement stmt=conn.createStatement();  
    //table
   
    String []tab= {"ID", "Name", "Email", "Phone", "Access"};
    String []users= new String[5];//array who will stock data 
    //My default table
    DefaultTableModel mod= new DefaultTableModel(null, tab);

    //cust is the name of the table
  ResultSet rs=stmt.executeQuery("select * from user where permission=1");  
while(rs.next())  {
  users[0]=  rs.getString("id");
  users[1]= rs.getString("name");
  users[2]= rs.getString("email");
  users[3]= rs.getString("Tel");
  users[4]= rs.getString("permission");
  mod.addRow(users);
}


table7.setModel(mod);
conn.close(); 

} catch(SQLException e) {
   System.out.println(e.getMessage());
} finally {
    try{
           if(conn != null)
             conn.close();
    }catch(SQLException ex){
           System.out.println(ex.getMessage());
    }

    }
 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table6 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        userN = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        pN = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        pU = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table7 = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        emName = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        mailEm = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        pnEM = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        accessEM = new javax.swing.JTextField();
        upEM = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Admin");

        table6.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Email", "Phone ", "Access"
            }
        ));
        table6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table6MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table6);

        jLabel2.setText("Name");

        jLabel4.setText("Email");

        jLabel5.setText("Phone number");

        jLabel6.setText("Acces");

        pU.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pUActionPerformed(evt);
            }
        });

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(userN, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(pN, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(pU, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33)
                .addComponent(jLabel5)
                .addGap(28, 28, 28)
                .addComponent(pN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(pU, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(107, 107, 107))
        );

        jTabbedPane1.addTab("Users dashboard", jPanel1);

        table7.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Email", "Tel", "Access"
            }
        ));
        table7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table7MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(table7);

        jLabel7.setText("Name");

        emName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emNameActionPerformed(evt);
            }
        });

        jLabel9.setText("Email");

        jLabel10.setText("Phone  number");

        jLabel11.setText("Access");

        accessEM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                accessEMActionPerformed(evt);
            }
        });

        upEM.setText("Update");
        upEM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upEMActionPerformed(evt);
            }
        });

        jButton4.setText("Delete");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(accessEM, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(emName, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE)
                            .addComponent(pnEM, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mailEm))
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(upEM)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(emName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(mailEm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(pnEM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(accessEM, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(36, 36, 36)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(upEM)
                    .addComponent(jButton4))
                .addContainerGap(45, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Employees dashboard", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jTabbedPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(193, 193, 193)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table6MouseClicked
        // TODO add your handling code here:
          int line= table6.getSelectedRow();//id of row
        
        String id= table6.getModel().getValueAt(line, 0).toString();
        String req= "Select * from user where id = '"+id+"'";
        Connection conn = null;
try {
    // db parameters ptest is the name of the database
    String url       = "jdbc:mariadb://localhost:3307/cinema";
    String user      = "root";
    String password  = "";
    
    // create a connection to the database
    conn = DriverManager.getConnection(url, user, password);
    // more processing here
    // ...   
    
    Statement stmt=conn.createStatement();  
    //cust is the name of the table
    ResultSet rs=stmt.executeQuery(req);  
    if(rs.next()){
    userN.setText(rs.getString("name"));
    email.setText(rs.getString("email"));
    pN.setText(rs.getString("Tel"));
    pU.setText(rs.getString("permission"));
}
    conn.close();  
} catch(SQLException e) {
    System.out.println(e.getMessage());
} finally {
    try{
           if(conn != null)
             conn.close();
    }catch(SQLException ex){
           System.out.println(ex.getMessage());
    }
}
      
    }//GEN-LAST:event_table6MouseClicked

    private void pUActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pUActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pUActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         
        if(userN.getText().isEmpty() ||email.getText().isEmpty() || pN.getText().isEmpty() || pU.getText().isEmpty() ){
            JOptionPane.showMessageDialog(null, "Each fill must be fill in");
        }else{
        Connection conn = null;
       int line= table6.getSelectedRow();//id of row
        
        String id= table6.getModel().getValueAt(line, 0).toString();
     
      JFrame jf= new JFrame();
       int result = JOptionPane.showConfirmDialog(jf, "Are you sure to delete this user ?.", "WARNING", JOptionPane.YES_NO_OPTION);
       if (result == 0){
        String req= "Delete from user where id = '"+id+"' ";
       
    try {
        // db parameters ptest is the name of the database
        String url       = "jdbc:mariadb://localhost:3307/cinema";
        String user      = "root";
        String password  = "";
    
        // create a connection to the database
        conn = DriverManager.getConnection(url, user, password);
        // more processing here
        // ...    
        Statement stmt=conn.createStatement();  
        //cust is the name of the table
        ResultSet rs=stmt.executeQuery(req);  
        JOptionPane.showMessageDialog(null, "User successfuly deleted ");
        showUser();
        conn.close();  
        
        userN.setText("");
        email.setText("");
        pN.setText("");
        pU.setText("");
} catch(SQLException e) {
             System.out.println(e.getMessage());
} finally {
    try{
           if(conn != null)
             conn.close();
    }catch(SQLException ex){
           System.out.println(ex.getMessage());
    }
}
       }else{
           System.out.println("You pressed cancel");
       }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String n= userN.getText();
        String em = email.getText();
        String num= pN.getText();
        String per= pU.getText();
        if(n.isEmpty() ||em.isEmpty() || num.isEmpty() || per.isEmpty() ){
            JOptionPane.showMessageDialog(null, "Each fill must be fill in");
        }else{
        Connection conn = null;
       int line= table6.getSelectedRow();//id of row
        
        String id= table6.getModel().getValueAt(line, 0).toString();
      
    try {
        // db parameters ptest is the name of the database
        String url       = "jdbc:mariadb://localhost:3307/cinema";
        String user      = "root";
        String password  = "";
    
        // create a connection to the database
        conn = DriverManager.getConnection(url, user, password);
        // more processing here
        // ...    
        Statement stmt=conn.createStatement();  
        String req= "Update user set name= '"+n+"', email='"+em+"', Tel='"+num+"', permission='"+per+"' where id= '"+id+"'";
        //cust is the name of the table
        ResultSet rs=stmt.executeQuery( req);  
        JOptionPane.showMessageDialog(null, "User updated");
        showUser();
        conn.close();  

        userN.setText("");
        email.setText("");
        pN.setText("");
        pU.setText("");
     
    } catch(SQLException e) {
        System.out.println(e.getMessage());
    } finally {
    try{
           if(conn != null)
             conn.close();
    }catch(SQLException ex){
           System.out.println(ex.getMessage());
    }
}
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void emNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emNameActionPerformed

    private void accessEMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_accessEMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_accessEMActionPerformed

    private void table7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table7MouseClicked
        // TODO add your handling code here:
             int line= table7.getSelectedRow();//id of row
        
        String id= table7.getModel().getValueAt(line, 0).toString();
        String req= "Select * from user where id = '"+id+"'";
        Connection conn = null;
try {
    // db parameters ptest is the name of the database
    String url       = "jdbc:mariadb://localhost:3307/cinema";
    String user      = "root";
    String password  = "";
    
    // create a connection to the database
    conn = DriverManager.getConnection(url, user, password);
    // more processing here
    // ...   
    
    Statement stmt=conn.createStatement();  
    //cust is the name of the table
    ResultSet rs=stmt.executeQuery(req);  
    if(rs.next()){
    emName.setText(rs.getString("name"));
    mailEm.setText(rs.getString("email"));
    pnEM.setText(rs.getString("Tel"));
    accessEM.setText(rs.getString("permission"));
}
    conn.close();  
} catch(SQLException e) {
    System.out.println(e.getMessage());
} finally {
    try{
           if(conn != null)
             conn.close();
    }catch(SQLException ex){
           System.out.println(ex.getMessage());
    }
    }
    }//GEN-LAST:event_table7MouseClicked

    private void upEMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upEMActionPerformed
        // TODO add your handling code here:
        String n= emName.getText();
        String em = mailEm.getText();
        String num= pnEM.getText();
        String per= accessEM.getText();
        if(n.isEmpty() ||em.isEmpty() ||num.isEmpty() || per.isEmpty() ){
            JOptionPane.showMessageDialog(null, "Each fill must be fill in");
        }else{
        Connection conn = null;
       int line= table7.getSelectedRow();//id of row
        
        String id= table7.getModel().getValueAt(line, 0).toString();
      
    try {
        // db parameters ptest is the name of the database
        String url       = "jdbc:mariadb://localhost:3307/cinema";
        String user      = "root";
        String password  = "";
    
        // create a connection to the database
        conn = DriverManager.getConnection(url, user, password);
        // more processing here
        // ...    
        Statement stmt=conn.createStatement();  
        String req= "Update user set name= '"+n+"', email='"+em+"', Tel='"+num+"', permission='"+per+"' where id= '"+id+"'";
        //cust is the name of the table
        ResultSet rs=stmt.executeQuery( req);  
        JOptionPane.showMessageDialog(null, "Employee updated");
        showEmployee();
        conn.close();  

        emName.setText("");
        mailEm.setText("");
        pnEM.setText("");
        accessEM.setText("");
     
    } catch(SQLException e) {
        System.out.println(e.getMessage());
    } finally {
    try{
           if(conn != null)
             conn.close();
    }catch(SQLException ex){
           System.out.println(ex.getMessage());
    }
    }
        }
    }//GEN-LAST:event_upEMActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        if(emName.getText().isEmpty() ||mailEm.getText().isEmpty() || pnEM.getText().isEmpty() || accessEM.getText().isEmpty() ){
            JOptionPane.showMessageDialog(null, "Each fill must be fill in");
        }else{
       Connection conn = null;
       int line= table7.getSelectedRow();//id of row
        
        String id= table7.getModel().getValueAt(line, 0).toString();
     
      JFrame jf= new JFrame();
       int result = JOptionPane.showConfirmDialog(jf, "Are you sure to delete this employee ?.", "WARNING", JOptionPane.YES_NO_OPTION);
       if (result == 0){
        String req= "Delete from user where id = '"+id+"' ";
      
    try {
        // db parameters ptest is the name of the database
        String url       = "jdbc:mariadb://localhost:3307/cinema";
        String user      = "root";
        String password  = "";
    
        // create a connection to the database
        conn = DriverManager.getConnection(url, user, password);
        // more processing here
        // ...    
         Statement stmt=conn.createStatement();  
        //cust is the name of the table
        ResultSet rs=stmt.executeQuery(req);  
        JOptionPane.showMessageDialog(null, "Employee successfuly deleted ");
        showEmployee();
        conn.close();  

     
    } catch(SQLException e) {
        System.out.println(e.getMessage());
    } finally {
    try{
           if(conn != null)
             conn.close();
    }catch(SQLException ex){
           System.out.println(ex.getMessage());
    }
    }
       }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField accessEM;
    private javax.swing.JTextField emName;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField mailEm;
    private javax.swing.JTextField pN;
    private javax.swing.JTextField pU;
    private javax.swing.JTextField pnEM;
    private javax.swing.JTable table6;
    private javax.swing.JTable table7;
    private javax.swing.JButton upEM;
    private javax.swing.JTextField userN;
    // End of variables declaration//GEN-END:variables
}
