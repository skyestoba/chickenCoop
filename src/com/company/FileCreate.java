package com.company;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.File;
import java.io.FileWriter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;

public class FileCreate {
    LocalDate today;
    String name;

    public FileCreate(LocalDate today, String name) {
        this.today = today;
        this.name = name;
    }

    //Creates a file for a particular chicken
    public void createFile() throws IOException {
        String fileName = name + ".txt";
        File file = new File(fileName);
        if (file.createNewFile()) {
            System.out.println("File created.");
        } else {
            System.out.println("File already exists.");
        }
    }

    //Writes to the file for the first time
    public static String writeToFile(String message) throws IOException {
        Path path = Paths.get(message);
        byte[] b = {};

        try {
            b = Files.readAllBytes(path);

        } catch (IOException e) {
            e.printStackTrace();
        }
        String contents = new String(b);
        return contents;
    }
    //Adds additional text to the file
    public void finalWrite(String fileName, String already, String mes){
        try{
            FileWriter myWrite = new FileWriter(fileName+ ".txt");
            BufferedWriter buf = new BufferedWriter(myWrite);
            buf.write(already+"\n"+mes);
            buf.newLine();
            buf.close();
            System.out.println("Wrote to file");
        }
        catch(IOException e){
            System.out.println("an error occured");
            e.printStackTrace();
        }
    }
}
