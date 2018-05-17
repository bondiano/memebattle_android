package com.membattle.domain.service;

import android.util.Log;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.google.gson.Gson;

import org.greenrobot.eventbus.EventBus;

public class SocketService {
    Socket socket;

    public SocketService(Socket socket) {
        this.socket = socket;
        connect();
    }

    void connect() {
        socket.on("connect", onConnect);
        socket.connect();
    }

    public Emitter.Listener onConnect = args -> {
        try {
            Log.i("game", "onConnect " + args[0]);
            EventBus.getDefault().post(args[0]+"");
        } catch (Exception e) {
            Log.i("game", "onConnect null");
        }
    };


}
