package com.mrswimmer.memebattle.presentation.main.fragment.modes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.mrswimmer.memebattle.R;

public class ModesFragment extends MvpAppCompatFragment implements ModesFragmentView {
    @InjectPresenter
    ModesFragmentPresenter presenter;

    @ProvidePresenter
    public ModesFragmentPresenter presenter() {
        return new ModesFragmentPresenter();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.modes_fragment, container, false);
    }
}
