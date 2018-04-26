package com.membattle.domain.service;

import android.content.SharedPreferences;

public class SettingsService {
    private final String MAIL = "mail";
    private final String MAIL_KEY = "mail key";
    private final String USERNAME = "username";
    private final String USERNAME_DEFAULT = "Гость";
    private final String ERROR = "error";
    private final String IMAGE_URL = "image url";

    SharedPreferences sharedPreferences;

    public SettingsService(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public void saveUsernameAndMail(String mail, String username, String mailKey) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(MAIL, mail);
        editor.putString(MAIL_KEY, mailKey);
        editor.putString(USERNAME, username);
        editor.apply();
    }


    public String getUsername() {
        return sharedPreferences.getString(USERNAME, USERNAME_DEFAULT);
    }

    public String getMail() {
        return sharedPreferences.getString(MAIL, ERROR);
    }

    public String getMailKey() {
        return sharedPreferences.getString(MAIL_KEY, ERROR);
    }

    public String getZoomImage() {
        return sharedPreferences.getString(IMAGE_URL, ERROR);
    }

    public void setZoomImage(String url) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(IMAGE_URL, url);
        editor.apply();
    }
}
