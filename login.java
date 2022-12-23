/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication2;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
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
import javax.swing.Timer;

/**
 *
 * @author oumar
 */
public class login extends javax.swing.JFrame implements ActionListener {
private static int p=0;
JButton sign , register, guest;
JPanel header;
JLabel Email, password;
 JTextField email;
static JLabel back;
JPasswordField passw;
 public login() throws IOException {
        initComponents();
        
        //Panel
         header= new JPanel();
        // header.setBackground(Color.DARK_GRAY);
        header.setBounds(0, 0, 900, 100);
        

         Email =new JLabel(new ImageIcon("C://Users//oumar//OneDrive//Documents//NetBeansProjects//JavaApplication2//images/mess.png"));
        Email.setBounds(100, 23, 50, 50);
        
        email= new JTextField();
        email.setBounds(150, 30, 150, 30);

         password= new JLabel(new ImageIcon("C://Users//oumar//OneDrive//Documents//NetBeansProjects//JavaApplication2//images/pas.png"));
        password.setBounds(400,23, 50,50);
        
         passw = new JPasswordField();
        passw.setBounds(450, 30, 150, 30);
        
         sign  = new JButton("LOGIN");
        sign.setBounds(360, 80, 100, 30);
        //sign.addActionListener((ActionListener) l);
        sign.addActionListener(this);
        
         register  = new JButton("REGISTER");
        register.setBounds(200, 80, 100, 30);
       register.addActionListener(this);

        
         guest  = new JButton("GUEST");
        guest.setBounds(520, 80, 100, 30);
        guest.addActionListener(this);
        
         //img= ImageIO.read(new File("C://Users//oumar//OneDrive//Documents//NetBeansProjects//JavaApplication2//src//javaapplication2/images/tb.png"));
        ImageIcon background= new ImageIcon("C://Users//oumar//OneDrive//Documents//NetBeansProjects//JavaApplication2//images/aladdin.png");
        Image ig= background.getImage();
        Image tmp=  ig.getScaledInstance(900, 510, Image.SCALE_SMOOTH);
        background= new ImageIcon(tmp);
        back= new JLabel("", background , JLabel.CENTER);
        back.setBounds(0, 0, 900, 510);
       
        add(guest);
        add(register);
        add(sign);
        add(passw);
        add(password);
        add(email);
        add(Email);
        add(header);
        add(back);
        setVisible(true);
            
    }   
     public void actionPerformed(ActionEvent e) {
         if(e.getSource()== guest){try {
             //For the guest
             new main(-1).setVisible(true);
             setVisible(false);
             } catch (IOException ex) {
                 Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
             }
         }else if(e.getSource()== register) {//For new User
             new createAccount().setVisible(true);
              setVisible(false);
         }
    /*****Here we receive email and password , and check if they are available
     in data, if that exits we redirect user from the good page. *****/
         else{
             
            String em= email.getText();
        String pass= new String(passw.getPassword());

        if(em.isEmpty()){
            JOptionPane.showMessageDialog(null, "Email required");
            email.setText("");
        }
        if(pass.isEmpty()){
          JOptionPane.showMessageDialog(null,"Password required");
          passw.setText("");
        }
        
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
  ResultSet rs= stmt.executeQuery("Select * from user where email= '"+em+"' and password= '"+pass+"' " );  
    
    if(rs.next()){
            int permission= rs.getInt("permission");
            int id=rs.getInt("id");
            if(permission==0){
                try {
                    new main(id).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }
            setVisible(false);
            }
            if(permission==1){
                try {
                    new employee().setVisible(true);
                     setVisible(false);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }
             }
                if(permission==2){
                    new Admin().setVisible(true);
                     setVisible(false);
                 }
        }else{
            JOptionPane.showMessageDialog(null,"User unavailable in database");
            email.setText("");
            passw.setText("");
        }  
        conn.close();  
    } catch(SQLException s) {
         System.out.println(s.getMessage());
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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
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
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new login().setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
       //Display a animation of images
        
          p = 1 ; Timer t;
		t = new Timer(3000, new ActionListener(){
			@Override
           public void actionPerformed(ActionEvent e) {
						
    // TODO Auto-generated method stub
            if(p == 1)
            {
             back.setIcon(new ImageIcon("C://Users//oumar//OneDrive//Documents//NetBeansProjects//JavaApplication2//images/lion.png"));
             p++ ;
            }
            else if(p == 2)
            {
             back.setIcon(new ImageIcon("C://Users//oumar//OneDrive//Documents//NetBeansProjects//JavaApplication2//images/jam.png"));
            p++ ;		
            }
            else if(p == 3)
            {
            back.setIcon(new ImageIcon("C://Users//oumar//OneDrive//Documents//NetBeansProjects//JavaApplication2//images/ratatouille.png"));
            p++;			
            }
            else if(p == 4)
            {
            back.setIcon(new ImageIcon("C://Users//oumar//OneDrive//Documents//NetBeansProjects//JavaApplication2//images/indestructibles.png"));
            p++;			
            }
            else if(p == 5)
            {
            back.setIcon(new ImageIcon("C://Users//oumar//OneDrive//Documents//NetBeansProjects//JavaApplication2//images/wars.png"));
            p++;			
            }
            else if(p == 6)
            {
            back.setIcon(new ImageIcon("C://Users//oumar//OneDrive//Documents//NetBeansProjects//JavaApplication2//images/dogs.png"));
            p=1;			
            }
             }}) ;
             t.start();
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
}