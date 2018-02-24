package com.mrswimmer.memebattle.di;

import com.mrswimmer.memebattle.di.module.APIModule;
import com.mrswimmer.memebattle.di.module.NavigatorModule;
import com.mrswimmer.memebattle.presentation.auth.activity.AuthActivity;
import com.mrswimmer.memebattle.presentation.auth.fragment.sign_in.SignInFragmentPresenter;
import com.mrswimmer.memebattle.presentation.auth.fragment.sign_up.SignUpFragmentPresenter;
import com.mrswimmer.memebattle.presentation.game.activity.GameActivity;
import com.mrswimmer.memebattle.presentation.game.activity.GameActivityPresenter;
import com.mrswimmer.memebattle.presentation.main.activity.MainActivity;
import com.mrswimmer.memebattle.presentation.main.activity.MainActivityPresenter;
import com.mrswimmer.memebattle.presentation.main.fragment.modes.ModesFragment;
import com.mrswimmer.memebattle.presentation.main.fragment.modes.ModesFragmentPresenter;
import com.mrswimmer.memebattle.presentation.main.fragment.rate.RateFragment;
import com.mrswimmer.memebattle.presentation.main.fragment.rate.RateFragmentPresenter;
import com.mrswimmer.memebattle.presentation.main.fragment.settings.SettingsFragmentPresenter;

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
}
