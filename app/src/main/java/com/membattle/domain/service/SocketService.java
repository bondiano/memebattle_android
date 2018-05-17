package com.membattle.domain.service;

import android.util.Log;

import com.github.nkzawa.emitter.Emitter;
import com.github.nkzawa.socketio.client.Socket;

import org.greenrobot.eventbus.EventBus;

public class SocketService {
    Socket socket;

    public SocketService(Socket socket) {
        this.socket = socket;
        connect();
    }

    private void connect() {
        socket.on("connect", onConnect);
        socket.on("_error", onMeme);
        socket.connect();
    }

    private Emitter.Listener onConnect = args -> {
        try {
            Log.i("code", "onConnect " + args[0]);
            EventBus.getDefault().post(args[0]+"");
        } catch (Exception e) {
            Log.i("code", "onConnect e " + e.getMessage());
        }
    };

    private Emitter.Listener onMeme = args -> {
        try {
            Log.i("code", "onMeme " + args[0]);
            EventBus.getDefault().post(args[0]+"");
        } catch (Exception e) {
            Log.i("code", "onMeme e " + e.getMessage());
        }
    };

    public void emit() {
        Log.i("code", "socketconnect " + socket.connected());
        socket.emit("temp-user", "emit");
    }

    public void close() {
        socket.close();
    }
}
