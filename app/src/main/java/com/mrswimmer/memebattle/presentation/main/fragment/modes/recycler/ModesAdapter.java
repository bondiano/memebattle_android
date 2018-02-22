package com.mrswimmer.memebattle.presentation.main.fragment.modes.recycler;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrswimmer.memebattle.R;
import com.mrswimmer.memebattle.data.item.Mode;

import java.util.ArrayList;

public class ModesAdapter extends RecyclerView.Adapter<ModesViewHolder> {
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
        holder.Title.setText(mode.Title);
        holder.Image.setImageResource(mode.Image);
        holder.Rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Правила")
                        .setMessage(modes[position])
                        .setCancelable(false)
                        .setPositiveButton("ОК",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return modeList.size();
    }
}
