package com.mrswimmer.memebattle.di;

import com.mrswimmer.memebattle.di.module.APIModule;
import com.mrswimmer.memebattle.di.module.NavigatorModule;
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
}
