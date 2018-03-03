package com.membattle.presentation.main.fragment.profile.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;

import com.membattle.R;
import com.membattle.data.widget_plus.ButtonPlus;
import com.membattle.data.widget_plus.TextViewPlus;


public class StatModesViewHolder extends RecyclerView.ViewHolder {
    TextViewPlus title;
    GridView grid;
    ButtonPlus showAllButton;

    public StatModesViewHolder(View v) {
        super(v);
        title = v.findViewById(R.id.stat_title);
        grid = v.findViewById(R.id.stat_grid);
        showAllButton = v.findViewById(R.id.stat_show_all_but);
    }
}
