package com.example.calcnewsecondpart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.calcnewsecondpart.domain.Theme;
import com.example.calcnewsecondpart.domain.ThemesStorage;

public class SecondActivity extends AppCompatActivity {
    private ThemesStorage themeStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        themeStorage = new ThemesStorage(this);
        setTheme(themeStorage.getCurrentTheme().getRes());

        setContentView(R.layout.activity_second);

        View.OnClickListener themeClicked = v -> {
            if (v.getId() == R.id.theme_1) {
                themeStorage.setCurrentTheme(Theme.THEME_1);
            } else if (v.getId() == R.id.theme_2) {
                themeStorage.setCurrentTheme(Theme.THEME_2);
            }
            recreate();
        };

        findViewById(R.id.theme_1).setOnClickListener(themeClicked);
        findViewById(R.id.theme_2).setOnClickListener(themeClicked);
    }
}