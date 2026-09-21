package ca.sfu.lab1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import ca.sfu.lab1.LibraryItem;
import java.util.Comparator;

/**
 *
 * @author amin
 */
// Orders items by publication year, oldest first; items from the same year go A-Z by title. 
public class ByYearThenTitle {

    @Override
    public int compare(LibraryItem a, LibraryItem b) {
        int byYear = Integer.compare(a.getYear(), b.getYear()); // oldest first
        if (byYear != 0) {
            return byYear;
        }
        return a.getTitle().compareTo(b.getTitle()); // same year: A-Z by title
    }
}
