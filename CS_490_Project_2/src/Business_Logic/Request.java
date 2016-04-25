/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business_Logic;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author charlie
 */
public class Request implements Searchable{
    //Class variables
    private Calendar requestDate;
    private Customer customer;
    private Movie movie;
    
    //Class constructor
    public Request (Calendar reqDate, Customer customer, Movie movie) {
        this.requestDate = reqDate;
        this.customer = customer;
        this.movie = movie;
    }
    
    //Class getters
    public String getRequestDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String date = dateFormat.format(requestDate.getTime());
        return date;        
    }
    
    @Override
    public String info(){
        return "Request Date: " + this.getRequestDate();
    }
    
    @Override
    public boolean contains(String key){
        if(customer.getName().trim().toUpperCase().contains(key.trim().toUpperCase()))
            return true;
        else if(movie.getName().trim().toUpperCase().contains(key.trim().toUpperCase()))
            return true;
        else 
            return false;
    }
}
