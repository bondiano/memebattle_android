package com.mrswimmer.memebattle.presentation.main.fragment.rate;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mrswimmer.memebattle.App;
import com.mrswimmer.memebattle.data.api.req.Id;
import com.mrswimmer.memebattle.data.api.res.rate.Rate;
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

    public void getRateList() {
        ArrayList<LineRate> lineRates = new ArrayList<>();
        String secret = App.settings.getString(Settings.TOKEN_ACCESS, "no");
        Id id = new Id(App.settings.getInt(Settings.ID, 0));
        Log.i("code", "req: " + Settings.HEADER + secret + " " + id.getId());
        service.getRateList(Settings.HEADER + secret, id,  new Service.RateCallback() {
            @Override
            public void onSuccess(Rate rate) {
                for (int i=0; i<rate.getGlobalRating().size(); i++) {
                    lineRates.add(new LineRate(rate.getGlobalRating().get(i).getUsername(), rate.getGlobalRating().get(i).getCoins(), i+1));
                }
                //Log.i("code", rate.getUserRating().getUsername()+"");
                if(rate.getUserRating().getRating()>10) {
                    lineRates.add(new LineRate("...", 1, 1));
                    lineRates.add(new LineRate(rate.getUserRating().getUsername(), rate.getUserRating().getCoins(), rate.getUserRating().getRating()));
                }
                getViewState().initAdapter(lineRates);
            }

            @Override
            public void onError(Throwable e) {
                Log.i("code", e+"");
                getViewState().showError();
            }
        });
    }
}
