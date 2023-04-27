import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> NumList = new ArrayList<Integer>();
        for(int i = 0 ; i<=9 ; i++){
            NumList.add(i);
        }

        String nonRepeatAnswer = "";
        Random rand = new Random();
        for(int j = 0;j<4;j++){

            int index = rand.nextInt(NumList.size()); //取得隨機整數，區間由陣列字串的長度決定，因為每次迭代的長度會變化
            int n = NumList.get(index);
            String ch = Integer.toString(n);
            nonRepeatAnswer += ch;

            NumList.remove(index);
            // 利用隨機索引值 取得數字後將其刪除，避免取得同樣的數字
        }
        System.out.println(nonRepeatAnswer);
    }
}