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
public class Actor {
    public enum Gender {MALE, FEMALE};
    private String name;
    private Gender gender;
    
    public Actor (String Name, Gender gend) {
        this.name = Name;
        this.gender = gend;
    }
}
