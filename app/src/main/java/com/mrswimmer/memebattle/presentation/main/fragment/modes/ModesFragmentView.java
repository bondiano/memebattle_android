package com.mrswimmer.memebattle.presentation.main.fragment.modes;

import com.arellomobile.mvp.MvpView;
import com.mrswimmer.memebattle.data.item.Mode;

import java.util.ArrayList;

public interface ModesFragmentView extends MvpView {
    void initAdapter(ArrayList<Mode> modes);
}
