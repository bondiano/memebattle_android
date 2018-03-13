package com.membattle.presentation.auth.fragment.sign_up;

import android.content.SharedPreferences;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.google.gson.Gson;
import com.membattle.App;
import com.membattle.data.api.model.req.RegistrationUser;
import com.membattle.data.api.model.res.UserResponse;
import com.membattle.domain.service.APIService;
import com.membattle.presentation.widget_plus.EditTextPlus;
import com.membattle.data.settings.Screens;

import java.util.List;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class SignUpFragmentPresenter extends MvpPresenter<SignUpFragmentView> {
    @Inject
    Router router;
    @Inject
    APIService APIService;
    @Inject
    SharedPreferences settings;
    private Gson gson = new Gson();

    public SignUpFragmentPresenter() {
        App.getComponent().inject(this);
    }

    public void registration(String username, String password, String email) {
        RegistrationUser registrationUser = new RegistrationUser(username, password, email);
        String json = gson.toJson(registrationUser);
        Log.i("code", json);
        APIService.signUp(registrationUser, new APIService.AuthCallback() {
            @Override
            public void onSuccess(UserResponse userResponse) {
                enter(username, password);
            }

            @Override
            public void onError(Throwable e) {
                getViewState().showErrorToast("Ошибка регистрации");
            }
        });
    }

    private void enter(String username, String password) {
        APIService.signIn(new RegistrationUser(username, password, "lol"), new APIService.AuthCallback() {
            @Override
            public void onSuccess(UserResponse userResponse) {
                Log.i("code", userResponse.getSuccess() + "");
                saveSettings(userResponse);
                router.navigateTo(Screens.MAIN_ACTIVITY);
            }

            @Override
            public void onError(Throwable e) {
                Log.i("code", e + "");
                getViewState().showErrorToast("Ошибка входа");
            }
        });
    }

    public void backToSignIn() {
        router.backTo(Screens.SIGN_IN_SCREEN);
    }

    public void saveSettings(UserResponse userResponse) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("token_access", userResponse.getToken_access());
        editor.putString("token_refresh", userResponse.getToken_refresh());
        editor.putString("username", userResponse.getUsername());
        editor.putInt("coins", Integer.parseInt(userResponse.getCoins()));
        editor.putInt("id", userResponse.get_id());
        editor.apply();
    }


}
