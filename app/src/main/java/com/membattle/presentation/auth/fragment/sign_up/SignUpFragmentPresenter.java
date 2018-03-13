package com.membattle.presentation.auth.fragment.sign_up;

import android.content.SharedPreferences;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.google.gson.Gson;
import com.membattle.App;
import com.membattle.data.api.req.RegistrationUser;
import com.membattle.data.api.res.Exres;
import com.membattle.presentation.widget_plus.EditTextPlus;
import com.membattle.domain.service.Service;
import com.membattle.data.settings.Screens;

import java.util.List;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class SignUpFragmentPresenter extends MvpPresenter<SignUpFragmentView> {
    @Inject
    Router router;
    @Inject
    Service service;
    @Inject
    SharedPreferences settings;
    private Gson gson = new Gson();

    public SignUpFragmentPresenter() {
        App.getComponent().inject(this);
    }

    public void registration(List<EditTextPlus> edits) {
        if(edits.get(2).getText().toString().equals(edits.get(3).getText().toString())) {
            RegistrationUser registrationUser = new RegistrationUser(edits.get(0).getText().toString(), edits.get(2).getText().toString(), edits.get(1).getText().toString());
            String json = gson.toJson(registrationUser);
            Log.i("code", json);
            service.signUp(registrationUser, new Service.AuthCallback() {
                @Override
                public void onSuccess(Exres exres) {
                    Log.i("code", exres.getSuccess()+"");
                    enter(edits);
                }

                @Override
                public void onError(Throwable e) {
                    Log.i("code", e + "");
                    getViewState().showErrorToast("Ошибка регистрации");
                }
            });
        } else {
            getViewState().showErrorToast("Пароли должны совпадать!");
        }
    }

    private void enter(List<EditTextPlus> edits) {
        service.signIn(new RegistrationUser(edits.get(0).getText().toString(), edits.get(2).getText().toString(), "lol"), new Service.AuthCallback() {
            @Override
            public void onSuccess(Exres exres) {
                Log.i("code", exres.getSuccess()+"");
                saveSettings(exres);
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

    public void saveSettings(Exres exres) {
        SharedPreferences.Editor editor = settings.edit();
        editor.putString("token_access", exres.getToken_access());
        editor.putString("token_refresh", exres.getToken_refresh());
        editor.putString("username", exres.getUsername());
        editor.putInt("coins", Integer.parseInt(exres.getCoins()));
        editor.putInt("id", exres.get_id());
        editor.apply();
    }


}
