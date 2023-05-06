public class MainActivity {

    int i;
    String answer = "";
    for(i =0;i< 4;i++)

    {
        int intNum = (int) Math.random() * 10;
        // 要將整數 int( primitive data type) 放到字串裡，可用valueOf()
        String randNum = String.valueOf(intNum);
        answer += randNum;
    }
    System.out.println(answer);

}
