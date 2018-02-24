package com.mrswimmer.memebattle.presentation.game.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.mrswimmer.memebattle.App;
import com.mrswimmer.memebattle.R;
import com.mrswimmer.memebattle.data.settings.Screens;
import com.mrswimmer.memebattle.presentation.game.fragment.GameFragment;
import com.mrswimmer.memebattle.presentation.main.activity.MainActivityPresenter;
import com.mrswimmer.memebattle.presentation.main.fragment.modes.ModesFragment;
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

    @ProvidePresenter
    public GameActivityPresenter presenter() {
        return new GameActivityPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
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
}
