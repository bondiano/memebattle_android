package com.mrswimmer.membattle.di;

import com.mrswimmer.membattle.di.module.APIModule;
import com.mrswimmer.membattle.di.module.NavigatorModule;
import com.mrswimmer.membattle.presentation.auth.activity.AuthActivity;
import com.mrswimmer.membattle.presentation.auth.fragment.sign_in.SignInFragmentPresenter;
import com.mrswimmer.membattle.presentation.auth.fragment.sign_up.SignUpFragmentPresenter;
import com.mrswimmer.membattle.presentation.game.activity.GameActivity;
import com.mrswimmer.membattle.presentation.game.activity.GameActivityPresenter;
import com.mrswimmer.membattle.presentation.game.fragment.GameFragment;
import com.mrswimmer.membattle.presentation.game.fragment.GameFragmentPresenter;
import com.mrswimmer.membattle.presentation.main.activity.MainActivity;
import com.mrswimmer.membattle.presentation.main.activity.MainActivityPresenter;
import com.mrswimmer.membattle.presentation.main.fragment.modes.ModesFragment;
import com.mrswimmer.membattle.presentation.main.fragment.modes.ModesFragmentPresenter;
import com.mrswimmer.membattle.presentation.main.fragment.rate.RateFragment;
import com.mrswimmer.membattle.presentation.main.fragment.rate.RateFragmentPresenter;
import com.mrswimmer.membattle.presentation.main.fragment.settings.SettingsFragmentPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NavigatorModule.class, APIModule.class})
public interface AppComponent {
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
}
