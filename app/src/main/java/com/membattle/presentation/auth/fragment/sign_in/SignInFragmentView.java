package com.membattle.presentation.auth.fragment.sign_in;

import com.arellomobile.mvp.MvpView;

interface SignInFragmentView extends MvpView {
    void showErrorToast(String error);
}
