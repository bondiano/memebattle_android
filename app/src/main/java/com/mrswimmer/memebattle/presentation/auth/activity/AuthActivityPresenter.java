package com.mrswimmer.memebattle.presentation.auth.activity;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mrswimmer.memebattle.App;
import com.mrswimmer.memebattle.presentation.Screens;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class AuthActivityPresenter extends MvpPresenter<AuthActivityView> {
    @Inject
    Router router;

    public AuthActivityPresenter() {
        App.getComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        router.newRootScreen(Screens.SIGN_IN_SCREEN);
    }
}
