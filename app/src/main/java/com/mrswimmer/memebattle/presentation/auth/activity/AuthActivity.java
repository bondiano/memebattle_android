package com.mrswimmer.memebattle.presentation.auth.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.mrswimmer.memebattle.App;
import com.mrswimmer.memebattle.R;
import com.mrswimmer.memebattle.presentation.Screens;
import com.mrswimmer.memebattle.presentation.auth.fragment.sign_in.SignInFragment;
import com.mrswimmer.memebattle.presentation.auth.fragment.sign_up.SignUpFragment;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

public class AuthActivity extends MvpAppCompatActivity implements AuthActivityView {

    @InjectPresenter
    AuthActivityPresenter presenter;

    @Inject
    NavigatorHolder mNavigatorHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        App.getComponent().inject(this);
    }

    private Navigator navigator = new SupportFragmentNavigator(getSupportFragmentManager(), R.id.auth_container) {

        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            switch (screenKey) {
                case Screens.SIGN_IN_SCREEN :
                    return new SignInFragment();
                case Screens.SIGN_UP_SCREEN :
                    return new SignUpFragment();
                default:
                    return new SignInFragment();
            }
        }
        @Override
        protected void showSystemMessage(String message) {
            Toast.makeText(AuthActivity.this, message, Toast.LENGTH_SHORT).show();
        }

        @Override
        protected void exit() {
            finish();
        }
    };

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        mNavigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mNavigatorHolder.removeNavigator();
    }
}
