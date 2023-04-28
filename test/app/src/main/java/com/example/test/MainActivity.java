package com.example.test;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MainActivity extends AppCompatActivity {


    // 先宣告 View 的變數
    Button submitButton;
    Button restartButton;
    EditText inputNumber;
    TextView historyInput;
    TextView historyResult;
    // Toast 是畫面下面會跳出來的小提示框
    Toast toast;
    FrameLayout cover;
    ToggleButton toggleButton;
    Boolean flag_hard;
    int counter;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 找到畫面中的 View
        submitButton = (Button) findViewById(R.id.submitButton);
        restartButton = (Button) findViewById(R.id.restartButton);
        inputNumber = (EditText) findViewById(R.id.inputNumber);
        historyInput = (TextView) findViewById(R.id.history_input);
        historyResult = (TextView) findViewById(R.id.history_result);
        cover = (FrameLayout) findViewById(R.id.cover);
        counter = 0;
        flag_hard = false;
        toggleButton = (ToggleButton) findViewById(R.id.toggle_btn);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (toggleButton.isChecked()) {
                    flag_hard = true;
                    Toast.makeText(getApplicationContext(),"數字可重複",Toast.LENGTH_SHORT);
                } else {
                    flag_hard = false;
                    Toast.makeText(getApplicationContext(),"數字不可重複",Toast.LENGTH_SHORT);
                }
            }
        });




        private String answer;
        private boolean win = false;

        //    getter
        String getAnswer() {
            return answer;
        }

        boolean isWin() {
            return win;
        }


        final Context that = this;
        // 設定送出按鈕的點擊事件
        submitButton.setOnClickListener(new View.OnClickListener() {
            //            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                // 一定要輸入四個數字才有反應
                if (inputNumber.getText().length() == 4) {
                    // 將使用者輸入的數字跟幾 A 幾 B 放入文字框框中
                    historyInput.setText((inputNumber.getText() + "\n") + historyInput.getText());
                    historyResult.setText((game.checkAnswer(inputNumber.getText().toString()) + "\n") + historyResult.getText());
                    // 清空輸入框
                    inputNumber.setText("");
                    // 如果猜中了
                    if (game.isWin()) {
                        // 跳出獲勝的訊息
                        Toast.makeText(that, "You win", Toast.LENGTH_LONG).show();
                        inputNumber.setEnabled(false);
                        submitButton.setEnabled(false);
                        cover.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        // 設定重新開始按鈕的點擊事件
        restartButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                if (game.isWin()) {
                    Toast.makeText(that, ("Game restarted"), Toast.LENGTH_LONG).show();
                } else {
                    // 沒有獲勝的話會顯示答案
                    Toast.makeText(that, ("Last answer: " + game.getAnswer() + "\n\n   Game restarted"), Toast.LENGTH_LONG).show();
                }
                inputNumber.setEnabled(false);
                inputNumber.setEnabled(true);
                submitButton.setEnabled(true);
                game.generateAnswer();
                historyInput.setText("");
                historyResult.setText("");
                cover.setVisibility(View.INVISIBLE);
            }
        });

        // 可重複亂數
        private void repeatableAnswer() {
            answer = "";
            for (int i = 0; i < 4; i++) {
                int randNum = (int) (Math.random() * 10);
                String strNum = Integer.toString(randNum);
                answer += strNum;
            }
        }
        // 不可重複亂數
        private void nonRepeatAnswer() {
            Random rand = new Random();

            ArrayList<Integer> numList = new ArrayList<>();
            for (int i = 0; i <= 9; i++) {
                numList.add(i); // 建立 1-9 的數字庫
            }
            answer = "";
            for (int j = 0; j < 4; j++) {
                int index = rand.nextInt(numList.size()); // 根據數字庫長度決定隨機產商亂數的區間
                int n = numList.get(index);
                String strNum = Integer.toString(n);
                answer += strNum;
                numList.remove(index);
            }
        }

        // 判斷亂數答案生成的選擇
        private void generateAnswer() {
            if (flag_hard) {
                repeatableAnswer();
            } else {
                nonRepeatAnswer();
            }
        }
        // 產生一個隨機的答案
        generateAnswer();

        // 對比答案
        String checkAnswer(String guess) {
            int a = 0, b = 0, c = 0;
            boolean[] answerUsed = {false, false, false, false};
            boolean[] guessUsed = {false, false, false, false};
            // 計算 a
            for (int i = 0; i < 4; i++) {
                if (guess.charAt(i) == answer.charAt(i)) {
                    answerUsed[i] = true;
                    guessUsed[i] = true;
                    a++;
                }
                System.out.println();
            }
            // 計算 b
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                    if (!guessUsed[i] && !answerUsed[j] && guess.charAt(i) == answer.charAt(j)) {
                        answerUsed[j] = true;
                        guessUsed[i] = true;
                        b++;
                        break;
                    }
                }
            }
            // 計算 c
            Map<Character, Integer> charCount = new HashMap<>();
            char[] charList = answer.toCharArray();
            for (char ch : charList) {
                if (!charCount.containsKey(ch)) {
                    charCount.put(ch, 1);
                } else {
                    charCount.put(ch, charCount.get(ch) + 1);
                }
            }
            for (int i : charCount.values()) {
                if (i > 1) {
                    c++;
                }
            }

            //輸出結果
            String result = a + "A" + b + "B" + c + "C";
            if (a == 4) {
                win = true;
            }
            return result;
        }
    }


}