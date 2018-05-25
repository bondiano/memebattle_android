package com.membattle.di.module;

import com.membattle.data.api.meme.MemeBattleApi;
import com.membattle.data.api.vk.VkAPI;
import com.membattle.domain.interactor.APIService;
import com.membattle.domain.interactor.VkAPIService;

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
    @SuppressWarnings("unused")
    public APIService providesService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.mems.fun/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        MemeBattleApi memeBattleApi = retrofit.create(MemeBattleApi.class);
        return new APIService(memeBattleApi);
    }

    @Provides
    @Singleton
    @SuppressWarnings("unused")
    public VkAPIService providesServiceVk() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.vk.com/method/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        VkAPI vkApi = retrofit.create(VkAPI.class);
        return new VkAPIService(vkApi);
    }
}
