/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.printing.PDFPageable;

/**
 *
 * @author oumar
 */
public class paiement {
    private booking book;
    private  ArrayList<String> seat;
    private boolean isStudent;
    private double consumption;
    private final double studentDiscount=0.05;
    private double total;
    private static String pathTicketPdf;//Contain the pdf of user's order, we use him for when user want to print his ticket
    public paiement(booking b, ArrayList<String>s, double food, boolean isStu){
        book=b;
        seat=s;
        consumption=food;
        isStudent= isStu;
    }
    
    public booking getBooking(){return book;}
    public ArrayList<String> getSeat(){return seat;}
    public double getConsol(){return consumption;}
    public boolean getStud(){return isStudent;}
    public double getTotal(){return total;}
    public String getPathTicket(){return pathTicketPdf;}

    public void setTot(double p){total=p;}
    public void setPathTicket(String s){pathTicketPdf=s;}
    
    public String displaySeat(){
        String p="" ;
        for(String i: seat){
            p+=i+ " ";
        }
        return p;
    }
    public double pay(){
        double total=0.0;
        //if idUser != -1 , it's a client who have a count
        int idUser= getBooking().getDet_film().getIdUser();
        if(idUser == -1){
           double res= getBooking().getPlace() * getBooking().getDet_film().getPr();
            if(getStud()== true){
                double res1= res - (res*studentDiscount);
                total = res1  ;
            }else{
                total=res;
            }
            
        }else{
            double res= (getBooking().getPlace() * getBooking().getDet_film().getPr());
            double discount= (getBooking().getDet_film().getDis())/100.0;
           if(getStud()==true){//it's a client who have an account 
               double res1= res - (res*discount);//discount for member
               total= (res1-(res1*studentDiscount));
           }else{
               double res1= res - (res*discount);//discount for member
               total=res1;
           }
        }
        total= total+getConsol();
        setTot(total);
        return getTotal();
    }
    
    
    
    /*************Print the ticket in pdf format**********/
    public void printicket() throws FileNotFoundException, DocumentException{
         Document doc = new Document();  
        
        int nbSeat= getBooking().getPlace();
        String ns= String.valueOf(nbSeat);//number of seat
        String dte= getBooking().getDate();//date 
        String name= getBooking().getDet_film().getName();//movie name
        ArrayList<String> s= getSeat();
        boolean std= getStud();//have a student card
        double tot= getTotal();//total bill
        String d="Ticket" + ns+dte; //ticket name
        setPathTicket(d);
        String res="C://Users//oumar//OneDrive//Documents//NetBeansProjects//JavaApplication2//pdf/"+ d+".pdf";
        PdfWriter writer = PdfWriter.getInstance(doc, new FileOutputStream(res));  
        System.out.println("PDF created.");  
        doc.open();  
        //adding paragraphs to the PDF      
        doc.add(new Paragraph( ""+ name));  
        doc.add(new Paragraph("                                       "));  
        doc.add(new Paragraph(nbSeat + " seat(s)"));  
        doc.add(new Paragraph("place(s) number: " + displaySeat()));

        doc.add(new Paragraph("Student card: "+ std));  
        doc.add(new Paragraph("Total: "+ tot + " €"));  
        doc.add(new Paragraph("Please bring this ticket with you, as well as your student card if this is the case."));  
        //closes the document  
        doc.close();  
        changeTicketNumber();//For change the total number of seats
        ticketBooking(res);//insertion of ticket path in databas
        insertSeats();
        
  }




  /**Method for update the number of ticket in the database we call him in 
   the method "printicket"*/
   public void changeTicketNumber(){
       int id = getBooking().getDet_film().getId();
       int ticketBuying= getBooking().getPlace();
       int totalTicket= getBooking().getDet_film().getNS();
       int restTicket= totalTicket- ticketBuying;
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
        String req= "Update movie set nbSeat='"+restTicket+"' where id= '"+id+"'";
        //System.out.println(req);
        //cust is the name of the table
        ResultSet rs=stmt.executeQuery( req);  
      
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
   
   
    /*****Method for insert the ticket in the database
      we call him in 
   the method "printicket"
     *******/
   public void ticketBooking(String s){//This string contain the path of the pdf
       int idU= getBooking().getDet_film().getIdUser();
       String name= getBooking().getDet_film().getName();
       int nbSeat= getBooking().getPlace();
       
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
        String req= "insert into ticket (id, film_name, userId, seats, date, pdf) values(null, '"+name+"', '"+idU+"','"+nbSeat+"', now(), '"+s+"')";
        //System.out.println(req);  

        ResultSet rs=stmt.executeQuery(req);  
        System.out.println(idU);  

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



   /*Method who allows user to print her ticket**/
public void printUser() throws PrinterException, IOException{
            
            File f= new File("C://Users//oumar//OneDrive//Documents//NetBeansProjects//JavaApplication2//pdf//" + getPathTicket()+".pdf");//The path where we will find the ticket
            PDDocument document = Loader.loadPDF(f);
            
            PrinterJob job = PrinterJob.getPrinterJob();
             job.setPageable(new PDFPageable(document));
	     //job.print();

         if (job.printDialog())
	        {
	            job.print();
	        }
}



/*********Method for insert reserved seats in database******************/
public void insertSeats(){
    //film id
      int idF= getBooking().getDet_film().getId();
      String date= getBooking().getDate();//show date
      String hour= getBooking().getHour();

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
for(String s: getSeat()){
ResultSet rs=stmt.executeQuery("Insert into seat_booked(id_film , seat_number,date_show, hours) values('"+idF+"', '"+s+"', '"+date+"', '"+hour+"') ");  
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