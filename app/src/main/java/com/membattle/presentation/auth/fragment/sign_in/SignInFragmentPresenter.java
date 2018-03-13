package com.membattle.presentation.auth.fragment.sign_in;

import android.content.SharedPreferences;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.membattle.App;
import com.membattle.data.api.req.RegistrationUser;
import com.membattle.data.api.res.Exres;
import com.membattle.presentation.widget_plus.EditTextPlus;
import com.membattle.domain.service.Service;
import com.membattle.data.settings.Screens;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class SignInFragmentPresenter extends MvpPresenter<SignInFragmentView> {
    @Inject
    Router router;

    @Inject
    Service service;

    @Inject
    SharedPreferences settings;

    public SignInFragmentPresenter() {
        App.getComponent().inject(this);
    }


    public void enter(EditTextPlus log, EditTextPlus pass) {
        service.signIn(new RegistrationUser(log.getText().toString(), pass.getText().toString(), "lol"), new Service.AuthCallback() {
            @Override
            public void onSuccess(Exres exres) {
                Log.i("code", exres.getSuccess()+"");
                saveSettings(exres);
                router.replaceScreen(Screens.MAIN_ACTIVITY);
            }

            @Override
            public void onError(Throwable e) {
                Log.i("code", e + "");
                getViewState().showErrorToast("Ошибка входа");
            }
        });
    }

    public void gotoReg() {
        router.navigateTo(Screens.SIGN_UP_SCREEN);
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
