/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package javaapplication2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;


public class employee extends javax.swing.JFrame {
    private static String s;//my image path
    private static String nImage;
    public String getPath(){return s;}
    public void setPath(String t){s=t;}
    public String getNom(){return nImage;}
    public void setNom(String p){nImage=p;}
    
    public employee() throws FileNotFoundException {
        initComponents();
        //Load data in the table
        showTable();
        upDateTable();
        DelTable();
        jComboFilmID();
      filmBroadcasts();
        jComboDelete();
       deleteBroadcasts();
       
    }

    /***Method for add film****/
    public void addFilm() throws FileNotFoundException{
        String fn= nameFilm.getText();
        String type= genreFilm.getText();
        String duree= during.getText();
        String dt= dte.getText();
        String pr= price.getText();
        String descF= desc.getText();
        String discount= dc.getText();
        String nb= nbSeat.getText();
        String tr= trail.getText(); 
        //InputStream img= new FileInputStream(new File(s));
        if(fn.isEmpty() || type.isEmpty() ||  duree.isEmpty() || dt.isEmpty()|| pr.isEmpty() || descF.isEmpty()|| discount.isEmpty() || nb.isEmpty() || tr.isEmpty()){
            //msg.setText("Each field is required, please to fill in");
            JOptionPane.showMessageDialog(null, "Each field is required, please to fill in");
        }else{
           InputStream img= new FileInputStream(new File(s));

             Connection conn = null;
try {
    // db parameters ptest is the name of the database
    String url       = "jdbc:mariadb://localhost:3307/cinema";
    String user      = "root";
    String password  = "";
    
    // create a connection to the database
    conn = DriverManager.getConnection(url, user, password);
    // more processing here
   
        PreparedStatement ps; 
        String req= "Insert into movie (image, nom, type, date, time, description, Price, Discount, nbSeat, link) values(?, ?, ? ,? ,? ,? ,? ,? ,? ,?) ";
        ps = conn.prepareStatement(req);
       // ps.setString(1,null);
       ps.setBlob(1, img);
       ps.setString(2, fn);
       ps.setString(3, type);
       ps.setString(4, dt);
       ps.setString(5, duree);
       ps.setString(6, descF);
       ps.setString(7, pr);
       ps.setString(8, discount);
       ps.setString(9,nb);
       ps.setString(10, tr);
        ps.executeUpdate();
    JOptionPane.showMessageDialog(null, "film successfully inserted");
    upDateTable();
   DelTable();
    showTable();
    
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

         nameFilm.setText("");
        genreFilm.setText("");
        during.setText("");
        dte.setText("");
        price.setText("");
        desc.setText("");
        dc.setText("");
        nbSeat.setText("");
        trail.setText("");
        }
        
    }
    
    
    /***********This method will be able to display in the table.
     .**********************/
    public void showTable() throws FileNotFoundException{
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
   
     String [] ob= {"ID", "Name", "Type", "Duree", "Price", "Image"};
     Object []movie= new Object[6];//array who will stock data 
     DefaultTableModel mod= new DefaultTableModel(null, ob);

    ResultSet rs=stmt.executeQuery("select * from movie");  
    byte[] b;
    while(rs.next())  {
     movie[0]=  rs.getString("id");
     movie[1]= rs.getString("nom");
     movie[2]= rs.getString("type");
     movie[3]= rs.getString("time");
     movie[4]= rs.getString("Price");
     b= rs.getBytes("image");
     movie[5]=b;
     mod.addRow(movie);
    }
    table.setModel(mod);
    conn.close(); 
    } catch(SQLException e) {
    System.out.println(e.getMessage());
}    finally {
    try{
           if(conn != null)
             conn.close();
    }catch(SQLException ex){
           System.out.println(ex.getMessage());
    }
} 
        

        
    }
    
 
    /**This method create a dynamique for update a film
     * If i clicked a row of my table , my inputs case will be full.**/
    public void upDateTable() throws FileNotFoundException{
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
    String []tab= {"ID","Name",  "Date",  "Price", "Discount", "Seats", "During", "Type"};
    String []movie= new String[8];//array who will stock data */

    //My default table
    DefaultTableModel mod= new DefaultTableModel(null, tab);

    //cust is the name of the table
    ResultSet rs=stmt.executeQuery("select * from movie");  
    while(rs.next())  {
    movie[0]= rs.getString("id");
    movie[1]=  rs.getString("nom");
    movie[2]= rs.getString("date");
    movie[3]= rs.getString("Price");
    movie[4]= rs.getString("discount");
    movie[5]= rs.getString("nbSeat");
    movie[6]= rs.getString("time");
    movie[7]= rs.getString("type");
  
  mod.addRow(movie);
}
table3.setModel(mod);
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
    
    
     public void DelTable() throws FileNotFoundException{
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
    String []tab= {"ID","Name",  "Date",  "Price", "Discount", "Seats", "During", "Genre" };
    String []movie= new String[8];//array who will stock data 
    //My default table
    DefaultTableModel mod= new DefaultTableModel(null, tab);

    //cust is the name of the table
    ResultSet rs=stmt.executeQuery("select * from movie");  
    while(rs.next())  {
    movie[0]= rs.getString("id");
    movie[1]=  rs.getString("nom");
    movie[2]= rs.getString("date");
    movie[3]= rs.getString("Price");
    movie[4]= rs.getString("discount");
    movie[5]= rs.getString("nbSeat");
    movie[6]= rs.getString("time");
    movie[7]= rs.getString("type");

    mod.addRow(movie);
}
    table4.setModel(mod);
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
    
     
///////////////////For add a broadcasts ///////////////////////
    public void filmBroadcasts(){
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
    String []tab= {"ID_Broadcast","Date",  "Hours"};
    String []movie= new String[3];//array who will stock data 
    //My default table
    DefaultTableModel mod= new DefaultTableModel(null, tab);

    String res =jComboBox1.getSelectedItem().toString();
       
    //cust is the name of the table
    ResultSet rs=stmt.executeQuery("select * from broadcast where id_film='"+res+"'");  
    while(rs.next())  {
    movie[0]= rs.getString("id_broadcast");
    movie[1]=  rs.getString("date_broadcast");
    movie[2]= rs.getString("hours");
 
    mod.addRow(movie);
}
    tableDate.setModel(mod);
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
   
    
    ///xxxxxxxxxxxxxxxxxxxxxxxxxxxDelete a broadcast
   public void deleteBroadcasts(){
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
    String []tab= {"ID_Broadcast","Date",  "Hours"};
    String []movie= new String[3];//array who will stock data 
    //My default table
    DefaultTableModel mod= new DefaultTableModel(null, tab);

     String res =jComboBox2.getSelectedItem().toString();
       
    //cust is the name of the table
    ResultSet rs=stmt.executeQuery("select * from broadcast where id_film='"+res+"'");  
    while(rs.next())  {
    movie[0]= rs.getString("id_broadcast");
    movie[1]=  rs.getString("date_broadcast");
    movie[2]= rs.getString("hours");
    mod.addRow(movie);
}
    tableDelete.setModel(mod);
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

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel4 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table4 = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        delName = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        dDate = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        dPrice = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        dDiscount = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        dSeats = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        dDuring = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        dType = new javax.swing.JTextField();
        Del = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nameFilm = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        genreFilm = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        during = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        dte = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        price = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        desc = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        dc = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        img = new javax.swing.JButton();
        labimage = new javax.swing.JLabel();
        msg = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        nbSeat = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        trail = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        movieN = new javax.swing.JTextField();
        mt = new javax.swing.JLabel();
        msg4 = new javax.swing.JLabel();
        msg5 = new javax.swing.JLabel();
        d = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        mD = new javax.swing.JTextField();
        movieDn = new javax.swing.JTextField();
        moviePr = new javax.swing.JTextField();
        mS = new javax.swing.JTextField();
        mDT = new javax.swing.JTextField();
        mGr = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        nf = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tableDate = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        newDate = new javax.swing.JFormattedTextField();
        jButton4 = new javax.swing.JButton();
        jComboBox1 = new javax.swing.JComboBox<>();
        newHours = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        tableDelete = new javax.swing.JTable();
        nom = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        deleteBroadcastDate = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        deleteBroadcastHours = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Type", "Duree", "Price", "Image"
            }
        ));
        jScrollPane2.setViewportView(table);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 476, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 154, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("All films", jPanel1);

        table4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Date", "Price", "Discount", "Seats", "During", "Type"
            }
        ));
        table4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table4MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(table4);

        jLabel12.setText("Name");

        jLabel16.setText("Date");

        dDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dDateActionPerformed(evt);
            }
        });

        jLabel17.setText("Price");

        jLabel18.setText("Discount");

        jLabel19.setText("Seats");

        jLabel20.setText("During");

        dDuring.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dDuringActionPerformed(evt);
            }
        });

        jLabel21.setText("Type");

        Del.setText("Delete");
        Del.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dDate, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(18, 18, 18)
                                .addComponent(dPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel19)
                                    .addComponent(jLabel20))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dDuring, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dSeats, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(31, 31, 31)
                                .addComponent(dType, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(delName))))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(Del)))
                .addGap(60, 60, 60)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(delName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(dDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(dPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(dDiscount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(dSeats, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel20)
                            .addComponent(dDuring, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(dType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(38, 38, 38)
                        .addComponent(Del)))
                .addContainerGap(176, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Delete a film", jPanel5);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Name:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Genre:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Time(min)");

        during.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duringActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Date");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Price");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Description");

        desc.setColumns(20);
        desc.setRows(5);
        jScrollPane1.setViewportView(desc);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Discount(%)");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("image");

        jButton1.setText("Submit");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        img.setText("load");
        img.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imgActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Number of seats");

        nbSeat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nbSeatActionPerformed(evt);
            }
        });

        jLabel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel23.setText("Trailer");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(395, 395, 395)
                        .addComponent(labimage, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(393, 393, 393)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel23)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(img)
                                .addGap(165, 165, 165))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(trail, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(105, 105, 105))))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(239, 239, 239)
                        .addComponent(msg))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(nbSeat, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dc, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(90, 90, 90)
                        .addComponent(jButton1))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)
                        .addGap(12, 12, 12)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nameFilm, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(genreFilm, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                .addComponent(dte, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(price, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(during, javax.swing.GroupLayout.Alignment.LEADING))))
                    .addComponent(jLabel28))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(nameFilm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(genreFilm, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(during, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(price, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(dte, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(labimage, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(img))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jLabel6)))
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel23)
                    .addComponent(trail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(nbSeat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9))
                    .addComponent(jButton1))
                .addGap(49, 49, 49)
                .addComponent(jLabel28)
                .addGap(129, 129, 129)
                .addComponent(msg)
                .addGap(47, 47, 47))
        );

        jTabbedPane1.addTab("New film", jPanel2);

        jLabel10.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel10.setText("Name");

        movieN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movieNActionPerformed(evt);
            }
        });

        mt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        mt.setText("Type");

        d.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        d.setText("Date");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel13.setText("Price");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel14.setText("Discount");

        jLabel15.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel15.setText("Seats");

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel11.setText("During");

        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Name", "Date", "Price", "Discount", "Seats", "During", "Type"
            }
        ));
        table3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table3MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(table3);

        movieDn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                movieDnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(53, 53, 53)
                                .addComponent(msg5))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(mt, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(12, 151, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(movieN, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(mD, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(movieDn, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(87, 87, 87)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(mS, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(moviePr, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mGr, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(d, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(mDT, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(msg4)
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jButton2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(58, 58, 58)
                                .addComponent(msg4))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(movieN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11)
                            .addComponent(mD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(53, 53, 53)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(movieDn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(moviePr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(d)
                            .addComponent(mDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(msg5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mGr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mt))
                        .addGap(45, 45, 45)
                        .addComponent(jButton2)
                        .addGap(157, 157, 157))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(209, 209, 209))))
        );

        jTabbedPane1.addTab("Update a film", jPanel3);

        jLabel24.setFont(new java.awt.Font("Serif", 0, 18)); // NOI18N
        jLabel24.setText("Film_id");

        nf.setFont(new java.awt.Font("Sylfaen", 0, 14)); // NOI18N

        tableDate.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Date", "Hours"
            }
        ));
        jScrollPane4.setViewportView(tableDate);

        jLabel26.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel26.setText("Date");

        jLabel27.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel27.setText("Hours");

        try {
            newDate.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jButton4.setText("Add");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        newHours.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1pm", "2pm", "3pm", "12am", "11am", "10am", "9am", "8am", "7am", "6am", "5am", " " }));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(nf)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel27)
                                    .addComponent(jLabel26))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(newDate, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(newHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jButton4))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(nf)
                        .addGap(42, 42, 42)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel26)
                            .addComponent(newDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel27)
                            .addComponent(newHours, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(77, 77, 77)
                        .addComponent(jButton4))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(209, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Add a broadcast", jPanel6);

        jLabel25.setText("Your film id");

        jComboBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox2ActionPerformed(evt);
            }
        });

        tableDelete.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID_Broadcast", "Name", "Hours"
            }
        ));
        tableDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableDeleteMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tableDelete);
        if (tableDelete.getColumnModel().getColumnCount() > 0) {
            tableDelete.getColumnModel().getColumn(2).setResizable(false);
        }

        jLabel29.setText("Date");

        jLabel31.setText("Hours");

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel25)
                                .addGap(30, 30, 30)
                                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(nom, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(18, 18, 18)
                                .addComponent(deleteBroadcastHours))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addComponent(jLabel29)
                                .addGap(30, 30, 30)
                                .addComponent(deleteBroadcastDate))
                            .addComponent(jButton3))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(nom)
                        .addGap(50, 50, 50)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel29)
                            .addComponent(deleteBroadcastDate))
                        .addGap(41, 41, 41)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31)
                            .addComponent(deleteBroadcastHours))
                        .addGap(61, 61, 61)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(115, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(156, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Delete a broadcast", jPanel8);

        jLabel22.setFont(new java.awt.Font("Segoe UI Semilight", 0, 18)); // NOI18N
        jLabel22.setText("My dasboard");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(271, 271, 271)
                        .addComponent(jLabel22))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel22)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 664, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imgActionPerformed
        // TODO add your handling code here:
        //JFileChooser for the path of images
        //Images treatment when you want to add a new film
        JFileChooser jfc= new JFileChooser();
        //String t= "C://Users//oumar//OneDrive//Documents//NetBeansProjects//JavaApplication2//images/";
        jfc.setCurrentDirectory(new File("C:/Users//oumar/OneDrive/Documents/NetBeansProjects/JavaApplication2/images/"));
        //Use of a filter for images type
        FileNameExtensionFilter fnef= new FileNameExtensionFilter("IMAGES","jpg", "png", "jpeg");
        jfc.addChoosableFileFilter(fnef);

        int result=  jfc.showSaveDialog(null);

        if(result== JFileChooser.APPROVE_OPTION){
            //Resizing the image
            File selectedFile= jfc.getSelectedFile();
            String path = selectedFile.getAbsolutePath();
           // System.out.println(path);
            String name= selectedFile.getName();
            ImageIcon imc= new ImageIcon(path);
            java.awt.Image img= imc.getImage();
            java.awt.Image nimg= img.getScaledInstance(labimage.getWidth(), labimage.getHeight(), java.awt.Image.SCALE_SMOOTH);
            ImageIcon finalImg= new ImageIcon(nimg);
            labimage.setIcon(finalImg);
            setPath(path);
            //setNom(name);
        }else{
            if(result== JFileChooser.CANCEL_OPTION){
                JOptionPane.showMessageDialog(null, "You don't chose any image");
            }
        }
    }//GEN-LAST:event_imgActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            // TODO add your handling code here:
            addFilm();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void duringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duringActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_duringActionPerformed

    private void nbSeatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nbSeatActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nbSeatActionPerformed

    private void movieNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movieNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_movieNActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        /***********When the button is cliked, this method
         will retrieve new value of the film and updated.******************/
        String n= movieN.getText();
        String d= mDT.getText();
        String p = moviePr.getText();
        String dis= movieDn.getText();
        String s= mS.getText();
        String t=  mD.getText();
        String type= mGr.getText();
        if(n.isEmpty() || d.isEmpty() || p.isEmpty() || dis.isEmpty() || s.isEmpty() || t.isEmpty() || type.isEmpty() || type.isEmpty()){
            JOptionPane.showMessageDialog(null, "Each field must be fill");
        }else{
            Connection conn = null;
        int line= table3.getSelectedRow();//id of row
        
        String id= table3.getModel().getValueAt(line, 0).toString();
        
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
        String req= "Update movie set nom= '"+n+"', type='"+type+"', date='"+d+"', time='"+t+"', Price='"+p+"', Discount='"+dis+"', nbSeat='"+s+"' where id= '"+id+"'";
        //cust is the name of the table
        ResultSet rs=stmt.executeQuery( req);  
        JOptionPane.showMessageDialog(null, "Film updated");
        showTable();
        upDateTable();
        DelTable();
        conn.close();  

        movieN.setText("");
        mDT.setText("");
        moviePr.setText("");
        movieDn.setText("");
        mS.setText("");
        mD.setText("");
        mGr.setText("");
    
 } catch(SQLException e) {
        System.out.println(e.getMessage());
}       catch (FileNotFoundException ex) {
                Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
    try{
           if(conn != null)
             conn.close();
    }catch(SQLException ex){
           System.out.println(ex.getMessage());
    }
    }
     }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void table3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table3MouseClicked
        // TODO add your handling code here:
   
        int line= table3.getSelectedRow();//id of row
        
        String id= table3.getModel().getValueAt(line, 0).toString();
        String req= "Select * from movie where id = '"+id+"'";
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
    movieN.setText(rs.getString("nom"));
    mDT.setText(rs.getString("date"));
    moviePr.setText(rs.getString("Price"));
    movieDn.setText(rs.getString("discount"));
    mS.setText(rs.getString("nbSeat"));
    mD.setText(rs.getString("time"));
    mGr.setText(rs.getString("type"));

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
        
        
    }//GEN-LAST:event_table3MouseClicked

    private void dDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dDateActionPerformed

    private void dDuringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dDuringActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dDuringActionPerformed

    private void DelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DelActionPerformed
        // TODO add your handling code here:
        /*******When this button is cliked, that means, employee want to delete a film*************/
        JFrame jf= new JFrame();
         int result = JOptionPane.showConfirmDialog(jf, "Are you sure to delete this film ?.", "WARNING", JOptionPane.YES_NO_OPTION);
       if (result == 0){
        Connection conn = null;
        int line= table4.getSelectedRow();//id of row
        
        String id= table4.getModel().getValueAt(line, 0).toString();
        String req= "Delete from movie where id = '"+id+"' ";
       
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
        JOptionPane.showMessageDialog(null, "Film successfuly deleted ");
        showTable();
        upDateTable();
        DelTable();
        
        
        conn.close();  
        delName.setText("");
        dDate.setText("");
        dPrice.setText("");
        dDiscount.setText("");
        dSeats.setText("");
        dDuring.setText("");
        dType.setText("");
} catch(SQLException e) {
             System.out.println(e.getMessage());
}           catch (FileNotFoundException ex) {
                Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
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
       
    }//GEN-LAST:event_DelActionPerformed

    private void table4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table4MouseClicked
        // TODO add your handling code here:
        
        int line= table4.getSelectedRow();//id of row
        
        String id= table4.getModel().getValueAt(line, 0).toString();
        String req= "Select * from movie where id = '"+id+"'";
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
        delName.setText(rs.getString("nom"));
        dDate.setText(rs.getString("date"));
        dPrice.setText(rs.getString("Price"));
        dDiscount.setText(rs.getString("discount"));
        dSeats.setText(rs.getString("nbSeat"));
        dDuring.setText(rs.getString("time"));
        dType.setText(rs.getString("type"));
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
    }//GEN-LAST:event_table4MouseClicked

    private void movieDnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_movieDnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_movieDnActionPerformed

    //////////////////////
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String date= newDate.getText();
        String h= newHours.getSelectedItem().toString();
        String idF= jComboBox1.getSelectedItem().toString();//id film
        if(date.length()!=10){
            JOptionPane.showMessageDialog(null, "Each fill must be fill");
        }else{
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
        ResultSet rs=stmt.executeQuery("Insert into broadcast (id_broadcast,date_broadcast,hours, id_film) values(null, '"+date+"', '"+h+"', '"+idF+"') ");  
        JOptionPane.showMessageDialog(null, "Broadcast time inserted"); 
        filmBroadcasts();
        deleteBroadcasts();
       
        newDate.setText("");
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
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        String id= jComboBox1.getSelectedItem().toString();
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
        ResultSet rs=stmt.executeQuery("SELECT* FROM movie where id= '"+id+"'");  
        if(rs.next()){
        nf.setText(rs.getString("nom"));
        }else{
        JOptionPane.showMessageDialog(null, "Film unavailable");
        }
        filmBroadcasts();

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

    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jComboBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox2ActionPerformed
        // TODO add your handling code here:
            String id= jComboBox2.getSelectedItem().toString();
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
            ResultSet rs=stmt.executeQuery("SELECT* FROM movie where id= '"+id+"'");  
        if(rs.next()){
            nom.setText(rs.getString("nom"));
    }else{
        JOptionPane.showMessageDialog(null, "Film unavailable");
    }
        deleteBroadcasts();
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
    }//GEN-LAST:event_jComboBox2ActionPerformed
    }
    private void tableDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableDeleteMouseClicked
        int line= tableDelete.getSelectedRow();//id of row
        
        String id= tableDelete.getModel().getValueAt(line, 0).toString();
        String req= "Select * from broadcast where id_broadcast = '"+id+"'";
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
        deleteBroadcastDate.setText(rs.getString("date_broadcast"));
        deleteBroadcastHours.setText(rs.getString("hours"));
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
    }//GEN-LAST:event_tableDeleteMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
            JFrame jf= new JFrame();
       int result = JOptionPane.showConfirmDialog(jf, "Are you sure to delete this broadcast time ?.", "WARNING", JOptionPane.YES_NO_OPTION);
       if (result == 0){
        Connection conn = null;
        int line= tableDelete.getSelectedRow();//id of row
        
        String id= tableDelete.getModel().getValueAt(line, 0).toString();
        String req= "Delete from broadcast where id_broadcast = '"+id+"' ";
       
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
        JOptionPane.showMessageDialog(null, "Broadcast time successfuly deleted ");
        deleteBroadcasts();
        filmBroadcasts();
       
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
       }else{
           System.out.println("You pressed cancel");
       }
       deleteBroadcastDate.setText("");
       deleteBroadcastHours.setText("");
    }//GEN-LAST:event_jButton3ActionPerformed

     
    
    public void jComboFilmID(){
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
    ResultSet rs=stmt.executeQuery("SELECT * from movie");  
    while(rs.next()) {
        jComboBox1.addItem(rs.getString("id"));
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
    
    public void jComboDelete(){
    
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
        ResultSet rs=stmt.executeQuery("SELECT* from movie");  
        while(rs.next()) {
        jComboBox2.addItem(rs.getString("id"));
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
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(employee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new employee().setVisible(true);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(employee.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Del;
    private javax.swing.JLabel d;
    private javax.swing.JTextField dDate;
    private javax.swing.JTextField dDiscount;
    private javax.swing.JTextField dDuring;
    private javax.swing.JTextField dPrice;
    private javax.swing.JTextField dSeats;
    private javax.swing.JTextField dType;
    private javax.swing.JTextField dc;
    private javax.swing.JTextField delName;
    private javax.swing.JLabel deleteBroadcastDate;
    private javax.swing.JLabel deleteBroadcastHours;
    private javax.swing.JTextArea desc;
    private javax.swing.JTextField dte;
    private javax.swing.JTextField during;
    private javax.swing.JTextField genreFilm;
    private javax.swing.JButton img;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labimage;
    private javax.swing.JTextField mD;
    private javax.swing.JTextField mDT;
    private javax.swing.JTextField mGr;
    private javax.swing.JTextField mS;
    private javax.swing.JTextField movieDn;
    private javax.swing.JTextField movieN;
    private javax.swing.JTextField moviePr;
    private javax.swing.JLabel msg;
    private javax.swing.JLabel msg4;
    private javax.swing.JLabel msg5;
    private javax.swing.JLabel mt;
    private javax.swing.JTextField nameFilm;
    private javax.swing.JTextField nbSeat;
    private javax.swing.JFormattedTextField newDate;
    private javax.swing.JComboBox<String> newHours;
    private javax.swing.JLabel nf;
    private javax.swing.JLabel nom;
    private javax.swing.JTextField price;
    private javax.swing.JTable table;
    private javax.swing.JTable table3;
    private javax.swing.JTable table4;
    private javax.swing.JTable tableDate;
    private javax.swing.JTable tableDelete;
    private javax.swing.JTextField trail;
    // End of variables declaration//GEN-END:variables
}
