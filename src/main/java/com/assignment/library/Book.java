package com.assignment.library;

public class Book {

    private String title;
    private boolean borrowed;

    // Creates a new Book
    public Book(String bookTitle) {
        // Implement this method
        this.title = bookTitle;
    }

    // Marks the book as rented
    public void borrowed() {
        // Implement this method
        this.borrowed = true;
    }

    // Marks the book as not rented
    public void returned() {
        // Implement this method
        this.borrowed = false;
    }

    // Returns true if the book is rented, false otherwise
    public boolean isBorrowed() {
        // Implement this method
        return this.borrowed;
    }

    // Returns the title of the book
    public String getTitle() {
        // Implement this method
        return this.title;
    }

    public void rented() {
        borrowed();
    }

    public static void main(String[] arguments) {
        // Small test of the Book class
        Book example = new Book("Java How To Program (Early Objects))");
        System.out.println("Title (should be Java How To Program (Early Objects))): " + example.getTitle());
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
        example.rented();
        System.out.println("Borrowed? (should be true): " + example.isBorrowed());
        example.returned();
        System.out.println("Borrowed? (should be false): " + example.isBorrowed());
    }
}
