package com.mrswimmer.memebattle.presentation.game.fragment;

import android.content.Intent;

import com.arellomobile.mvp.MvpView;

interface GameFragmentView extends MvpView {
    void showErrorToast(String error);

    void setMemes(String urlTop, String urlBottom);
}
