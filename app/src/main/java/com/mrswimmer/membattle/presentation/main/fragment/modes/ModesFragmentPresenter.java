package com.mrswimmer.membattle.presentation.main.fragment.modes;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mrswimmer.membattle.App;
import com.mrswimmer.membattle.R;
import com.mrswimmer.membattle.presentation.main.fragment.modes.recycler.Mode;

import java.util.ArrayList;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class ModesFragmentPresenter extends MvpPresenter<ModesFragmentView> {
    @Inject
    Router router;

    public ModesFragmentPresenter() {
        App.getComponent().inject(this);
    }

    public void setAdapter() {
        ArrayList<Mode> modes = new ArrayList<>();
        modes.add(new Mode(R.drawable.stub_mem, "Бесконечный батл", 0, 0, R.color.main_blue));
        getViewState().initAdapter(modes);
    }
}
