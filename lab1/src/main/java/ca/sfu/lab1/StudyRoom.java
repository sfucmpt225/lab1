package ca.sfu.lab1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import ca.sfu.lab1.Reservable;

/**
 *
 * @author amin
 */
// A study room members can book. It never leaves the building and has no title or year.
public class StudyRoom implements Reservable {

    private final int number;
    private final int seats;
    private final double fee = 5.00;

    public StudyRoom(int number, int seats) {
        this.number = number;
        this.seats = seats;
    }

    @Override
    public String reservationLabel() {
        return "Study Room " + number + " (" + seats + " seats)";
    }
    
    // replaces the default version from Reservable
    @Override  
    public double noShowFee() {
        return fee;
    }
}