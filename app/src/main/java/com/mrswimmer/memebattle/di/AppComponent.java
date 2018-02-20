package com.mrswimmer.memebattle.di;

import com.mrswimmer.memebattle.di.module.APIModule;
import com.mrswimmer.memebattle.di.module.NavigatorModule;
import com.mrswimmer.memebattle.presentation.auth.activity.AuthActivity;
import com.mrswimmer.memebattle.presentation.auth.activity.AuthActivityPresenter;
import com.mrswimmer.memebattle.presentation.auth.fragment.sign_in.SignInFragmentPresenter;
import com.mrswimmer.memebattle.presentation.auth.fragment.sign_up.SignUpFragmentPresenter;
import com.mrswimmer.memebattle.presentation.main.activity.MainActivity;
import com.mrswimmer.memebattle.presentation.main.activity.MainActivityPresenter;
import com.mrswimmer.memebattle.presentation.main.fragment.modes.ModesFragment;
import com.mrswimmer.memebattle.presentation.main.fragment.modes.ModesFragmentPresenter;

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
    void inject(AuthActivityPresenter authActivityPresenter);
    void inject(SignInFragmentPresenter signInFragmentPresenter);
    void inject(SignUpFragmentPresenter signUpFragmentPresenter);
}
