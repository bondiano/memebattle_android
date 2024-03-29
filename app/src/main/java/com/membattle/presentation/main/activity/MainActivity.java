package com.membattle.presentation.main.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.membattle.App;
import com.membattle.R;
import com.membattle.data.settings.Screens;
import com.membattle.presentation.game.activity.GameActivity;
import com.membattle.presentation.main.fragment.info.InfoFragment;
import com.membattle.presentation.main.fragment.modes.ModesFragment;
import com.membattle.presentation.main.fragment.profile.ProfileFragment;
import com.membattle.presentation.main.fragment.rate.RateFragment;
import com.membattle.presentation.main.fragment.settings.SettingsFragment;
import com.nightonke.boommenu.BoomMenuButton;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

public class MainActivity extends MvpAppCompatActivity implements MainActivityView {

    @Inject
    NavigatorHolder navigatorHolder;

    @Inject
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
        setContentView(R.layout.activity_main);
        App.getComponent().inject(this);
        BoomMenuButton bmb = findViewById(R.id.main_bmb);
        presenter().initBmb(bmb);
    }

    private Navigator navigator = new SupportFragmentNavigator(getSupportFragmentManager(), R.id.main_container) {

        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            switch (screenKey) {
                case Screens.MODES_SCREEN:
                    return new ModesFragment();
                case Screens.GAME_ACTIVITY:
                    presenter.gotoGame();
                case Screens.RATE_SCREEN:
                    return new RateFragment();
                case Screens.INFO_SCREEN:
                    return new InfoFragment();
                case Screens.SETTINGS_SCREEN:
                    return new SettingsFragment();
                case Screens.SHOP_SCREEN:
                    showToast();
                    return new ModesFragment();
                case Screens.PROFILE_SCREEN:
                    return new ProfileFragment();
                default:
                    return new ModesFragment();
            }
        }

        @Override
        protected void showSystemMessage(String message) {
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
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

    @Override
    public void gotoGame() {
        Intent intent = new Intent(getApplication(), GameActivity.class);
        getApplication().startActivity(intent);
    }

    void showToast() {
        Toast.makeText(getApplication(), "Магазин пока не работает!", Toast.LENGTH_SHORT).show();
    }
}
