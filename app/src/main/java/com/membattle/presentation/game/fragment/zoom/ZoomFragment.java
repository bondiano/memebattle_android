package com.membattle.presentation.game.fragment.zoom;

import android.annotation.SuppressLint;
import android.app.DownloadManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.membattle.R;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

@SuppressLint("ValidFragment")
public class ZoomFragment extends MvpAppCompatFragment implements ZoomFragmentView {
    String url;
    private Target target;

    @InjectPresenter
    ZoomFragmentPresenter presenter;

    @SuppressLint("ValidFragment")
    public ZoomFragment(Object data) {
        url = String.valueOf(data);
        Log.i("code", url);
    }

    @ProvidePresenter
    public ZoomFragmentPresenter presenter() {
        return new ZoomFragmentPresenter();
    }

    @BindView(R.id.zoom_mem)
    ImageView mem;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_zoom, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        target = presenter.initTarget(url);
    }

    @OnClick(R.id.zoom_back)
    void onBackClick() {
        presenter.back();
    }

    @OnClick(R.id.zoom_save)
    void onSaveClick() {
        Picasso.with(getActivity()).load(url).into(target);
    }
}
