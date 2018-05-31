package com.membattle.presentation.screen.auth.fragment.sign_up;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.google.gson.Gson;
import com.membattle.App;
import com.membattle.data.api.meme.model.req.RegistrationUser;
import com.membattle.data.api.meme.model.res.UserResponse;
import com.membattle.di.qualifier.Local;
import com.membattle.domain.interactor.APIService;
import com.membattle.data.settings.Screens;
import com.membattle.domain.interactor.SettingsService;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class SignUpFragmentPresenter extends MvpPresenter<SignUpFragmentView> {
    @Inject
    @Local
    Router router;
    @Inject
    APIService APIService;
    @Inject
    SettingsService settingsService;

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
                settingsService.initUser(userResponse.getTokenAccess(), userResponse.getTokenRefresh(), userResponse.getUsername(), Integer.parseInt(userResponse.getCoins()), userResponse.getId());
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
}
