package com.mrswimmer.memebattle.presentation.main.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.widget.Toast;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.mrswimmer.memebattle.App;
import com.mrswimmer.memebattle.R;
import com.mrswimmer.memebattle.data.settings.Screens;
import com.mrswimmer.memebattle.presentation.game.activity.GameActivity;
import com.mrswimmer.memebattle.presentation.main.fragment.info.InfoFragment;
import com.mrswimmer.memebattle.presentation.main.fragment.modes.ModesFragment;
import com.mrswimmer.memebattle.presentation.main.fragment.rate.RateFragment;
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
        context = getBaseContext();
        setContentView(R.layout.activity_main);
        App.getComponent().inject(this);
        BoomMenuButton bmb = findViewById(R.id.main_bmb);
        presenter().initBmb(bmb);
    }

    private Context context;
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
                    return new
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
        Intent intent = new Intent(context, GameActivity.class);
        context.startActivity(intent);
    }
}
