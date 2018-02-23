package com.mrswimmer.memebattle.presentation.main.fragment.info;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.mrswimmer.memebattle.R;
import com.mrswimmer.memebattle.data.widget_plus.TextViewPlus;

public class InfoFragment extends MvpAppCompatFragment {
    TextViewPlus title, text;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_rules, container, false);
        text = v.findViewById(R.id.rultext);
        title = v.findViewById(R.id.ruletitle);
        text.setText(R.string.description);
        title.setText("Правила игры");
        return v;
    }
}
