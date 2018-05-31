package com.membattle.di;

import android.content.Context;

import com.membattle.di.module.SocketModule;
import com.membattle.presentation.base.BaseActivity;
import com.membattle.di.module.APIModule;
import com.membattle.di.module.NavigatorModule;
import com.membattle.di.module.SharedPreferencesModule;
import com.membattle.presentation.screen.auth.activity.AuthActivity;
import com.membattle.presentation.screen.auth.fragment.sign_in.SignInFragmentPresenter;
import com.membattle.presentation.screen.auth.fragment.sign_up.SignUpFragmentPresenter;
import com.membattle.presentation.screen.main.fragment.game.GameFragment;
import com.membattle.presentation.screen.main.fragment.game.GameFragmentPresenter;
import com.membattle.presentation.screen.main.fragment.game.zoom.ZoomActivity;
import com.membattle.presentation.screen.main.fragment.game.zoom.ZoomActivityPresenter;
import com.membattle.presentation.screen.main.fragment.info.InfoFragment;
import com.membattle.presentation.screen.splash.SplashActivity;
import com.membattle.presentation.screen.main.activity.MainActivity;
import com.membattle.presentation.screen.main.activity.MainActivityPresenter;
import com.membattle.presentation.screen.main.fragment.modes.ModesFragment;
import com.membattle.presentation.screen.main.fragment.modes.ModesFragmentPresenter;
import com.membattle.presentation.screen.main.fragment.modes.recycler.ModesAdapter;
import com.membattle.presentation.screen.main.fragment.profile.ProfileFragmentPresenter;
import com.membattle.presentation.screen.main.fragment.rate.RateFragment;
import com.membattle.presentation.screen.main.fragment.rate.RateFragmentPresenter;
import com.membattle.presentation.screen.main.fragment.settings.SettingsFragmentPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NavigatorModule.class, APIModule.class, SharedPreferencesModule.class, SocketModule.class})
public interface AppComponent {
    Context context();

    void inject(MainActivityPresenter mainActivityPresenter);

    void inject(MainActivity mainActivity);

    void inject(ModesFragment modesFragment);

    void inject(ModesFragmentPresenter modesFragmentPresenter);

    void inject(AuthActivity authActivity);

    void inject(SignInFragmentPresenter signInFragmentPresenter);

    void inject(SignUpFragmentPresenter signUpFragmentPresenter);

    void inject(RateFragment rateFragment);

    void inject(RateFragmentPresenter rateFragmentPresenter);

    void inject(SettingsFragmentPresenter settingsFragmentPresenter);

    void inject(GameFragmentPresenter gameFragmentPresenter);

    void inject(GameFragment gameFragment);

    void inject(ProfileFragmentPresenter profileFragmentPresenter);

    void inject(BaseActivity baseActivity);

    void inject(SplashActivity splashActivity);

    void inject(ModesAdapter modesAdapter);

    void inject(ZoomActivity zoomActivity);

    void inject(ZoomActivityPresenter zoomActivityPresenter);

    void inject(InfoFragment infoFragment);
}
