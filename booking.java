/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication2;

/**
 *
 * @author oumar
 */
public class booking {
    private det_film DF;
    private int reserved_place;//the place reserved
    private String date;
    private String hour;
    public booking(det_film f, int nb, String d, String h){
        DF= f;
        reserved_place= nb;
        date=d;
        hour=h;
    }
    
    public int getPlace(){return reserved_place;}
    public det_film getDet_film(){return DF;}
    public String getDate(){return date;}
    public String getHour(){return hour;}
    
    
}
