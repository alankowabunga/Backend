/*
parameter -> expression
(parameter1, parameter2) -> expression
(parameter1, parameter2) -> { code block }
 */

import java.util.ArrayList;

interface StringFunction {
    String run(String str);
}

public class Main {
    public static void main(String[] args) {

//        Use a lambda expression in the ArrayList's forEach() method to print every item in the list
        ArrayList<Integer> numArray = new ArrayList<Integer>();
        numArray.add(1997);
        numArray.add(02);
        numArray.add(18);

        // 標準 for-each
        for(int n:numArray){ System.out.println(n);};
        // Lambda Expression
        numArray.forEach((n) -> {System.out.println(n);});

//     Create a method which takes a lambda expression as a parameter:

//        1. 使用傳統的匿名函式，實作 StringFunction
        StringFunction ask = new StringFunction() {
            @Override
            public String run(String str) {
                return str + "?";
            }
        };
    //最終匿名類別的實例賦值給 ask 變數，會傳到 printFormatted 的第二個參數。

//       2.使用 Lambda Expression:  StringFunction ask = (s) -> s + "?";



        printFormatted("Hello", ask);
    }
    public static void printFormatted(String str, StringFunction format) {
/*
第二個參數 format 是一功能型介面 StringFunction 的實例，表示該方法需要一個函數作為輸入。
。當我們創建一個 StringFunction 的實例時，我們實際上創建了一個對象(在這裡是 ask)，並且可以使用這個對象的 run 方法來執行我們定義的函數邏輯。
*/
        String result = format.run(str);
        System.out.println(result);
    }
}