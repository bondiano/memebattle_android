package com.membattle.presentation.intro;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.membattle.R;

import agency.tango.materialintroscreen.MaterialIntroActivity;

public class FirstStartActivity extends MaterialIntroActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] intros = getResources().getStringArray(R.array.intros);
        enableLastSlideAlphaExitTransition(true);
        for(int i=0; i<intros.length; i++) {
            addSlide(new SlideIntro(intros[i]));
        }
    }

    @Override
    public void onFinish() {
        super.onFinish();
    }
}