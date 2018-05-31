package com.membattle.presentation.screen.main.fragment.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.membattle.R;
import com.membattle.presentation.custom.widget_plus.TextViewPlus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileFragment extends MvpAppCompatFragment implements ProfileFragmentView {
    @InjectPresenter
    ProfileFragmentPresenter presenter;

    @ProvidePresenter
    public ProfileFragmentPresenter presenter() {
        return new ProfileFragmentPresenter();
    }

    @BindView(R.id.profile_coins)
    TextViewPlus coins;
    @BindView(R.id.profile_username)
    TextViewPlus username;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        return v;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        presenter.setFields();
    }
    @Override
    public void setFields(String username, String coins) {
        this.username.setText(username);
        this.coins.setText(coins);
    }

}
