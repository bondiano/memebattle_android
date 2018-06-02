package com.membattle.presentation.screen.main.fragment.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.membattle.App;
import com.membattle.R;
import com.membattle.data.settings.Screens;
import com.membattle.presentation.base.BaseFragment;
import com.membattle.presentation.custom.widget_plus.TextViewPlus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileFragment extends BaseFragment implements ProfileFragmentView {
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
    protected void injectDependencies() {
        App.getComponent().inject(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        presenter.setFields();
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_profile;
    }

    @Override
    public void setFields(String username, String coins) {
        this.username.setText(username);
        this.coins.setText(coins);
    }

}
