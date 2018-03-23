package com.membattle.presentation.main.activity;

import android.graphics.Rect;
import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.membattle.App;
import com.membattle.R;
import com.membattle.data.settings.Screens;
import com.membattle.data.settings.Settings;
import com.membattle.di.qualifier.Global;
import com.membattle.di.qualifier.Local;
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
    @Local
    Router router;

    @Inject
    @Global
    Router globalRouter;

    public void initBmb(BoomMenuButton bmb) {
        bmb.setButtonEnum(ButtonEnum.TextOutsideCircle);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_6_1);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_6_1);
        bmb.setDimColor(R.color.main_blue);
        for (int i = 0; i < bmb.getButtonPlaceEnum().buttonNumber(); i++) {
            final int finalI = i;
            bmb.addBuilder(new TextOutsideCircleButton.Builder()
                    .normalImageRes(Settings.MAIN_ICONS[i])
                    .normalText(Settings.MAIN_NAMES[i])
                    .imagePadding(new Rect(30, 30, 30, 30))
                    .textSize(13)
                    .listener(index -> {
                        Log.i("code", index + "");
                        switch (finalI) {
                            case 0:
                                router.replaceScreen(Screens.SETTINGS_SCREEN);
                                break;
                            case 1:
                                router.replaceScreen(Screens.INFO_SCREEN);
                                break;
                            case 2:
                                router.replaceScreen(Screens.PROFILE_SCREEN);
                                break;
                            case 3:
                                router.replaceScreen(Screens.MODES_SCREEN);
                                break;
                            case 4:
                                router.replaceScreen(Screens.RATE_SCREEN);
                                break;
                            case 5:
                                globalRouter.navigateTo(Screens.SHOP_SCREEN);
                                //getViewState().showToast("Магазин пока не работает!");
                                break;
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
