package com.membattle.presentation.main.fragment.profile;

import com.arellomobile.mvp.MvpView;
import com.membattle.presentation.main.fragment.profile.recycler.StatMode;

import java.util.ArrayList;

public interface ProfileFragmentView extends MvpView {
    void setFields(String username, String coins);

}
