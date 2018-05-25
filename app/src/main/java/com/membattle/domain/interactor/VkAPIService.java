package com.membattle.domain.interactor;

import com.membattle.data.api.vk.VkAPI;
import com.membattle.data.api.vk.model.res.profile_info.ProfileInfo;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class VkAPIService {
    private final VkAPI vkAPI;

    public VkAPIService(VkAPI vkAPI) {
        this.vkAPI = vkAPI;
    }

    public void getProfileInfo(String accessToken, ProfileInfoCallback callback) {
        vkAPI.getProfileInfo(accessToken, "6.0.2")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(callback::onSuccess, callback::onError);
    }

    public interface ProfileInfoCallback {
        void onSuccess(ProfileInfo profileInfo);

        void onError(Throwable e);
    }
}
