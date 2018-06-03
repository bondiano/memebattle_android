package com.membattle.presentation.screen.main.fragment.modes.recycler;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.membattle.App;
import com.membattle.R;
import com.membattle.data.settings.Screens;
import com.membattle.data.settings.Settings;
import com.membattle.di.qualifier.Local;
import com.membattle.domain.dialog.DialogFactory;
import com.membattle.presentation.custom.toast.CustomToast;

import java.util.ArrayList;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

public class ModesAdapter extends RecyclerView.Adapter<ModesViewHolder> {
    private ArrayList<Mode> modeList = new ArrayList<>();
    private Activity context;

    @Inject
    @Local
    Router router;

    public ModesAdapter(ArrayList<Mode> modeList, Activity context) {
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
            DialogFactory factory = new DialogFactory(context);
            factory.createInfoDialog("Правила", Settings.ARRAY_RULES[mode.type]);
        });
        holder.Play.setOnClickListener(v -> router.replaceScreen(Screens.GAME_SCREEN));
    }

    @Override
    public int getItemCount() {
        return modeList.size();
    }
}
