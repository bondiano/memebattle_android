package com.mrswimmer.memebattle.presentation.game.fragment;

import android.content.SharedPreferences;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.google.gson.Gson;
import com.mrswimmer.memebattle.App;
import com.mrswimmer.memebattle.data.api.req.RequestToGame;
import com.mrswimmer.memebattle.data.api.res.coins.Coins;
import com.mrswimmer.memebattle.data.api.res.game.PairLikes.PairLikes;
import com.mrswimmer.memebattle.data.api.res.game.PairMem.PairMem;
import com.mrswimmer.memebattle.data.settings.Settings;
import com.mrswimmer.memebattle.domain.service.Service;
import com.mrswimmer.memebattle.presentation.game.activity.GameActivity;
import com.mrswimmer.memebattle.presentation.main.activity.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

import static com.mrswimmer.memebattle.data.settings.Settings.ID;
import static com.mrswimmer.memebattle.data.settings.Settings.TAG;

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
}
