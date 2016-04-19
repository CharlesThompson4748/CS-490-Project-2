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
public class Movie {
    private double rating;
    private int year;
    private String name;
    
    public Movie (double Rating, int Year, String Name) { 
        this.rating = Rating;
        this.year = Year;
        this.name = Name;   
    }
}
