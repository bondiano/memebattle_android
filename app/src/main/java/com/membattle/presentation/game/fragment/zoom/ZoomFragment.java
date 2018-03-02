package com.membattle.presentation.game.fragment.zoom;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.membattle.R;
import com.membattle.data.widget_plus.ButtonPlus;
import com.membattle.presentation.game.fragment.game.GameFragmentPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZoomFragment extends MvpAppCompatFragment implements ZoomFragmentView {
    @InjectPresenter
    GameFragmentPresenter presenter;

    @ProvidePresenter
    public ZoomFragmentPresenter presenter() {
        return new ZoomFragmentPresenter();
    }

    @BindView(R.id.zoom_back)
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
    }

    @OnClick(R.id.zoom_back)
    void onBackClick() {

    }

}
