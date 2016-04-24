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
public class Actor{
    //Class variables
    private String name;
    private Gender gender;
    
    //Class constructor
    public Actor (String Name, Gender gend) {
        this.name = Name;
        this.gender = gend;
    }
    
    //Class getters
    public String getName() {
        return name;
    }
    
    public String info(){
        return "Name: " + name;
    }
}
