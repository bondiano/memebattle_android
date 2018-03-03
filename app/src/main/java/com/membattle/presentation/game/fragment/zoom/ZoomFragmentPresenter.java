package com.membattle.presentation.game.fragment.zoom;

import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.membattle.App;
import com.membattle.data.settings.Screens;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.io.FileOutputStream;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class ZoomFragmentPresenter extends MvpPresenter<ZoomFragmentView> {
    @Inject
    Router router;

    public ZoomFragmentPresenter() {
        App.getComponent().inject(this);
    }

    public void back() {
        router.backTo(Screens.GAME_SCREEN);
    }

    String getNameImageByUrl(String url) {
        return url.substring(url.lastIndexOf('/')+1);
    }

    public Target initTarget(String url) {
        Target target = new Target() {
            @Override
            public void onBitmapLoaded(final Bitmap bitmap, Picasso.LoadedFrom from) {
                new Thread(() -> {
                    File file = new File(Environment.getExternalStorageDirectory() + "/MemeBattle/" + getNameImageByUrl(url));
                    try {
                        file.createNewFile();
                        FileOutputStream ostream = new FileOutputStream(file);
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, ostream);
                        ostream.close();
                    }
                    catch (Exception e) {
                        e.printStackTrace();
                    }

                }).start();
                getViewState().successDownloadImage();
            }
            @Override
            public void onBitmapFailed(Drawable errorDrawable) {
                getViewState().errorDownloadImage();
            }

            @Override
            public void onPrepareLoad(Drawable placeHolderDrawable) {
                if (placeHolderDrawable != null) {
                }
            }
        };
        return target;
    }
}
