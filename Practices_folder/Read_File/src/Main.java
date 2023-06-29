import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            File fileObj = new File("C:\\Users\\User\\IdeaProjects\\Create_File\\fileTest.txt");

            Scanner myReader = new Scanner(fileObj);

            while (myReader.hasNextLine()) {
                String content = myReader.nextLine();
                System.out.println(content);
            }
        // get more information about a file
            if (fileObj.exists()) {
                System.out.println("File name: " + fileObj.getName());
                System.out.println("Absolute path: " + fileObj.getAbsolutePath());
                System.out.println("Writeable: " + fileObj.canWrite());
                System.out.println("Readable " + fileObj.canRead());
                System.out.println("File size in bytes " + fileObj.length());
            } else {
                System.out.println("The file does not exist.");
            }
            myReader.close();

        } catch (IOException e) {
            System.out.println("Error occurred.");
            e.printStackTrace();
        }


    }
}