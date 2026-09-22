package ca.sfu.lab1;


import ca.sfu.lab1.LibraryItem;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

// A book. Members can borrow it for `LOAN_PERIOD_DAYS` days or put it on hold. 
public class Book extends LibraryItem implements Reservable {

    private final int loanPeriodDays = 21;
    private final String author;

    public Book(String id, String title, int year, String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public int getLoanPeriodDays() {
        return loanPeriodDays;
    }

    @Override
    public String reservationLabel() {
        return "Book " + getId() + " \"" + title + "\"";
    }

    @Override
    public String toString() {
        return super.toString() + "  by " + author;
    }
}
