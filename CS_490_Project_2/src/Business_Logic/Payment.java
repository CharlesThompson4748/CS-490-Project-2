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
public class Payment {
    //Payment method enum
    public enum Method {CASH, CREADIT};
    
    //Class variables
    private int amount;
    private Method paymentMethod;
    
    //Class constructor
    public Payment (int amount, Method payMethod){
        this.amount = amount;
        this.paymentMethod = payMethod;
    }
    
}
