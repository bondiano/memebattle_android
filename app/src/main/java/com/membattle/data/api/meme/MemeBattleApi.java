package com.membattle.data.api.meme;

import com.membattle.data.api.meme.model.req.Id;
import com.membattle.data.api.meme.model.req.RegistrationUser;
import com.membattle.data.api.meme.model.req.Secret;
import com.membattle.data.api.meme.model.res.UserResponse;
import com.membattle.data.api.meme.model.res.rate.Rate;
import com.membattle.data.api.meme.model.res.ValidToken;

import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import rx.Observable;

public interface MemeBattleApi {
    @POST("auth/signup")
    Observable<UserResponse> signUp(@Body RegistrationUser user);
    @POST("auth/login")
    Observable<UserResponse> signIn(@Body RegistrationUser user);
    @POST("auth/refresh-token")
    Observable<UserResponse> refreshToken(@Header("Authorization") String secret, @Body Secret refreshTok);
    @POST("game/rating")
    Observable<Rate> getRateList(@Header("Authorization") String secret, @Body Id id);
    @GET("auth/secret")
    Observable<ValidToken> getsecret(@Header("Authorization") String secret);
}