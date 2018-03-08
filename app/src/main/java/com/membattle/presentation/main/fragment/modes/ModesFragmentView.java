package com.membattle.presentation.main.fragment.modes;

import com.arellomobile.mvp.MvpView;
import com.membattle.presentation.main.fragment.modes.recycler.Mode;

import java.util.ArrayList;

public interface ModesFragmentView extends MvpView {
    void initAdapter(ArrayList<Mode> modes);
}
