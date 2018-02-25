package com.mrswimmer.membattle.presentation.main.fragment.rate.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.mrswimmer.membattle.R;
import com.mrswimmer.membattle.data.widget_plus.TextViewPlus;

public class RateViewHolder extends RecyclerView.ViewHolder {
    public TextViewPlus Pos, Username, Coin;
    public RateViewHolder(View v) {
        super(v);
        Pos = v.findViewById(R.id.line_pos);
        Username = v.findViewById(R.id.line_user);
        Coin = v.findViewById(R.id.line_points);
    }
}
