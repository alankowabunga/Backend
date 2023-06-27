import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {


        LocalDate time = LocalDate.now();

        System.out.println(time); //2023-04-17

        // 把格式轉換成 yyyy/MM/dd 的字串型態
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd"); //建立物件
        String strTime = time.format(formatter);
        System.out.println(strTime); //2023/04/17

        //另一種字串格式
        DateTimeFormatter myFormatter = DateTimeFormatter.ofPattern("MMM-dd-yyyy");
        String myTime = time.format(myFormatter);
        System.out.println(myTime); //4月-17-2023

    }
}