// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        String answer = "";
        for (int i = 0; i < 4; i++) {
            int intNum = (int) (Math.random() * 10);
            String strNum = String.valueOf(intNum);
            answer += strNum;
        }
    }
}