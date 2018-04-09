package com.membattle.presentation.main.activity;

import android.content.Intent;
import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.membattle.App;
import com.membattle.R;
import com.membattle.presentation.base.BaseActivity;
import com.membattle.di.qualifier.Local;
import com.membattle.presentation.game.activity.GameActivity;
import com.nightonke.boommenu.BoomMenuButton;

import javax.inject.Inject;

import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

public class MainActivity extends BaseActivity implements MainActivityView {


    @Inject
    @Local
    NavigatorHolder navigatorHolder;

    @Inject
    @Local
    Router router;

    @InjectPresenter
    MainActivityPresenter presenter;

    @ProvidePresenter
    public MainActivityPresenter presenter() {
        return new MainActivityPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BoomMenuButton bmb = findViewById(R.id.main_bmb);
        presenter().initBmb(bmb);
    }

    @Override
    protected int getContainerId() {
        return R.id.main_container;
    }

    @Override
    protected void injectDependencies() {
        App.getComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void gotoGame() {
        Intent intent = new Intent(getApplication(), GameActivity.class);
        getApplication().startActivity(intent);
    }
}
