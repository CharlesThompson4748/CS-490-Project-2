/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business_Logic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;

/**
 *
 * @author charlie
 */
public class Rental implements Searchable{
    //Class variables
    private Calendar rentalDate;
    private Calendar returnDate;
    private Status status;
    private DVD dvd;
    private Review review;
    private Customer customer;
    
    //Class constructor
    public Rental (Calendar RentDate, Calendar ReturnDate, Status status, Customer customer, DVD dvd){
        this.rentalDate = RentDate;
        this.returnDate = ReturnDate;
        this.status = status;
        this.customer = customer;
        this.dvd = dvd;
        setReturnDate();
    }
    
    //Class setters
    //This added 7 days to the date for return date
    private void setReturnDate(){
        returnDate.add(Calendar.DAY_OF_MONTH, 7);
    }
    
    public void setStatus(Status status){
        this.status = status;
    }
    
    //Class getters
    public String getRentalDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        String date = dateFormat.format(rentalDate.getTime());
        return date;
    }
    
    public String getReturnDate(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");   
        String date = dateFormat.format(returnDate.getTime());
        return date;
    }
    

    
    //Function to add a Review object to the reviews list
    //Input: Review object
    //Output: Void
    public void newReview(Review review){
        this.review = review;
    }
    
    //Function for testing
    @Override
    public String info(){
        return "Rental Date: " + this.getRentalDate() + "\nReturn Date: " + this.getReturnDate() + "\nStatus: " + this.status;
    }
    
    @Override
    public boolean contains(String key){
        if(customer.getName().trim().toUpperCase().contains(key.trim().toUpperCase()))
            return true;
        else 
            return false;
    }
}
