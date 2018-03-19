package com.membattle.presentation.auth.fragment.sign_in;

import android.content.SharedPreferences;
import android.util.Log;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.membattle.App;
import com.membattle.data.api.model.req.RegistrationUser;
import com.membattle.data.api.model.res.UserResponse;
import com.membattle.domain.service.APIService;
import com.membattle.data.settings.Screens;
import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class SignInFragmentPresenter extends MvpPresenter<SignInFragmentView> {
    @Inject
    Router router;

    @Inject
    APIService APIService;

    @Inject
    SharedPreferences settings;

    public SignInFragmentPresenter() {
        App.getComponent().inject(this);
    }


    public void enter(String log, String pass) {
        router.replaceScreen(Screens.MAIN_ACTIVITY);
        /*APIService.signIn(new RegistrationUser(log, pass, "lol"), new APIService.AuthCallback() {
            @Override
            public void onSuccess(UserResponse userResponse) {
                Log.i("code", userResponse.getSuccess()+"");
                saveSettings(userResponse);
                router.replaceScreen(Screens.MAIN_ACTIVITY);
            }

            @Override
            public void onError(Throwable e) {
                Log.i("code", e + "");
                getViewState().showErrorToast("Ошибка входа");
            }
        });*/
    }

    public void gotoReg() {
        router.navigateTo(Screens.SIGN_UP_SCREEN);
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
