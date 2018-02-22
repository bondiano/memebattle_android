package com.mrswimmer.memebattle.presentation.main.fragment.rate.recycler;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrswimmer.memebattle.R;
import com.mrswimmer.memebattle.data.item.Mode;
import com.mrswimmer.memebattle.data.settings.Settings;
import com.mrswimmer.memebattle.presentation.main.activity.MainActivity;

import java.util.ArrayList;

public class RateAdapter extends RecyclerView.Adapter<RateViewHolder> {
    private ArrayList<Mode> modeList = new ArrayList<>();
    private Context context;

    public RateAdapter(ArrayList<Mode> modeList, Context context) {
        this.modeList = modeList;
        this.context = context;
    }
    @Override
    public RateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mode_item, parent, false);
        return new RateViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RateViewHolder holder, int position) {
        Mode mode = modeList.get(position);
        holder.Title.setText(mode.Title);
        holder.Image.setImageResource(mode.Image);
        holder.Rules.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Правила")
                    .setMessage(Settings.ARRAY_RULES[mode.Type])
                    .setCancelable(false)
                    .setPositiveButton("ОК",
                            (dialog, id) -> dialog.cancel());
            AlertDialog alert = builder.create();
            alert.show();
        });
        holder.Play.setOnClickListener(v -> {
            Intent intent = new Intent(context, MainActivity.class);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return modeList.size();
    }
}
