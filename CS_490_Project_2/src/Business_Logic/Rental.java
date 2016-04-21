/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business_Logic;

import java.util.Calendar;
import java.util.LinkedList;

/**
 *
 * @author charlie
 */
public class Rental {
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
    }
    
    //Function to add a Review object to the reviews list
    //Input: Review object
    //Output: Void
    public void newReview(Review review){
        this.review = review;
    }
    
    //Function for testing
    public String info(){
        return "Rental Date: " + this.rentalDate.toString() + "\nReturn Date: " + this.returnDate.toString() + "\nStatus: " + this.status;
    }
    
}
