package com.mrswimmer.memebattle.presentation.main.fragment.modes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.mrswimmer.memebattle.R;
import com.mrswimmer.memebattle.data.item.Mode;

import java.util.ArrayList;

public class ModesAdapter extends RecyclerView.Adapter<ModesAdapter.ModesViewHolder> {
    private ArrayList<Mode> modeList = new ArrayList<>();

    public ModesAdapter(ArrayList<Mode> modeList) {
        this.modeList = modeList;
    }
    @Override
    public ModesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mode_item, parent, false);
        return new ModesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ModesViewHolder holder, int position) {
        Mode mode = modeList.get(position);
        holder.Play.setText("lol");
    }

    @Override
    public int getItemCount() {
        return modeList.size();
    }

    public class ModesViewHolder extends RecyclerView.ViewHolder {
        public TextView Title, Play, Rules, TextTime;
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
}
