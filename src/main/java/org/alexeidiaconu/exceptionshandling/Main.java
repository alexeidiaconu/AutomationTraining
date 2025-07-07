package org.alexeidiaconu.exceptionshandling;

public class Main {
    public static void main(String[] args) {
String text = RandomString.generateString();

    try{
        RandomString.printStringAndLength(text);

        } catch (NullPointerException ex) {

            System.out.println("Empty String was generated: " + ex.getMessage());

        } finally {

            System.out.println("Executed successfully");

        }

    }
}
