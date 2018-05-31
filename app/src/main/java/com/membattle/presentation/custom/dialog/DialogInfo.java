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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogInfo extends DialogFragment {

    final String LOG_TAG = "myLogs";

    @BindView(R.id.dialog_info_message)
    TextViewPlus message;
    @BindView(R.id.dialog_info_title)
    TextViewPlus title;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_info, null);
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

    @OnClick(R.id.dialog_info_ok)
    public void onOkClick() {
        getDialog().cancel();
    }
}