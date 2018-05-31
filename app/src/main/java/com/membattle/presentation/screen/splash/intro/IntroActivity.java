package com.membattle.presentation.screen.splash.intro;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.membattle.R;

import agency.tango.materialintroscreen.MaterialIntroActivity;

public class IntroActivity extends MaterialIntroActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String[] intros = getResources().getStringArray(R.array.intros);
        enableLastSlideAlphaExitTransition(true);
        for(int i=0; i<intros.length; i++) {
            addSlide(new IntroFragment(intros[i]));
        }
    }

    @Override
    public void onFinish() {
        super.onFinish();
    }
}