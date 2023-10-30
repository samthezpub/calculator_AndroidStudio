package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clearNum(View view) {
        TextView num = findViewById(R.id.textView);
        num.setText("0");
    }

    public void switchOperator(View view) {
        TextView num = findViewById(R.id.textView);

        Integer integerText = Integer.parseInt(num.getText().toString());
        String switchedText = String.valueOf((-integerText));
        num.setText(switchedText);
    }

    public void addNumToTextValue(View view){
        TextView num = findViewById(R.id.textView);
        Button button = (Button) view; // Преобразование 'view' к типу Button

        char numText = num.getText().charAt(0);

        if (num.getText().charAt(0) == '0'){
            num.setText(button.getText());
        }
        else{
            num.setText(num.getText().toString() + button.getText());
        }



    }
}