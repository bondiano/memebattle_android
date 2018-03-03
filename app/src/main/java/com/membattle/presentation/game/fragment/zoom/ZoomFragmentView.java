package com.membattle.presentation.game.fragment.zoom;

import android.app.DownloadManager;

import com.arellomobile.mvp.MvpView;
import com.squareup.picasso.Target;

public interface ZoomFragmentView extends MvpView{

    void successDownloadImage();

    void errorDownloadImage();
}
