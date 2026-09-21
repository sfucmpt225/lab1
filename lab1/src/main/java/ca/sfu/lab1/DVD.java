package ca.sfu.lab1;


import ca.sfu.lab1.LibraryItem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author amin
 */
// A DVD. Loaned for `LOAN_PERIOD_DAYS days`; DVDs are walk-in only, so they can't be put on hold.
public class DVD extends LibraryItem {
    
    private final int loanPeriodDays = 7;
    private final int minutes;

    public DVD(String id, String title, int year, int minutes) {
        super(id, title, year);    
    }

    @Override
    public int getLoanPeriodDays() {
        return loanPeriodDays;
    }

    @Override
    public String toString() {
        return super.toString() + "  " + minutes + " min";
    }
}
