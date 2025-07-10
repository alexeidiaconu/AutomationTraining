package org.alexeidiaconu.library;

public class Book {
    private int bookId;
    private String author;
    private String title;
//Constructor
    public Book(String author, String title) {
        this.bookId = 0;
        this.author = author;
        this.title = title;
    }
//Setter
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

//Getter


    public int getBookId() {
        return bookId;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }
}

