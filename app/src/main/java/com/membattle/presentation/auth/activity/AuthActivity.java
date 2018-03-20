package com.membattle.presentation.auth.activity;

import com.membattle.App;
import com.membattle.R;
import com.membattle.data.base.BaseActivity;
import com.membattle.data.settings.Screens;
import com.membattle.di.qualifier.Local;

import javax.inject.Inject;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

public class AuthActivity extends BaseActivity {

    @Inject
    @Local
    NavigatorHolder mNavigatorHolder;

    @Inject
    @Local
    Router router;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_auth;
    }

    @Override
    protected int getContainerId() {
        return Screens.CONTAINER_AUTH;
    }

    @Override
    protected void injectDependencies() {
        App.getComponent().inject(this);
    }

}
