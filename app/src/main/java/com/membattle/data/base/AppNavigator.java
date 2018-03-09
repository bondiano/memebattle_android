package com.membattle.data.base;

import android.app.Activity;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.commands.Back;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Forward;
import ru.terrakok.cicerone.commands.Replace;

class AppNavigator implements Navigator {
    Activity activity;
    public AppNavigator(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void applyCommand(Command command) {
        if(command instanceof Forward) {
            openScreen(((Forward) command).getScreenKey(), ((Forward) command).getTransitionData());
        }
        else if (command instanceof Back) {
            activity.onBackPressed();
        }
        else if (command instanceof Replace) {
            openScreen(((Replace) command).getScreenKey(), ((Replace) command).getTransitionData());
            activity.finish();
        }
        else {
            throw new UnsupportedOperationException();
        }
    }

    private void openScreen(String key, Object data) {

    }
}
