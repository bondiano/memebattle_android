package com.mrswimmer.memebattle.data.api;

import com.mrswimmer.memebattle.data.api.req.Id;
import com.mrswimmer.memebattle.data.api.req.RegistrationUser;
import com.mrswimmer.memebattle.data.api.req.Secret;
import com.mrswimmer.memebattle.data.api.res.Exres;
import com.mrswimmer.memebattle.data.api.res.rate.Rate;
import com.mrswimmer.memebattle.data.api.res.ValidToken;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

public interface API {
    @POST("auth/signup")
    Observable<Exres> signUp(@Body RegistrationUser user);
    @POST("auth/login")
    Observable<Exres> signIn(@Body RegistrationUser user);
    @POST("auth/refresh-token")
    Observable<Exres> refresh(@Header("Authorization") String secret, @Body Secret refreshTok);
    @POST("icon_game/icon_rating")
    Observable<Rate> getrate(@Header("Authorization") String secret, @Body Id id);
    @GET("auth/secret")
    Observable<ValidToken> getsecret(@Header("Authorization") String secret);
}