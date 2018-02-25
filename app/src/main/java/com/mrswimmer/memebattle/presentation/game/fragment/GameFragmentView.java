package com.mrswimmer.memebattle.presentation.game.fragment;

import com.arellomobile.mvp.MvpView;

interface GameFragmentView extends MvpView {
    void showErrorToast(String error);

    void setMemes(String urlTop, String urlBottom, boolean firstPair);

    void showResult(String topLikes, String bottomLikes, String topStatus, String bottomStatus);
}
