package com.membattle.presentation.main.fragment.rate;

import com.arellomobile.mvp.MvpView;
import com.membattle.presentation.main.fragment.rate.recycler.LineRate;

import java.util.ArrayList;

public interface RateFragmentView extends MvpView {
    void initAdapter(ArrayList<LineRate> lineRates);
    void showError();
}
