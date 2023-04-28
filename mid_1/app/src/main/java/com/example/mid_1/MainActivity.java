package com.example.mid_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void send_Btn(View view) {
//        取得 EditText & TextView 的元件
        EditText input=(EditText) findViewById(R.id.input_Txt);
        String guess=input.getText().toString(); //轉換成字串，放入變數 guess
        TextView output=(TextView) findViewById(R.id.output_Txt);

//        Scanner sc=new Scanner(System.in);
        String computerGuess="";  //電腦自行產生4位數的亂數，放入初始為空字串的 computerGuess
        for(int i=0;i<4;i++){
            computerGuess+=(int)(Math.random()*10);
        }

        output.setText("random: "+computerGuess);
        while(true){
            int A=0,B=0;
            boolean check[]=new boolean[4]; // 使用 new指令產生新物件、長度為 6 的陣列
            Arrays.fill(check, false);
//            String guess=sc.next(); //使用者輸入數字

            //檢查有幾A
            for(int i=0;i<4;i++){
                if(computerGuess.charAt(i)==guess.charAt(i)){
                    A++;
                    check[i]=true;
                }
            }
            //檢查有幾B
            for(int i=0;i<4;i++){
                for(int j=0;j<4;j++){
                    if(!check[j] && computerGuess.charAt(j)==guess.charAt(i)){
                        B++;
                        check[j]=true;
                        break;
                    }
                }
            }

            //Output
            if(A==4){
                output.setText("結果: Correct");
                break;
            }
            else{
                output.setText("結果為:"+A+"A"+B+"B");
            }
        }
    }
}