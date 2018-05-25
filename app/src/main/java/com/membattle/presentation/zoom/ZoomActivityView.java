package com.membattle.presentation.zoom;

import com.arellomobile.mvp.MvpView;
import com.membattle.presentation.base.BaseView;

interface ZoomActivityView extends MvpView {
    void successDownloadImage();

    void errorDownloadImage();

}
