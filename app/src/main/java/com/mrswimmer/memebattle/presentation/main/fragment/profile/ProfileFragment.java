package com.mrswimmer.memebattle.presentation.main.fragment.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.arellomobile.mvp.MvpAppCompatFragment;
import com.mrswimmer.memebattle.App;
import com.mrswimmer.memebattle.R;
import com.mrswimmer.memebattle.data.settings.Settings;
import com.mrswimmer.memebattle.data.widget_plus.TextViewPlus;

public class ProfileFragment extends MvpAppCompatFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        TextViewPlus username = v.findViewById(R.id.profile_username);
        username.setText(App.settings.getString(Settings.USERNAME, "guest"));
        TextViewPlus coins = v.findViewById(R.id.profile_coins);
        coins.setText(App.settings.getInt(Settings.COINS, 0)+"");
        return v;
    }
}
