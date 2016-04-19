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
public class Customer {
    private String email;
    private String name;
    private String address;
    private String phoneNum;
    private String password;
    
    public Customer (String Email, String Name, String Address, String PhoneNum, String Password) {
        this.email = Email;
        this.name = Name;
        this.address = Address;
        this.phoneNum = PhoneNum;
        this.password = Password;
    }
}
