/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sfu.lab1;

/**
 *
 * @author amin
 */
import java.util.ArrayList;
import java.util.Scanner;
import ca.sfu.lab1.archive.RareBook;

// The console menu. Run this class. 
public class Lab1 {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        Library library = makeSampleLibrary();
        boolean running = true;

        while (running) {
            printMenu();
            int choice = readInt(in, "Choice: ");
            switch (choice) {
                case 1 -> printItems("By ID:", library.sortedById());
                case 2 -> printItems("By year, then title:", library.sortedByYear());
                case 3 -> addBook(in, library);
                case 4 -> findTitle(in, library);
                case 5 -> System.out.println("Publication years: " + library.distinctYears());
                case 6 -> printReservationDesk(library);
                case 0 -> running = false;
                default -> System.out.println("There is no option " + choice + ".");
            }
        }
        System.out.println("Goodbye!");
    }

    // The starting catalog. SelfCheck uses it too, so please don't change it.
    static Library makeSampleLibrary() {
        Library lib = new Library();
        lib.add(new Book("B-310", "Dune", 1965, "Frank Herbert"));
        lib.add(new DVD("D-120", "Spirited Away", 2001, 125));
        lib.add(new Book("B-105", "Clean Code", 2008, "Robert C. Martin"));
        lib.add(new RareBook("R-001", "First Folio", 1623, "William Shakespeare"));
        lib.add(new Book("B-220", "Hidden Figures", 2016, "Margot Lee Shetterly"));
        lib.add(new DVD("D-045", "Arrival", 2016, 116));
        lib.add(new Book("B-150", "Effective Java", 2018, "Joshua Bloch"));
        lib.addRoom(new StudyRoom(3, 6));
        lib.addRoom(new StudyRoom(7, 2));
        return lib;
    }

    static void printMenu() {
        System.out.println();
        System.out.println("===== Campus Library =====");
        System.out.println("1) List items by ID");
        System.out.println("2) List items by year");
        System.out.println("3) Add a book");
        System.out.println("4) Find a title");
        System.out.println("5) Show publication years");
        System.out.println("6) Reservation desk");
        System.out.println("0) Quit");
    }

    // Reads a whole number.
    static int readInt(Scanner in, String prompt) {
        System.out.print(prompt);
        while (!in.hasNextInt()) {
            String bad = in.nextLine();
            System.out.print("\"" + bad.trim() + "\" is not a whole number. " + prompt);
        }
        int value = in.nextInt();
        in.nextLine(); // consume the rest of the line (the trailing newline)
        return value;
    }

    static void addBook(Scanner in, Library library) {
        System.out.print("ID (e.g. B-400): ");
        String id = in.nextLine();
        System.out.print("Title: ");
        String title = in.nextLine();
        System.out.print("Author: ");
        String author = in.nextLine();
        int year = readInt(in, "Year: ");
        try {
            Book book = new Book(id, title, year, author);
            if (library.add(book)) {
                System.out.println("Added: " + book);
            } else {
                System.out.println("Not added: the catalog already has an item with ID " + book.getId() + ".");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Not added: " + e.getMessage());
        }
    }

    static void findTitle(Scanner in, Library library) {
        System.out.print("Exact title: ");
        String title = in.nextLine().trim();
        LibraryItem found = library.findByTitle(title);
        System.out.println(found == null ? "No item has that title." : "Found: " + found);
    }

    static void printItems(String heading, ArrayList<LibraryItem> items) {
        System.out.println(heading);
        for (LibraryItem item : items) {
            System.out.println("  " + item);
        }
    }

    static void printReservationDesk(Library library) {
        System.out.println("Things you can reserve:");
        for (Reservable r : library.reservables()) {
            System.out.println("  " + r.reservationLabel());
            System.out.printf("  %-30s no-show fee: $%.2f%n", r.reservationLabel(), r.noShowFee());
        }
    }
}