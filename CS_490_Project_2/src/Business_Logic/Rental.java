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
    
    private LinkedList<Review> reviews = new LinkedList<>();
    
    //Class constructor
    public Rental (Calendar RentDate, Calendar ReturnDate, Status status){
        this.rentalDate = RentDate;
        this.returnDate = ReturnDate;
        this.status = status;
    }
    
    //Function to add a Review object to the reviews list
    //Input: Review object
    //Output: Void
    public void newReview(Review review){
        this.review = review;
    }
    
    //Function to get anc calculate the Movie rating
    //Input: Void
    //Output: Movie rating 
    public double getMovieRating() {
        double r = 0.0;
        for(Review review:reviews){
            r += review.getRating();
        }
        r= r/reviews.size();
        return r;
    }
    
}
