package com.example.calcnewsecondpart.domain;

import android.content.Context;
import android.content.SharedPreferences;

public class ThemesStorage {
    private static final String KEY_THEME = "KEY_THEME";
    private Context context;
    private final SharedPreferences sharedPreferences;

    public ThemesStorage(Context context) {
        this.context = context;

        sharedPreferences = context.getSharedPreferences("ThemePreferences", Context.MODE_PRIVATE);
    }

    public Theme getCurrentTheme() {
        String key = sharedPreferences.getString(KEY_THEME, Theme.THEME_1.getKey());
        for (Theme themes : Theme.values()) {
            if (themes.getKey().equals(key)) {
                    return themes;
            }
        }
        return null;
    }

    public void setCurrentTheme(Theme themes){
        sharedPreferences.edit().putString(KEY_THEME, themes.getKey()).apply();
    }
}