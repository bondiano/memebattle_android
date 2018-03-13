package com.membattle.presentation.auth.fragment.sign_up;

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

public class SignUpFragment extends MvpAppCompatFragment implements SignUpFragmentView {
    @InjectPresenter
    SignUpFragmentPresenter presenter;

    @ProvidePresenter
    public SignUpFragmentPresenter presenter() {
        return new SignUpFragmentPresenter();
    }

    @BindView(R.id.sign_up_login)
    EditTextPlus login;
    @BindView(R.id.sign_up_mail)
    EditTextPlus mail;
    @BindView(R.id.sign_up_pass)
    EditTextPlus password;
    @BindView(R.id.sign_up_repeat_pass)
    EditTextPlus repeatPassword;

    String sLogin, sMail, sPass, sRepeat;

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
        sLogin = login.getText().toString();
        sMail = mail.getText().toString();
        sPass = password.getText().toString();
        sRepeat = repeatPassword.getText().toString();
        sendData();
    }

    @OnClick(R.id.sign_up_button_back)
    void onBackClick() {
        presenter.backToSignIn();
    }

    @Override
    public void showErrorToast(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    void sendData() {
        if (checkOnFillingFields()) {
            if (checkEqualsPasswords()) {
                presenter.registration(sLogin, sPass, sMail);
            } else {
                showErrorToast("Пароли должны совпадать!");
            }
        } else {
            showErrorToast("Заполните все поля!");
        }
    }

    boolean checkEqualsPasswords() {
        if (sPass.equals(sRepeat)) {
            return true;
        }
        return false;
    }

    boolean checkOnFillingFields() {
        if (sLogin.equals("") || sPass.equals("") || sMail.equals("") || sRepeat.equals("")) {
            return false;
        }
        return true;
    }
}
