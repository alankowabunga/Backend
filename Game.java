import java.util.Random;

public class Game {

    //  data (宣告放答案的字串、預設遊戲初始狀態 win = false)
    private String answer;
    private boolean win = false;

    //    getter 取得答案、和獲勝的回傳值
    String getAnswer() {
        return answer;
    }

    boolean isWin() {
        return win;
    }
//    function 生成題目、和檢查user答案的函式

    // 可重複的 4 random number
    void generateAnswer() {
        String answer = "";
        for(int i=0; i < 4;i++){
            int intNum=(int) Math.random()*10;
            // 要將整數 int( primitive data type) 放到字串裡，可用valueOf()
            String randNum=String.valueOf(intNum);
            answer+=randNum;
        }
    System.out.println(answer);
    }

}

