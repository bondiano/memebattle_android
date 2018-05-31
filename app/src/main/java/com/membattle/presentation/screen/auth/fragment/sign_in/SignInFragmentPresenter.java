package com.membattle.presentation.screen.auth.fragment.sign_in;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.membattle.App;
import com.membattle.di.qualifier.Global;
import com.membattle.di.qualifier.Local;
import com.membattle.domain.interactor.APIService;
import com.membattle.data.settings.Screens;
import com.membattle.domain.interactor.SettingsService;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class SignInFragmentPresenter extends MvpPresenter<SignInFragmentView> {
    @Inject
    @Local
    Router router;
    @Inject
    @Global
    Router globalRouter;

    @Inject
    APIService APIService;
    @Inject
    SettingsService settingsService;

    public SignInFragmentPresenter() {
        App.getComponent().inject(this);
    }


    public void enter(String log, String pass) {
        globalRouter.navigateTo(Screens.MAIN_ACTIVITY);
        /*APIService.signIn(new RegistrationUser(log, pass, "lol"), new APIService.AuthCallback() {
            @Override
            public void onSuccess(UserResponse userResponse) {
                Log.i("code", userResponse.getSuccess()+"");
        settingsService.initUser(userResponse.getTokenAccess(), userResponse.getTokenRefresh(), userResponse.getUsername(), userResponse.getCoins(), userResponse.getId());
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
}
