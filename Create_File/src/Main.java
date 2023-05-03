//IOException 一定要導入

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
// Create File
        try {
            File fileObj = new File("fileTest.txt");
            if (fileObj.createNewFile()) {
                System.out.println("File created: " + fileObj.getName());
                System.out.println(fileObj.getCanonicalFile());
            } else {
                System.out.println("File already exists.");
                System.out.println(fileObj.getCanonicalFile());
            }

        } catch (IOException e) {
            System.out.println("Error occurred.");
            e.printStackTrace();
        }
// Write to  File: use the FileWriter class together with its write() method，at the end close it with the close() method
        try {

            FileWriter myWritter = new FileWriter("fileTest.txt");
            myWritter.write("I used FileWriter Class's write() method to write this sentence");
            myWritter.close();
            System.out.println("Successfully wrote to the file.");

        } catch (IOException e) {
            System.out.println("Error occurred.");
            e.printStackTrace();
        }
    }
}