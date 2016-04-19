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
    public enum Status {RENTED, AVAILABLE};
    public enum Type {};
    private Calendar requestDate;
    private Calendar responseDate;
    private Status status;
    private Type type;
    
    public Request (Calendar reqDate, Calendar resDate, Status status, Type type) {
        this.requestDate = reqDate;
        this.responseDate = resDate;
        this.status = status;
        this.type = type;
    }
}
