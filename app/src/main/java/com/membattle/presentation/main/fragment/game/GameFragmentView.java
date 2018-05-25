package com.membattle.presentation.main.fragment.game;

import com.arellomobile.mvp.MvpView;

interface GameFragmentView extends MvpView {
    void setMemes(String urlTop, String urlBottom, boolean firstPair);
    void showResult(String topLikes, String bottomLikes, String topStatus, String bottomStatus);
}
