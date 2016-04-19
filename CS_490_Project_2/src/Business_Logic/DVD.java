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
    private int serialNo;
    private boolean lost;
    
    public DVD(int SN, boolean Lost) {
        this.serialNo = SN;
        this.lost = Lost;
    }
}
