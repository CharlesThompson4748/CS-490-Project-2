/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business_Logic;

import java.util.Calendar;

/**
 *
 * @author charlie
 */
public class Rental {
    private Calendar rentalDate;
    private Calendar returnDate;
    private Status status;
    
    public Rental (Calendar RentDate, Calendar ReturnDate, Status status){
        this.rentalDate = RentDate;
        this.returnDate = ReturnDate;
        this.status = status;
    }
}
