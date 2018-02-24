package com.mrswimmer.memebattle.presentation.game.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.mrswimmer.memebattle.R;
import com.mrswimmer.memebattle.data.api.req.RequestToGame;
import com.mrswimmer.memebattle.presentation.main.fragment.settings.SettingsFragmentPresenter;

import java.net.URISyntaxException;

import butterknife.ButterKnife;

public class GameFragment extends MvpAppCompatFragment implements GameFragmentView{
    Socket socket = null;

    @InjectPresenter
    GameFragmentPresenter presenter;

    @ProvidePresenter
    public GameFragmentPresenter presenter() {
        return new GameFragmentPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void showErrorToast(String error) {

    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            socket = IO.socket("https://api.mems.fun/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        socket.on(Socket.EVENT_CONNECT, args -> presenter.connectToGame(socket));
        socket.on("connect", presenter.onConnect);
        socket.on("action", presenter.onAction);
        socket.on("error", presenter.onError);
        socket.connect();
    }
}
