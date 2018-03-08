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
import com.membattle.data.settings.Screens;
import com.membattle.data.settings.Settings;
import com.membattle.presentation.game.fragment.game.GameFragment;
import com.membattle.presentation.game.fragment.zoom.ZoomFragment;
import com.membattle.presentation.main.fragment.modes.ModesFragment;
import com.membattle.presentation.main.fragment.profile.ProfileFragment;
import com.membattle.presentation.main.fragment.rate.RateFragment;
import com.nightonke.boommenu.BoomMenuButton;
import javax.inject.Inject;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

public class GameActivity extends MvpAppCompatActivity implements GameActivityView {

    @Inject
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
        setContentView(R.layout.activity_game);
        Intent i = getIntent();
        currentMode = i.getIntExtra(Settings.CURRENT_MODE, 0);
        App.getComponent().inject(this);
        BoomMenuButton bmb = findViewById(R.id.game_bmb);
        presenter().initBmb(bmb);
    }

    private Navigator navigator = new SupportFragmentNavigator(getSupportFragmentManager(), R.id.game_container) {

        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            switch (screenKey) {
                case Screens.GAME_SCREEN:
                    return new GameFragment();
                case Screens.MODES_SCREEN:
                    finish();
                case Screens.RATE_SCREEN:
                    return new RateFragment();
                case Screens.RULES_DIALOG:
                    showRules();
                    return new GameFragment();
                case Screens.SHOP_SCREEN:
                    showToast();
                    return new GameFragment();
                case Screens.PROFILE_SCREEN:
                    return new ProfileFragment();
                case Screens.ZOOM_SCREEN:
                    return new ZoomFragment(data);
                default:
                    return new ModesFragment();
            }
        }

        @Override
        protected void showSystemMessage(String message) {
            Toast.makeText(GameActivity.this, message, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void exit() {
            finish();
        }
    };


    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        super.onPause();
        navigatorHolder.removeNavigator();
    }

    void showToast() {
        Toast.makeText(getApplication(), "Магазин пока не работает!", Toast.LENGTH_SHORT).show();
    }

    void showRules() {
        AlertDialog.Builder builder = new AlertDialog.Builder(GameActivity.this);
        presenter.setRulesBuilder(builder, currentMode);
    }
}
