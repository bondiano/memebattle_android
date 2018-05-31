package com.membattle.presentation.screen.main.fragment.rate;

import com.arellomobile.mvp.MvpView;
import com.membattle.presentation.screen.main.fragment.rate.recycler.LineRate;

import java.util.ArrayList;

public interface RateFragmentView extends MvpView {
    void initAdapter(ArrayList<LineRate> lineRates);
    void showError();
}
