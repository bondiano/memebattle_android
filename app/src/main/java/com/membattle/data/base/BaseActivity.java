package com.membattle.data.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.membattle.data.settings.Screens;
import javax.inject.Inject;
import butterknife.ButterKnife;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

public abstract class BaseActivity extends MvpAppCompatActivity {

    @Inject
    NavigatorHolder navigatorHolder;
    @Inject
    Router router;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        router.newRootScreen(Screens.SIGN_IN_SCREEN);
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(new AppNavigator(getSupportFragmentManager(), getContainerId(), this));
    }

    protected abstract int getContainerId();

    @Override
    protected void onPause() {
        super.onPause();
        navigatorHolder.removeNavigator();
    }

    protected abstract void injectDependencies();

    protected abstract int getLayoutId();
}
