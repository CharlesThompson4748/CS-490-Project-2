/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business_Logic;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 *
 * @author charlie
 */
public class MovieRental {
    public static void main(String[] args){
        //Creating new controller object
        Controller controller = Controller.instance();
        
        //Adding Customers
        controller.addCustomer("Bender@gmail.com", "Bender Bending Rodriguez", "1800 King Dr.", "470-010-0100", "BenderIsGreat");
        controller.addCustomer("DeliveryBoy@gmail.com", "Phillip J. Fry", "2999 Future Ln.", "001-231-2000", "Leila");
        controller.addCustomer("ShellCity@gmail.com", "John A. Zoidberg", "200 DumbsterOutBack Rd.", "158-0245-9752", "Awww");
        controller.addCustomer("CharlesThompson@gmail.com", "Charles Thompson", "1234 Road Dr.", "123-456-7890", "HaHaHaHa");
        controller.addCustomer("KatrinaFlynn@gmail.com", "Katrina Flynn", "5678 Drive Rd.", "987-654-3210", "KatFlynn");
        controller.addCustomer("BrandonBuckalew@gmail.com", "Brandon Buckalew", "5780 Main St.", "785-123-7802", "Brandon");
        
        //Adding Movies
        controller.addMovie(3.2, 2006, "That One Movie", "Comedy", "PG");
        controller.addMovie(1.2, 2010, "That Other Movie", "Thriller", "PG13");
        controller.addMovie(4.0, 2013, "Ted", "Comedy", "R");
        controller.addMovie(5.0, 2001, "Forrest Gump", "Drama", "PG13");
        controller.addMovie(4.2, 2008, "Some Movie Nobody Has Heard Of", "Drama","G");
        controller.addMovie(2.3, 2003, "Another One", "Comedy","G");
        controller.addMovie(3.6, 1999, "1999 I Don't Know Something Awefull", "Drama","R");
        controller.addMovie(4.1, 1984, "LOL 1984", "Comedy","PG13");
        controller.addMovie(1.8, 2015, "Star Wars: The Force Awakens", "Action","PG13");
        
        //Adding DVDs
        controller.addDVD("Ted", 5654684, false, "AVAILABLE");
        controller.addDVD("Ted", 6846841, true, "AVAILABLE");
        controller.addDVD("Forrest Gump", 3126845, false, "AVAILABLE");
        controller.addDVD("Forrest Gump", 9561155, false, "AVAILABLE");
        controller.addDVD("That One Movie", 1234567, false, "AVAILABLE");
        controller.addDVD("That Other Movie", 2486842, false, "AVAILABLE");
        controller.addDVD("1984", 1000001, false, "AVAILABLE");
        controller.addDVD("1.8", 2225554, false, "AVAILABLE");
        controller.addDVD("2008", 5475685, true, "AVAILABLE");
        controller.addDVD("Another One", 7884545, false, "AVAILABLE");
        controller.addDVD("3.6", 7798451, false, "AVAILABLE");
        
        //Adding Actors
        controller.addActor("Ted", "Mark Wallberg", "MALE");
        controller.addActor("Ted", "Mila Kunis", "FEMALE");
        controller.addActor("Forrest Gump", "Tom Hanks", "MALE");
        controller.addActor("Forrest Gump", "That Other Actor", "FEMALE");
        controller.addActor("That One Movie", "Some Women", "FEMALE");
        controller.addActor("That Other Movie", "Some Man", "MALE");
        controller.addActor("1984", "Old Man Rivers", "MALE");
        controller.addActor("1.8", "Daisy Ridley", "FEMALE");
        controller.addActor("2008", "Some Guy", "MALE");
        controller.addActor("Another One", "Another Women", "FEMALE");
        controller.addActor("3.6", "Mr. T", "MALE");
        
        //Adding Rentals
        controller.addRental(GregorianCalendar.getInstance(Locale.US), GregorianCalendar.getInstance(Locale.US), "Bender Bending Rodriguez", "Ted", "CASH");
        controller.addRental(GregorianCalendar.getInstance(Locale.US), GregorianCalendar.getInstance(Locale.US), "Charles Thompson", "That One Movie", "CREDIT");
        controller.addRental(GregorianCalendar.getInstance(Locale.US), GregorianCalendar.getInstance(Locale.US), "Brandon Buckalew", "Another One", "CREDIT");
        controller.addRental(GregorianCalendar.getInstance(Locale.US), GregorianCalendar.getInstance(Locale.US), "Phillip J. Fry", "Forrest Gump", "CASH");
        controller.addRental(GregorianCalendar.getInstance(Locale.US), GregorianCalendar.getInstance(Locale.US), "Katrina Flynn", "That Other Movie", "CASH");
        
        //Adding Requests - Movie is already rented out
        controller.addRental(GregorianCalendar.getInstance(Locale.US), GregorianCalendar.getInstance(Locale.US), "Phillip J. Fry", "Another One", "CASH");
        
        //Initial Print List
        controller.printLists();
        
        //Remove Actor
        controller.removeActor("Mark Wallberg", "Ted");
        
        //Remove DVD
        controller.removeDVD("Ted", 6846841);
        
        //Remove Customer
        controller.removeCustomer("BrandonBuckalew@gmail.com");
        
        //Remove Movie
        controller.removeMovie("Star Wars: The Force Awakens");
        
        //Remove Keyword
        controller.changeKeyword("LOL 1984", "");
        
        //Returning Rentals
        controller.returnRental("Bender Bending Rodriguez", 5654684, "CASH");
        controller.returnRental("Charles Thompson", 1234567, "CASH");
        controller.returnRental("Phillip J. Fry", 3126845, "CREDIT");
        controller.returnRental("Brandon Buckalew", 7884545, "CASH");
        
        //Removing from Request and adding to Rentals
        controller.requestAnswered("Phillip J. Fry", "Another One", "CASH");
        
        //Print list after things were removed
        controller.printLists();
        
        //Adding Reviews
        controller.addReview("Ted", "Bender Bending Rodriguez", 4.8, "A bear that came to life and is a terrible influence on the main character, what isnt there to like.");
        controller.addReview("That One Movie", "Charles Thompson", 1.2, "Almost as bad as That Other Movie.");
        controller.addReview("Some Movie Nobody Has Herd Of", "Phillip J. Fry", 2.1, "So bad I forgot what it was even called.");
        controller.addReview("1999 I Don't Know Something Awful", "Brandon Buckalew", 8.2, "Surprisingly good.");
    }
}
