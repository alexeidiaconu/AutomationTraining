package org.alexeidiaconu.library;

import java.util.HashMap;
import java.util.Map;

public class Library {

    private String libraryName;
    private Map<Integer,Book> library;

    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.library = new HashMap<>();
    }

    public String getLibraryName() {
        return libraryName;
    }

    //Setter
    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public Book addBook (String author, String title) {
        Book newBook = new Book(author,title);
        newBook.setBookId(this.library.size() + 1);
        this.library.put(newBook.getBookId(), newBook);
        return newBook;
    }

    public void printAllTheBooks() {
        for(Book currentBook : this.library.values()) {

            System.out.println("-----------------");
            System.out.println("BookId: " + currentBook.getBookId() + " Book Author: " + currentBook.getAuthor() + " BookTitle: " + currentBook.getTitle());
            System.out.println("-----------------");
        }
    }
}
