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
public class Request {
    //Class variables
    private Status status;
    public Type type;
    private Calendar requestDate;
    private Calendar responseDate;
    private Customer customer;
    private Movie movie;
    
    //Class constructor
    public Request (Calendar reqDate, Calendar resDate, Status status, Customer customer, Movie movie) {
        this.requestDate = reqDate;
        this.responseDate = resDate;
        this.status = status;
        this.customer = customer;
        this.movie = movie;
    }
}
