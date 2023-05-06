public class Main {
    public static void main(String[] args) {

//        練習將各種參雜符號的字串，分離出各別單字，並輸出字和數量

//        "aaa:bbb:ccc:ddd";
        String str1 = "aaa:bbb";
        String[] words = str1.split(":");
        for(String word:words){
            System.out.println(word);
        }

        int count = str1.split(":").length;
        System.out.println(count);

        System.out.println("-------------------------------------");
//        "aaa:bbb-ccc_ddd"; -> 字串中有多個分隔符號時，就須加上"|"。

        String str2 = "aaa:bbb-ccc_ddd";
        String[] words2 = str2.split(":|_|-");
        for(String word:words2){
            System.out.println(word);
        }

        int count2 = str2.split(":|_|-").length;
        System.out.println(count2);

        System.out.println("-------------------------------------");
//        "aaa-bbb-ccc.ddd"; -> 用到特殊字元時，如".", "|", "$"，此時要在特殊字元前面加上"\\"，才會得到正確的結果。

        String str3 = "aaa-bbb-ccc.ddd.eee";
        String[] words3 = str3.split("-|\\.");
        for(String word:words3){
            System.out.println(word);
        }

        int count3 = str3.split("-|\\.").length;
        System.out.println(count3);

        System.out.println("-------------------------------------");
//        "One Two Three";

        String str4 = "One Two Three";
        String[] words4 = str4.split("\\s"); //正規式空白鍵 -> \\s
        for(String word:words4){
            System.out.println(word);
        }

        int count4 = str4.split("\\s").length;
        System.out.println(count4);
    }
}