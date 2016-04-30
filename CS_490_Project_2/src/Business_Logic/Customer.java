/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business_Logic;

import java.util.LinkedList;

/**
 *
 * @author charlie
 */
public class Customer implements Searchable{
    //Class variables
    private String email;
    private String name;
    private String address;
    private String phoneNum;
    private String password;
    
    //Class lists
    private LinkedList<Review> reviews = new LinkedList<>();
    
    //Class constructor
    public Customer (String Email, String Name, String Address, String PhoneNum, String Password) {
        this.email = Email;
        this.name = Name;
        this.address = Address;
        this.phoneNum = PhoneNum;
        this.password = Password;
    }

    //Class getters
    public String getName() {
        return name;
    }
    
    public String getEmail() {
        return email;
    }
    
    //Overriden interface function to find matches for searches of Customer objects
    //Input: String search key
    //Output: Boolean 
    @Override
    public boolean contains(String key){
        if(email.trim().toUpperCase().contains(key.trim().toUpperCase()))
            return true;
        else if(name.trim().toUpperCase().contains(key.trim().toUpperCase()))
            return true;
        else if(address.trim().toUpperCase().contains(key.trim().toUpperCase()))
            return true;
        else if(phoneNum.trim().toUpperCase().contains(key.trim().toUpperCase()))
            return true;
        else 
            return false;
    }
    
    //For testing
    @Override
    public String info() {
        return "\nEmail: " + email + 
                "\nName: " + name + 
                "\nAddress: " + address + 
                "\nPhone Number: " + phoneNum + 
                "\nPassword: " + password;
    }
    
}
