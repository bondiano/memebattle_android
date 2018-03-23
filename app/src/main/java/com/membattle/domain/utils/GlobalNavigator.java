package com.membattle.domain.utils;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.membattle.data.settings.Screens;
import com.membattle.data.settings.Settings;
import com.membattle.presentation.game.activity.GameActivity;
import com.membattle.presentation.main.activity.MainActivity;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.commands.Back;
import ru.terrakok.cicerone.commands.BackTo;
import ru.terrakok.cicerone.commands.Command;
import ru.terrakok.cicerone.commands.Forward;
import ru.terrakok.cicerone.commands.SystemMessage;

public class GlobalNavigator implements Navigator {
    Activity activity;

    public GlobalNavigator(Activity activity) {
        this.activity = activity;
    }

    @Override
    public void applyCommand(Command command) {
        Log.i("code", command.getClass() + "");
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
                case Screens.RULES_DIALOG:
                    showDialog(String.valueOf(((Forward) command).getTransitionData()));
                    break;
                case Screens.SHOP_SCREEN:
                    showToast("Магазин пока не работает!");
            }
        } else if (command instanceof BackTo) {
            activity.finish();
        } else if (command instanceof SystemMessage) {
            showToast("Магазин пока не работает!");
        }
    }

    void showToast(String message) {
        Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }

    void showDialog(String text) {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("Правила")
                .setMessage(text)
                .setCancelable(false)
                .setPositiveButton("ОК",
                        (dialog, id) -> dialog.cancel());
        AlertDialog alert = builder.create();
        alert.show();
    }
}
