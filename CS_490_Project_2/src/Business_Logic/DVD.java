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
    private Status status;
    
    //Class constructor
    public DVD(int SN, boolean Lost, Status status) {
        this.serialNo = SN;
        this.lost = Lost;
        this.status = status;
    }
    
    //Class Getters
    public int getSerialNo() {
        return serialNo;
    }
    
    public Status getStatus() {
        return status;
    }

    //Class Setters
    public boolean isLost() {
        return lost;
    }

    public void setStatus(Status status){
        this.status = status;
    }
    
    public void setLost(boolean lost) {
        this.lost = lost;
    }
    
    public String info() {
        return "SerialNo: " + serialNo + 
                "\nLost: " + lost;
    }
}
