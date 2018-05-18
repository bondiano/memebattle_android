package com.membattle.presentation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.github.nkzawa.socketio.client.Socket;
import com.membattle.App;
import com.membattle.di.qualifier.Local;
import com.membattle.domain.service.SocketService;
import com.membattle.domain.utils.SocketListener;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnPageChange;

public abstract class BaseFragment extends MvpAppCompatFragment implements BaseView {

    @Inject
    SocketService socketService;

    @Override
    public void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        injectDependencies();
        return inflater.inflate(getLayoutID(), container, false);
    }

    protected abstract void injectDependencies();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void showDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("ОК",
                        (dialog, id) -> dialog.cancel());
        AlertDialog alert = builder.create();
        alert.show();
    }

    protected abstract int getLayoutID();

    @Override
    public void onResume() {
        super.onResume();
        if (SocketListener.class.isAssignableFrom(getClass())) {
            EventBus.getDefault().register(this);
            socketService.connect();
            //EventBus.getDefault().post("connect");
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (SocketListener.class.isAssignableFrom(getClass())) {
            //EventBus.getDefault().post("disconnect");
            socketService.close();
            EventBus.getDefault().unregister(this);
        }
    }
}
