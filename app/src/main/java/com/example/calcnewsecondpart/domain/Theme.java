package com.example.calcnewsecondpart.domain;

import com.example.calcnewsecondpart.R;

public enum Theme {
    THEME_1("Theme_1", R.style.Theme_CalcNewSecondPart),
    THEME_2("Theme_2", R.style.Theme_CalcNewSecondPart2);

    private final String key;
    private final int res;

    Theme(String key, int res) {
        this.key = key;
        this.res = res;
    }

    public String getKey() {
        return key;
    }

    public int getRes() {
        return res;
    }
}
