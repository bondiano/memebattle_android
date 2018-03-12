package com.membattle.presentation.widget_plus;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.util.AttributeSet;

import com.membattle.R;


public class EditTextPlus extends android.support.v7.widget.AppCompatEditText {
    public EditTextPlus(Context context) {
        super(context);
    }

    public EditTextPlus(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context, attrs);
    }

    public EditTextPlus(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setCustomFont(context, attrs);
    }

    private void setCustomFont(Context ctx, AttributeSet attrs) {
        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.TextViewPlus);
        String customFont = a.getString(R.styleable.TextViewPlus_customFont);
        setCustomFont(ctx);
        a.recycle();
    }

    public boolean setCustomFont(Context ctx) {
        String font = "main.ttf";
        Typeface CF = Typeface.createFromAsset(ctx.getAssets(), font);
        setTypeface(CF);
        getBackground().mutate().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        return true;
    }
}
