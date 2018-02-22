package com.mrswimmer.memebattle;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.mrswimmer.memebattle.data.settings.Settings;
import com.mrswimmer.memebattle.di.AppComponent;
import com.mrswimmer.memebattle.di.DaggerAppComponent;

public class App extends Application {
    private static AppComponent component;
    public static SharedPreferences settings;
    public static AppComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        settings = getApplicationContext().getSharedPreferences(Settings.SETTINGS_NAME, Context.MODE_PRIVATE);
        component = buildComponent();
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent.create();
    }
}
