package org.alexeidiaconu.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManager {
    public List<Library> libraries;

    public LibraryManager() {
        this.libraries = new ArrayList<>();
    }

    public Library addLibrary(String libraryName) {

        Library newLibrary = new Library(libraryName);
        this.libraries.add(newLibrary);
        return newLibrary;
    }

    public void printLibraries() {
        for (int i = 0; i < this.libraries.size(); i++) {
            System.out.println("Library: " + this.libraries.get(i).getLibraryName());
        }
    }

    public Library getLibrary(String libraryName) {

       for (Library currentLibrary : this.libraries) {
           if (currentLibrary.getLibraryName().equals(libraryName)) {
               return currentLibrary;
           }
       }
        System.out.println("The specified library wasn't fount");
       return null;
    }

    public static void main(String[] args) {

        LibraryManager cityLibraries = new LibraryManager();
        Library newLibrary = null;
        String addNewlib = "y";
        Scanner keyboard;

        while (addNewlib.equals("y")) {


            System.out.print("Adding new Library. Please input the Library name :");
            keyboard = new Scanner(System.in);
            String libraryName = keyboard.nextLine();

            if ((newLibrary = cityLibraries.addLibrary(libraryName)) != null) {
                System.out.println("The Library " + newLibrary.getLibraryName() + " was successfully added");
            }
            System.out.print("Add a new Library? y/n : ");
            addNewlib = keyboard.nextLine();
            }
        cityLibraries.printLibraries();


        String addNewBook = "y";

        while (addNewBook.equals("y") ) {

            System.out.print("Adding new Books to the library. Please input the Library name :");
            keyboard = new Scanner(System.in);
            String libraryToAddBooks = keyboard.nextLine();

            int libraryIndex = cityLibraries.libraries.indexOf(cityLibraries.getLibrary(libraryToAddBooks));

            System.out.println("Library index: " + libraryIndex);

            System.out.print("Please input book author: ");
            String bookAuthor = keyboard.nextLine();

            System.out.print("Please input book title: ");
            String bookTitle = keyboard.nextLine();

            Book addedBook = cityLibraries.libraries.get(libraryIndex).addBook(bookAuthor,bookTitle);

            System.out.println("The book " + addedBook.getTitle() + " by " + addedBook.getAuthor() + " was successfully added to the  " + cityLibraries.libraries.get(libraryIndex).getLibraryName());

            System.out.print("Add a new book? y/n : ");
            addNewBook = keyboard.nextLine();

        }

        System.out.print("Do you want to print the books from any library? y/n : ");
        keyboard = new Scanner(System.in);
        String printTheBooksFromLib = keyboard.nextLine();

        while(printTheBooksFromLib.equals("y")) {

            System.out.print("Printing the Books from the library. Please input the Library name :");

            String libraryToPrintBooks = keyboard.nextLine();

            int libraryToPrintIndex = cityLibraries.libraries.indexOf(cityLibraries.getLibrary(libraryToPrintBooks));

            System.out.println("Index Of Library To Print: " + libraryToPrintIndex);

            if (libraryToPrintIndex != -1) {
                cityLibraries.libraries.get(libraryToPrintIndex).printAllTheBooks();
            } else {
                System.out.println("Wrong library Name");
            }
            System.out.print("Do you want to print the books from any other library? y/n : ");
            printTheBooksFromLib = keyboard.nextLine();
        }


    }
}
