package com.assignment.library;

import java.util.ArrayList;
import java.util.List;

public class Library {
    // Add the missing implementation to this class
    private String address;
    private List<Book> books;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    Library(String address) {
        super();
        books = new ArrayList<>();
        setAddress(address);
    }

    public void addBook(final Book book) {
        books.add(book);
    }

    public static void main(String[] args) {
        // Create two sections
        Library firstSection = new Library("300 College Park Dr.");
        Library secondSection = new Library("Ohio Link.");

        // Add four books to the first library
        firstSection.addBook(new Book("Java How To Program (Early Objects))"));
        firstSection.addBook(new Book("Rise of the Robots"));
        firstSection.addBook(new Book("Code Complete"));
        firstSection.addBook(new Book("The Pragmatic Programmer"));

        // Print opening hours and the addresses
        System.out.println("Library hours:");
        printOpeningHours();
        System.out.println();

        System.out.println("Library addresses:");
        firstSection.printAddress();
        secondSection.printAddress();
        System.out.println();

        // Try to borrow The Pragmatic Programmer from both sections
        System.out.println("Borrowing The Pragmatic Programmer:");
        firstSection.borrowBook("The Pragmatic Programmer");
        firstSection.borrowBook("The Pragmatic Programmer");
        secondSection.borrowBook("The Pragmatic Programmer");
        System.out.println();

        // Print the titles of all available books from both sections
        System.out.println("Books available in the first Section:");
        firstSection.printAvailableBooks();
        System.out.println();
        System.out.println("Books available in the second Section:");
        secondSection.printAvailableBooks();
        System.out.println();

        // Return The Pragmatic Programmer to the first section
        System.out.println("Returning The Pragmatic Programmer:");
        firstSection.returnBook("The Pragmatic Programmer");
        System.out.println();

        // Print the titles of available from the first Section
        System.out.println("Books available in the first section:");
        firstSection.printAvailableBooks();
    }

    private void returnBook(String bookName) {
        for (Book book : books) {
            if (book.getTitle().equals(bookName)) {
                book.returned();
                System.out.println("You successfully returned " + book.getTitle());
                break;
            }
        }
    }

    private void printAvailableBooks() {
        boolean completeEmpty = true;
        for (Book book : getBooks()) {
            if (!book.isBorrowed()) {
                completeEmpty = false;
                System.out.println(book.getTitle());
            }
        }
        if (completeEmpty) {
            System.out.println("No book in catalog");
        }
    }

    private void borrowBook(String bookName) {
        boolean found = false;
        for (Book book : getBooks()) {
            if (book.getTitle().equals(bookName)) {
                found = true;
                if (book.isBorrowed()) {
                    System.out.println("Sorry, this book is already borrowed.");
                } else {
                    book.borrowed();
                    System.out.println("You successfully borrowed "+ bookName);
                }
                break;
            }
        }
        if (!found) {
            System.out.println("Sorry, this book is not in our catalog.");
        }
    }

    private void printAddress() {
        System.out.println(getAddress());
    }

    private static void printOpeningHours() {
        System.out.println("Libraries are open daily from 9am to 5pm.");
    }
}
