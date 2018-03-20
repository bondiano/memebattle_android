package com.membattle.data.base;

import android.app.Activity;
import android.content.Intent;

import com.membattle.data.settings.Screens;
import com.membattle.presentation.game.activity.GameActivity;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Forward;

public class GlobalNavigator implements Navigator {
    Activity activity;
    public GlobalNavigator(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void applyCommand(Command command) {
        if (command instanceof Forward) {
            if(((Forward) command).getScreenKey().equals(Screens.GAME_ACTIVITY)) {
                Intent intent = new Intent(activity, GameActivity.class);
                activity.startActivity(intent);
            }
        }
    }
}
