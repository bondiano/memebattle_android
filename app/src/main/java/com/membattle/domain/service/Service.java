package com.membattle.domain.service;

import com.membattle.data.api.API;
import com.membattle.data.api.req.Id;
import com.membattle.data.api.req.RegistrationUser;
import com.membattle.data.api.req.Secret;
import com.membattle.data.api.res.Exres;
import com.membattle.data.api.res.rate.Rate;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class Service {
    private final API api;

    public Service(API api) {
        this.api = api;
    }

    public Subscription signIn(RegistrationUser registrationUser, final AuthCallback callback) {
        return api.signIn(registrationUser)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess, callback::onError);
    }

    public Subscription signUp(RegistrationUser registrationUser, final AuthCallback callback) {
        return api.signUp(registrationUser)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess, callback::onError);
    }

    public interface AuthCallback {
        void onSuccess(Exres exres);
        void onError(Throwable e);
    }

    public Subscription getRateList(String secret, Id id, final RateCallback callback) {
        return api.getRateList(secret, id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess, callback::onError);
    }

    public interface RateCallback {
        void onSuccess(Rate rate);
        void onError(Throwable e);
    }

    public Subscription refreshToken(String secret, Secret refreshToken, final AuthCallback callback) {
        return api.refreshToken(secret, refreshToken)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess, callback::onError);
    }
}