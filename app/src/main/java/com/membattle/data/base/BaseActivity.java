package com.membattle.data.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.arellomobile.mvp.MvpAppCompatActivity;
import javax.inject.Inject;
import ru.terrakok.cicerone.NavigatorHolder;

public abstract class BaseActivity extends MvpAppCompatActivity {

    @Inject
    NavigatorHolder navigatorHolder;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(new AppNavigator(this));
    }

    @Override
    protected void onPause() {
        super.onPause();
        navigatorHolder.removeNavigator();
    }

    protected abstract void injectDependencies();
}
