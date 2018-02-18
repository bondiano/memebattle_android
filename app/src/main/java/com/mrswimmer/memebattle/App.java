package com.mrswimmer.memebattle;

import android.app.Application;

import com.mrswimmer.memebattle.di.AppComponent;
import com.mrswimmer.memebattle.di.DaggerAppComponent;

public class App extends Application {
    private static AppComponent component;

    public static AppComponent getComponent() {
        return component;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        component = buildComponent();
    }

    protected AppComponent buildComponent() {
        return DaggerAppComponent.create();
    }
}
