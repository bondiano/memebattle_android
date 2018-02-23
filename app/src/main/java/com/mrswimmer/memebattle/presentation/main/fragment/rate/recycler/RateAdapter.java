package com.mrswimmer.memebattle.presentation.main.fragment.rate.recycler;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.mrswimmer.memebattle.R;

import java.util.ArrayList;

public class RateAdapter extends RecyclerView.Adapter<RateViewHolder> {
    private ArrayList<LineRate> rateList = new ArrayList<>();

    public RateAdapter(ArrayList<LineRate> rateList) {
        this.rateList = rateList;
    }
    @Override
    public RateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rate_item, parent, false);
        return new RateViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RateViewHolder holder, int position) {
        LineRate lineRate = rateList.get(position);
        if(lineRate.user.equals("...")) {
            holder.Pos.setText("...");
            holder.Username.setText("");
            holder.Coin.setText("");
        } else {
            holder.Pos.setText(lineRate.pos+"");
            holder.Username.setText(lineRate.user);
            holder.Coin.setText(lineRate.coins+"");
        }
    }

    @Override
    public int getItemCount() {
        return rateList.size();
    }
}
