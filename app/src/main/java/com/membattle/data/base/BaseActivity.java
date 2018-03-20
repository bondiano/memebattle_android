package com.membattle.data.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.membattle.data.settings.Screens;
import com.membattle.di.qualifier.Global;
import com.membattle.di.qualifier.Local;
import com.membattle.domain.utils.GlobalNavigator;
import com.membattle.domain.utils.LocalNavigator;

import javax.inject.Inject;

import butterknife.ButterKnife;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

public abstract class BaseActivity extends MvpAppCompatActivity {

    @Inject
    @Local
    NavigatorHolder localNavigatorHolder;
    @Inject
    @Global
    NavigatorHolder globalNavigatorHolder;
    @Inject
    @Local
    Router localRouter;
    @Inject
    @Global
    Router globalRouter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        localRouter.newRootScreen(Screens.SIGN_IN_SCREEN);
    }

    @Override
    protected void onResume() {
        super.onResume();
        localNavigatorHolder.setNavigator(new LocalNavigator(getSupportFragmentManager(), getContainerId()));
        globalNavigatorHolder.setNavigator(new GlobalNavigator(this));
    }

    protected abstract int getContainerId();

    @Override
    protected void onPause() {
        super.onPause();
        localNavigatorHolder.removeNavigator();

    }

    protected abstract void injectDependencies();

    protected abstract int getLayoutId();
}
