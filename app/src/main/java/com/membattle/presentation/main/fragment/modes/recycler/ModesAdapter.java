package com.membattle.presentation.main.fragment.modes.recycler;

import android.app.AlertDialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.membattle.App;
import com.membattle.R;
import com.membattle.data.settings.Screens;
import com.membattle.data.settings.Settings;
import com.membattle.di.qualifier.Global;

import java.util.ArrayList;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

public class ModesAdapter extends RecyclerView.Adapter<ModesViewHolder> {
    private ArrayList<Mode> modeList = new ArrayList<>();
    private Context context;

    @Inject
    @Global
    Router globalRouter;

    public ModesAdapter(ArrayList<Mode> modeList, Context context) {
        this.modeList = modeList;
        this.context = context;
        App.getComponent().inject(this);
    }
    @Override
    public ModesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_mode, parent, false);
        return new ModesViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ModesViewHolder holder, int position) {
        Mode mode = modeList.get(position);
        holder.Title.setText(mode.title);
        holder.Image.setImageResource(mode.image);
        holder.Rules.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Правила")
                    .setMessage(Settings.ARRAY_RULES[mode.type])
                    .setCancelable(false)
                    .setPositiveButton("ОК",
                            (dialog, id) -> dialog.cancel());
            AlertDialog alert = builder.create();
            alert.show();
        });
        holder.Play.setOnClickListener(v -> {
            globalRouter.navigateTo(Screens.GAME_ACTIVITY, mode.type);
            /*Intent intent = new Intent(context, GameActivity.class);
            intent.putExtra(Settings.CURRENT_MODE, mode.type);
            context.startActivity(intent);*/
        });
    }

    @Override
    public int getItemCount() {
        return modeList.size();
    }
}
