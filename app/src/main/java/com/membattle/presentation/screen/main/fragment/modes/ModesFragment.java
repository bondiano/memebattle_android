package com.membattle.presentation.screen.main.fragment.modes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.membattle.App;
import com.membattle.R;
import com.membattle.data.settings.Screens;
import com.membattle.domain.utils.SocketListener;
import com.membattle.presentation.base.BaseFragment;
import com.membattle.presentation.screen.main.fragment.modes.recycler.Mode;
import com.membattle.presentation.screen.main.fragment.modes.recycler.ModesAdapter;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import butterknife.BindView;

public class ModesFragment extends BaseFragment implements ModesFragmentView, SocketListener{
    @InjectPresenter
    ModesFragmentPresenter presenter;

    @ProvidePresenter
    public ModesFragmentPresenter presenter() {
        return new ModesFragmentPresenter();
    }

    @BindView(R.id.modes_recycler)
    RecyclerView recyclerView;

    @Override
    protected void injectDependencies() {
        App.getComponent().inject(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        presenter.setAdapter();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_mode;
    }

    @Override
    public void initAdapter(ArrayList<Mode> modes) {
        recyclerView.setAdapter(new ModesAdapter(modes, getActivity()));
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(String pairMem) {
        Log.i("code", "onMode " + pairMem);
    }

}
