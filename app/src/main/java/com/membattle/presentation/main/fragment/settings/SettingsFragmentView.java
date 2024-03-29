package com.membattle.presentation.main.fragment.settings;

import android.content.Intent;

import com.arellomobile.mvp.MvpView;

interface SettingsFragmentView extends MvpView {
    void showErrorToast(String error);
    void gotoAuthActivity();
    void showDia(int id);
    void gotoActivity(Intent intent);
}
