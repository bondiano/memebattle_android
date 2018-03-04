package com.membattle.presentation.main.fragment.profile.recycler;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.membattle.R;
import com.membattle.presentation.main.fragment.ImageAdapter;

import java.util.ArrayList;

public class StatModesAdapter extends RecyclerView.Adapter<StatModesViewHolder> {
    private ArrayList<StatMode> statModes = new ArrayList<>();
    private Context context;

    public StatModesAdapter(ArrayList<StatMode> modeList, Context context) {
        this.statModes = modeList;
        this.context = context;
    }
    @Override
    public StatModesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_stat_mode, parent, false);
        return new StatModesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(StatModesViewHolder holder, int position) {
        StatMode statMode = statModes.get(position);
        holder.title.setText(statMode.title);
        holder.grid.setAdapter(new ImageAdapter(context, statModes.get(position).urls));
        holder.showAllButton.setOnClickListener(v -> {
            Intent intent = new Intent(context, )
        });
    }

    @Override
    public int getItemCount() {
        return statModes.size();
    }
}
