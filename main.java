/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication2;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class main extends javax.swing.JFrame implements ItemListener,ActionListener{
private static JPanel  body;//body of page
private static JLabel background_img;//Background image
JLabel jl;//will contain images of movies
JLabel  menu , name;//menu show-->Welcome, name show---> Choose your movie
private static JButton detail;//button for look detail of film
private static JComboBox jc;//contain the name of film
private static int p=0;
private static int idU;

    public main(int i) throws IOException {
        initComponents();
        idU=i;
        //Body
        jl= new JLabel(); 
        jl.setBounds(380,300,165,100);
            body= new JPanel();
            body.setBackground(Color.LIGHT_GRAY);

            body.setBounds(0,200,900,400);
            
            JPanel mn= new JPanel();
            mn.setBounds(140, 250, 600, 200);
            mn.setBackground(Color.red);
            
          
            
            //Label
            menu= new JLabel("WELCOME");
            menu.setBounds(350, 230, 200,20);
            menu.setFont(new Font("Serif", Font.BOLD, 25));
           body.add(menu);
        
           
            name= new JLabel("Choose your movie");
            name.setBounds(60, 300, 200,20);
            name.setFont(new Font("Serif", Font.BOLD, 20));
            jc= new JComboBox();
            jc.addItemListener((ItemListener) this);
             displayItems();//Method for display film name in jcomboBox
            jc.setBounds(230, 300,120,20);    
             
             detail  = new JButton("Details");
            detail.setBounds(430, 420, 100, 30);
            detail.addActionListener((ActionListener) this);
            
          //Requete for display image for the first value of jcombobox(hell driver)
           displayImage();
            
           //Background image
          ImageIcon background= new ImageIcon("C://Users//oumar//OneDrive//Documents//NetBeansProjects//JavaApplication2//images/cats2.png");
          Image ig= background.getImage();
          Image tmp=  ig.getScaledInstance(900, 200, Image.SCALE_SMOOTH);
          background= new ImageIcon(tmp);
          background_img= new JLabel("", background , JLabel.CENTER);
          background_img.setBounds(0, 0, 900, 200);

            //Display a animation of images
        
          p = 1 ; Timer t;
		t = new Timer(3000, new ActionListener(){
			@Override
           public void actionPerformed(ActionEvent e) {
						
          // TODO Auto-generated method stub
            if(p == 1)
            {
             background_img.setIcon(new ImageIcon("C://Users//oumar//OneDrive//Documents//NetBeansProjects//JavaApplication2//images/flash2.png"));
             p++ ;
            }
            else if(p == 2)
            {
             background_img.setIcon(new ImageIcon("C://Users//oumar//OneDrive//Documents//NetBeansProjects//JavaApplication2//images/hell2.png"));
            p++ ;		
            }
            else if(p == 3)
            {
            background_img.setIcon(new ImageIcon("C://Users//oumar//OneDrive//Documents//NetBeansProjects//JavaApplication2//images/jumanji2.png"));
            p++;			
            }
            else if(p == 4)
            {
            background_img.setIcon(new ImageIcon("C://Users//oumar//OneDrive//Documents//NetBeansProjects//JavaApplication2//images/bp2.png"));
            p++;			
            }
            else if(p == 5)
            {
            background_img.setIcon(new ImageIcon("C://Users//oumar//OneDrive//Documents//NetBeansProjects//JavaApplication2//images/cat2.png"));
            p++;			
            }
            else if(p == 6)
            {
            background_img.setIcon(new ImageIcon("C://Users//oumar//OneDrive//Documents//NetBeansProjects//JavaApplication2//images/wars2.png"));
            p=1;			
            }
             }}) ;
             t.start();
    
   
       // body.add(menu);
       add(detail);
       add(jl);
       add(jc);
       add(name);
       add(menu);
        add(body);
        add(background_img);
       
        setVisible(true);
    }

//Change images
   public void itemStateChanged(ItemEvent e) 
    { 
        // si l'état du combobox est modifiée 
        if (e.getSource() == jc) { 
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
   // String name= jc.getSelectedItem().toString();
    //cust is the name of the table
    String name= jc.getSelectedItem().toString();//The name of the film
    String req= "SELECT* FROM movie where nom = '"+name+"'";
    //cust is the name of the table
    ResultSet rs1=stmt.executeQuery(req);
    System.out.println(req);
    if(rs1.next()){  
     byte[] b= rs1.getBytes("image");
     System.out.println(b);
       ImageIcon ic= new ImageIcon(b);
        java.awt.Image il= ic.getImage();
        java.awt.Image ni= il.getScaledInstance(165, 100, java.awt.Image.SCALE_SMOOTH);
        ImageIcon niii= new ImageIcon(ni);
       jl.setIcon(niii);
    }
    conn.close();  
} catch(SQLException sql) {
   System.out.println(sql.getMessage());
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
   
    //*Method for display items in jcomboBox**/
    public void displayItems(){
                   Connection conn = null;
  System.out.println("Hello");
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
    ResultSet rs=stmt.executeQuery("SELECT nom from movie");  
    while(rs.next()) {
    jc.addItem(rs.getString("nom"));
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
   
    }
    
    
    
    //Method for display image of the first item of jcombobox when we load the page
    public void displayImage(){
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
   // String name= jc.getSelectedItem().toString();
    //cust is the name of the table
    String name= jc.getSelectedItem().toString();//The name of the film
    String req= "SELECT* FROM movie where nom = '"+name+"'";
    //cust is the name of the table
    ResultSet rs1=stmt.executeQuery(req);
    System.out.println(req);
    if(rs1.next()){  
     byte[] b= rs1.getBytes("image");
       ImageIcon ic= new ImageIcon(b);
        java.awt.Image il= ic.getImage();
        java.awt.Image ni= il.getScaledInstance(165, 100, java.awt.Image.SCALE_SMOOTH);
         ic= new ImageIcon(ni);
         jl.setIcon(ic );
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
    }

@Override
         public void actionPerformed(ActionEvent e) {
             if(e.getSource()==detail){
                 String name= jc.getSelectedItem().toString();//The name of the film
                 String req= "SELECT* FROM movie where nom = '"+name+"'";
                 int id = 0;
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
                   id= rs.getInt("id");
                }
                conn.close();  
        } catch(SQLException sql) {
             System.out.println(sql.getMessage());
        } finally {
            try{
                if(conn != null)
                    conn.close();
                }catch(SQLException ex){
            System.out.println(ex.getMessage());
       }
        } 
                 try {
                    det_film df= new det_film(id,idU);
                     new detail_film(df).setVisible(true);
                 } catch (IOException ex) {
                     Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                 }
            setVisible(false);

             }
         }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(900, 600));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 577, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws IOException {
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
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new main(idU).setVisible(true);
                } catch (IOException ex) {
                    Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        }

   // @Override
    /*public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }*/

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
