package com.mrswimmer.memebattle.presentation.main.fragment.settings;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mrswimmer.memebattle.App;
import com.mrswimmer.memebattle.data.api.req.RegistrationUser;
import com.mrswimmer.memebattle.data.api.res.Exres;
import com.mrswimmer.memebattle.data.settings.Screens;
import com.mrswimmer.memebattle.data.widget_plus.EditTextPlus;
import com.mrswimmer.memebattle.domain.service.Service;

import java.util.List;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class SettingsFragmentPresenter extends MvpPresenter<SettingsFragmentView> {
    @Inject
    Router router;

    @Inject
    Service service;

    public SettingsFragmentPresenter() {
        App.getComponent().inject(this);
    }

    public void share() {

    }

    public void setMark() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=com.membattle"));
        getViewState().setMark(intent);
    }

    public void aboutVersion() {

    }

    public void signOut() {
        SharedPreferences.Editor editor = App.settings.edit();
        editor.putString("username", "no");
        editor.apply();
        getViewState().signOut();
    }

    public void showDia() {
        getViewState().showDia();
    }

    public void setBuilder(AlertDialog.Builder builder) {
        builder.setTitle("Выход из аккаунта")
                .setMessage("Вы действительно хотите выйти из аккаунта?")
                .setPositiveButton("Да", (dialog, which) -> {
                    signOut();
                }).setNegativeButton("Нет", (dialog, which) -> dialog.cancel());
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
