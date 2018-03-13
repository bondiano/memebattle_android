package com.membattle.presentation.main.fragment.profile;

import android.content.SharedPreferences;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.membattle.App;
import com.membattle.R;
import com.membattle.data.settings.Settings;

import java.util.ArrayList;

import javax.inject.Inject;

@InjectViewState
public class ProfileFragmentPresenter extends MvpPresenter<ProfileFragmentView> {
    @Inject
    SharedPreferences settings;
    public ProfileFragmentPresenter() {
        App.getComponent().inject(this);
    }

    public String[] getUrls() {
        String[] arrayList = new String[100];
        for(int i=0; i<6; i++) {
            arrayList[i]="https://301-1.ru/gen-mems/img_mems/4a4c2a53661ede617bd7437b4e728cbb.jpg";
        }
        return arrayList;
    }

    public void setFields() {
        String username = settings.getString(Settings.USERNAME, "guest");
        String coins = settings.getInt(Settings.COINS, 0)+"";
        getViewState().setFields(username, coins);
    }

}
