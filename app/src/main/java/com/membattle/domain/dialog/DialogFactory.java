package com.membattle.domain.dialog;

import android.app.Activity;
import android.app.DialogFragment;
import android.os.Bundle;

import com.membattle.presentation.custom.dialog.DialogChoose;
import com.membattle.presentation.custom.dialog.DialogInfo;

public class DialogFactory {

    Activity activity;

    public DialogFactory(Activity activity) {
        this.activity = activity;
    }

    public void createInfoDialog(String title, String message) {
        DialogFragment dialogFragment = new DialogInfo();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("message", message);
        dialogFragment.setArguments(bundle);
        dialogFragment.show(activity.getFragmentManager(), "info");
    }

    public void createChooseDialog(String title, String message) {
        DialogFragment dialogFragment = new DialogChoose();
        Bundle bundle = new Bundle();
        bundle.putString("title", title);
        bundle.putString("message", message);
        dialogFragment.setArguments(bundle);
        dialogFragment.show(activity.getFragmentManager(), "info");
    }
}
