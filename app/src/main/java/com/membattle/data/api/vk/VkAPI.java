package com.membattle.data.api.vk;

import com.membattle.data.api.vk.model.res.profile_info.ProfileInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface VkAPI {
    @GET("account.getProfileInfo")
    Observable<ProfileInfo> getProfileInfo(@Query("access_token") String token, @Query("v") String v);
}
