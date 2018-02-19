package com.mrswimmer.memebattle.presentation.intro;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrswimmer.memebattle.R;
import com.mrswimmer.memebattle.data.widget_plus.TextViewPlus;

import agency.tango.materialintroscreen.SlideFragment;


public class SlideIntro extends SlideFragment {
    String text;
    TextViewPlus Text;

    public SlideIntro() {
        super();
    }

    @SuppressLint("ValidFragment")
    public SlideIntro(String text) {
        super();
        this.text = text;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.firstslide_layout, container, false);
        Text = view.findViewById(R.id.textintro);
        Text.setText(text);
        return view;
    }

    @Override
    public int backgroundColor() {
        return R.color.custom_slide_background;
    }

    @Override
    public int buttonsColor() {
        return R.color.memblue;
    }

    @Override
    public String cantMoveFurtherErrorMessage() {
        return "Ошибка";
    }
}
