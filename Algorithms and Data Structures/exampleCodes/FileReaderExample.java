package com.example.packages.exampleCodes;

import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

public class FileReaderExample {
    static Scanner scanner = new Scanner(System.in);
    static String line;
    public static void main(String[] args) {
        //System.out.print( "Enter the filename: " );   // Prompt the user for a file name
        //String fileName = scanner.nextLine();         // get a file name from the user
        File file = new File("C:\\Users\\Aзат\\IdeaProjects\\exercises\\src\\com\\example\\packages\\exampleCodes\\numbers.txt");             // create a File object

        if ( file.exists() ){                                             // before trying to create a
            // Scanner to read the file
            // Create a Scanner from the file.
            // This statement can cause a FileNotFoundException.
            Scanner inFile = null;
            try {
                inFile = new Scanner( file );
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            // For each line in the file, read in the line and display it with the line number
            int lineNum = 0;

            // Use the results of calling the hasNext method to
            // determine if you are at the end of the file before
            // reading the next line of the file.
            while ( inFile.hasNext() )
            {
                line = inFile.nextLine();   // read the next line

                // Output the line read to the screen for the user
                System.out.println( ++lineNum + ": " + line );
            }

            // When we're done reading the file,
            // close the Scanner object attached to the file
            inFile.close();
        } else {
            System.out.println("file not found");
        }
    }
}
