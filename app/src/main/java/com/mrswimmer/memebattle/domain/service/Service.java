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

    public Subscription registration(RegistrationUser registrationUser, final RegistrationCallback callback) {
        return api.auth(registrationUser)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess
                        /*new Subscriber<Exres>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(Exres exres) {
                        callback.onSuccess(exres);
                    }
                }*/);
    }

    public interface RegistrationCallback {
        void onSuccess(Exres exres);
    }
}