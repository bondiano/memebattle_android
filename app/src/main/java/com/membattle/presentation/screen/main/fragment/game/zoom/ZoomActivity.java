package com.membattle.presentation.screen.main.fragment.game.zoom;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.membattle.App;
import com.membattle.R;
import com.membattle.data.settings.Screens;
import com.membattle.di.qualifier.Global;
import com.membattle.domain.interactor.SettingsService;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ru.terrakok.cicerone.Router;

public class ZoomActivity extends MvpAppCompatActivity implements ZoomActivityView{
    private Target target;
    String url;

    @InjectPresenter
    ZoomActivityPresenter presenter;

    @ProvidePresenter
    public ZoomActivityPresenter presenter() {
        return new ZoomActivityPresenter();
    }

    @BindView(R.id.zoom_mem)
    ImageView mem;
    @BindView(R.id.zoom_download)
    LinearLayout download;
    @BindView(R.id.zoom_share)
    LinearLayout share;
    @BindView(R.id.zoom_prooral)
    LinearLayout prooral;

    @Inject
    SettingsService settingsService;
    @Inject
    @Global
    Router globalRoter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom);
        App.getComponent().inject(this);
        ButterKnife.bind(this);
        url = settingsService.getZoomImage();
        target = presenter.initTarget(url);
        Picasso.with(this)
                .load(url)
                .into(mem);
    }

    @OnClick(R.id.zoom_minus)
    void onMinusClick() {
        finish();
    }

    @OnClick(R.id.zoom_share)
    void onShareClick() {
        globalRoter.navigateTo(Screens.SHARE_IMAGE);
    }

    @OnClick(R.id.zoom_download)
    void onDownloadClick() {
        Picasso.with(this).load(url).into(target);
        download.setAlpha((float) 0.3);
        download.setClickable(false);
    }

    @Override
    public void successDownloadImage() {
        Toast.makeText(this, "Загрузка завершена!", Toast.LENGTH_SHORT).show();
        download.setAlpha((float) 0.3);
        download.setClickable(false);
    }

    @Override
    public void errorDownloadImage() {
        Toast.makeText(this, "Ошибка загрузки!", Toast.LENGTH_SHORT).show();
    }


}
