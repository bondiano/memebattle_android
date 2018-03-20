package com.membattle.data.base;

import android.support.v4.app.Fragment;

import com.membattle.data.settings.Screens;
import com.membattle.presentation.main.fragment.info.InfoFragment;
import com.membattle.presentation.main.fragment.modes.ModesFragment;
import com.membattle.presentation.main.fragment.profile.ProfileFragment;
import com.membattle.presentation.main.fragment.rate.RateFragment;
import com.membattle.presentation.main.fragment.settings.SettingsFragment;

class MainFragmentsFactory {
    /*public static Fragment getFragmentByKey(String screenKey, Object data) {
        switch (screenKey) {
            case Screens.MODES_SCREEN:
                return new ModesFragment();
            case Screens.GAME_ACTIVITY:
                ActivityFactory.startActivityByID(Screens.GAME_ACTIVITY);
                gotoGame();
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
    }*/
}
