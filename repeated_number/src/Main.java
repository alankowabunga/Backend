import java.util.HashMap;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        String answer="3894";

//    宣告
        Map<Character,Integer> charCount = new HashMap<>();

        char[] answerArray = answer.toCharArray();
        for(char c : answerArray){
            if(!charCount.containsKey(c)){
                charCount.put(c,1);
            }else{
                charCount.put(c,charCount.get(c)+1);
            }
        }
        int count=0;
        for(int i: charCount.values()){
            if(i>1){
                count++;
            }
        }
        System.out.println(count);
    }
}