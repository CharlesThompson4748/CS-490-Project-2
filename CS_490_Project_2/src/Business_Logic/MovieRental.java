/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business_Logic;

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
        
        controller.addCustomer("Bender@gmail.com", "Bender Bending Rodriguez", "1800 King Dr.", "470-010-0100", "BenderIsGreat");
        controller.addCustomer("DeliveryBoy@gmail.com", "Phillip J. Fry", "2999 Future Ln.", "001-231-2000", "Leila");
        controller.addCustomer("ShellCity@gmail.com", "John A. Zoidberg", "200 DumbsterOutBack Rd.", "158-0245-9752", "Awww");
        controller.addCustomer("CharlesThompson@gmail.com", "Charles Thompson", "1234 Road Dr.", "123-456-7890", "HaHaHaHa");
        controller.addCustomer("KatrinaFlynn@gmail.com", "Katrina Flynn", "5678 Drive Rd.", "987-654-3210", "KatFlynn");
        controller.addCustomer("BrandonBuckalew@gmail.com", "Brandon Buckalew", "5780 Main St.", "785-123-7802", "Brandon");
        
        controller.addMovie(3.2, 2006, "That One Movie");
        controller.addMovie(1.2, 2010, "That Other Movie");
        controller.addMovie(4.0, 2013, "Ted");
        controller.addMovie(5.0, 2001, "Forest Gump");
        controller.addMovie(4.2, 2008, "Some Movie Nobody Has Heard Of");
        controller.addMovie(2.3, 2003, "Another One");
        controller.addMovie(3.6, 1999, "1999 I Don't Know Something Awefull");
        controller.addMovie(4.1, 1984, "LOL 1984");
        controller.addMovie(1.8, 2015, "Star Wars: The Force Awakens");
        
        controller.addDVD("Ted", 5654684, false);
        controller.addDVD("Ted", 6846841, true);
        controller.addDVD("Forest Gump", 3126845, false);
        controller.addDVD("Forest Gump", 9561155, false);
        controller.addDVD("That One Movie", 1234567, false);
        controller.addDVD("That Other Movie", 2486842, false);
        controller.addDVD("1984", 0000001, false);
        controller.addDVD("1.8", 2225554, false);
        controller.addDVD("2008", 5475685, true);
        controller.addDVD("Another One", 7884545, false);
        controller.addDVD("3.6", 7798451, false);
        
        controller.addActor("Ted", "Mark Wallberg", "MALE");
        controller.addActor("Ted", "Mila Kunis", "FEMALE");
        controller.addActor("Forest Gump", "Tom Hanks", "MALE");
        controller.addActor("Forest Gump", "That Other Actor", "FEMALE");
        controller.addActor("That One Movie", "Some Women", "FEMALE");
        controller.addActor("That Other Movie", "Some Man", "MALE");
        controller.addActor("1984", "Old Man Rivers", "MALE");
        controller.addActor("1.8", "Daisy Ridley", "FEMALE");
        controller.addActor("2008", "Some Guy", "MALE");
        controller.addActor("Another One", "Another Women", "FEMALE");
        controller.addActor("3.6", "Mr. T", "MALE");
        
        controller.addRental(GregorianCalendar.getInstance(Locale.US), GregorianCalendar.getInstance(Locale.US), "RENTED");
        controller.addRental(GregorianCalendar.getInstance(Locale.US), GregorianCalendar.getInstance(Locale.US), "AVAILABLE");
        controller.addRental(GregorianCalendar.getInstance(Locale.US), GregorianCalendar.getInstance(Locale.US), "AVAILABLE");
        controller.addRental(GregorianCalendar.getInstance(Locale.US), GregorianCalendar.getInstance(Locale.US), "AVAILABLE");
        controller.addRental(GregorianCalendar.getInstance(Locale.US), GregorianCalendar.getInstance(Locale.US), "RENTED");
        
    }
}
