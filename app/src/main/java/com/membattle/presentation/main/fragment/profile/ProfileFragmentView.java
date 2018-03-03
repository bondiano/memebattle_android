package com.membattle.presentation.main.fragment.profile;

import com.arellomobile.mvp.MvpView;

public interface ProfileFragmentView extends MvpView {
    void setFields(String username, String coins);
}
