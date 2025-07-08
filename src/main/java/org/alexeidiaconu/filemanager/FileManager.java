package org.alexeidiaconu.filemanager;
import java.io.*;
import java.util.Scanner;

public class FileManager {
    private final File fileObject;
    public static String fileLocation = "C:\\Users\\alexdiaconu\\Desktop\\INVESTIGATION\\Files";
    private final String fileName;

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
            }
        }

        return newFile;
    }


    public static boolean deleteFileFromTheDisk(File fileName) throws IOException {
        if (fileName.exists()) {
            fileName.delete();

            if (!fileName.exists()) {
                System.out.println("The file was deleted successfully");
                return true;
            }
        }

        System.out.println("The File was not found on the Disk");
        return false;
    }

    public void writeToFile()
    {
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;

        try{
            String filePath = this.getFileLocation() + "\\" + this.getFileName();
            fileWriter = new FileWriter(filePath,true);
            bufferedWriter = new BufferedWriter(fileWriter);
            String fileLine;

            System.out.print("Do you want to write a text line in the file " + this.getFileName() + " ? y/n: ");
            Scanner keyboard = new Scanner(System.in);
            fileLine = keyboard.nextLine();


            while (!fileLine.equals("Q")) {

                System.out.print("//>:");
                fileLine = keyboard.nextLine();
                if (!fileLine.equals("Q")) {
                    bufferedWriter.write(fileLine);
                    bufferedWriter.newLine();
                }

            }

        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (NullPointerException npe) {
            System.out.println("Unexpected end of file: " + npe.getMessage());
        } finally {

            try {
                if (bufferedWriter != null) {
                    bufferedWriter.close();
                }
                if (fileWriter != null) {
                    fileWriter.close();
                }
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }

        }

    }

    public void printFileContent() {
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;

        try {
            String filePath = this.getFileLocation() + "\\" + this.getFileName();
            fileReader = new FileReader(filePath);
            bufferedReader = new BufferedReader(fileReader);

            String fileLine;
            while ((fileLine = bufferedReader.readLine()) != null) {

                System.out.println(fileLine);
            }

        } catch (IOException ex) {
            System.out.println("File Reading Error: " + ex.getMessage());
        } finally {
            try {
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
            } catch (IOException ex1) {
                ex1.printStackTrace();
            }
        }


    }


}
