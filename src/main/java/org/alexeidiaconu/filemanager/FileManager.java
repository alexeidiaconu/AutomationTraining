package org.alexeidiaconu.filemanager;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FileManager {
    private File fileObject;
    public static String fileLocation = "C:\\Users\\alexdiaconu\\Desktop\\INVESTIGATION\\Files";
    private String fileName;

// Constructor
    public FileManager(File fileName) {

        this.fileObject = fileName;
        this.fileName = fileName.getName();
    }

//Getters
    public String getFileName() {
        return fileName;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public File getFileObject() {
        return fileObject;
    }

    public static File createFileOnTheDisk() throws IOException {

        Scanner keyboard = new Scanner(System.in);
        System.out.print(("Input the File Name: "));
        String fileName = keyboard.nextLine();

        File newFile = new File(FileManager.fileLocation + "\\" + fileName);
        //FileManager newFile  = new FileManager(fileName);

        if(newFile.exists()) {
            System.out.println("The File is already created");
        } else {
            newFile.createNewFile();

            if(newFile.exists()) {
                System.out.println("The file " + newFile.getName() + " is successfully created in " + newFile.getAbsolutePath());
                return newFile;
            }
        }

        return null;
    }


    public static void deleteFileFromTheDisk(File fileName) throws IOException {
        if (fileName.exists()) {
            fileName.delete();

            if (!fileName.exists()) {
                System.out.println("The file was deleted successfully");
            }
        } else {
            System.out.println("The File was not found on the Disk");
        }
    }


}
