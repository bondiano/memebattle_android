package com.membattle.domain.utils;

import android.app.Activity;
import android.content.Intent;

import com.membattle.data.settings.Screens;
import com.membattle.data.settings.Settings;
import com.membattle.presentation.game.activity.GameActivity;
import com.membattle.presentation.main.activity.MainActivity;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.commands.Back;
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
            Intent intent;
            switch (((Forward) command).getScreenKey()) {
                case Screens.GAME_ACTIVITY:
                    int mode = (int) ((Forward) command).getTransitionData();
                    intent = new Intent(activity, GameActivity.class);
                    intent.putExtra(Settings.CURRENT_MODE, mode);
                    activity.startActivity(intent);
                    break;
                case Screens.MAIN_ACTIVITY:
                    intent = new Intent(activity, MainActivity.class);
                    activity.startActivity(intent);
                    activity.finish();
                    break;
            }
        } else if(command instanceof Back) {
            activity.finish();
        }
    }
}
