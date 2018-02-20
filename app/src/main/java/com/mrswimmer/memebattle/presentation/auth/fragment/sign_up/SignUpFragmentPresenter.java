package com.mrswimmer.memebattle.presentation.auth.fragment.sign_up;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mrswimmer.memebattle.App;
import com.mrswimmer.memebattle.data.widget_plus.EditTextPlus;

import java.util.List;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class SignUpFragmentPresenter extends MvpPresenter<SignUpFragmentView> {
    @Inject
    Router router;

    public SignUpFragmentPresenter() {
        App.getComponent().inject(this);
    }

    public void registration(List<EditTextPlus> edits) {

    }
}
