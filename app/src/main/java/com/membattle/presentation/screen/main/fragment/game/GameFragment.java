package com.membattle.presentation.screen.main.fragment.game;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.membattle.App;
import com.membattle.R;
import com.membattle.data.api.meme.model.res.game.PairMem.PairMem;
import com.membattle.data.settings.Screens;
import com.membattle.domain.utils.SocketListener;
import com.membattle.presentation.base.BaseActivity;
import com.membattle.presentation.base.BaseFragment;
import com.membattle.presentation.custom.widget_plus.TextViewPlus;
import com.squareup.picasso.Picasso;
import com.yandex.metrica.YandexMetrica;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.OnLongClick;

public class GameFragment extends BaseFragment implements GameFragmentView, SocketListener {
    //Socket socket = null;
    boolean canClickMem = true;
    boolean change = false;

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
    @BindView(R.id.game_progress)
    ProgressBar progressBar;

    @BindView(R.id.game_top_zoom)
    LinearLayout topZoom;
    @BindView(R.id.game_top_share)
    LinearLayout topShare;
    @BindView(R.id.game_top_download)
    LinearLayout topDownload;
    @BindView(R.id.game_top_prooral)
    LinearLayout topProoral;

    private Handler handler;
    int meme = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler = new Handler();
    }

    @ProvidePresenter
    public GameFragmentPresenter presenter() {
        return new GameFragmentPresenter();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if(savedInstanceState != null) {
            Log.i("code", "comeback game !null");
            resumeTick(savedInstanceState.getInt("time", 1500));
        } else {
            startTick();
            Log.i("code", "comeback meme null");
        }
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_game;
    }

    @OnClick(R.id.game_top_mem)
    void onTopMemClick() {
        meme = 1;
        startTick();
        showSnack("mem", v -> Log.i("code", "snack action"));
        YandexMetrica.reportEvent("topmemclick");
        Log.i("code", "topmem");
        presenter.emit();
        if (canClickMem) {
            canClickMem = false;
            //presenter.omMemClick(socket, 0);
            topLike.setVisibility(View.VISIBLE);
        }
    }

    @OnClick(R.id.game_bottom_mem)
    void onBottomMemClick() {
        if (canClickMem) {
            canClickMem = false;
            //presenter.omMemClick(socket, 1);
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
        handler.post(() -> {
            hideAfter();
            if (!firstPair) {
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

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(PairMem pairMem) {
        Log.i("code", "onGameFragment " + pairMem.toString());
    }

    void hideAfter() {
        topAfterLayout.setVisibility(View.INVISIBLE);
        bottomAfterLayout.setVisibility(View.INVISIBLE);
        topLike.setVisibility(View.INVISIBLE);
        bottomLike.setVisibility(View.INVISIBLE);
    }

    MemeTimer memeTimer;
    void startTick() {
        progressBar.setMax(15000);
        progressBar.setProgress(15000);
        memeTimer = new MemeTimer(15000, 10);
        memeTimer.start();
    }

    void resumeTick(int time) {
        progressBar.setMax(15000);
        progressBar.setProgress(time);
        memeTimer = new MemeTimer(time, 10);
        memeTimer.start();
    }

    @OnClick(R.id.game_top_zoom)
    void onTopZoomClick() {
        presenter.zoomMem(true);
    }

    @Override
    public void injectDependencies() {
        App.getComponent().inject(this);
    }

    public class MemeTimer extends CountDownTimer {

        public MemeTimer(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onFinish() {
            handler.post(() -> {
                if (change) {
                    topMem.setImageResource(R.drawable.meme1);
                    bottomMem.setImageResource(R.drawable.meme2);
                } else {
                    topMem.setImageResource(R.drawable.meme2);
                    bottomMem.setImageResource(R.drawable.meme1);
                }
                change = !change;
                startTick();
            });
        }

        public void onTick(long millisUntilFinished) {
            handler.post(() -> {
                Log.i("code", "millis " + millisUntilFinished);
                progressBar.setProgress((int) millisUntilFinished);
            });
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("time", progressBar.getProgress());
        Log.i("code", "save");
        memeTimer.cancel();
    }

    /*@Override
    public void onStop() {
        super.onStop();
        //Log.i("code", "stop");
        //memeTimer.cancel();
    }

    @Override
    public void onPause() {
        super.onPause();
        memeTimer.cancel();
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("code", "resume");
    }*/
}
