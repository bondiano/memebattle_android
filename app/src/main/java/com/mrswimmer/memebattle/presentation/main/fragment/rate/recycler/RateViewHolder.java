package com.mrswimmer.memebattle.presentation.main.fragment.rate.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.mrswimmer.memebattle.R;
import com.mrswimmer.memebattle.data.widget_plus.TextViewPlus;


public class RateViewHolder extends RecyclerView.ViewHolder {
    public TextViewPlus Title, Play, Rules, TextTime;
    public ImageView Image;
    public RateViewHolder(View v) {
        super(v);
        Title = v.findViewById(R.id.item_title);
        Play = v.findViewById(R.id.item_play);
        Rules = v.findViewById(R.id.item_rules);
        Image = v.findViewById(R.id.item_image);
        TextTime = v.findViewById(R.id.item_text_timer);
    }
}
