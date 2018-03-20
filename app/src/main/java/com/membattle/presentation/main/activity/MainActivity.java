package com.membattle.presentation.main.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.membattle.App;
import com.membattle.R;
import com.membattle.data.base.BaseActivity;
import com.membattle.data.settings.Screens;
import com.membattle.di.qualifier.Global;
import com.membattle.di.qualifier.Local;
import com.membattle.presentation.game.activity.GameActivity;
import com.membattle.presentation.main.fragment.info.InfoFragment;
import com.membattle.presentation.main.fragment.modes.ModesFragment;
import com.membattle.presentation.main.fragment.profile.ProfileFragment;
import com.membattle.presentation.main.fragment.rate.RateFragment;
import com.membattle.presentation.main.fragment.settings.SettingsFragment;
import com.nightonke.boommenu.BoomMenuButton;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

public class MainActivity extends BaseActivity implements MainActivityView {


    @Inject
    @Local
    NavigatorHolder navigatorHolder;

    @Inject
    @Local
    Router router;

    @Inject
    @Global
    NavigatorHolder globalnavigatorHolder;

    @Inject
    @Global
    Router globalRouter;

    @InjectPresenter
    MainActivityPresenter presenter;

    @ProvidePresenter
    public MainActivityPresenter presenter() {
        return new MainActivityPresenter();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*setContentView(R.layout.activity_main);
        App.getComponent().inject(this);*/
        BoomMenuButton bmb = findViewById(R.id.main_bmb);
        presenter().initBmb(bmb);
    }

    @Override
    protected int getContainerId() {
        return R.id.main_container;
    }

    @Override
    protected void injectDependencies() {
        App.getComponent().inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public void gotoGame() {
        Intent intent = new Intent(getApplication(), GameActivity.class);
        getApplication().startActivity(intent);
    }
}
