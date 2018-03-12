package com.membattle.presentation.auth.activity;

import com.membattle.App;
import com.membattle.R;
import com.membattle.data.base.BaseActivity;
import com.membattle.data.settings.Screens;

import javax.inject.Inject;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

public class AuthActivity extends BaseActivity {

    @Inject
    NavigatorHolder mNavigatorHolder;

    @Inject
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
