interface StringFunction {  //  functional Interface
    String run(String str);  //  Abstract method

}

public class Main {
    public static void main(String[] args) {

        // 使用 Lambda Expression 定義了一個匿名函式ask，該函式接受一個字串參數s，並返回s加上問號的字串。
        StringFunction ask = s -> s + "?";

        // Step 1.
        printFormatted("Hello",ask);

        //兩個參數：一個字串和一個StringFunction實例。它使用StringFunction的run方法來處理傳入的字串，並將結果輸出到控制台。
        public static void printFormatted(String str,StringFunction format){
            String result = format.run(str);
            System.out.println(result);
        }

    }
}