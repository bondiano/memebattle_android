package com.mrswimmer.memebattle.presentation.game.fragment;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.google.gson.Gson;
import com.mrswimmer.memebattle.App;
import com.mrswimmer.memebattle.data.api.req.RequestToGame;
import com.mrswimmer.memebattle.data.settings.Settings;
import com.mrswimmer.memebattle.domain.service.Service;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URISyntaxException;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class GameFragmentPresenter extends MvpPresenter<GameFragmentView> {
    int USER_ID;
    Gson gson;
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
            String type = getJsonFromArgs(args[0]).getString("type");
            Log.i("game", "type " + type);
            switch (type) {
                case "@@ws/NEW_PAIR":
                    onSetMemes(args[0] + "");
                    break;
                case "@@ws/GET_MEM_PAIR_SUCCESS":
                    onSetMemesOnly(args[0] + "");
                    break;
                case "@@ws/PAIR_WINNER":
                    showlikes(args[0] + "");
                    break;
                case "@@ws/ADD_COIN":
                    addCoins(args[0] + "");
                    break;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    };

    private void onSetMemes(String s) {

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

    JSONObject getJsonFromArgs(Object... args) {
        JSONObject jsonObject = null;
        try {
            jsonObject = new JSONObject(String.valueOf(args[0]));
            Log.i("code", "json: " + jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }
}
