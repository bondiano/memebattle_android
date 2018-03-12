package com.membattle.presentation.main.fragment.rate.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.membattle.R;
import com.membattle.presentation.widget_plus.TextViewPlus;

public class RateViewHolder extends RecyclerView.ViewHolder {
    public TextViewPlus Pos, Username, Coin;
    public RateViewHolder(View v) {
        super(v);
        Pos = v.findViewById(R.id.line_pos);
        Username = v.findViewById(R.id.line_user);
        Coin = v.findViewById(R.id.line_points);
    }
}
