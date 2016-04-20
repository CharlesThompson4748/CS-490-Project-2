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
    private static Controller Singleton;
    private LinkedList<Customer> customers = new LinkedList<>();
    private LinkedList<Rental> rentals = new LinkedList<>();
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
    
    public Customer addCustomer(String email, String name, String address, String phone, String password) {
        Customer newCustomer = new Customer(email, name, address, phone, password);
        customers.add(newCustomer);
        return newCustomer;
    }
    
    public Rental addRental (Calendar rentDate, Calendar returnDate, Status status){
        Rental newRental = new Rental(rentDate, returnDate, status);
        rentals.add(newRental);
        return newRental;
    }

}
