package com.membattle.di;

import android.content.Context;

import com.membattle.presentation.base.BaseActivity;
import com.membattle.di.module.APIModule;
import com.membattle.di.module.NavigatorModule;
import com.membattle.di.module.SharedPreferencesModule;
import com.membattle.presentation.auth.activity.AuthActivity;
import com.membattle.presentation.auth.fragment.sign_in.SignInFragmentPresenter;
import com.membattle.presentation.auth.fragment.sign_up.SignUpFragmentPresenter;
import com.membattle.presentation.game.activity.GameActivity;
import com.membattle.presentation.game.activity.GameActivityPresenter;
import com.membattle.presentation.game.fragment.game.GameFragment;
import com.membattle.presentation.game.fragment.game.GameFragmentPresenter;
import com.membattle.presentation.game.fragment.zoom.ZoomFragmentPresenter;
import com.membattle.presentation.splash.SplashActivity;
import com.membattle.presentation.main.activity.MainActivity;
import com.membattle.presentation.main.activity.MainActivityPresenter;
import com.membattle.presentation.main.fragment.modes.ModesFragment;
import com.membattle.presentation.main.fragment.modes.ModesFragmentPresenter;
import com.membattle.presentation.main.fragment.modes.recycler.ModesAdapter;
import com.membattle.presentation.main.fragment.profile.ProfileFragmentPresenter;
import com.membattle.presentation.main.fragment.rate.RateFragment;
import com.membattle.presentation.main.fragment.rate.RateFragmentPresenter;
import com.membattle.presentation.main.fragment.settings.SettingsFragmentPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NavigatorModule.class, APIModule.class, SharedPreferencesModule.class})
public interface AppComponent {
    Context context();
    void inject(MainActivityPresenter mainActivityPresenter);
    void inject(MainActivity mainActivity);
    void inject(ModesFragment modesFragment);
    void inject(ModesFragmentPresenter modesFragmentPresenter);
    void inject(AuthActivity authActivity);
    void inject(SignInFragmentPresenter signInFragmentPresenter);
    void inject(SignUpFragmentPresenter signUpFragmentPresenter);
    void inject(GameActivity gameActivity);
    void inject(GameActivityPresenter gameActivityPresenter);
    void inject(RateFragment rateFragment);
    void inject(RateFragmentPresenter rateFragmentPresenter);
    void inject(SettingsFragmentPresenter settingsFragmentPresenter);
    void inject(GameFragmentPresenter gameFragmentPresenter);
    void inject(GameFragment gameFragment);
    void inject(ZoomFragmentPresenter zoomFragmentPresenter);
    void inject(ProfileFragmentPresenter profileFragmentPresenter);
    void inject(BaseActivity baseActivity);
    void inject(SplashActivity splashActivity);
    void inject(ModesAdapter modesAdapter);
}
