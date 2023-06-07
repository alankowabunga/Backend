import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String str ="123456";
        char[] list = str.toCharArray();
        for(char i: list){
            System.out.println(i);
        }

        System.out.println("---------------Lambda Expression-------------");
//        char 陣列沒有提供 forEach() 方法，無法像 Collection 集合使用 lambda expression 的 forEach()
//        因此如果要使用的話，可以轉換為 Character 集合
        List<Character> charList = new ArrayList<>();
        for(char c:list){  // list char[]沒辦法像集合，使用 Lambda Expression
            charList.add(c); // 將 list 的值都給 charList
        }

        charList.forEach(s ->System.out.println(s));
    }
}