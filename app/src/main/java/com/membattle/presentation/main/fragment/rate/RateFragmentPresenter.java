package com.membattle.presentation.main.fragment.rate;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.membattle.App;
import com.membattle.data.api.meme.model.req.Id;
import com.membattle.data.api.meme.model.req.Secret;
import com.membattle.data.api.meme.model.res.UserResponse;
import com.membattle.data.api.meme.model.res.rate.Rate;
import com.membattle.data.settings.Settings;
import com.membattle.domain.interactor.APIService;
import com.membattle.domain.interactor.SettingsService;
import com.membattle.presentation.main.fragment.rate.recycler.LineRate;

import java.util.ArrayList;

import javax.inject.Inject;

@InjectViewState
public class RateFragmentPresenter extends MvpPresenter<RateFragmentView> {
    @Inject
    APIService APIService;
    @Inject
    SettingsService settingsService;
    public RateFragmentPresenter() {
        App.getComponent().inject(this);
    }

    public void getRateList() {
        ArrayList<LineRate> lineRates = new ArrayList<>();
        String secret = settingsService.getTokenAccess();
        Id id = new Id(settingsService.getUserId());
        APIService.getRateList(Settings.HEADER + secret, id,  new APIService.RateCallback() {
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
                Log.i("code", e.getMessage());
                if(e.getMessage().equals("HTTP 401 Unauthorized")) {
                    refrechToken();
                }
                getViewState().showError();
            }
        });
    }

    private void refrechToken() {
        String refresh = settingsService.getTokenRefresh();
        Secret secret = new Secret(refresh);
        APIService.refreshToken(Settings.HEADER + refresh, secret, new APIService.AuthCallback() {
            @Override
            public void onSuccess(UserResponse userResponse) {
                Log.i("code", "refresh_success");
                settingsService.updateTokens(userResponse.getTokenRefresh(), userResponse.getTokenAccess());
                getRateList();
            }
            @Override
            public void onError(Throwable e) {
                Log.i("code", "refresh_error");
            }
        });
    }

}
