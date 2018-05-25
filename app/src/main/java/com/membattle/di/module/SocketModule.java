package com.membattle.di.module;


import com.github.nkzawa.socketio.client.IO;
import com.github.nkzawa.socketio.client.Socket;
import com.membattle.domain.interactor.SocketService;

import java.net.URISyntaxException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SocketModule {
    Socket socket;

    public SocketModule() {
        try {
            socket = IO.socket("http://139.59.156.1:8000/");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @Provides
    @Singleton
    SocketService socketService() {
        return new SocketService(socket);
    }
}
