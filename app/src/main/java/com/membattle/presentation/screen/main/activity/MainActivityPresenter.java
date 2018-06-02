package com.membattle.presentation.screen.main.activity;

import android.support.design.widget.NavigationView;
import android.util.Log;
import android.view.MenuItem;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.membattle.App;
import com.membattle.R;
import com.membattle.data.settings.Screens;
import com.membattle.di.qualifier.Global;
import com.membattle.di.qualifier.Local;
import com.membattle.domain.interactor.SettingsService;
import com.membattle.presentation.base.BaseActivity;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MainActivityView> {

    MainActivityPresenter() {
        App.getComponent().inject(this);
    }

    @Inject
    @Local
    Router router;

    @Inject
    @Global
    Router globalRouter;

    @Inject
    SettingsService settingsService;

    public void setupDrawerContent(NavigationView navigationView) {
        navigationView.setCheckedItem(0);
        navigationView.setNavigationItemSelectedListener(
                menuItem -> {
                    selectDrawerItem(menuItem);
                    return true;
                });
    }

    private void selectDrawerItem(MenuItem menuItem) {
        Log.i("code", "select drawer item");
        switch(menuItem.getItemId()) {
            case R.id.nav_main:
                router.replaceScreen(Screens.MODES_SCREEN);
                break;
            case R.id.nav_rate:
                router.replaceScreen(Screens.RATE_SCREEN);
                break;
            case R.id.nav_shop:
                break;
            case R.id.nav_settings:
                router.replaceScreen(Screens.SETTINGS_SCREEN);
                break;
            default:
        }
        menuItem.setChecked(true);
        getViewState().checkDrawerItem(menuItem);
    }

    public String getUsername() {
        return settingsService.getUsername();
    }

    public void share() {
        //globalRouter.navigateTo(Screens.SHARE);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        Log.i("code", "firstattach");
        router.newRootScreen(Screens.MODES_SCREEN);
    }
}
