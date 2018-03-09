package com.membattle.data.base.flow;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import ru.terrakok.cicerone.android.SupportFragmentNavigator;
import ru.terrakok.cicerone.commands.Command;

public class FlowNavigator extends SupportFragmentNavigator {
    private final Activity context;

    public FlowNavigator(FragmentManager fragmentManager, int containerId, Activity activity) {
        super(fragmentManager, containerId);
        this.context = activity;
    }

    @Override
    protected Fragment createFragment(String screenKey, Object data) {
        return null;
    }

    @Override
    protected void showSystemMessage(String message) {

    }

    @Override
    protected void exit() {

    }

    @Override
    public void applyCommand(Command command) {
        if(command instanceof StartFlow) {
            startFlow(((StartFlow) command).screenKey, ((StartFlow) command).transitionData);
        }
    }
    void startFlow(String screenKey, Object transitionData) {
        Intent intent = new Intent(screenKey);
        context.startActivityForResult(intent, );
    }
}
