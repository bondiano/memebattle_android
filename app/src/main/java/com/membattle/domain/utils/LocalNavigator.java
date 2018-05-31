package com.membattle.domain.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import com.membattle.data.settings.Screens;
import com.membattle.presentation.screen.auth.fragment.sign_in.SignInFragment;
import com.membattle.presentation.screen.auth.fragment.sign_up.SignUpFragment;
import com.membattle.presentation.screen.main.fragment.game.GameFragment;
import com.membattle.presentation.screen.main.fragment.info.InfoFragment;
import com.membattle.presentation.screen.main.fragment.modes.ModesFragment;
import com.membattle.presentation.screen.main.fragment.profile.ProfileFragment;
import com.membattle.presentation.screen.main.fragment.rate.RateFragment;
import com.membattle.presentation.screen.main.fragment.settings.SettingsFragment;

import ru.terrakok.cicerone.android.SupportFragmentNavigator;

public class LocalNavigator extends SupportFragmentNavigator {

    int currentContainer;

    public LocalNavigator(FragmentManager fragmentManager, int containerId) {
        super(fragmentManager, containerId);
        currentContainer = containerId;
    }

    @Override
    protected Fragment createFragment(String screenKey, Object data) {
        switch (currentContainer) {
            case Screens.CONTAINER_MAIN:
                return mainFragments(screenKey);
            case Screens.CONTAINER_AUTH:
                return authFragments(screenKey);
            default:
                    authFragments(screenKey);
        }
        return null;
    }
    public Fragment mainFragments(String screenKey) {
        switch (screenKey) {
            case Screens.GAME_SCREEN:
                return new GameFragment();
            case Screens.MODES_SCREEN:
                return new ModesFragment();
            case Screens.RATE_SCREEN:
                return new RateFragment();
            case Screens.INFO_SCREEN:
                return new InfoFragment();
            case Screens.SETTINGS_SCREEN:
                return new SettingsFragment();
            case Screens.SHOP_SCREEN:
                showSystemMessage("Магазин пока не работает!");
                return new ModesFragment();
            case Screens.PROFILE_SCREEN:
                return new ProfileFragment();
            default:
                return new ModesFragment();
        }
    }

    private Fragment authFragments(String screenKey) {
        switch (screenKey) {
            case Screens.SIGN_IN_SCREEN :
                return new SignInFragment();
            case Screens.SIGN_UP_SCREEN :
                return new SignUpFragment();
            default:
                return new SignInFragment();
        }
    }

    @Override
    protected void showSystemMessage(String message) {
    }

    @Override
    protected void exit() {
    }
}


