package com.mrswimmer.membattle.di.module;

import com.mrswimmer.membattle.data.api.API;
import com.mrswimmer.membattle.domain.service.Service;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class APIModule {
    @Provides
    @Singleton
    Retrofit provideCall() {
        return new Retrofit.Builder()
                .baseUrl("https://api.mems.fun/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }
    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public API providesNetworkService(
            Retrofit retrofit) {
        return retrofit.create(API.class);
    }
    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public Service providesService(
            API networkService) {
        return new Service(networkService);
    }

}
