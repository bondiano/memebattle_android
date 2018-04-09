package com.membattle.presentation.base;

import com.arellomobile.mvp.MvpView;

public interface BaseView extends MvpView {
    public void showToast(String message);
    void showDialog(String title, String message);
}
