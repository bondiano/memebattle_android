package com.membattle.presentation.game.fragment.game;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.membattle.R;
import com.membattle.presentation.widget_plus.TextViewPlus;
import com.squareup.picasso.Picasso;
import java.net.URISyntaxException;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class GameFragment extends MvpAppCompatFragment implements GameFragmentView {
    Socket socket = null;
    boolean canClickMem = true;
    int zoom = 0;

    @InjectPresenter
    GameFragmentPresenter presenter;

    @BindView(R.id.game_top_mem)
    ImageView topMem;
    @BindView(R.id.game_bottom_mem)
    ImageView bottomMem;
    @BindView(R.id.game_top_like)
    ImageView topLike;
    @BindView(R.id.game_bottom_like)
    ImageView bottomLike;
    @BindView(R.id.game_top_after_layout)
    RelativeLayout topAfterLayout;
    @BindView(R.id.game_bottom_after_layout)
    RelativeLayout bottomAfterLayout;
    @BindView(R.id.game_top_after_status)
    TextViewPlus topAfterStatus;
    @BindView(R.id.game_bottom_after_status)
    TextViewPlus bottomAfterStatus;
    @BindView(R.id.game_top_after_likes)
    TextViewPlus topAfterLikes;
    @BindView(R.id.game_bottom_after_likes)
    TextViewPlus bottomAfterLikes;
    @BindView(R.id.game_chronometer)
    Chronometer chronometer;
    @BindView(R.id.game_timer)
    TextViewPlus timer;

    private Handler handler;
    private int tick = 15;

    @ProvidePresenter
    public GameFragmentPresenter presenter() {
        return new GameFragmentPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        handler = new Handler();
        return inflater.inflate(R.layout.fragment_game, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @OnClick(R.id.game_top_mem)
    void onTopMemClick() {
        Log.i("code", "topmem");
        if(canClickMem) {
            canClickMem = false;
            presenter.omMemClick(socket, 0);
            topLike.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.game_bottom_mem)
    void onBottomMemClick() {
        if(canClickMem) {
            canClickMem = false;
            presenter.omMemClick(socket, 1);
            bottomLike.setVisibility(View.VISIBLE);
        }
    }

    @OnLongClick(R.id.game_top_mem)
    boolean onTopMemLongClick() {

        presenter.zoomMem(true);
        return false;
    }

    @Override
    public void setMemes(String urlTop, String urlBottom, boolean firstPair) {
        canClickMem = true;
        handler.post(()->{
            hideAfter();
            if(!firstPair) {
                startTick();
            }
            Picasso.with(getActivity())
                    .load(urlTop)
                    .into(topMem);
            Picasso.with(getActivity())
                    .load(urlBottom)
                    .into(bottomMem);
        });
    }

    @Override
    public void showResult(String topLikes, String bottomLikes, String topStatus, String bottomStatus) {
        handler.post(() -> {
            topAfterLayout.setVisibility(View.VISIBLE);
            bottomAfterLayout.setVisibility(View.VISIBLE);
            topAfterLikes.setText(topLikes);
            bottomAfterLikes.setText(bottomLikes);
            topAfterStatus.setText(topStatus);
            bottomAfterStatus.setText(bottomStatus);
        });
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

    void hideAfter() {
        topAfterLayout.setVisibility(View.INVISIBLE);
        bottomAfterLayout.setVisibility(View.INVISIBLE);
        topLike.setVisibility(View.INVISIBLE);
        bottomLike.setVisibility(View.INVISIBLE);
    }

    void startTick() {
        chronometer.stop();
        timer.setText("15");
        chronometer.start();
        chronometer.setOnChronometerTickListener(chronometer -> {
            long elapsedMillis = SystemClock.elapsedRealtime()
                    - chronometer.getBase();
            if (elapsedMillis > 1000) {
                tick--;
                timer.setText(tick + "");
                elapsedMillis = 0;
                if (tick == 0) {
                    chronometer.stop();
                    tick = 15;//длина баттла
                }
            }
        });
    }
}
