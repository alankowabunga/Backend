public class Main {
    public static void main(String[] args) {

//        String 物件不能更改內容，只能轉成其他型態來操作(例如 String.toCharArray() )
//        Class StringBuffer的方法可以直接修改含字串的內容，因此可以建立其物件

        String str = "This is a string.\n";
        StringBuffer sbObj = new StringBuffer(str);

        System.out.println(sbObj.length()); //長度

        sbObj.append("Using append method to add new words.");
        System.out.println(sbObj);
    }
}