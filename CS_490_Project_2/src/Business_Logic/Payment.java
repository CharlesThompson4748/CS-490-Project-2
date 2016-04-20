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
public class Payment {
    //Payment method enum
    public enum Method {CASH, CREADIT};
    
    //Class variables
    private int amount;
    private Method paymentMethod;
    private Calendar paymentDate;
    
    //Class constructor
    public Payment (int amount, Method payMethod, Calendar date){
        this.amount = amount;
        this.paymentMethod = payMethod;
        this.paymentDate = date;
    }
    
    public boolean processPayment (int amount, Method type) {
        return true;
    }   
}
