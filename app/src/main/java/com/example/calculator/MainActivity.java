package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView textView_result;
    private Integer first, second;
    private boolean isOperationClick;
    private String operation;
    private Button btn_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView_result = findViewById(R.id.text_view);
        btn_go = findViewById(R.id.btn);
    }

    public void nullNumberClick(View view) {
        switch (view.getId()) {
            case R.id.btn_zero:
                setNumber("0");
                break;
            case R.id.btn_one:
                setNumber("1");
                break;
            case R.id.btn_two:
                setNumber("2");
                break;
            case R.id.btn_three:
                setNumber("3");
                break;
            case R.id.btn_four:
                setNumber("4");
                break;
            case R.id.btn_five:
                setNumber("5");
                break;
            case R.id.btn_six:
                setNumber("6");
                break;
            case R.id.btn_seven:
                setNumber("7");
                break;
            case R.id.btn_eight:
                setNumber("8");
                break;
            case R.id.btn_nine:
                setNumber("9");
                break;
            case R.id.clean:
                textView_result.setText("0");
                first = 0;
                second = 0;
                break;
        }
    }

    private void setNumber(String number) {
        btn_go.setVisibility(View.INVISIBLE);
        if (textView_result.getText().toString().equals("0")) {
            textView_result.setText(number);
        } else if (isOperationClick) {
            textView_result.setText(number);
        } else {
            textView_result.append(number);
        }
        isOperationClick = false;
    }

    public void onOperationClick(View view) {
        btn_go.setVisibility(View.INVISIBLE);
        switch (view.getId()) {
            case R.id.btn_plus:
                first = Integer.parseInt(textView_result.getText().toString());
                operation = "+";
                isOperationClick = true;
                break;
            case R.id.minus:
                first = Integer.parseInt(textView_result.getText().toString());
                operation = "-";
                isOperationClick = true;
                break;
            case R.id.multiply:
                first = Integer.parseInt(textView_result.getText().toString());
                operation = "*";
                isOperationClick = true;
                break;
            case R.id.division:
                first = Integer.parseInt(textView_result.getText().toString());
                operation = "/";
                isOperationClick = true;
                break;
            case R.id.btn_equal:
                btn_go.setVisibility(View.VISIBLE);
                second = Integer.parseInt(textView_result.getText().toString());
                Integer result = 0;
                switch (operation) {
                    case "+":
                        result = first + second;
                        break;
                    case "-":
                        result = first - second;
                        break;
                    case "*":
                        result = first * second;
                        break;
                    case "/":
                        result = first / second;
                        break;
                }
                textView_result.setText(result.toString());
                isOperationClick = true;
                break;
        }
    }
}