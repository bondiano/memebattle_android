package com.mrswimmer.memebattle.presentation.main.fragment.rate;

import com.arellomobile.mvp.MvpView;
import com.mrswimmer.memebattle.data.item.Mode;

import java.util.ArrayList;

public interface RateFragmentView extends MvpView {
    void initAdapter(ArrayList<Mode> modes);
}
