/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business_Logic;

import java.util.Calendar;
import java.util.Random;

/**
 *
 * @author charlie
 */
public class Payment {
    //Payment method enum
    public enum Method {CASH, CREDIT};
    
    //Class variables
    private double amount;
    private Method paymentMethod;
    private Calendar paymentDate;
    
    //Class constructor
    public Payment (double amount, String payMethod, Calendar date){
        this.amount = amount;
        this.paymentDate = date;
        getPaymentMethod(payMethod);
    }

    //Class getters
    public Method getPaymentMethod(String methodType) {
        switch(methodType){
        case"CASH":
            paymentMethod = Method.CASH;
            break;
        case"CREDIT":
            paymentMethod = Method.CREDIT;
            break;
        default:
            paymentMethod = Method.CREDIT;
            break;
        }
        return paymentMethod;
    }
    
    //Function to calculate late fee
    public double lateFee (int lateDays){
        return lateDays*.10;
    }
    
    //Function to process payment
    //Input: Amount and payment type
    //Output: boolean
    public boolean processPayment (int amount, Method type) {
        if(type == Method.CASH){
            System.out.println("Payment Processed");
            return true;
        }
        else if(type == Method.CREDIT){
            Random random = new Random();
            int i = random.nextInt(1);
            if(i == 0){
                System.out.println("Payment Processed");
                return true;
            }
            else {
                System.out.println("Payment Declined");
                return false;
            }
        }
        return false;
    }   
}
