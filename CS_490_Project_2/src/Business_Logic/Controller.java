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
public class Controller {
    //Controller singleton object
    private static Controller Singleton;
    
    //Class lists
    private LinkedList<Customer> customers = new LinkedList<>();
    private LinkedList<Rental> rentals = new LinkedList<>();
    private LinkedList<Movie> movies = new LinkedList<>();
    
    //Class Constructor
    private Controller() {}

    //Function to return the Singleton class object
    //Input: None
    //Output: Class Singleton object
    public static Controller instance() {
        //Determine if a class object has been created.
        if(Singleton == null) {
            //No class object created yet. Create one.
            Singleton = new Controller();
        }
        //Return the Singleton class object
        return Singleton;
    }
    
    //Function to add a new Customer
    //Input: Customer email, name, address, phone number, and password
    //Output: Customer object
    public Customer addCustomer(String email, String name, String address, String phone, String password) {
        Customer newCustomer = new Customer(email, name, address, phone, password);
        customers.add(newCustomer);
        return newCustomer;
    }
    
    //Function to add a new Rental
    //Input: The current date, the return date and the status of the movie
    //Output: Rental object
    public Rental addRental (Calendar rentDate, Calendar returnDate, String Status){
        Rental newRental = new Rental(rentDate, returnDate, getStatus(Status));
        rentals.add(newRental);
        return newRental;
    }
    
    //Function to add a new Movie
    //Input: The movie rating, year made, and name
    //Ouput: Movie object
    public Movie addMovie (double Rating, int Year, String Name) {
        Movie newMovie = new Movie(Rating, Year, Name);
        movies.add(newMovie);
        return newMovie;
    }

    //Function to add a avaiable DVD for a Movie
    //Input: Search key, DVD serial number and lost status
    //Output: Void
    public void addDVD(String Key, int SerialNo, boolean Status){
        //Search the movies list for strings that contain key 
        for(Movie movie:movies) {
            if(movie.contains(Key)) {
                //Match found creating new DVD object
                movie.addDVD(SerialNo, Status);
                break;
            }
        }
    }
    
    //Function to add Actors to a movie
    //Input: Search key, Actor name and gender
    //Output: Void
    public void addActor(String Key, String Name, String Gender) {
        //Search the movies list for strings that contain key 
        for(Movie movie:movies) {
            if(movie.contains(Key)) {
                //Match found creating new Actor object
                movie.addActor(Name, getGender(Gender));
                break;
            }
        }
    }
    
    //Function to convert a String to an Gender enum object
    //Input: String gender
    //Ouput: Gender enum object
    private Gender getGender(String gender) {
        //Remove any whitespace and conver to upper case
        String type = gender.trim().toUpperCase();
        //Compare input to specific values
        switch(type) {
            case "MALE":
                //Return the enum object
                return Gender.MALE;
            case "FEMALE":
                return Gender.FEMALE;
            //No match found. Default value to enum MALE
            default:
                return Gender.MALE;
        }
    }
    
    //Function to convert a String to an Status enum object
    //Input: String status
    //Ouput: Status enum object
    private Status getStatus(String status) {
        //Remove any whitespace and convert to upper case
        String type = status.trim().toUpperCase();
        //Compare input to specific values
        switch(type) {
            case "AVAILABLE":
                //Return the enum object
                return Status.AVAILABLE;
            case "RENTED":
                return Status.RENTED;
            //No match found. Default value to enum AVAILABLE
            default:
                return Status.AVAILABLE;
        }
    }
}
