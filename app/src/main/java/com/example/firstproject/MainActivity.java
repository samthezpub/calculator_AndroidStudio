package com.example.firstproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void clearNum(View view) {
        TextView num = findViewById(R.id.textView);
        num.setText("0");
        changeFontSize();
    }

    public void switchOperator(View view) {
        TextView num = findViewById(R.id.textView);

        Integer integerText = Integer.parseInt(num.getText().toString());
        String switchedText = String.valueOf((-integerText));
        num.setText(switchedText);
    }

    public void addNumToTextValue(View view) {
        TextView num = findViewById(R.id.textView);
        Button button = (Button) view; // Преобразование 'view' к типу Button
        changeFontSize();


        if (checkIsZero(num)) {
            num.setText(button.getText());
        } else {
            num.setText(num.getText().toString() + button.getText());
        }
    }

    public boolean checkIsZero(TextView num) {
        char numText = num.getText().charAt(0);
        if (numText == '0') {
            return true;
        }
        return false;
    }

    public void changeFontSize() {
        TextView num = findViewById(R.id.textView);
        int lengthOfNum = num.getText().toString().length();

        if (lengthOfNum > 5) {
            float newSize = (float) (100 - (lengthOfNum * 4));
            if (num.getTextSize() > 70) {
                num.setTextSize(Math.max(newSize, 1));
            }

        } else {
            num.setTextSize(100);
        }
    }

    public void AddOperator(View view) {
        TextView num = findViewById(R.id.textView);
        Button button = (Button) view; // Преобразование 'view' к типу Button

        CharSequence numText = num.getText();
        StringBuilder stringBuilder = new StringBuilder(numText);

        char lastIndex = stringBuilder.charAt(stringBuilder.length()-1); // последний элемент строки
        if (lastIndex !='*' && lastIndex != '/' && lastIndex != '-' && lastIndex != '+'){
            stringBuilder.append(button.getText());
        }


        String textWithOperator = stringBuilder.toString();
        num.setText(textWithOperator);
    }
}