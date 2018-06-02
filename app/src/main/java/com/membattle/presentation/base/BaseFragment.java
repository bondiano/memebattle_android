package com.membattle.presentation.base;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.text.Spannable;
import android.text.SpannableString;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.membattle.App;
import com.membattle.domain.font.CustomTypefaceSpan;
import com.membattle.domain.interactor.SettingsService;
import com.membattle.domain.interactor.SocketService;
import com.membattle.domain.utils.SocketListener;
import com.membattle.presentation.custom.toast.CustomToast;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.ButterKnife;

public abstract class BaseFragment extends MvpAppCompatFragment implements BaseView {

    @Inject
    SocketService socketService;
    CustomToast toast;

    @Override
    public void showToast(String message) {
        if (!toast.getView().isShown()) {
            CustomToast.makeText(getContext(), "Hello World!").show();
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        injectDependencies();
        setRetainInstance(true);
        return inflater.inflate(getLayoutID(), container, false);
    }

    protected abstract void injectDependencies();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
    }

    @Override
    public void showDialog(String title, String message) {
        Typeface font = Typeface.createFromAsset(getActivity().getAssets(), "main.ttf");
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(typeface(title, font))
                .setMessage(typeface(message, font))
                .setCancelable(false)
                .setPositiveButton("ОК",
                        (dialog, id) -> dialog.cancel());
        AlertDialog alert = builder.create();
        alert.show();
    }

    protected abstract int getLayoutID();

    @Override
    public void onResume() {
        super.onResume();
        if (SocketListener.class.isAssignableFrom(getClass())) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (SocketListener.class.isAssignableFrom(getClass())) {
            EventBus.getDefault().unregister(this);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("code", "fragment save inst");
    }

    public static SpannableString typeface(CharSequence string, Typeface font) {
        SpannableString s = new SpannableString(string);
        s.setSpan(new CustomTypefaceSpan("", font), 0, s.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        return s;
    }
}
