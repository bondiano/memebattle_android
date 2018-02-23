package com.mrswimmer.memebattle.presentation.main.fragment.rate;

import com.arellomobile.mvp.MvpView;
import com.mrswimmer.memebattle.presentation.main.fragment.rate.recycler.LineRate;

import java.util.ArrayList;

public interface RateFragmentView extends MvpView {
    void initAdapter(ArrayList<LineRate> lineRates);
}
