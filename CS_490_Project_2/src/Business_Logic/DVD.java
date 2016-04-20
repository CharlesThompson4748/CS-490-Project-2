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
public class DVD {
    //Class Variables
    private int serialNo;
    private boolean lost;
    
    //Class constructor
    public DVD(int SN, boolean Lost) {
        this.serialNo = SN;
        this.lost = Lost;
    }

    //Class Getters
    public int getSerialNo() {
        return serialNo;
    }

    //Class Setters
    public boolean isLost() {
        return lost;
    }

    public void setLost(boolean lost) {
        this.lost = lost;
    }
    
    
}
