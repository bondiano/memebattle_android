package com.membattle.presentation.main.fragment.settings;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AlertDialog;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.membattle.App;
import com.membattle.di.qualifier.Local;
import com.membattle.domain.interactor.APIService;
import com.membattle.domain.interactor.SettingsService;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class SettingsFragmentPresenter extends MvpPresenter<SettingsFragmentView> {
    @Inject
    @Local
    Router router;

    @Inject
    APIService APIService;
    @Inject
    SettingsService settingsService;
    public SettingsFragmentPresenter() {
        App.getComponent().inject(this);
    }

    public void share() {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");
        i.putExtra(Intent.EXTRA_TEXT, "Присоединяйтесь к mems.fun!");
        i.putExtra(Intent.EXTRA_SUBJECT, "Поделиться");
        i = Intent.createChooser(i, "С помощью");
        getViewState().gotoActivity(i);
    }

    public void setMark() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=com.membattle"));
        getViewState().gotoActivity(intent);
    }

    public void aboutVersion() {
        getViewState().showDia(1);
    }

    public void clearPrefs() {
        settingsService.signOut();
        getViewState().gotoAuthActivity();
    }

    public void signOut() {
        getViewState().showDia(0);
    }

    public void setSignOutBuilder(AlertDialog.Builder builder) {
        builder.setTitle("Выход из аккаунта")
                .setMessage("Вы действительно хотите выйти из аккаунта?")
                .setPositiveButton("Да", (dialog, which) -> {
                    clearPrefs();
                }).setNegativeButton("Нет", (dialog, which) -> dialog.cancel());
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    public void setAboutVersionBuilder(AlertDialog.Builder builder) {
        builder.setTitle("О версии")
                .setMessage("Что нового?\nНовый интерфейс, исправление ошибок, добавление новых\nЧто ожидать в следующих версиях?\nМоре товаров в нашем Мемагазине, чтобы вы могли тратить свои мемоины!")
                .setPositiveButton("Неплохо", (dialog, which) -> dialog.cancel());
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}
