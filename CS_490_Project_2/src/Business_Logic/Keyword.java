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
public class Keyword {
    //Class variables
    private String name;
    
    //Class constructor
    public Keyword (String Name) {
        this.name = Name;
    }
    //Class setters
    public void setKeyword(String name) {
        this.name = name;
    }
    
    //Class getters
    public String getKeyword() {
        return name;
    }
}
