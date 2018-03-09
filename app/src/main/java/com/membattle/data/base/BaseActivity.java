package com.membattle.data.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.arellomobile.mvp.MvpAppCompatActivity;
import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;

public abstract class BaseActivity extends MvpAppCompatActivity {

    @Inject
    NavigatorHolder navigatorHolder;
    private Navigator navigator;
    private int layoutRes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
        setContentView(layoutRes);
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        super.onPause();
        navigatorHolder.removeNavigator();
    }

    protected abstract void injectDependencies();
}
