package com.membattle.presentation.screen.main.fragment.settings;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.membattle.R;
import com.membattle.domain.dialog.DialogFactory;
import com.membattle.domain.utils.SocketListener;
import com.membattle.presentation.screen.auth.activity.AuthActivity;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsFragment extends MvpAppCompatFragment implements SettingsFragmentView, SocketListener{

    DialogFactory factory;

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
        factory = new DialogFactory(getActivity());
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.settings_sign_out)
    void onSignOutClick() {
        //presenter.signOut();
        factory.createChooseDialog("Выход", "Вы действительно хотите выйти из аккаунта?");
    }

    @OnClick(R.id.settings_about_v)
    void onAboutVersionClick() {
        //presenter.aboutVersion();
        factory.createInfoDialog("О версии", "Что нового?\nНовый интерфейс, исправление ошибок, добавление новых\nЧто ожидать в следующих версиях?\nМоре товаров в нашем Мемагазине, чтобы вы могли тратить свои мемоины!");
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
    public void gotoAuthActivity() {
        Intent intent = new Intent(getContext(), AuthActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    /*@Override
    public void showDia(int id) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        switch (id) {
            case 0 :
                presenter.setSignOutBuilder(builder); break;
            case 1 :
                presenter.setAboutVersionBuilder(builder); break;
        }
    }*/

    @Override
    public void gotoActivity(Intent intent) {
        startActivity(intent);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onStringEvent(String pairMem) {
        Log.i("code", "onSettings " + pairMem);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onIntEvent(int pairMem) {
        Log.i("code", "onSettings " + pairMem);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onBoolEvent(boolean pairMem) {
        Log.i("code", "onSettings " + pairMem);
    }
}
