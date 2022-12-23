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


 public class Film {
    private String name, type,description,link;
    private int duree,date,id;
    
    
    public Film(int id){
        this.id= id;
        initFilm();
    }
    
    
   public String getName(){return name;}
   public String getType(){return type;}
   public String getDesc(){return description;}
   public String getLink(){return link ;}

   public int getDuree(){return duree;}
   public int getDate(){return date;}
   public int getId(){return id;}

   public void setName(String n){name=n;}
   public void setType(String t){type=t;}
   public void setDesc(String d){description=d;}
   public void setLink(String n){link=n;}
   public void setDate(int d){date=d;}
   public void setTime(int t){duree= t;}
   
    public void initFilm(){
        int i= getId();
        
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
    ResultSet rs=stmt.executeQuery("SELECT * FROM movie where id= '"+i+"'");  
    while(rs.next()){  
       setName(rs.getString("nom"));
       setType(rs.getString("type"));
       setDesc(rs.getString("description"));
       setLink(rs.getString("link"));
       setDate(rs.getInt("date"));
       setTime(rs.getInt("time"));
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

 



