package com.membattle.presentation.main.fragment.profile;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.membattle.App;
import com.membattle.domain.interactor.SettingsService;

import javax.inject.Inject;

@InjectViewState
public class ProfileFragmentPresenter extends MvpPresenter<ProfileFragmentView> {
    @Inject
    SettingsService settingsService;

    public ProfileFragmentPresenter() {
        App.getComponent().inject(this);
    }

    public String[] getUrls() {
        String[] arrayList = new String[100];
        for (int i = 0; i < 6; i++) {
            arrayList[i] = "https://301-1.ru/gen-mems/img_mems/4a4c2a53661ede617bd7437b4e728cbb.jpg";
        }
        return arrayList;
    }

    public void setFields() {
        String username = settingsService.getUsername();
        String coins = settingsService.getCoins()+"";
        getViewState().setFields(username, coins);
    }

}
