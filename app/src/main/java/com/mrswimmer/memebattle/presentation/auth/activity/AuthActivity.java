package com.mrswimmer.memebattle.presentation.auth.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.mrswimmer.memebattle.App;
import com.mrswimmer.memebattle.R;
import com.mrswimmer.memebattle.presentation.Screens;
import com.mrswimmer.memebattle.presentation.auth.fragment.sign_in.SignInFragment;
import com.mrswimmer.memebattle.presentation.auth.fragment.sign_up.SignUpFragment;
import com.mrswimmer.memebattle.presentation.main.activity.MainActivity;

import javax.inject.Inject;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

public class AuthActivity extends AppCompatActivity {

    @Inject
    NavigatorHolder mNavigatorHolder;

    @Inject
    Router router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);
        App.getComponent().inject(this);
        router.newRootScreen(Screens.SIGN_IN_SCREEN);
    }

    private Navigator navigator = new SupportFragmentNavigator(getSupportFragmentManager(), R.id.auth_container) {

        @Override
        protected Fragment createFragment(String screenKey, Object data) {
            switch (screenKey) {
                case Screens.SIGN_IN_SCREEN :
                    return new SignInFragment();
                case Screens.SIGN_UP_SCREEN :
                    return new SignUpFragment();
                case Screens.MAIN_ACTIVITY :
                    Intent intent = new Intent(AuthActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    return null;
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
