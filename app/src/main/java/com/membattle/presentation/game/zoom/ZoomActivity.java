package com.membattle.presentation.game.zoom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.membattle.App;
import com.membattle.R;
import com.membattle.domain.service.SettingsService;
import com.squareup.picasso.Picasso;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ZoomActivity extends AppCompatActivity {

    @BindView(R.id.zoom_mem)
    ImageView mem;

    @Inject
    SettingsService settingsService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom);
        ButterKnife.bind(this);
        App.getComponent().inject(this);
        String url = settingsService.getZoomImage();
        Picasso.with(this)
                .load(url)
                .into(mem);
    }

    @OnClick(R.id.zoom_minus)
    void OnMinusClick() {
        finish();
    }
}
