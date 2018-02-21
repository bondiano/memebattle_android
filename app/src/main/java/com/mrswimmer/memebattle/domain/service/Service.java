package com.mrswimmer.memebattle.domain.service;


import com.mrswimmer.memebattle.data.api.API;
import com.mrswimmer.memebattle.data.api.req.RegistrationUser;
import com.mrswimmer.memebattle.data.api.res.Exres;

import rx.Subscriber;
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
}