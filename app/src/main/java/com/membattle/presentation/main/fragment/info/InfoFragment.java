package com.membattle.presentation.main.fragment.info;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.membattle.App;
import com.membattle.R;
import com.membattle.domain.utils.SocketListener;
import com.membattle.presentation.base.BaseFragment;
import com.membattle.presentation.widget_plus.TextViewPlus;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoFragment extends BaseFragment implements SocketListener {
    @BindView(R.id.rultext)
    TextViewPlus text;
    @BindView(R.id.ruletitle)
    TextViewPlus title;

    @Override
    protected void injectDependencies() {
        App.getComponent().inject(this);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        text.setText(R.string.description);
        title.setText("Правила игры");
    }

    @Override
    protected int getLayoutID() {
        return R.layout.fragment_rules;
    }
}
