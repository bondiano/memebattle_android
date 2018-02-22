package com.mrswimmer.memebattle.presentation.main.fragment.rate;

import android.graphics.Color;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mrswimmer.memebattle.App;
import com.mrswimmer.memebattle.R;
import com.mrswimmer.memebattle.data.item.Mode;

import java.util.ArrayList;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class RateFragmentPresenter extends MvpPresenter<RateFragmentView> {
    @Inject
    Router router;

    public RateFragmentPresenter() {
        App.getComponent().inject(this);
    }

    public void setAdapter() {
        /*ArrayList<Mode> modes = new ArrayList<>();
        modes.add(new Mode(R.drawable.ng, "Новогодний баттл", 0, 0, Color.WHITE));
        modes.add(new Mode(R.drawable.ng, "Новогодний баттл2", 0, 0, Color.WHITE));*/
        getViewState().initAdapter(modes);
    }

    public
}
