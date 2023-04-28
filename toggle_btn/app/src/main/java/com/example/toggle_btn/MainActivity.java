package com.example.toggle_btn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton myBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myBtn = (ToggleButton) findViewById(R.id.toggleButton);
        myBtn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(myBtn.isChecked()){
                    Toast.makeText(getApplicationContext() ,"open",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext() ,"close",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}