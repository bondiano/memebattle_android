package com.membattle.presentation.auth.fragment.sign_up;

import com.arellomobile.mvp.MvpView;

interface SignUpFragmentView extends MvpView {
    public void showErrorToast(String error);
}
