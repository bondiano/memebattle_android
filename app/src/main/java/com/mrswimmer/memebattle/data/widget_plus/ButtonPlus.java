package com.mrswimmer.memebattle.data.widget_plus;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.mrswimmer.memebattle.R;


public class ButtonPlus extends android.support.v7.widget.AppCompatButton {
    public ButtonPlus(Context context) {
        super(context);
    }

    public ButtonPlus(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context, attrs);
    }

    public ButtonPlus(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCustomFont(context, attrs);
    }

    private void setCustomFont(Context context, AttributeSet attrs) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TextViewPlus);
        String customFont = a.getString(R.styleable.TextViewPlus_customFont);
        setCustomFont(context);
        a.recycle();
    }

    public boolean setCustomFont(Context ctx) {
        String font = "main.ttf";
        Typeface CF = Typeface.createFromAsset(ctx.getAssets(), font);
        setTypeface(CF);
        return true;
    }
}
