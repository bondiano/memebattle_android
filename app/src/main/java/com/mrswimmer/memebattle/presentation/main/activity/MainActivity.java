package com.mrswimmer.memebattle.presentation.main.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.MvpView;
import com.mrswimmer.memebattle.App;
import com.mrswimmer.memebattle.R;
import com.mrswimmer.memebattle.presentation.Screens;
import com.mrswimmer.memebattle.presentation.main.fragment.modes.ModesFragment;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

public class MainActivity extends MvpAppCompatActivity implements MvpView {

    @Inject
    NavigatorHolder navigatorHolder;

    @Inject
    Router router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        App.getComponent().inject(this);
        router.newRootScreen(Screens.MODES_SCREEN);
    }

    private Navigator navigator = new SupportFragmentNavigator(getSupportFragmentManager(), R.id.main_container) {

        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            switch (screenKey) {
                case Screens.MODES_SCREEN:
                    return new ModesFragment();
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
}
