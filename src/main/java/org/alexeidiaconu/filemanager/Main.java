package org.alexeidiaconu.filemanager;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File newFile = null;
        FileManager createdFile = null;

        try{

            if ((newFile = FileManager.createFileOnTheDisk()) != null) {

                createdFile =  new FileManager(newFile);
            }
        } catch (IOException ex){
            System.out.println("File creation error: " + ex.getMessage());
        }

        System.out.print("Do you want to delete any file y/n :");

        Scanner keyboard = new Scanner(System.in);
        String inputOption = keyboard.nextLine();

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
