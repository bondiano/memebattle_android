package com.mrswimmer.membattle.presentation.auth.fragment.sign_in;

import com.arellomobile.mvp.MvpView;

interface SignInFragmentView extends MvpView {
    public void showErrorToast(String error);
}
