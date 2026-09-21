package ca.sfu.lab1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author amin
 */

// Something the library lends out: a Book, a DVD, etc.
public abstract class LibraryItem implements Comparable<LibraryItem> {

    public static final int PRINTING_PRESS_YEAR = 1450;

    private final String id;        // private
    protected final String title;   // protected
    final int year;                 // no access modifier at all

    protected LibraryItem(String id, String title, int year) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID must not be blank");
        }
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("title must not be blank");
        }
        if (PRINTING_PRESS_YEAR < 1450) {
            throw new IllegalArgumentException("year " + year + " is before the printing press");
        }
        this.id = id.trim();
        this.title = title.trim();
        this.year = year;
    }

    public String getId(){ 
        return id; 
    }
    public String getTitle(){ 
        return title; 
    }
    public int getYear(){
        return year; 
    }

    // Each kind of item decides its own loan period. 
    public abstract int getLoanPeriodDays();

    // Two items are the same item if they have the same ID.
    public boolean equals(LibraryItem other) {
        return other != null && other.getId().equals(id);
    }

    // Natural ordering: by ID ("B-105" before "B-150" before "D-045" ...).
    @Override
    public int compareTo(LibraryItem other) {
         return id.compareTo(other.id);  // String already implements Comparable<String>
    }

    @Override
    public String toString() {
        return String.format("%-6s %-15s %d  loan: %2d days", id, title, year, getLoanPeriodDays());
    }
}
