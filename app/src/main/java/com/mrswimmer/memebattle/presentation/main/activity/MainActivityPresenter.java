package com.mrswimmer.memebattle.presentation.main.activity;

import android.graphics.Rect;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mrswimmer.memebattle.App;
import com.mrswimmer.memebattle.data.settings.Screens;
import com.mrswimmer.memebattle.data.settings.Settings;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class MainActivityPresenter extends MvpPresenter<MainActivityView> {

    MainActivityPresenter() {
        App.getComponent().inject(this);
    }

    @Inject
    Router router;

    public void initBmb(BoomMenuButton bmb) {
        bmb.setButtonEnum(ButtonEnum.TextOutsideCircle);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_6_1);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_6_1);
        for (int i = 0; i < bmb.getButtonPlaceEnum().buttonNumber(); i++) {
            final int finalI = i;
            bmb.addBuilder(new TextOutsideCircleButton.Builder()
                    .normalImageRes(Settings.MAIN_ICONS[i])
                    .normalText(Settings.MAIN_NAMES[i])
                    .imagePadding(new Rect(30, 30,30, 30))
                    .textSize(13)
                    .listener(index -> {
                        Log.i("code", index+"");
                        switch (finalI) {
                            case 0 :
                                router.navigateTo(Screens.MODES_SCREEN); break;
                        }
                    }));
        }
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        router.newRootScreen(Screens.MODES_SCREEN);
    }
}
