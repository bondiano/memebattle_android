package com.mrswimmer.memebattle.presentation.auth.fragment.sign_in;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mrswimmer.memebattle.App;
import com.mrswimmer.memebattle.data.widget_plus.EditTextPlus;
import com.mrswimmer.memebattle.domain.service.Service;
import com.mrswimmer.memebattle.presentation.Screens;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class SignInFragmentPresenter extends MvpPresenter<SignInFragmentView> {
    @Inject
    Router router;

    public SignInFragmentPresenter() {
        App.getComponent().inject(this);
    }


    public void enter(EditTextPlus log, EditTextPlus pass) {

    }

    public void gotoReg() {
        router.navigateTo(Screens.SIGN_UP_SCREEN);
    }
}
