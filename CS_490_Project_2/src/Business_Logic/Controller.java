/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business_Logic;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

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
    private LinkedList<Request> requests = new LinkedList<>();
    private LinkedList<Movie> movies = new LinkedList<>();
    
    //Class Constructor
    private Controller () {}

    //Function to return the Singleton class object
    //Input: None
    //Output: Class Singleton object
    public static Controller instance () {
        //Determine if a class object has been created.
        if(Singleton == null) {
            //No class object created yet. Create one.
            Singleton = new Controller();
        }
        //Return the Singleton class object
        return Singleton;
    }
        
    //Function for testing
    //Print out of Customers, Movies, Rentals, and Requests
    public void printLists (){
        System.out.println("\n-------------------------");
        System.out.println("Customers: " + customers.size());
        System.out.println("-------------------------");
        for(Customer customer:customers){
            System.out.println(customer.info());
        }
        System.out.println("\n-------------------------");
        System.out.println("Movies: " + movies.size());
        System.out.println("-------------------------");
        for(Movie movie:movies){
            System.out.println(movie.info() + "\nDVDs");
            movie.printDVDs();
            System.out.println("\nActors");
            movie.printActors();
        }
        System.out.println("\n-------------------------");
        System.out.println("Rentals: " + rentals.size());
        System.out.println("-------------------------");
        for(Rental rental:rentals){
            System.out.println(rental.info());
        } 
        System.out.println("\n-------------------------");
        System.out.println("Requests: " + requests.size());
        System.out.println("-------------------------");
        for(Request request:requests){
            System.out.println(request.info());
        }     
    }
    
    //Function to add a new Customer
    //Input: Customer email, name, address, phone number, and password
    //Output: Customer object
    public Customer addCustomer (String email, String name, String address, String phone, String password) {
        Customer newCustomer = new Customer(email, name, address, phone, password);
        customers.add(newCustomer);
        return newCustomer;
    }
    
    //Function to add a new Rental
    //Input: The current date, the return date, customer name, and movie name
    //Output: Void
    public void addRental (Calendar rentDate, Calendar returnDate, String customerName, String movieName, String method){
        Customer customer = searchCustomers(customerName);
        Movie movie = searchMovies(movieName);
        DVD dvd = movie.getDVD();
        if(dvd != null) {
            Rental newRental = new Rental(rentDate, returnDate, customer, dvd, movie);
            rentals.add(newRental);
            makePayment(2.00, method, rentDate);
        }
        else {
            Request newRequest = new Request(rentDate, customer, movie);
            requests.add(newRequest);
        }
    }
        
    //Function to add a new Movie
    //Input: The movie rating, year made, and name
    //Ouput: Movie object
    public Movie addMovie (double Rating, int Year, String Name, String keyword, String type) {
        Keyword newKeyword = new Keyword(keyword);
        Movie newMovie = new Movie(Rating, Year, Name, newKeyword, getType(type));
        movies.add(newMovie);
        return newMovie;
    }

    //Function to add a avaiable DVD for a Movie
    //Input: Search key, DVD serial number ,lost , and rental status
    //Output: Void
    public void addDVD (String Key, int SerialNo, boolean Lost, String status){
        Movie movie = searchMovies(Key);
        movie.addDVD(SerialNo, Lost, getStatus(status));
    }
    
    //Function to add Actors to a movie
    //Input: Search key, Actor name and gender
    //Output: Void
    public void addActor (String Key, String Name, String Gender) {
        Movie movie = searchMovies(Key);
        movie.addActor(Name, getGender(Gender));
    }
        
    //Function to add Reviews for a movie
    //Input: Movie name, Customer name, rating, and review
    //Output: Void
    public void addReview (String Movie, String Customer, double Rating, String Review) {
        Customer customer = searchCustomers(Customer);
        Movie movie = searchMovies(Movie);
        Review review = new Review(customer, movie, Rating, Review);
    }
    
    //Function to return Rental
    //Input: Customer Name and DVD id
    //Output: Void
    public void returnRental (String customerName, int DVDid, String method){
        Rental rental = searchRentals(customerName, DVDid);
        Calendar today = Calendar.getInstance(Locale.US);
        int days;
        //Changing rental status from RENTED to AVAILABLE
        rental.getDvd().setStatus(Status.AVAILABLE);
        if (rental.getDate().before(today)){
            days = today.DAY_OF_MONTH - rental.getDate().DAY_OF_MONTH;
            System.out.println("\nRental " + days + " days late processing late fee payment\n");
            makePayment(days*.1, method, today);
        }
        for (Iterator<Rental> iter = rentals.listIterator(); iter.hasNext(); ) {
            Rental r = iter.next();
            if (r.contains(customerName) && r.contains(Integer.toString(DVDid))) {
                iter.remove();
            }
        }
    }
    
    //Function to make payment
    //Input: Amount, payment method, and date
    //Output: Payment object
    public Payment makePayment (double amount, String method, Calendar date){
        Payment p = new Payment(amount, method , date);
        p.processPayment();
        return p;
    }
    
    //Function to remove actors from a movie
    //Input: Actor and Movie Title
    //Output: void
    public void removeActor (String actor, String movieTitle){
        Movie movie = searchMovies(movieTitle);
        movie.removeActor(actor);
    }
    
    //Function to remove DVD from a movie
    //Input: Movie title and DVD id
    //Output: void
    public void removeDVD (String movieTitle, int DVDid){
        Movie movie = searchMovies(movieTitle);
        movie.removeDVD(DVDid);
    }
        
    //Function to iterate through customers and remove customer
    //Input: Email
    //Output: void
    public void removeCustomer (String email){
        for (Iterator<Customer> iter = customers.listIterator(); iter.hasNext(); ) {
            Customer c = iter.next();
            if (c.getEmail().contains(email)) {
                iter.remove();
            }
        }
    }
    
    //Function to iterate through movies and remove movie
    //Input: Movie name
    //Output: void
    public void removeMovie (String movieName){
        for (Iterator<Movie> iter = movies.listIterator(); iter.hasNext(); ) {
            Movie m = iter.next();
            if (m.getName().contains(movieName)) {
                iter.remove();
            }
        }
    }
    
    //Function to remove requests and add rental
    //Input: Customer name, and movie name
    //Output: void
    public void requestAnswered (String customerName, String movieName, String method){
        addRental(GregorianCalendar.getInstance(Locale.US), GregorianCalendar.getInstance(Locale.US), customerName, movieName, method);
        for (Iterator<Request> iter = requests.listIterator(); iter.hasNext(); ) {
            Request r = iter.next();
            if (r.contains(customerName) && r.contains(movieName)) {
                iter.remove();
            }
        }
    }  
        
    //Function to change keyword in a movie
    //Input: Movie title and keyword
    //Output: void
    public void changeKeyword (String movieTitle, String keyword){
        Movie movie = searchMovies(movieTitle);
        movie.changeKeyword(keyword);
    }
    
    //Function to convert a String to an Gender enum object
    //Input: String gender
    //Ouput: Gender enum object
    private Gender getGender (String gender) {
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
    
    //Funtion to convert a String to a Type enum object
    //Input: String type
    //Output: Type enum object
    private Type getType (String type) {
        //Remove any whitespace and conver to upper case
        String stringType = type.trim().toUpperCase();
        //Compare input to specific values
        switch(stringType) {
            case "G":
                return Type.G;
            case "PG":
                return Type.PG;
            case "PG13":
                return Type.PG13;
            case "R":
                return Type.R;
            default:
                return Type.PG;
        }
    }
    
    //Function to convert a String to an Status enum object
    //Input: String status
    //Ouput: Status enum object
    private Status getStatus (String status) {
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
    
    //Function to search through Movies list
    //Input: String search key
    //Output: Movie object
    public Movie searchMovies (String Key) {
        Movie m = null;
        for(Movie movie:movies) {
            if(movie.contains(Key)) {
                //Match found 
                m = movie;
                break;
            }
        }
        return m;
    }
    
    //Function to search through Rentals list
    //Input: Customer Name and DVD id
    //Output: Rental object
    public Rental searchRentals (String customerName, int DVDid ){
        Rental r = null;
        for(Rental rental:rentals){
            if(rental.contains(customerName) && rental.contains(Integer.toString(DVDid))){
                r = rental;
                break;
            }
        }
        return r;
    }
     
    //Function to search through Customers list
    //Input: String search key
    //Output: Customer object
    public Customer searchCustomers (String Key) {
        Customer c = null;
        for(Customer customer:customers){
            if(customer.contains(Key)) {
                //Match found
                c = customer;
                break;
            }
        }
        return c;
    }   
}
