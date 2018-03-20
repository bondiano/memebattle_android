package com.membattle.presentation.main.fragment.info;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.membattle.R;
import com.membattle.presentation.widget_plus.TextViewPlus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoFragment extends MvpAppCompatFragment {
    @BindView(R.id.rultext)
    TextViewPlus text;
    @BindView(R.id.ruletitle)
    TextViewPlus title;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_rules, container, false);
        return v;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        text.setText(R.string.description);
        title.setText("Правила игры");
    }
}
