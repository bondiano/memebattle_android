package com.mrswimmer.memebattle.presentation.main.fragment.modes;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.mrswimmer.memebattle.App;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class ModesFragmentPresenter extends MvpPresenter<ModesFragmentView> {
    @Inject
    Router router;

    public ModesFragmentPresenter() {
        App.getComponent().inject(this);
    }


}
