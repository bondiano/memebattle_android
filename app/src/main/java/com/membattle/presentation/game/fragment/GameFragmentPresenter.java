package com.membattle.presentation.game.fragment;

import android.content.SharedPreferences;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Socket;
import com.google.gson.Gson;
import com.membattle.App;
import com.membattle.R;
import com.membattle.data.api.req.RequestToGame;
import com.membattle.data.api.res.coins.Coins;
import com.membattle.data.api.res.game.PairLikes.PairLikes;
import com.membattle.data.api.res.game.PairMem.PairMem;
import com.membattle.data.settings.Settings;
import com.membattle.domain.service.Service;
import com.membattle.presentation.game.activity.GameActivity;

import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

import static com.membattle.data.settings.Settings.ID;

@InjectViewState
public class GameFragmentPresenter extends MvpPresenter<GameFragmentView> {
    int USER_ID = App.settings.getInt(ID, 0);
    Gson gson = new Gson();
    @Inject
    Router router;

    @Inject
    Service service;

    public Emitter.Listener onConnect = args -> {
        try {
            Log.i("game", "onConnect " + args[0]);
        } catch (Exception e) {
            Log.i("game", "onConnect null");
        }
    };

    public Emitter.Listener onAction = args -> {
        Log.i("game", "onAction  " + args[0]);
        try {
            JSONObject jsonObject = (JSONObject) args[0];
            String type = jsonObject.getString("type");
            Log.i("game", "type " + type);
            switch (type) {
                case "@@ws/NEW_PAIR":
                    onSetMemes(args[0] + "", false);
                    break;
                case "@@ws/GET_MEM_PAIR_SUCCESS":
                    onSetMemes(args[0] + "", true);
                    break;
                case "@@ws/PAIR_WINNER":
                    onResult(args[0] + "");
                    break;
                case "@@ws/ADD_COIN":
                    onCoins(args[0] + "");
                    break;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    };

    private void onCoins(String args) {
        Coins coins = gson.fromJson(args, Coins.class);
        SharedPreferences.Editor editor = App.settings.edit();
        editor.putInt(Settings.COINS, Integer.parseInt(coins.getData().getCoins()));
        editor.apply();
    }

    private void onResult(String args) {
        PairLikes pairLikes = gson.fromJson(args, PairLikes.class);
        final int topLikes = Integer.parseInt(pairLikes.getData().getLeftLikes());
        final int bottomLikes = Integer.parseInt(pairLikes.getData().getRightLikes());
        String topStatus, bottomStatus;
        if(topLikes>bottomLikes) {
            topStatus = "Победитель";
            bottomStatus = "";
        } else if(topLikes < bottomLikes) {
            topStatus = "";
            bottomStatus = "Победитель";
        } else {
            topStatus = "";
            bottomStatus = "";
        }
        getViewState().showResult(topLikes + "", bottomLikes + "", topStatus, bottomStatus);
    }

    private void onSetMemes(String args, boolean firstPair) {
        PairMem pairMem = gson.fromJson(args, PairMem.class);
        String urlTop = pairMem.getData().getLeftMemeImg();
        String urlBottom = pairMem.getData().getRightMemeImg();
        getViewState().setMemes(urlTop, urlBottom, firstPair);
    }

    public Emitter.Listener onError = args -> Log.i("game", "onError  " + args[0]);

    public GameFragmentPresenter() {
        App.getComponent().inject(this);
    }

    public void connectToGame(Socket socket) {
        RequestToGame requestToGame = new RequestToGame(USER_ID, 0, 0, "@@ws/CONNECT_TO_GAME_REQUEST");
        String json = gson.toJson(requestToGame);
        socket.emit("action", json);
        RequestToGame requestToGame2 = new RequestToGame(USER_ID, 0, 0, "@@ws/GET_MEM_PAIR_REQUEST");
        String json2 = gson.toJson(requestToGame2);
        socket.emit("action", json2);
    }

    public void omMemClick(Socket socket, int right) {
        RequestToGame req = new RequestToGame(USER_ID, right, GameActivity.currentMode, "@@ws/CHOOSE_MEM_REQUEST");
        String j = gson.toJson(req);
        socket.emit("action", j);
    }

    public boolean zoomMem(int i) {
        return false;
    }
}
