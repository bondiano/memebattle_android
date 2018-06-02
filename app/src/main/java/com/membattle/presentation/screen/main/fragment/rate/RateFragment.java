package com.membattle.presentation.screen.main.fragment.rate;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.membattle.App;
import com.membattle.R;
import com.membattle.data.settings.Screens;
import com.membattle.presentation.base.BaseFragment;
import com.membattle.presentation.screen.main.fragment.rate.recycler.LineRate;
import com.membattle.presentation.screen.main.fragment.rate.recycler.RateAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RateFragment extends BaseFragment implements RateFragmentView {
    @InjectPresenter
    RateFragmentPresenter presenter;

    @ProvidePresenter
    public RateFragmentPresenter presenter() {
        return new RateFragmentPresenter();
    }

    @BindView(R.id.rate_recycler)
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_rate, container, false);
    }

    @Override
    protected void injectDependencies() {
        App.getComponent().inject(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        presenter.getRateList();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_rate;
    }

    @Override
    public void initAdapter(ArrayList<LineRate> lineRates) {
        recyclerView.setAdapter(new RateAdapter(lineRates));
    }

    @Override
    public void showError() {
        Toast.makeText(getContext(), "Ошибка подлючения", Toast.LENGTH_SHORT).show();
    }
}
