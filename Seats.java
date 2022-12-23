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
import java.util.ArrayList;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;


public class Seats extends javax.swing.JFrame {
private static booking b;
//private static ArrayList<String>seat;
private static double total;
private ArrayList<JCheckBox> te;//for manage the seat reserved
private ArrayList<String> seat;

    
    public Seats(booking boo) {
        initComponents();
        b=boo;
        
        te= new ArrayList<JCheckBox>();
        te.add(s1); te.add(s2); te.add(s3); te.add(s4); te.add(s5);  
        te.add(s6); te.add(s7); te.add(s8); te.add(s9); te.add(s10);
        te.add(s11);te.add(s12);te.add(s13);te.add(s14);te.add(s15);
        te.add(s16);te.add(s17);te.add(s18);te.add(s19);te.add(s20);
        te.add(s21); te.add(s22);te.add(s23);te.add(s24);te.add(s25);
        te.add(s26);te.add(s27);te.add(s28);te.add(s29);te.add(s30);
        te.add(s31);te.add(s32);te.add(s33); te.add(s34);te.add(s35);
        te.add(s36);te.add(s37);te.add(s38);te.add(s39);te.add(s40);
        te.add(s41);te.add(s42);te.add(s43);te.add(s44);te.add(s45);
        te.add(s46);te.add(s47); te.add(s48);te.add(s49); te.add(s50);
        te.add(s51);te.add(s52);te.add(s53);te.add(s54);te.add(s55);
        te.add(s56);te.add(s57);te.add(s58);te.add(s59);te.add(s60);
        te.add(s61);te.add(s62);te.add(s63);te.add(s64);te.add(s65);
        te.add(s66);te.add(s67);te.add(s68); te.add(s69);te.add(s70);
        te.add(s71); te.add(s72);
        
        //connexion in database for check the seat availables for this date
        //I do an sql requete for select seat number from data who correspond
        //to the date, hours of film broadcast and the film_id
        //With a for loop, i makes invisibles checkBox booked
            //retrieve the film id and the date for show
            int id= b.getDet_film().getId();
            String date= b.getDate();//the date for see the film
            String h= b.getHour();//Hour of watching
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
            ResultSet rs=stmt.executeQuery("SELECT* FROM seat_booked where date_show= '"+date+"' and hours='"+h+"' and id_film='"+id+"'");  
            while(rs.next()){
            String pl = rs.getString("seat_number");//the seat number in database 
             for(int i=0; i< te.size(); i++){
            if(te.get(i).getText().equals(pl)){
                te.get(i).setEnabled(false);
                 }
             }
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

    

    public void setTotal(double p){total=p;}
    public double getTotal(){return total;}
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        s1 = new javax.swing.JCheckBox();
        s2 = new javax.swing.JCheckBox();
        s3 = new javax.swing.JCheckBox();
        s4 = new javax.swing.JCheckBox();
        s5 = new javax.swing.JCheckBox();
        s6 = new javax.swing.JCheckBox();
        s7 = new javax.swing.JCheckBox();
        s8 = new javax.swing.JCheckBox();
        s9 = new javax.swing.JCheckBox();
        s10 = new javax.swing.JCheckBox();
        s11 = new javax.swing.JCheckBox();
        s12 = new javax.swing.JCheckBox();
        s13 = new javax.swing.JCheckBox();
        s14 = new javax.swing.JCheckBox();
        s15 = new javax.swing.JCheckBox();
        s16 = new javax.swing.JCheckBox();
        s17 = new javax.swing.JCheckBox();
        s18 = new javax.swing.JCheckBox();
        s19 = new javax.swing.JCheckBox();
        s20 = new javax.swing.JCheckBox();
        s21 = new javax.swing.JCheckBox();
        s22 = new javax.swing.JCheckBox();
        s23 = new javax.swing.JCheckBox();
        s24 = new javax.swing.JCheckBox();
        s25 = new javax.swing.JCheckBox();
        s26 = new javax.swing.JCheckBox();
        s27 = new javax.swing.JCheckBox();
        s28 = new javax.swing.JCheckBox();
        s29 = new javax.swing.JCheckBox();
        s30 = new javax.swing.JCheckBox();
        s31 = new javax.swing.JCheckBox();
        s32 = new javax.swing.JCheckBox();
        s33 = new javax.swing.JCheckBox();
        s34 = new javax.swing.JCheckBox();
        s35 = new javax.swing.JCheckBox();
        s36 = new javax.swing.JCheckBox();
        s37 = new javax.swing.JCheckBox();
        s38 = new javax.swing.JCheckBox();
        s39 = new javax.swing.JCheckBox();
        s40 = new javax.swing.JCheckBox();
        s41 = new javax.swing.JCheckBox();
        s42 = new javax.swing.JCheckBox();
        s43 = new javax.swing.JCheckBox();
        s44 = new javax.swing.JCheckBox();
        s45 = new javax.swing.JCheckBox();
        s46 = new javax.swing.JCheckBox();
        s47 = new javax.swing.JCheckBox();
        s48 = new javax.swing.JCheckBox();
        s49 = new javax.swing.JCheckBox();
        s50 = new javax.swing.JCheckBox();
        s51 = new javax.swing.JCheckBox();
        s52 = new javax.swing.JCheckBox();
        s53 = new javax.swing.JCheckBox();
        s54 = new javax.swing.JCheckBox();
        s55 = new javax.swing.JCheckBox();
        s56 = new javax.swing.JCheckBox();
        s58 = new javax.swing.JCheckBox();
        s57 = new javax.swing.JCheckBox();
        s59 = new javax.swing.JCheckBox();
        s60 = new javax.swing.JCheckBox();
        s61 = new javax.swing.JCheckBox();
        s62 = new javax.swing.JCheckBox();
        s63 = new javax.swing.JCheckBox();
        s64 = new javax.swing.JCheckBox();
        s65 = new javax.swing.JCheckBox();
        s66 = new javax.swing.JCheckBox();
        s67 = new javax.swing.JCheckBox();
        s68 = new javax.swing.JCheckBox();
        s69 = new javax.swing.JCheckBox();
        s70 = new javax.swing.JCheckBox();
        s71 = new javax.swing.JCheckBox();
        s72 = new javax.swing.JCheckBox();
        jLabel10 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton33 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        popCorn = new javax.swing.JTextField();
        sodas = new javax.swing.JTextField();
        kitkat = new javax.swing.JTextField();
        mms = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        tot = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        oui = new javax.swing.JCheckBox();
        non = new javax.swing.JCheckBox();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        s1.setText("1");

        s2.setText("2");

        s3.setText("3");

        s4.setText("4");

        s5.setText("5");

        s6.setText("6");

        s7.setText("7");

        s8.setText("8");
        s8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s8ActionPerformed(evt);
            }
        });

        s9.setText("9");

        s10.setText("10");
        s10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s10ActionPerformed(evt);
            }
        });

        s11.setText("11");
        s11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s11ActionPerformed(evt);
            }
        });

        s12.setText("12");
        s12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s12ActionPerformed(evt);
            }
        });

        s13.setText("13");
        s13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s13ActionPerformed(evt);
            }
        });

        s14.setText("14");
        s14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s14ActionPerformed(evt);
            }
        });

        s15.setText("15");
        s15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s15ActionPerformed(evt);
            }
        });

        s16.setText("16");
        s16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s16ActionPerformed(evt);
            }
        });

        s17.setText("17");
        s17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s17ActionPerformed(evt);
            }
        });

        s18.setText("18");
        s18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s18ActionPerformed(evt);
            }
        });

        s19.setText("19");
        s19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s19ActionPerformed(evt);
            }
        });

        s20.setText("20");
        s20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s20ActionPerformed(evt);
            }
        });

        s21.setText("21");
        s21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s21ActionPerformed(evt);
            }
        });

        s22.setText("22");
        s22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s22ActionPerformed(evt);
            }
        });

        s23.setText("23");
        s23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s23ActionPerformed(evt);
            }
        });

        s24.setText("24");
        s24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s24ActionPerformed(evt);
            }
        });

        s25.setText("25");
        s25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s25ActionPerformed(evt);
            }
        });

        s26.setText("26");
        s26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s26ActionPerformed(evt);
            }
        });

        s27.setText("33");
        s27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s27ActionPerformed(evt);
            }
        });

        s28.setText("28");
        s28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s28ActionPerformed(evt);
            }
        });

        s29.setText("29");
        s29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s29ActionPerformed(evt);
            }
        });

        s30.setText("30");
        s30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s30ActionPerformed(evt);
            }
        });

        s31.setText("31");
        s31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s31ActionPerformed(evt);
            }
        });

        s32.setText("32");
        s32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s32ActionPerformed(evt);
            }
        });

        s33.setText("27");
        s33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s33ActionPerformed(evt);
            }
        });

        s34.setText("34");
        s34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s34ActionPerformed(evt);
            }
        });

        s35.setText("35");
        s35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s35ActionPerformed(evt);
            }
        });

        s36.setText("36");
        s36.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s36ActionPerformed(evt);
            }
        });

        s37.setText("37");
        s37.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s37ActionPerformed(evt);
            }
        });

        s38.setText("38");
        s38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s38ActionPerformed(evt);
            }
        });

        s39.setText("39");
        s39.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s39ActionPerformed(evt);
            }
        });

        s40.setText("40");
        s40.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s40ActionPerformed(evt);
            }
        });

        s41.setText("41");
        s41.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s41ActionPerformed(evt);
            }
        });

        s42.setText("42");
        s42.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s42ActionPerformed(evt);
            }
        });

        s43.setText("43");
        s43.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s43ActionPerformed(evt);
            }
        });

        s44.setText("44");
        s44.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s44ActionPerformed(evt);
            }
        });

        s45.setText("45");
        s45.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s45ActionPerformed(evt);
            }
        });

        s46.setText("46");
        s46.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s46ActionPerformed(evt);
            }
        });

        s47.setText("47");
        s47.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s47ActionPerformed(evt);
            }
        });

        s48.setText("48");
        s48.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s48ActionPerformed(evt);
            }
        });

        s49.setText("49");
        s49.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s49ActionPerformed(evt);
            }
        });

        s50.setText("50");
        s50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s50ActionPerformed(evt);
            }
        });

        s51.setText("51");
        s51.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s51ActionPerformed(evt);
            }
        });

        s52.setText("52");
        s52.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s52ActionPerformed(evt);
            }
        });

        s53.setText("53");
        s53.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s53ActionPerformed(evt);
            }
        });

        s54.setText("54");
        s54.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s54ActionPerformed(evt);
            }
        });

        s55.setText("55");
        s55.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s55ActionPerformed(evt);
            }
        });

        s56.setText("56");
        s56.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s56ActionPerformed(evt);
            }
        });

        s58.setText("58");
        s58.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s58ActionPerformed(evt);
            }
        });

        s57.setText("57");
        s57.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s57ActionPerformed(evt);
            }
        });

        s59.setText("59");
        s59.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s59ActionPerformed(evt);
            }
        });

        s60.setText("60");
        s60.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s60ActionPerformed(evt);
            }
        });

        s61.setText("61");
        s61.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s61ActionPerformed(evt);
            }
        });

        s62.setText("62");
        s62.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s62ActionPerformed(evt);
            }
        });

        s63.setText("63");
        s63.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s63ActionPerformed(evt);
            }
        });

        s64.setText("64");
        s64.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s64ActionPerformed(evt);
            }
        });

        s65.setText("65");
        s65.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s65ActionPerformed(evt);
            }
        });

        s66.setText("66");
        s66.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s66ActionPerformed(evt);
            }
        });

        s67.setText("67");
        s67.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s67ActionPerformed(evt);
            }
        });

        s68.setText("68");
        s68.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s68ActionPerformed(evt);
            }
        });

        s69.setText("69");
        s69.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s69ActionPerformed(evt);
            }
        });

        s70.setText("70");
        s70.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s70ActionPerformed(evt);
            }
        });

        s71.setText("71");
        s71.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s71ActionPerformed(evt);
            }
        });

        s72.setText("72");
        s72.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                s72ActionPerformed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon("C:\\Users\\oumar\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication2\\images\\th.jpeg")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(s1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s17, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s27, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s25, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s41, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s49, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s57, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s65, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(s9, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(s18, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(s19, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(s20, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(s26, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(s33, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(s28, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(s34, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(s35, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(s36, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(s42, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(s43, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(s44, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(s50, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(s51, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(s52, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(s58, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(s59, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(s60, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(24, 24, 24)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(56, 56, 56)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(s53, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(s45, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(s37, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(s29, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(s61, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(s69, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(s21, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(s66, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(s67, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(s68, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(s10, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(s11, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(s12, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(s2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(s3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(s5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(s13, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(s6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(s7, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(s8, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(s14, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s15, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s16, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(s22, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(s23, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(s30, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(s31, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(s32, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(s24, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(s38, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s39, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s40, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(s46, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s47, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s48, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(s54, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s55, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s56, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(s62, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s63, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s64, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(s70, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s71, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(s72, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s1)
                    .addComponent(s2)
                    .addComponent(s3)
                    .addComponent(s5)
                    .addComponent(s6)
                    .addComponent(s7)
                    .addComponent(s8)
                    .addComponent(s4))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s9)
                    .addComponent(s10)
                    .addComponent(s11)
                    .addComponent(s12)
                    .addComponent(s13)
                    .addComponent(s14)
                    .addComponent(s15)
                    .addComponent(s16))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s17)
                    .addComponent(s18)
                    .addComponent(s19)
                    .addComponent(s20)
                    .addComponent(s21)
                    .addComponent(s22)
                    .addComponent(s23)
                    .addComponent(s24))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s25)
                    .addComponent(s26)
                    .addComponent(s33)
                    .addComponent(s28)
                    .addComponent(s29)
                    .addComponent(s30)
                    .addComponent(s31)
                    .addComponent(s32))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(s34)
                        .addComponent(s35)
                        .addComponent(s36)
                        .addComponent(s37)
                        .addComponent(s38)
                        .addComponent(s39)
                        .addComponent(s40))
                    .addComponent(s27))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s41)
                    .addComponent(s42)
                    .addComponent(s43)
                    .addComponent(s44)
                    .addComponent(s45)
                    .addComponent(s46)
                    .addComponent(s47)
                    .addComponent(s48))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s49)
                    .addComponent(s50)
                    .addComponent(s51)
                    .addComponent(s52)
                    .addComponent(s53)
                    .addComponent(s54)
                    .addComponent(s55)
                    .addComponent(s56))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(s58)
                        .addComponent(s59)
                        .addComponent(s60)
                        .addComponent(s61)
                        .addComponent(s62)
                        .addComponent(s63)
                        .addComponent(s64))
                    .addComponent(s57))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(s65)
                    .addComponent(s66)
                    .addComponent(s67)
                    .addComponent(s68)
                    .addComponent(s69)
                    .addComponent(s70)
                    .addComponent(s71)
                    .addComponent(s72))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Choose your seat");

        jButton33.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton33.setText("Make payment");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\oumar\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication2\\images\\popC.png")); // NOI18N
        jLabel3.setText("15€");

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\oumar\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication2\\images\\sodas.png")); // NOI18N
        jLabel4.setText("2,98€");

        jLabel5.setIcon(new javax.swing.ImageIcon("C:\\Users\\oumar\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication2\\images\\kitkat.png")); // NOI18N
        jLabel5.setText("2,75€");

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\oumar\\OneDrive\\Documents\\NetBeansProjects\\JavaApplication2\\images\\mms.png")); // NOI18N
        jLabel6.setText("11,99€");

        popCorn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popCornActionPerformed(evt);
            }
        });

        mms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mmsActionPerformed(evt);
            }
        });

        jButton1.setText("Add to my booking");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(tot, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 71, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(popCorn, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(sodas, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kitkat, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(mms, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(26, 26, 26))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(60, 60, 60))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(popCorn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(sodas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(kitkat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mms, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tot)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jLabel7.setFont(new java.awt.Font("Segoe Print", 0, 14)); // NOI18N
        jLabel7.setText("Foods");

        jLabel8.setFont(new java.awt.Font("Segoe Print", 0, 12)); // NOI18N
        jLabel8.setText("Quantity");

        jLabel9.setFont(new java.awt.Font("SimSun-ExtB", 0, 14)); // NOI18N
        jLabel9.setText("Do you have a student card ?");

        buttonGroup1.add(oui);
        oui.setText("Yes");

        buttonGroup1.add(non);
        non.setText("No");

        jButton2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(121, 121, 121)
                .addComponent(jLabel8)
                .addGap(51, 51, 51))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(oui, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(non, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(48, 48, 48)
                        .addComponent(jButton2)
                        .addGap(31, 31, 31)
                        .addComponent(jButton33))
                    .addComponent(jLabel9))
                .addContainerGap(282, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton33)
                    .addComponent(oui)
                    .addComponent(non)
                    .addComponent(jButton2))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void s8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s8ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        // TODO add your handling code here:
        if( (!(oui.isSelected())) && (!(non.isSelected()))) {
            JOptionPane.showMessageDialog(null, "You must select the case YES/NO");
        }else{
       /* te= new ArrayList<JCheckBox>();
        te.add(s1); te.add(s2); te.add(s3); te.add(s4); te.add(s5);  
        te.add(s6); te.add(s7); te.add(s8); te.add(s9); te.add(s10);
        te.add(s11);te.add(s12);te.add(s13);te.add(s14);te.add(s15);
        te.add(s16);te.add(s17);te.add(s18);te.add(s19);te.add(s20);
        te.add(s21); te.add(s22);te.add(s23);te.add(s24);te.add(s25);
        te.add(s26);te.add(s27);te.add(s28);te.add(s29);te.add(s30);
        te.add(s31);te.add(s32);te.add(s33); te.add(s34);te.add(s35);
        te.add(s36);te.add(s37);te.add(s38);te.add(s39);te.add(s40);
        te.add(s41);te.add(s42);te.add(s43);te.add(s44);te.add(s45);
        te.add(s46);te.add(s47); te.add(s48);te.add(s49); te.add(s50);
        te.add(s51);te.add(s52);te.add(s53);te.add(s54);te.add(s55);
        te.add(s56);te.add(s57);te.add(s58);te.add(s59);te.add(s60);
        te.add(s61);te.add(s62);te.add(s63);te.add(s64);te.add(s65);
        te.add(s66);te.add(s67);te.add(s68); te.add(s69);te.add(s70);
        te.add(s71); te.add(s72);*/
     
        int i=0;
        for(JCheckBox f: te){
            if(f.isSelected()){
                i++;
            }
        }
        System.out.println(i);
        seat=new ArrayList<String>();
         for(JCheckBox f: te){
             if(f.isSelected()){
                 seat.add(f.getText());
             }
         }
         
         if(b.getPlace()!=i){
         /*for(String s:seat){
             System.out.println(s);
             }*/
             JOptionPane.showMessageDialog(null, "You must select the good number of ticket(s)");
         }else{
             boolean std;//for student card
             if(oui.isSelected()){
                 std=true;
             }else{
                 std=false;
             }
         paiement paie= new paiement(b,seat, getTotal(), std);
         new payment(paie).setVisible(true);
                         setVisible(false);

         }
         }
    }//GEN-LAST:event_jButton33ActionPerformed

    private void s10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s10ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s10ActionPerformed

    private void s11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s11ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s11ActionPerformed

    private void s12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s12ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s12ActionPerformed

    private void s13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s13ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s13ActionPerformed

    private void s14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s14ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s14ActionPerformed

    private void s15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s15ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s15ActionPerformed

    private void s16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s16ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s16ActionPerformed

    private void s17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s17ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s17ActionPerformed

    private void s18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s18ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s18ActionPerformed

    private void s19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s19ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s19ActionPerformed

    private void s20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s20ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s20ActionPerformed

    private void s21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s21ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s21ActionPerformed

    private void s22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s22ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s22ActionPerformed

    private void s23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s23ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s23ActionPerformed

    private void s24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s24ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s24ActionPerformed

    private void s25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s25ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s25ActionPerformed

    private void s26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s26ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s26ActionPerformed

    private void s27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s27ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s27ActionPerformed

    private void s28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s28ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s28ActionPerformed

    private void s29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s29ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s29ActionPerformed

    private void s30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s30ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s30ActionPerformed

    private void s31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s31ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s31ActionPerformed

    private void s32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s32ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s32ActionPerformed

    private void s33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s33ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s33ActionPerformed

    private void s34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s34ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s34ActionPerformed

    private void s35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s35ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s35ActionPerformed

    private void s36ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s36ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s36ActionPerformed

    private void s37ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s37ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s37ActionPerformed

    private void s38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s38ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s38ActionPerformed

    private void s39ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s39ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s39ActionPerformed

    private void s40ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s40ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s40ActionPerformed

    private void s41ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s41ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s41ActionPerformed

    private void s42ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s42ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s42ActionPerformed

    private void s43ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s43ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s43ActionPerformed

    private void s44ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s44ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s44ActionPerformed

    private void s45ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s45ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s45ActionPerformed

    private void s46ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s46ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s46ActionPerformed

    private void s47ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s47ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s47ActionPerformed

    private void s48ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s48ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s48ActionPerformed

    private void s49ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s49ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s49ActionPerformed

    private void s50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s50ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s50ActionPerformed

    private void s51ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s51ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s51ActionPerformed

    private void s52ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s52ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s52ActionPerformed

    private void s53ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s53ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s53ActionPerformed

    private void s54ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s54ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s54ActionPerformed

    private void s55ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s55ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s55ActionPerformed

    private void s56ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s56ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s56ActionPerformed

    private void s58ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s58ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s58ActionPerformed

    private void s57ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s57ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s57ActionPerformed

    private void s59ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s59ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s59ActionPerformed

    private void s60ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s60ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s60ActionPerformed

    private void s61ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s61ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s61ActionPerformed

    private void s62ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s62ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s62ActionPerformed

    private void s63ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s63ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s63ActionPerformed

    private void s64ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s64ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s64ActionPerformed

    private void s65ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s65ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s65ActionPerformed

    private void s66ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s66ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s66ActionPerformed

    private void s67ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s67ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s67ActionPerformed

    private void s68ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s68ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s68ActionPerformed

    private void s69ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s69ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s69ActionPerformed

    private void s70ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s70ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s70ActionPerformed

    private void s71ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s71ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s71ActionPerformed

    private void s72ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_s72ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_s72ActionPerformed

    private void mmsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mmsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mmsActionPerformed

    private void popCornActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popCornActionPerformed
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_popCornActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       
        String pop= popCorn.getText();
        String sd= sodas.getText();
        String kit= kitkat.getText();
        String ms= mms.getText();
        double res=0.0;
         int nb,sds,kkt,m;

       

        if(pop.isEmpty()){
            pop="0";
        }
        if(sd.isEmpty()){
            sd="0";
        }
        if(kit.isEmpty()){
            kit="0";
           }
        if(ms.isEmpty()){
            ms="0";
        }
       //Convert into int
         //Pop Corn
           nb=Integer.parseInt(pop);
         sds= Integer.parseInt(sd);
         kkt= Integer.parseInt(kit);
         m= Integer.parseInt(ms);
       if(nb<0){
           JOptionPane.showMessageDialog(null, "Incorrect number");
       }
       
        //sodas
       if(sds<0){
           JOptionPane.showMessageDialog(null, "Incorrect number");
       }
        //kitkat
         if(kkt<0){
           JOptionPane.showMessageDialog(null, "Incorrect number");
       }
         
        //mms
         if(m<0){
           JOptionPane.showMessageDialog(null, "Incorrect number");
       }
        
         res= ((nb*15)+(sds*2.98)+(kkt*2.74)+ (m*11.98));
        //setTotal(res);
        res= Math.round(res);
       tot.setText("Cost= "+ res+" €");
       setTotal(res);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        new choise(b.getDet_film()).setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Seats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Seats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Seats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Seats.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Seats(b).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton33;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField kitkat;
    private javax.swing.JTextField mms;
    private javax.swing.JCheckBox non;
    private javax.swing.JCheckBox oui;
    private javax.swing.JTextField popCorn;
    private javax.swing.JCheckBox s1;
    private javax.swing.JCheckBox s10;
    private javax.swing.JCheckBox s11;
    private javax.swing.JCheckBox s12;
    private javax.swing.JCheckBox s13;
    private javax.swing.JCheckBox s14;
    private javax.swing.JCheckBox s15;
    private javax.swing.JCheckBox s16;
    private javax.swing.JCheckBox s17;
    private javax.swing.JCheckBox s18;
    private javax.swing.JCheckBox s19;
    private javax.swing.JCheckBox s2;
    private javax.swing.JCheckBox s20;
    private javax.swing.JCheckBox s21;
    private javax.swing.JCheckBox s22;
    private javax.swing.JCheckBox s23;
    private javax.swing.JCheckBox s24;
    private javax.swing.JCheckBox s25;
    private javax.swing.JCheckBox s26;
    private javax.swing.JCheckBox s27;
    private javax.swing.JCheckBox s28;
    private javax.swing.JCheckBox s29;
    private javax.swing.JCheckBox s3;
    private javax.swing.JCheckBox s30;
    private javax.swing.JCheckBox s31;
    private javax.swing.JCheckBox s32;
    private javax.swing.JCheckBox s33;
    private javax.swing.JCheckBox s34;
    private javax.swing.JCheckBox s35;
    private javax.swing.JCheckBox s36;
    private javax.swing.JCheckBox s37;
    private javax.swing.JCheckBox s38;
    private javax.swing.JCheckBox s39;
    private javax.swing.JCheckBox s4;
    private javax.swing.JCheckBox s40;
    private javax.swing.JCheckBox s41;
    private javax.swing.JCheckBox s42;
    private javax.swing.JCheckBox s43;
    private javax.swing.JCheckBox s44;
    private javax.swing.JCheckBox s45;
    private javax.swing.JCheckBox s46;
    private javax.swing.JCheckBox s47;
    private javax.swing.JCheckBox s48;
    private javax.swing.JCheckBox s49;
    private javax.swing.JCheckBox s5;
    private javax.swing.JCheckBox s50;
    private javax.swing.JCheckBox s51;
    private javax.swing.JCheckBox s52;
    private javax.swing.JCheckBox s53;
    private javax.swing.JCheckBox s54;
    private javax.swing.JCheckBox s55;
    private javax.swing.JCheckBox s56;
    private javax.swing.JCheckBox s57;
    private javax.swing.JCheckBox s58;
    private javax.swing.JCheckBox s59;
    private javax.swing.JCheckBox s6;
    private javax.swing.JCheckBox s60;
    private javax.swing.JCheckBox s61;
    private javax.swing.JCheckBox s62;
    private javax.swing.JCheckBox s63;
    private javax.swing.JCheckBox s64;
    private javax.swing.JCheckBox s65;
    private javax.swing.JCheckBox s66;
    private javax.swing.JCheckBox s67;
    private javax.swing.JCheckBox s68;
    private javax.swing.JCheckBox s69;
    private javax.swing.JCheckBox s7;
    private javax.swing.JCheckBox s70;
    private javax.swing.JCheckBox s71;
    private javax.swing.JCheckBox s72;
    private javax.swing.JCheckBox s8;
    private javax.swing.JCheckBox s9;
    private javax.swing.JTextField sodas;
    private javax.swing.JLabel tot;
    // End of variables declaration//GEN-END:variables
}
