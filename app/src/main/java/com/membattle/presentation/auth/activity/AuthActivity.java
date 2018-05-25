package com.membattle.presentation.auth.activity;

import android.content.Intent;
import android.util.Log;

import com.membattle.App;
import com.membattle.R;
import com.membattle.data.api.vk.model.res.profile_info.ProfileInfo;
import com.membattle.domain.interactor.VkAPIService;
import com.membattle.presentation.base.BaseActivity;
import com.membattle.data.settings.Screens;
import com.membattle.di.qualifier.Local;
import com.vk.sdk.VKAccessToken;
import com.vk.sdk.VKCallback;
import com.vk.sdk.VKSdk;
import com.vk.sdk.api.VKApi;
import com.vk.sdk.api.VKError;
import com.vk.sdk.api.VKRequest;

import javax.inject.Inject;

import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

public class AuthActivity extends BaseActivity {

    @Inject
    @Local
    NavigatorHolder mNavigatorHolder;

    @Inject
    @Local
    Router router;

    @Inject
    VkAPIService vkAPIService;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_auth;
    }

    @Override
    protected int getContainerId() {
        return Screens.CONTAINER_AUTH;
    }

    @Override
    protected void injectDependencies() {
        App.getComponent().inject(this);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.i("code", "onRes " + resultCode + " " + data);
        if (!VKSdk.onActivityResult(requestCode, resultCode, data, new VKCallback<VKAccessToken>() {
            @Override
            public void onResult(VKAccessToken res) {
                Log.i("code", "success " + res.accessToken);
                VKRequest user = VKApi.users().get();
                //Log.i("code", "success user " + user.toString());

                vkAPIService.getProfileInfo(res.accessToken, new VkAPIService.ProfileInfoCallback() {
                    @Override
                    public void onSuccess(ProfileInfo profileInfo) {
                        Log.i("code", "success prInfo " + profileInfo.getResponse().getFirst_name());
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.i("code", "error prInfo " + e.getMessage());
                    }
                });
            }

            @Override
            public void onError(VKError error) {
                Log.i("code", "error " + error.errorMessage);

            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
