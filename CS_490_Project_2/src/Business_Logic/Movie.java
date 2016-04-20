/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business_Logic;

import java.util.LinkedList;

/**
 *
 * @author charlie
 */
public class Movie implements Searchable{
    //Class variables
    private double rating;
    private int year;
    private String name;
    private DVD dvd;
    
    //Class list for actors in the movie
    private LinkedList<Actor> actors = new LinkedList<>();
    private LinkedList<Review> reviews = new LinkedList<>();
    private LinkedList<DVD> dvds = new LinkedList<>();
    
    //Class constructor
    public Movie (double Rating, int Year, String Name) { 
        this.rating = Rating;
        this.year = Year;
        this.name = Name;   
    }
    
    //Function for testing
    public void printActors() {
        for(Actor actor:actors){
            System.out.println(actor.info());
        }
    }
    
    //Function for testing
    public void prindDVDs(){
        for(DVD dvd:dvds){
            System.out.println(dvd.info());
        }
    }
    //Function to add a DVD 
    //Input: DVD serial number and the lost status
    //Output: DVD object
    public DVD addDVD (int SN, boolean Lost){
        DVD newDVD = new DVD(SN, Lost);
        dvds.add(newDVD);
        return newDVD;
    }
    
    //Function to add a new actor and and put it in the actors list
    //Input: Actor name and gender
    //Output: Acctor object
    public Actor addActor (String Name, Gender gender) {
        Actor newActor = new Actor(Name, gender);
        actors.add(newActor);
        return newActor;
    }

    //Function to change the DVD's lost status
    //Input: Boolean status
    //Output: Void
    public void changeDVDLostStatus(boolean status) {
        dvd.setLost(status);
    }
    
    //Function to get the DVD's serial number
    //Input: Void
    //Output: DVD integer serial number
    public int getDVDSerialNo(){
        return dvd.getSerialNo();
    }
    
    //Function to get anc calculate the Movie rating
    //Input: Void
    //Output: Movie rating 
    public double getMovieRating() {
        double r = rating;
        for(Review review:reviews){
            r += review.getRating();
        }
        rating = r/reviews.size();
        return rating;
    }
    
    //Overriden interface function to find matches for searches of Movie objects
    //Input: String search key
    //Output: Boolean 
    @Override
    public boolean contains(String key){
        if(name.trim().toUpperCase().contains(key.trim().toUpperCase()))
            return true;
        else if(Integer.toString(year).contains(key.trim()))
            return true;
        else if(String.valueOf(rating).contains(key.trim()))
            return true;
        else 
            return false;
    }
    
    @Override
    public String info() {
        return "\nYear: " + Integer.toString(year) + "\nTitle: " + name + "\nRating: " + String.valueOf(rating);
     }
    
}
