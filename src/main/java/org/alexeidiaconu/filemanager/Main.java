package org.alexeidiaconu.filemanager;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File newFile = null;
        FileManager createdFile = null;

        try{

            newFile = FileManager.createFileOnTheDisk();
            createdFile =  new FileManager(newFile);

        } catch (IOException ex){
            System.out.println("File creation error: " + ex.getMessage());
        }

            createdFile.writeToFile();

        System.out.print("Do you want to print the file content? y/n :");
        Scanner keyboard = new Scanner(System.in);
        String inputOption = keyboard.nextLine();

        if (inputOption.equals("y")) {
            createdFile.printFileContent();
        }

        System.out.print("Do you want to delete any file y/n :");

        keyboard = new Scanner(System.in);
        inputOption = keyboard.nextLine();

        while (inputOption.equals("y")) {

            System.out.print(("Input the File Name: "));
            String fileName = FileManager.fileLocation + "\\" + keyboard.nextLine();

            File fileToDelete = new File(fileName);

            try {
                if (fileToDelete.exists()) {
                    FileManager.deleteFileFromTheDisk(fileToDelete);
                } else {
                    System.out.println("The specified file was not found on the disk!");
                }
            } catch (IOException ex) {
                System.out.println("Error on file deletion");
            }

            System.out.print("Do you want to delete any file y/n :");
            inputOption = keyboard.nextLine();
        }

    }
}
