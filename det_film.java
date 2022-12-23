/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class det_film extends Film{
    private double Price, discount;
   // private String img;
    private int nbSeat;
    private int idUser;
 
     public det_film(int id, int i){
        super(id);
        idUser=i;
        initFilm();
    }
    
     public int getIdUser(){return idUser;}
     public double getPr(){return Price;}
     public double getDis(){return discount;}
     public int getNS(){return nbSeat;}
     
     public void setPrice(double p){Price=p;}
     public void setDiscount(double d){discount =d;}
     public void setNseat(int n){nbSeat=n;}
     
 
    
    @Override
    public void initFilm(){
       int i= super.getId();
       super.initFilm();
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
    ResultSet rs=stmt.executeQuery("SELECT* FROM movie where id= '"+i+"'");  
    while(rs.next()){  
       setPrice(rs.getDouble("Price"));
       setDiscount(rs.getDouble("discount"));
       setNseat(rs.getInt("nbSeat"));
      // setImagePath(rs.getString("path_img"));
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



}
