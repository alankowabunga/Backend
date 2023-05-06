import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

//        compile() 是 java.util.regex.Pattern 類別的一個方法，用來將正則表達式轉換為 Pattern 物件。
//        matcher() 是 java.util.regex.Pattern 類別的一個方法，用來建立一個 Matcher 物件，這個 Matcher 物件可以用來在字串中搜尋、比對符合正則表達式的文字。
//        透過 Matcher 類別所提供的方法，我們可以使用這個物件來進行比對、搜尋等操作，例如 find()、group() 等方法。

        Pattern pattern = Pattern.compile("Alan",Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher("alan is handsome~");
        boolean match = matcher.find();

        if(match){
            System.out.println("Found it");
        }else{
            System.out.println("Cant find it");
        }
    }
}