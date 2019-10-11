package com.example.helloworld;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText number1, number2;
    Button multiButton, sumButton, subButton;
    TextView multiView, sumView, subView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindViews();
        setListeners();

    }

    public void bindViews() {
        number1 = findViewById(R.id.firstNumber);
        number2 = findViewById(R.id.secondNumber);
        multiButton = findViewById(R.id.buttonMulti);
        sumButton = findViewById(R.id.buttonSum);
        subButton = findViewById(R.id.buttonSub);
        multiView = findViewById(R.id.multiTextV);
        sumView = findViewById(R.id.sumTextV);
        subView = findViewById(R.id.subTextV);
    }

    public boolean validate(EditText n1, EditText n2) {
        if (n1.getText().toString().isEmpty() || n2.getText().toString().isEmpty()) {
            return false;
        } else
            return true;
    }

    public void setListeners() {

        multiButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate(number1, number2)) {
                    double n1 = Double.valueOf(number1.getText().toString());
                    double n2 = Double.valueOf(number2.getText().toString());
                    multi(n1, n2);
                } else
                    showToast("PLEASE ENTER THE NUMBER!!!");
            }
        });
        sumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate(number1, number2)) {
                    double n1 = Double.valueOf(number1.getText().toString());
                    double n2 = Double.valueOf(number2.getText().toString());
                    sum(n1, n2);
                } else
                    showToast("PLEASE ENTER THE NUMBER!!!");
            }
        });
        subButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validate(number1, number2)) {
                    double n1 = Double.valueOf(number1.getText().toString());
                    double n2 = Double.valueOf(number2.getText().toString());
                    sub(n1, n2);
                } else
                    showToast("PLEASE ENTER THE NUMBER!!!");
            }
        });
    }

    public void multi(double n1, double n2) {

        double result = n1 * n2;
        multiView.setText(String.valueOf(result));
        subView.setText(R.string.sub_default);
        sumView.setText(R.string.sum_default);
    }

    public void sum(double n1, double n2) {

        double result = n1 + n2;
        sumView.setText(String.valueOf(result));
        subView.setText(R.string.sub_default);
        multiView.setText(R.string.multi_defualt);
    }

    public void sub(double n1, double n2) {

        double result = n1 - n2;
        subView.setText(String.valueOf(result));
        multiView.setText(R.string.multi_defualt);
        sumView.setText(R.string.sum_default);
    }

    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
