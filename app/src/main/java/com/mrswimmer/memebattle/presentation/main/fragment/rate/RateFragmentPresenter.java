package com.mrswimmer.memebattle.presentation.main.fragment.rate;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mrswimmer.memebattle.App;
import com.mrswimmer.memebattle.data.settings.Settings;
import com.mrswimmer.memebattle.presentation.main.fragment.rate.recycler.LineRate;
import com.mrswimmer.memebattle.domain.service.Service;

import java.util.ArrayList;

import javax.inject.Inject;

@InjectViewState
public class RateFragmentPresenter extends MvpPresenter<RateFragmentView> {
    @Inject
    Service service;

    public RateFragmentPresenter() {
        App.getComponent().inject(this);
    }

    public void setAdapter() {
        ArrayList<LineRate> lineRates = new ArrayList<>();
        /*ArrayList<Mode> modes = new ArrayList<>();
        modes.add(new Mode(R.drawable.ng, "Новогодний баттл", 0, 0, Color.WHITE));
        modes.add(new Mode(R.drawable.ng, "Новогодний баттл2", 0, 0, Color.WHITE));*/
        getViewState().initAdapter(lineRates);
    }

    public ArrayList<LineRate> getRateList() {
        String secret = App.settings.getString(Settings.TOKEN_ACCESS, "no");
        int id = App.settings.getInt(Settings.ID, 0);

        service.getRateList()
    }
}
