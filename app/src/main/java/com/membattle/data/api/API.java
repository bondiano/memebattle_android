package com.membattle.data.api;

import com.membattle.data.api.req.Id;
import com.membattle.data.api.req.RegistrationUser;
import com.membattle.data.api.req.Secret;
import com.membattle.data.api.res.Exres;
import com.membattle.data.api.res.rate.Rate;
import com.membattle.data.api.res.ValidToken;

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
    Observable<Exres> refreshToken(@Header("Authorization") String secret, @Body Secret refreshTok);
    @POST("game/rating")
    Observable<Rate> getRateList(@Header("Authorization") String secret, @Body Id id);
    @GET("auth/secret")
    Observable<ValidToken> getsecret(@Header("Authorization") String secret);
}