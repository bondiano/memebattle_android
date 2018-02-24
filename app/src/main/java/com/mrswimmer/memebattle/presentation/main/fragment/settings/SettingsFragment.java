package com.mrswimmer.memebattle.presentation.main.fragment.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.mrswimmer.memebattle.R;
import com.mrswimmer.memebattle.data.widget_plus.EditTextPlus;
import com.mrswimmer.memebattle.data.widget_plus.TextViewPlus;
import com.mrswimmer.memebattle.presentation.auth.activity.AuthActivity;

import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsFragment extends MvpAppCompatFragment implements SettingsFragmentView {
    @InjectPresenter
    SettingsFragmentPresenter presenter;

    @ProvidePresenter
    public SettingsFragmentPresenter presenter() {
        return new SettingsFragmentPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.settings_sign_out)
    void onSignOutClick() {
        presenter.showDia();
    }

    @OnClick(R.id.settings_about_v)
    void onAboutVersionClick() {
        presenter.aboutVersion();
    }

    @OnClick(R.id.settings_mark)
    void onMarkClick() {
        presenter.setMark();
    }

    @OnClick(R.id.settings_share)
    void onShareClick() {
        presenter.share();
    }

    @Override
    public void showErrorToast(String error) {
        Toast.makeText(getContext(), error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void signOut() {
        Intent intent = new Intent(getContext(), AuthActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void showDia() {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        presenter.setBuilder(builder);
    }

    @Override
    public void setMark(Intent intent) {
        startActivity(intent);
    }
}
