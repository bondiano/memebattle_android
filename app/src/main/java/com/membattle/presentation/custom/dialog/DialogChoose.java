package com.membattle.presentation.custom.dialog;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.membattle.R;
import com.membattle.presentation.custom.widget_plus.TextViewPlus;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogChoose extends DialogFragment {

    final String LOG_TAG = "myLogs";

    @BindView(R.id.dialog_choose_message)
    TextViewPlus message;
    @BindView(R.id.dialog_choose_title)
    TextViewPlus title;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_choose, null);
        ButterKnife.bind(this, v);
        Bundle bundle = getArguments();
        message.setText(bundle.getString("message"));
        title.setText(bundle.getString("title"));
        return v;
    }

    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        Log.d(LOG_TAG, "Dialog 1: onDismiss");
    }

    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Log.d(LOG_TAG, "Dialog 1: onCancel");
    }

    @OnClick(R.id.dialog_choose_yes)
    public void onYesClick() {
        EventBus.getDefault().post("yes");
        EventBus.getDefault().post(false);
        EventBus.getDefault().post(1);
        getDialog().cancel();
    }

    @OnClick(R.id.dialog_choose_no)
    public void onNoClick() {
        EventBus.getDefault().post("no");
        getDialog().cancel();
    }
}