import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        String computerGuess="";
        for(int i=0;i<4;i++){
            computerGuess+=(int)(Math.random()*10); //電腦自行產生4位數的亂數
        }

        System.out.println("random: "+computerGuess);

        //computerGuess -> 答案 、 guess -> 使用者猜測
        while(true){
            int A=0,B=0,C=0;
            // 下面兩行創造鎮業的方式只是 fancy way of creating: boolean[] check ={false,false,false,false}
            boolean check[]=new boolean[4]; //紀錄每個位數是否檢查過
            Arrays.fill(check, false);
            String guess=sc.next(); //將使用者的 input 放入變數 guess(字串型態)


            //檢查有幾A : 索引值相同代表正對
            for(int i=0;i<4;i++){
                if(computerGuess.charAt(i)==guess.charAt(i)){
                    A++;
                    check[i]=true;
                }
            }
            //檢查有幾B: 已排除 '正對情況'，只會檢查 check 陣列中' false '的位置
            // !check[j] 代表只有當 check[j] 為 false 才會執行，因為條件式用 ! 將 false 轉 true 才執行程式碼
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    if(!check[j] && computerGuess.charAt(j)==guess.charAt(i)){
                        B++;
                        check[j]=true;
                        break;
                    }
                }
            }

            ///檢查有幾C:
            //    宣告
            Map<Character,Integer> charCount = new HashMap<>();

            char[] answerArray = computerGuess.toCharArray();
            for(char c : answerArray){
                if(!charCount.containsKey(c)){
                    charCount.put(c,1);
                }else{
                    charCount.put(c,charCount.get(c)+1);
                }
            }
            for(int i: charCount.values()){
                if(i>1){
                    C++;
                }
            }

            //Output
            if(A==4){
                System.out.println("Correct");
                break;
            }
            else{
                System.out.println(A+"A"+B+"B"+C+"C");
            }
        }

    }
}