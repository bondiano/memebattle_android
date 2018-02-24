package com.mrswimmer.memebattle.presentation.main.fragment.settings;

import android.content.Intent;

import com.arellomobile.mvp.MvpView;

interface SettingsFragmentView extends MvpView {
    void showErrorToast(String error);
    void signOut();
    void showDia();
    void setMark(Intent intent);
}
