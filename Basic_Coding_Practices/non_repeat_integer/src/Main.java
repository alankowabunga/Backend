import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> NumList = new ArrayList<Integer>();
        for(int i = 0 ; i<=9 ; i++){
            NumList.add(i);
        }
        NumList.forEach(num -> System.out.println(num));
    }
}