package com.membattle.di.module;

import com.membattle.data.api.MemeBattleApi;
import com.membattle.domain.service.APIService;

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
    public MemeBattleApi providesNetworkService(
            Retrofit retrofit) {
        return retrofit.create(MemeBattleApi.class);
    }
    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public APIService providesService(
            MemeBattleApi networkService) {
        return new APIService(networkService);
    }

}
