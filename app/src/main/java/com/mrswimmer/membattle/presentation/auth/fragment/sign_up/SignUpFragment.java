package com.mrswimmer.membattle.presentation.auth.fragment.sign_up;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.mrswimmer.membattle.R;
import com.mrswimmer.membattle.data.widget_plus.EditTextPlus;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpFragment extends MvpAppCompatFragment implements SignUpFragmentView {
    @InjectPresenter
    SignUpFragmentPresenter presenter;

    @ProvidePresenter
    public SignUpFragmentPresenter presenter() {
        return new SignUpFragmentPresenter();
    }

    @BindViews({R.id.sign_up_login, R.id.sign_up_mail, R.id.sign_up_pass, R.id.sign_up_repeat_pass})
    List<EditTextPlus> edits;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.sign_up_reg)
    void onRegClick() {
        presenter.registration(edits);
    }

    @OnClick(R.id.sign_up_button_back)
    void onBackClick() {
        presenter.backToSignIn();
    }

    @Override
    public void showErrorToast(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }
}
