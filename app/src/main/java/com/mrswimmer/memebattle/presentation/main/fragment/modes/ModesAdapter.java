package com.mrswimmer.memebattle.presentation.main.fragment.modes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrswimmer.memebattle.R;
import com.mrswimmer.memebattle.data.item.Mode;

import java.util.ArrayList;
import java.util.HashMap;

public class ModesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Mode> modeList = new ArrayList<>();

    public ModesAdapter(ArrayList<Mode> modeList) {
        this.modeList = modeList;
    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mode_item, parent, false);
        new ModesViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    private class ModesViewHolder extends RecyclerView.ViewHolder {
        public ModesViewHolder(View v) {
            super(v);
        }
    }
}
