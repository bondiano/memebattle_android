package com.membattle.presentation.auth.activity;

import android.content.Intent;
import android.util.Log;

import com.membattle.App;
import com.membattle.R;
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
                Log.i("code", "success " + res.email);
                //VKRequest request =
// Пользователь успешно авторизовался
            }

            @Override
            public void onError(VKError error) {
                Log.i("code", "error " + error.errorMessage);
// Произошла ошибка авторизации (например, пользователь запретил авторизацию)
            }
        })) {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
