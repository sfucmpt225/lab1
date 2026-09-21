/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ca.sfu.lab1;

/**
 *
 * @author amin
 */
// Anything a library member can put on hold.
public interface Reservable {

    // Short description shown at the reservation desk.
    String reservationLabel();

     // `default` gives every existing implementer this version
     // for free, so none of them break; a class that needs something else overrides it.
     double noShowFee() {
        return 0.00;
    } 
}
