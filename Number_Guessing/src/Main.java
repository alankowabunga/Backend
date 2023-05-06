import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Game Start! Enter 4 integer numbers:");


        String computerGuess = "";
        for (int i = 0; i < 4; i++) computerGuess += (int) (Math.random() * 10); //電腦自行產生4位數的亂數

        //System.out.println("random: "+computerGuess);
        while (true) {
            int A = 0, B = 0, C = 0;
            boolean check[] = new boolean[4]; //紀錄每個位數是否檢查過，4 代表陣列的長度
            Arrays.fill(check, false);    // Arrays.fill(陣列名稱，要補滿的值)
            // -> just a fancy way of saying: boolean[] check={false,false,false,false}
            String guess = sc.next(); //使用者輸入數字

            //檢查有幾A
            for (int i = 0; i < 4; i++) {
                if (computerGuess.charAt(i) == guess.charAt(i)) {
                    A++;
                    check[i] = true;
                }
            }
            //檢查有幾B
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (!check[j] && computerGuess.charAt(j) == guess.charAt(i)) {
                        B++;
                        check[j] = true;
                        break;
                    }
                }
            }
            //計算 c
            Map<Character,Integer> charCount = new HashMap<>();

            char[] charGuess = computerGuess.toCharArray();
            for(char ch:charGuess){
                if(!charCount.containsKey(ch)){
                    charCount.put(ch,1);
                }else{
                    charCount.put(ch,charCount.get(ch)+1);
                }
            }
            
            for(int i:charCount.values()){
                if(i>1){
                    C++;
                }
            }
            //Output
            System.out.println("答案為: " + computerGuess);
            if (A == 4) {
                System.out.println("Correct");
                break;
            } else {
                System.out.println(A + "A" + B + "B" + C + "C");
            }
        }

    }
}