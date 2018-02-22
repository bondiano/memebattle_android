package com.mrswimmer.memebattle.presentation.game.activity;

import android.graphics.Rect;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.Toast;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.mrswimmer.memebattle.App;
import com.mrswimmer.memebattle.R;
import com.mrswimmer.memebattle.data.settings.Screens;
import com.mrswimmer.memebattle.data.settings.Settings;
import com.mrswimmer.memebattle.presentation.main.fragment.modes.ModesFragment;
import com.nightonke.boommenu.BoomButtons.ButtonPlaceEnum;
import com.nightonke.boommenu.BoomButtons.TextOutsideCircleButton;
import com.nightonke.boommenu.BoomMenuButton;
import com.nightonke.boommenu.ButtonEnum;
import com.nightonke.boommenu.Piece.PiecePlaceEnum;

import javax.inject.Inject;

import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.Router;
import ru.terrakok.cicerone.android.SupportFragmentNavigator;

@InjectViewState
public class GameActivityPresenter extends MvpPresenter<GameActivityView> {

    GameActivityPresenter() {
        App.getComponent().inject(this);
    }

    @Inject
    Router router;

    public void initBmb(BoomMenuButton bmb) {
        bmb.setButtonEnum(ButtonEnum.TextOutsideCircle);
        bmb.setPiecePlaceEnum(PiecePlaceEnum.DOT_6_1);
        bmb.setButtonPlaceEnum(ButtonPlaceEnum.SC_6_1);
        bmb.setDimColor(R.color.main_blue);
        for (int i = 0; i < bmb.getButtonPlaceEnum().buttonNumber(); i++) {
            final int finalI = i;
            bmb.addBuilder(new TextOutsideCircleButton.Builder()
                    .normalImageRes(Settings.GAME_ICONS[i])
                    .normalText(Settings.GAME_NAMES[i])
                    .imagePadding(new Rect(30, 30,30, 30))
                    .textSize(13)
                    .listener(index -> {
                        Log.i("code", index+"");
                        switch (finalI) {
                            case 0 :
                                router.navigateTo(Screens.SETTINGS_SCREEN); break;
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
