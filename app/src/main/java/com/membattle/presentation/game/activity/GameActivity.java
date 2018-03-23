package com.membattle.presentation.game.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.membattle.App;
import com.membattle.R;
import com.membattle.data.base.BaseActivity;
import com.membattle.data.settings.Screens;
import com.membattle.data.settings.Settings;
import com.membattle.di.qualifier.Local;
import com.membattle.presentation.game.fragment.game.GameFragment;
import com.membattle.presentation.game.fragment.zoom.ZoomFragment;
import com.membattle.presentation.main.fragment.modes.ModesFragment;
import com.membattle.presentation.main.fragment.profile.ProfileFragment;
import com.membattle.presentation.main.fragment.rate.RateFragment;
import com.nightonke.boommenu.BoomMenuButton;

import java.util.Set;

import javax.inject.Inject;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

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
