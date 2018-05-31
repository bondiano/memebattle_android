package com.membattle.presentation.screen.main.fragment.game.zoom;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Environment;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.membattle.App;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.io.File;
import java.io.FileOutputStream;

@InjectViewState
public class ZoomActivityPresenter extends MvpPresenter<ZoomActivityView> {
    public ZoomActivityPresenter() {
        App.getComponent().inject(this);
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
                    } catch (Exception e) {
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

    String getNameImageByUrl(String url) {
        return url.substring(url.lastIndexOf('/') + 1);
    }

}
