package com.membattle.presentation.game.activity;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.app.AlertDialog;
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

import java.util.Set;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

@InjectViewState
public class GameActivityPresenter extends MvpPresenter<GameActivityView> {

    GameActivityPresenter() {
        App.getComponent().inject(this);
    }

    @Inject
    @Local
    Router router;

    @Inject
    @Global
    Router globalRouter;

    public void initBmb(BoomMenuButton bmb, int mode) {
        bmb.setButtonEnum(ButtonEnum.TextOutsideCircle);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_6_1);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_6_1);
        bmb.setDimColor(R.color.main_blue);
        for (int i = 0; i < bmb.getButtonPlaceEnum().buttonNumber(); i++) {
            final int finalI = i;
            bmb.addBuilder(new TextOutsideCircleButton.Builder()
                    .normalImageRes(Settings.GAME_ICONS[i])
                    .normalText(Settings.GAME_NAMES[i])
                    .imagePadding(new Rect(30, 30, 30, 30))
                    .textSize(13)
                    .listener(index -> {
                        Log.i("code", index + "");
                        switch (finalI) {
                            case 0:
                                router.replaceScreen(Screens.GAME_SCREEN);
                                break;
                            case 1:
                                globalRouter.navigateTo(Screens.RULES_DIALOG, Settings.ARRAY_RULES[mode]);
                                //getViewState().showDialog("Правила", Settings.ARRAY_RULES[mode]);
                                break;
                            case 2:
                                router.replaceScreen(Screens.PROFILE_SCREEN);
                                break;
                            case 3:
                                router.replaceScreen(Screens.RATE_SCREEN);
                                break;
                            case 4:
                                globalRouter.backTo(Screens.MAIN_ACTIVITY);
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
        router.newRootScreen(Screens.GAME_SCREEN);
    }
}
