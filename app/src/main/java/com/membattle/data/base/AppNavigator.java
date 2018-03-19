package com.membattle.data.base;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.widget.Toast;
import com.membattle.data.settings.Screens;
import com.membattle.presentation.auth.fragment.sign_in.SignInFragment;
import com.membattle.presentation.auth.fragment.sign_up.SignUpFragment;
import com.membattle.presentation.game.activity.GameActivity;
import com.membattle.presentation.game.fragment.game.GameFragment;
import com.membattle.presentation.game.fragment.zoom.ZoomFragment;
import com.membattle.presentation.main.activity.MainActivity;
import com.membattle.presentation.main.fragment.info.InfoFragment;
import com.membattle.presentation.main.fragment.modes.ModesFragment;
import com.membattle.presentation.main.fragment.profile.ProfileFragment;
import com.membattle.presentation.main.fragment.rate.RateFragment;
import com.membattle.presentation.main.fragment.settings.SettingsFragment;

import ru.terrakok.cicerone.android.SupportFragmentNavigator;

public class AppNavigator extends SupportFragmentNavigator {

    Activity activity;
    int currentContainer;

    public AppNavigator(FragmentManager fragmentManager, int containerId, Activity activity) {
        super(fragmentManager, containerId);
        this.activity = activity;
        currentContainer = containerId;
    }

    @Override
    protected Fragment createFragment(String screenKey, Object data) {
        switch (currentContainer) {
            case Screens.CONTAINER_MAIN:
                //return mainFragments(screenKey);
                return MainFragmentsFactory.getFragmentByKey(screenKey, data);
            case Screens.CONTAINER_GAME:
                //return gameFragments(screenKey, data);
                return GameFragmentsFactory.getFragmentByKey(screenKey, data);
            case Screens.CONTAINER_AUTH:
                return authFragments(screenKey);
            default:
                    authFragments(screenKey);
        }
        return null;
    }

    private Fragment gameFragments(String screenKey, Object data) {
        switch (screenKey) {
            case Screens.GAME_SCREEN:
                return new GameFragment();
            case Screens.MODES_SCREEN:
                activity.finish();
            case Screens.RATE_SCREEN:
                return new RateFragment();
            case Screens.RULES_DIALOG:
                showRules();
                return new GameFragment();
            case Screens.SHOP_SCREEN:
                showSystemMessage("Магазин пока не работает!");
                return new GameFragment();
            case Screens.PROFILE_SCREEN:
                return new ProfileFragment();
            case Screens.ZOOM_SCREEN:
                return new ZoomFragment(data);
            default:
                return new ModesFragment();
        }
    }

    private void showRules() {

    }

    private Fragment authFragments(String screenKey) {
        switch (screenKey) {
            case Screens.SIGN_IN_SCREEN :
                return new SignInFragment();
            case Screens.SIGN_UP_SCREEN :
                return new SignUpFragment();
            case Screens.MAIN_ACTIVITY :
                Intent intent = new Intent(activity, MainActivity.class);
                activity.startActivity(intent);
                activity.finish();
                return null;
            default:
                return new SignInFragment();
        }
    }

    @Override
    protected void showSystemMessage(String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void exit() {
        activity.finish();
    }

    public void gotoGame() {
        Intent intent = new Intent(activity, GameActivity.class);
        activity.startActivity(intent);
    }
}


