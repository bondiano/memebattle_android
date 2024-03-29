package com.membattle.presentation.main.fragment.modes.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.membattle.R;
import com.membattle.data.widget_plus.TextViewPlus;


public class ModesViewHolder extends RecyclerView.ViewHolder {
    public TextViewPlus Title, Play, Rules, TextTime;
    public ImageView Image;
    public ModesViewHolder(View v) {
        super(v);
        Title = v.findViewById(R.id.item_title);
        Play = v.findViewById(R.id.item_play);
        Rules = v.findViewById(R.id.item_rules);
        Image = v.findViewById(R.id.item_image);
        TextTime = v.findViewById(R.id.item_text_timer);
    }
}
