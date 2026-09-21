/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sfu.lab1.archive;

import ca.sfu.lab1.Book;

/**
 *
 * @author amin
 */

// A rare book: it can be read in the reading room but never leaves the library. 
public class RareBook extends Book {

    private final int loanPeriodDays = 0;

    public RareBook(String id, String title, int year, String author) {
        super(id, title, year, author);
    }

    @Override
    public int getLoanPeriodDays() { 
        return loanPeriodDays;  
    }

    // The card shown beside the book in its display case, e.g. "First Folio (1623)". 
    public String exhibitLabel() {
        return title + " (" + super.getYear() + ")";   
    }

    @Override
    public String toString() {
        return super.toString() + "  [RARE: reading room only]";
    }
}
