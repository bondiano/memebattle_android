package com.membattle.presentation.game.fragment.game;

import android.content.SharedPreferences;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Socket;
import com.google.gson.Gson;
import com.membattle.App;
import com.membattle.data.api.model.req.RequestToGame;
import com.membattle.data.api.model.res.coins.Coins;
import com.membattle.data.api.model.res.game.PairLikes.PairLikes;
import com.membattle.data.api.model.res.game.PairMem.PairMem;
import com.membattle.data.settings.Screens;
import com.membattle.data.settings.Settings;
import com.membattle.di.qualifier.Global;
import com.membattle.di.qualifier.Local;
import com.membattle.domain.service.APIService;
import com.membattle.domain.service.SettingsService;
import com.membattle.presentation.game.activity.GameActivity;

import org.json.JSONException;
import org.json.JSONObject;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

import static com.membattle.data.settings.Settings.ID;

@InjectViewState
public class GameFragmentPresenter extends MvpPresenter<GameFragmentView> {

    @Inject
    @Local
    Router router;
    @Inject
    @Global
    Router globalRouter;

    @Inject
    APIService APIService;
    @Inject
    SettingsService settingsService;

    int USER_ID;
    Gson gson = new Gson();
    String urlTop, urlBottom;
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
        settingsService.setCoins(Integer.parseInt(coins.getData().getCoins()));
    }

    private void onResult(String args) {
        PairLikes pairLikes = gson.fromJson(args, PairLikes.class);
        final int topLikes = Integer.parseInt(pairLikes.getData().getLeftLikes());
        final int bottomLikes = Integer.parseInt(pairLikes.getData().getRightLikes());
        String topStatus, bottomStatus;
        if (topLikes > bottomLikes) {
            topStatus = "Победитель";
            bottomStatus = "";
        } else if (topLikes < bottomLikes) {
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
        urlTop = pairMem.getData().getLeftMemeImg();
        urlBottom = pairMem.getData().getRightMemeImg();
        getViewState().setMemes(urlTop, urlBottom, firstPair);
    }

    public Emitter.Listener onError = args -> Log.i("game", "onError  " + args[0]);

    public GameFragmentPresenter() {
        App.getComponent().inject(this);
        USER_ID = s;
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

    void zoomMem(boolean top) {
        String stubURL = "https://sun1-3.userapi.com/c840537/v840537418/78c6c/-tQlZSiA1B0.jpg";
        if (top) {
            settingsService.setZoomImage(stubURL);
            globalRouter.navigateTo(Screens.ZOOM_SCREEN);
            //router.navigateTo(Screens.ZOOM_SCREEN, stubURL);
        }

        else
            router.navigateTo(Screens.ZOOM_SCREEN, urlBottom);
    }
}
