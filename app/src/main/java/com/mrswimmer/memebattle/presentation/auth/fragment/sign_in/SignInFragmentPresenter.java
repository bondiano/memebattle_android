package com.mrswimmer.memebattle.presentation.auth.fragment.sign_in;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mrswimmer.memebattle.App;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class SignInFragmentPresenter extends MvpPresenter<SignInFragmentView> {
    @Inject
    Router router;

    public SignInFragmentPresenter() {
        App.getComponent().inject(this);
    }
}
