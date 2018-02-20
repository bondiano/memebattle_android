package com.mrswimmer.memebattle.presentation.auth.fragment.sign_in;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;

public class SignInFragment extends MvpAppCompatFragment implements SignInFragmentView {
    @InjectPresenter
    SignInFragmentPresenter presenter;

}
