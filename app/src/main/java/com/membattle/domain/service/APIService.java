package com.membattle.domain.service;

import com.membattle.data.api.MemeBattleApi;
import com.membattle.data.api.model.req.Id;
import com.membattle.data.api.model.req.RegistrationUser;
import com.membattle.data.api.model.req.Secret;
import com.membattle.data.api.model.res.UserResponse;
import com.membattle.data.api.model.res.rate.Rate;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class APIService {
    private final MemeBattleApi memeBattleApi;

    public APIService(MemeBattleApi memeBattleApi) {
        this.memeBattleApi = memeBattleApi;
    }

    public void signIn(RegistrationUser registrationUser, final AuthCallback callback) {
        memeBattleApi.signIn(registrationUser)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess, callback::onError);
    }

    public void signUp(RegistrationUser registrationUser, final AuthCallback callback) {
        memeBattleApi.signUp(registrationUser)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess, callback::onError);
    }

    public interface AuthCallback {
        void onSuccess(UserResponse userResponse);
        void onError(Throwable e);
    }

    public void getRateList(String secret, Id id, final RateCallback callback) {
        memeBattleApi.getRateList(secret, id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess, callback::onError);
    }

    public interface RateCallback {
        void onSuccess(Rate rate);
        void onError(Throwable e);
    }

    public void refreshToken(String secret, Secret refreshToken, final AuthCallback callback) {
        memeBattleApi.refreshToken(secret, refreshToken)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess, callback::onError);
    }
}