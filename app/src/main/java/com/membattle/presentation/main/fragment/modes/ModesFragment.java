package com.membattle.presentation.main.fragment.modes;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.membattle.App;
import com.membattle.R;
import com.membattle.domain.utils.SocketListener;
import com.membattle.presentation.base.BaseFragment;
import com.membattle.presentation.main.fragment.modes.recycler.Mode;
import com.membattle.presentation.main.fragment.modes.recycler.ModesAdapter;

import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ModesFragment extends BaseFragment implements ModesFragmentView, SocketListener {
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
        recyclerView.setAdapter(new ModesAdapter(modes, getContext()));
    }


}
