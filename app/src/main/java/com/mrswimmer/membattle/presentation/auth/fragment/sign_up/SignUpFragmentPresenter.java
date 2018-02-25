package com.mrswimmer.membattle.presentation.auth.fragment.sign_up;

import android.content.SharedPreferences;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mrswimmer.membattle.App;
import com.mrswimmer.membattle.data.api.req.RegistrationUser;
import com.mrswimmer.membattle.data.api.res.Exres;
import com.mrswimmer.membattle.data.widget_plus.EditTextPlus;
import com.mrswimmer.membattle.domain.service.Service;
import com.mrswimmer.membattle.data.settings.Screens;

import java.util.List;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class SignUpFragmentPresenter extends MvpPresenter<SignUpFragmentView> {
    @Inject
    Router router;

    @Inject
    Service service;

    public SignUpFragmentPresenter() {
        App.getComponent().inject(this);
    }

    public void registration(List<EditTextPlus> edits) {
        service.signUp(new RegistrationUser(edits.get(0).getText().toString(), edits.get(1).getText().toString(), edits.get(2).getText().toString()), new Service.AuthCallback() {
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
    }

    private void enter(List<EditTextPlus> edits) {
        service.signIn(new RegistrationUser(edits.get(0).getText().toString(), edits.get(1).getText().toString(), "lol"), new Service.AuthCallback() {
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
        SharedPreferences.Editor editor = App.settings.edit();
        editor.putString("token_access", exres.getToken_access());
        editor.putString("token_refresh", exres.getToken_refresh());
        editor.putString("username", exres.getUsername());
        editor.putInt("coins", Integer.parseInt(exres.getCoins()));
        editor.putInt("id", exres.get_id());
        editor.apply();
    }


}
