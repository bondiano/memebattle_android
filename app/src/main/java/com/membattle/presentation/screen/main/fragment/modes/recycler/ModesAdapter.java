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
            //CustomToast.makeText(context, "Hello World!").show();
            /*DialogFragment dialog1 = new DialogInfo();
            Bundle bundle = new Bundle();
            bundle.putString("title", "title");
            bundle.putString("message", "message");
            dialog1.setArguments(bundle);
            dialog1.show(context.getFragmentManager(), "dialog1");*/
            /*Typeface font = Typeface.createFromAsset(context.getAssets(), "main.ttf");
            View customDialog = context.getLayoutInflater().inflate(R.layout.dialog_info, null);
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setView(customDialog);
            TextViewPlus message = customDialog.findViewById(R.id.dialog_info_message);
            message.setText("mem");
            TextViewPlus title = customDialog.findViewById(R.id.dialog_info_title);
            title.setText("title");
            *//*builder.setMessage(typeface("mem", font))
                    .setTitle(typeface("title", font));*//*
            builder.setPositiveButton(typeface("OK", font),
                            (dialog, id) -> dialog.cancel());
            AlertDialog alert = builder.create();
            alert.getWindow().setBackgroundDrawableResource(R.color.rules_fragment_back);
            alert.show();
            *//*AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Правила")
                    .setMessage(Settings.ARRAY_RULES[mode.type])
                    .setCancelable(false)
                    .setPositiveButton("ОК",
                            (dialog, id) -> dialog.cancel());
            AlertDialog alert = builder.create();
            alert.show();*/
        });
        holder.Play.setOnClickListener(v -> router.navigateTo(Screens.GAME_SCREEN));
    }

    @Override
    public int getItemCount() {
        return modeList.size();
    }

    /*public static SpannableString typeface(CharSequence string, Typeface font) {
        SpannableString s = new SpannableString(string);
        s.setSpan(new CustomTypefaceSpan("", font), 0, s.length(), Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        return s;
    }*/

}
