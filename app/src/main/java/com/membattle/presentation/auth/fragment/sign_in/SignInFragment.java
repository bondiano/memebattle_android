package com.membattle.presentation.auth.fragment.sign_in;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.membattle.R;
import com.membattle.presentation.widget_plus.EditTextPlus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInFragment extends MvpAppCompatFragment implements SignInFragmentView {
    @InjectPresenter
    SignInFragmentPresenter presenter;

    @ProvidePresenter
    public SignInFragmentPresenter presenter() {
        return new SignInFragmentPresenter();
    }

    @BindView(R.id.sign_in_login)
    EditTextPlus login;

    @BindView(R.id.sign_in_password)
    EditTextPlus password;

    String sUsername, sPassword;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.sign_in_button_enter)
    void onEnterClick() {
        sUsername = login.getText().toString();
        sPassword = password.getText().toString();
        sendData();
    }

    @OnClick(R.id.sign_in_button_goto_reg)
    void onGoToReg() {
        presenter.gotoReg();
    }

    @Override
    public void showErrorToast(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    void sendData() {
        if(checkOnFillingFields()) {
            presenter.enter(sUsername, sPassword);
        } else {
            showErrorToast("Заполните все поля!");
        }
    }
    boolean checkOnFillingFields() {
        if (sUsername.equals("") || sPassword.equals("")) {
            return false;
        }
        return true;
    }
}
