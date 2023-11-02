package com.example.firstproject;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.udojava.evalex.Expression;
import java.math.BigDecimal;


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

        char lastIndex = stringBuilder.charAt(stringBuilder.length() - 1); // последний элемент строки
        if (lastIndex != '*' && lastIndex != '/' && lastIndex != '-' && lastIndex != '+') {
            stringBuilder.append(button.getText());
        }


        String textWithOperator = stringBuilder.toString();
        num.setText(textWithOperator);
    }

    public void equalsOperator(View view) {
        TextView num = findViewById(R.id.textView);

        String text = num.getText().toString();
        String result = solveEquation(text);

        num.setText(result);
    }

    public static String solveEquation(String equation) {
        String result;
        try {
            Expression expression = new Expression(equation);
            BigDecimal ans = expression.eval();
            result = ans.toPlainString();
        } catch (Exception e) {
            result = "Ошибка: " + e.getMessage();
        }
        return result;
    }



}