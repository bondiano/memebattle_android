package com.membattle.domain.interactor;

import android.content.SharedPreferences;

import com.membattle.data.settings.Screens;

public class SettingsService {
    private static final String TOKEN_ACCESS = "token access";
    private static final String ID = "id";
    private static final String COINS = "coins";
    private static final String TOKEN_REFRESH = "token refresh";
    private final String USERNAME = "username";
    private final String ERROR = "error";
    private final String IMAGE_URL = "image url";
    private final String CURRENT_FRAGMENT_KEY = "current fragment";

    SharedPreferences sharedPreferences;

    public SettingsService(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
    }

    public String getZoomImage() {
        return sharedPreferences.getString(IMAGE_URL, ERROR);
    }

    public void setZoomImage(String url) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(IMAGE_URL, url);
        editor.apply();
    }

    public void initUser(String tokenAccess, String tokenRefresh, String username, int coins, int id) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TOKEN_ACCESS, tokenAccess);
        editor.putString(TOKEN_REFRESH, tokenRefresh);
        editor.putString(USERNAME, username);
        editor.putInt(COINS, coins);
        editor.putInt(ID, id);
        editor.apply();
    }

    public void setCoins(int coins) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(COINS, coins);
        editor.apply();
    }

    public int getUserId() {
        return sharedPreferences.getInt(ID, 0);
    }

    public String getUsername() {
        return sharedPreferences.getString(USERNAME, ERROR);
    }

    public int getCoins() {
        return sharedPreferences.getInt(COINS, 0);
    }

    public String getTokenRefresh() {
        return sharedPreferences.getString(TOKEN_REFRESH, ERROR);
    }

    public void updateTokens(String tokenRefresh, String tokenAccess) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(TOKEN_REFRESH, tokenRefresh);
        editor.putString(TOKEN_ACCESS, tokenAccess);
        editor.apply();
    }

    public String getTokenAccess() {
        return sharedPreferences.getString(TOKEN_ACCESS, ERROR);
    }

    public void signOut() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USERNAME, "no");
        editor.apply();
    }
}
