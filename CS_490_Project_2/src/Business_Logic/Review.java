/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business_Logic;

/**
 *
 * @author charlie
 */
public class Review {
    //Class variables
    private double rating;
    private String review;
    
    //Class constructor
    public Review (double Rating, String Review) {
        this.rating = Rating;
        this.review = Review;
    }

    //Class get fucntions
    public double getRating() {
        return rating;
    }

    public String getReview() {
        return review;
    }
    
    
}
