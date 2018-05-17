package com.membattle.di.module;


import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.membattle.domain.service.SocketService;

import java.net.URISyntaxException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;

@Module
public class SocketModule {
    Socket socket;

    public SocketModule() {
        try {
            socket = IO.socket("https://api.mems.fun/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Provides
    @Singleton
    SocketService socketService(Socket socket) {
        return new SocketService(socket);
    }
}
