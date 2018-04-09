package com.membattle.presentation.game.activity;

import android.os.Bundle;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.membattle.App;
import com.membattle.R;
import com.membattle.presentation.base.BaseActivity;
import com.membattle.data.settings.Screens;
import com.membattle.di.qualifier.Local;
import com.nightonke.boommenu.BoomMenuButton;

import javax.inject.Inject;

import ru.terrakok.cicerone.NavigatorHolder;

public class GameActivity extends BaseActivity implements GameActivityView {

    @Inject
    @Local
    NavigatorHolder navigatorHolder;

    @InjectPresenter
    GameActivityPresenter presenter;

    public static int currentMode = 0;

    @ProvidePresenter
    public GameActivityPresenter presenter() {
        return new GameActivityPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BoomMenuButton bmb = findViewById(R.id.game_bmb);
        presenter().initBmb(bmb, currentMode);
    }

    @Override
    protected int getContainerId() {
        return Screens.CONTAINER_GAME;
    }

    @Override
    protected void injectDependencies() {
        App.getComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_game;
    }
}
