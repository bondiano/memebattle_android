package com.mrswimmer.memebattle.presentation.main.fragment.modes;

import android.graphics.Color;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.MvpPresenter;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.mrswimmer.memebattle.App;
import com.mrswimmer.memebattle.R;
import com.mrswimmer.memebattle.data.api.req.RegistrationUser;
import com.mrswimmer.memebattle.data.api.res.Exres;
import com.mrswimmer.memebattle.data.item.Mode;
import com.mrswimmer.memebattle.domain.service.Service;

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
        modes.add(new Mode(R.drawable.ng, "Новогодний баттл", 0, 0, Color.WHITE));
        modes.add(new Mode(R.drawable.ng, "Новогодний баттл2", 0, 0, Color.WHITE));
        getViewState().initAdapter(modes);
    }
}
