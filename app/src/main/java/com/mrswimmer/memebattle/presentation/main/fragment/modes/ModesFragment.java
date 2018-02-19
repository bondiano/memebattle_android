package com.mrswimmer.memebattle.presentation.main.fragment.modes;

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
import com.mrswimmer.memebattle.R;
import com.mrswimmer.memebattle.data.item.Mode;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ModesFragment extends MvpAppCompatFragment implements ModesFragmentView {
    @InjectPresenter
    ModesFragmentPresenter presenter;

    @ProvidePresenter
    public ModesFragmentPresenter presenter() {
        return new ModesFragmentPresenter();
    }

    @BindView(R.id.modes_recycler)
    RecyclerView recyclerView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.modes_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        presenter.setAdapter();
    }

    @Override
    public void initAdapter(ArrayList<Mode> modes) {
        recyclerView.setAdapter(new ModesAdapter(modes));
    }
}
