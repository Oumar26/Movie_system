/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication2;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class createAccount extends javax.swing.JFrame implements ActionListener {
static JLabel img_background;
JLabel email0, password, pass1, tel, nom;
JTextField email, name,num;
JPanel form;
JButton submit, log;
JPasswordField passw, passw1;
public createAccount() {
        initComponents();
        Color c= new Color(0, 51, 102);
         form= new JPanel();
         form.setBackground(c);
         form.setBounds(550, 0, 350, 474);
        
         //Name
         nom =new JLabel(new ImageIcon("C://Users//oumar//OneDrive//Documents//NetBeansProjects//JavaApplication2//images/user.png"));
         nom.setBounds(550, 10, 50, 50);
         name= new JTextField();
         name.setBounds(610, 20, 150, 30);

         //email
         email0 =new JLabel(new ImageIcon("C://Users//oumar//OneDrive//Documents//NetBeansProjects//JavaApplication2//images/mess.png"));
         email0.setBounds(550, 90, 50, 50);     
         email= new JTextField();
         email.setBounds(610, 100, 150, 30);

        //Pasword
        password= new JLabel(new ImageIcon("C://Users//oumar//OneDrive//Documents//NetBeansProjects//JavaApplication2//images/pas.png"));
        password.setBounds(550,170, 50,50);
        passw = new JPasswordField();
        passw.setBounds(610, 180, 150, 30);
       
        //confirm password
        pass1= new JLabel(new ImageIcon("C://Users//oumar//OneDrive//Documents//NetBeansProjects//JavaApplication2//images/pas.png"));
        pass1.setBounds(550,240, 50,50);
        passw1 = new JPasswordField();
        passw1.setBounds(610, 250, 150, 30);
       
         tel= new JLabel(new ImageIcon("C://Users//oumar//OneDrive//Documents//NetBeansProjects//JavaApplication2//images/tel.png"));
        tel.setBounds(550,310, 50,50);
         num = new JTextField();
         num.setBounds(610, 320, 150, 30);
       
        submit  = new JButton("SUBMIT");
        submit.setBounds(620, 380, 100, 30);
        submit.addActionListener(this);
        
         log  = new JButton("LOG ON");
         log.setBounds(720, 380, 100, 30);
         log.addActionListener(this);

        ImageIcon background= new ImageIcon("C://Users//oumar//OneDrive//Documents//NetBeansProjects//JavaApplication2//images/n.jpeg");
        Image ig= background.getImage();
        Image tmp=  ig.getScaledInstance(550  , 474, Image.SCALE_SMOOTH);
        background= new ImageIcon(tmp);
        img_background= new JLabel("", background , JLabel.CENTER);
        img_background.setBounds(0, 0, 550, 474);
       
        add(log);
        add(submit);
        add(num);
        add(tel);
        add(passw1);
        add(pass1);
        add(passw);
        add(password);
        add(email);
        add(email0);
        add(name);
        add(nom);
        add(form);
        add(img_background);
        setVisible(true);
    }

    
    @Override
     public void actionPerformed(ActionEvent e) {
         if(e.getSource()== submit){//For the guest
           addUser();
         }
         
         if(e.getSource()== log){
             try {
                 new login().setVisible(true);
                 setVisible(false);
             } catch (IOException ex) {
                 Logger.getLogger(createAccount.class.getName()).log(Level.SEVERE, null, ex);
             }
         }

     }
     
      /***This method will add a user in my file, before that, he checks if
     the password are same and if each field is fill**/
    public void addUser(){
        String nm= name.getText();
        String pass= new String(passw.getPassword());
        String pass1= new String(passw1.getPassword());
        String em= email.getText();
        String cont= num.getText();

        if(pass.equals(pass1)){
        if(nm.isEmpty() ||  pass1.isEmpty() || pass.isEmpty()|| em.isEmpty()|| cont.isEmpty()){
            //mess.setText("Each field is required, please to fill in");
            JOptionPane.showMessageDialog(null, "Each field is required, please to fill in");
        }else{
        
        //    p= new Person(nm, ad, em, pass, cont);
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
   stmt.executeQuery("insert into user(id,name, email, Tel, password, permission) values(null ,'"+nm+"', '"+em+"', '"+cont+"', '"+pass+"', '0' )" );  
   
    JOptionPane.showMessageDialog(null, "Data successfuly inserted");
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

             
        name.setText("");
        email.setText("");
        num.setText("");
        passw.setText("");
        passw1.setText("");
        }
        }else{
          //mess.setText("Password are not same, please retry");
          JOptionPane.showMessageDialog(null, "Password are not same, please retry");
          passw.setText("");
          passw1.setText("");
        }
        
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 474));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 640, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
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
            java.util.logging.Logger.getLogger(createAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createAccount.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createAccount().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
