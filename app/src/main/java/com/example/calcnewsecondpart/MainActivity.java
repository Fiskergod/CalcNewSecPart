package com.example.calcnewsecondpart;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.calcnewsecondpart.domain.ThemesStorage;

public class MainActivity extends AppCompatActivity {

    private ThemesStorage themesStorage;
    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        themesStorage = new ThemesStorage(this);
        setTheme(themesStorage.getCurrentTheme().getRes());

        setContentView(R.layout.activity_main);

        findViewById(R.id.settings).setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        });

        display = findViewById(R.id.editText_Numbers_Input);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(v -> {

        });
    }

    private void updateText(String strToAdd) {
        String oldStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftStr = oldStr.substring(0, cursorPos);
        String rightStr = oldStr.substring(cursorPos);
        display.setText(String.format("%s%s%s", leftStr, strToAdd, rightStr));
    }

    public void btnZero(View view) {
        updateText("0");
    }

    public void btnDot(View view) {
        updateText(".");
    }

    public void btnEqually(View view) {
        String userExp = display.getText().toString();
/*
        Expression exp = new Expression(userExp);

        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length()); */
    }

    public void numClick(View view) {
        Button btn = (Button)view;
        updateText(btn.getText().toString());
    }
/*
    public void btnNine(View view) {
        updateText("9");
    }

    public void btnEight(View view) {
        updateText("8");
    }

    public void btnSeven(View view) {
        updateText("7");
    }

    public void btnSix(View view) {
        updateText("6");
    }

    public void btnFive(View view) {
        updateText("5");
    }

    public void btnFour(View view) {
        updateText("4");
    }

    public void btnThree(View view) {
        updateText("3");
    }

    public void btnTwo(View view) {
        updateText("2");
    }

    public void btnOne(View view) {
        updateText("1");
    } */

    public void btnPlus(View view) {
        updateText("+");
    }

    public void btnMinus(View view) {
        updateText("-");
    }

    public void btnBack(View view) {
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0) {
            SpannableStringBuilder selection = (SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos, "");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }
    }

    public void btnMultiply(View view) {
        updateText("*");
    }

    public void btnDivide(View view) {
        updateText("/");
    }

    public void btnCancel(View view) {
        display.setText("");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        recreate();
    }
}