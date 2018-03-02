package com.membattle.presentation.game.fragment.zoom;

import com.arellomobile.mvp.MvpPresenter;
import com.membattle.App;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

public class ZoomFragmentPresenter extends MvpPresenter<ZoomFragmentView> {
    @Inject
    Router router;

    public ZoomFragmentPresenter() {
        App.getComponent().inject(this);
    }


}
