package com.membattle;

import android.app.Application;
import android.widget.Toast;

import com.membattle.data.settings.Settings;
import com.membattle.di.AppComponent;
import com.membattle.di.DaggerAppComponent;
import com.membattle.di.module.SharedPreferencesModule;
import com.vk.sdk.VKSdk;
import com.yandex.metrica.YandexMetrica;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
        VKSdk.initialize(getApplicationContext());
        // Initialisation AppMetrica SDK
        YandexMetrica.activate(getApplicationContext(), Settings.API_key);
        // Tracking user activity
        YandexMetrica.enableActivityAutoTracking(this);
    }


}
