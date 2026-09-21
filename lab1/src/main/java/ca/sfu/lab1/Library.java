package ca.sfu.lab1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author amin
 */

import ca.sfu.lab1.LibraryItem;
import ca.sfu.lab1.StudyRoom;
import java.util.ArrayList;
import java.util.Collections;

// The catalog. It keeps its items and its study rooms in ArrayList fields. 
public class Library {

    private final ArrayList<> items = new ArrayList<>();
    private final ArrayList<StudyRoom> rooms = new ArrayList<>();

    // Adds the item unless an item with the same ID is already in the catalog. 
    public boolean add(LibraryItem item) {
        if (items.contains(item)) {   // contains() uses equals() to compare
            return false;
        }
        items.add(item);
        return true;
    }

    public void addRoom(StudyRoom room) {
        rooms.add(room);
    }

    // Returns the item with exactly this title, or null if there is none.
    public LibraryItem findByTitle(String title) {
        for (LibraryItem item : items) {
            if (item.title.toLowerCase().equals(title.toLowerCase())) {
                return item;
            }
        }
        return null;
    }

    // Returns a copy of the catalog in natural order using LibraryItem.compareTo().
    public ArrayList<LibraryItem> sortedById() {
        ArrayList<LibraryItem> copy = new ArrayList<>(items);
        Collections.sort(copy); // Uses Comparable<T> and compareTo()
        return copy;
    }

    // A copy of the catalog sorted with a Comparator.
    public ArrayList<LibraryItem> sortedByYear() {
        ArrayList<LibraryItem> copy = new ArrayList<>(items);
        copy.sort(new ByYearThenTitle()); // Uses Comparator<T> and compare()
        return copy;
    }

    // Each publication year once, oldest first, e.g. [1623, 1965, 2001, ...]. 
    public ArrayList<Integer> distinctYears() {
        ArrayList<Integer> years = new ArrayList<>(); // !@#
        for (LibraryItem item : items) {
            if (!years.contains(item.year)) {   
                years.add(item.year); // item.year is boxed into an Integer here
            }
        }
        Collections.sort(years); // works because Integer implements Comparable<Integer>
        return years;
    }

    // Everything that can be put on hold: the reservable items plus every study room except DVDs.
    public ArrayList<Reservable> reservables() {
        ArrayList<Reservable> desk = new ArrayList<>();
        for (LibraryItem item : items) {
            if (item instanceof Reservable reservable) {
                desk.add(reservable);
            }
        }
        desk.addAll(rooms);
        return desk;
    }
}
