package com.membattle;

import android.app.Application;
import com.membattle.di.AppComponent;
import com.membattle.di.DaggerAppComponent;
import com.membattle.di.module.SharedPreferencesModule;

public class App extends Application {
    private static AppComponent component;
    public static AppComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.builder()
                .sharedPreferencesModule(new SharedPreferencesModule(getApplicationContext()))
                .build();
    }
}
