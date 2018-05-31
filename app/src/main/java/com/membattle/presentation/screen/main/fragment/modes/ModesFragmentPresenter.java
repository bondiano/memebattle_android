package com.membattle.presentation.screen.main.fragment.modes;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.membattle.App;
import com.membattle.R;
import com.membattle.di.qualifier.Local;
import com.membattle.presentation.screen.main.fragment.modes.recycler.Mode;

import java.util.ArrayList;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class ModesFragmentPresenter extends MvpPresenter<ModesFragmentView> {
    @Inject
    @Local
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
