package com.mrswimmer.memebattle.presentation.game.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.mrswimmer.memebattle.R;
import com.mrswimmer.memebattle.domain.service.Service;
import com.squareup.picasso.Picasso;
import java.net.URISyntaxException;
import javax.inject.Inject;
import butterknife.BindView;
import butterknife.ButterKnife;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class GameFragment extends MvpAppCompatFragment implements GameFragmentView {
    Socket socket = null;

    @Inject
    Service service;

    @InjectPresenter
    GameFragmentPresenter presenter;

    @BindView(R.id.game_top_mem)
    ImageView topMem;
    @BindView(R.id.game_bottom_mem)
    ImageView bottomMem;

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
    public void setMemes(String urlTop, String urlBottom) {
        Observable.just(urlTop)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> Picasso.with(getActivity())
                        .load(s)
                        .placeholder(R.color.white)
                        .error(R.color.white)
                        .into(topMem));
        Observable.just(urlBottom)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s -> Picasso.with(getActivity())
                        .load(s)
                        .placeholder(R.color.white)
                        .error(R.color.white)
                        .into(bottomMem));
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

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        socket.close();
    }

    @Override
    public void onPause() {
        super.onPause();
        socket.close();
    }
}
