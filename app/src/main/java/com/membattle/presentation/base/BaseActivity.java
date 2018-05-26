package com.membattle.presentation.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.viewstate.strategy.OneExecutionStateStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;
import com.membattle.data.settings.Screens;
import com.membattle.di.qualifier.Global;
import com.membattle.di.qualifier.Local;
import com.membattle.domain.interactor.SocketService;
import com.membattle.domain.utils.GlobalNavigator;
import com.membattle.domain.utils.LocalNavigator;
import com.membattle.domain.utils.SocketListener;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Inject;

import butterknife.ButterKnife;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

public abstract class BaseActivity extends MvpAppCompatActivity implements BaseView {

    @Inject
    @Local
    NavigatorHolder localNavigatorHolder;
    @Inject
    @Global
    NavigatorHolder globalNavigatorHolder;
    @Inject
    @Local
    Router localRouter;
    @Inject
    @Global
    Router globalRouter;
    @Inject
    SocketService socketService;

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("code", "stop");
        if (SocketListener.class.isAssignableFrom(getClass())) {
            socketService.close();
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("code", "create");
        injectDependencies();
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        localRouter.newRootScreen(Screens.SIGN_IN_SCREEN);
        if (SocketListener.class.isAssignableFrom(getClass())) {
            socketService.connect();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("code", "resume");
        localNavigatorHolder.setNavigator(new LocalNavigator(getSupportFragmentManager(), getContainerId()));
        globalNavigatorHolder.setNavigator(new GlobalNavigator(this));
    }

    protected abstract int getContainerId();

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("code", "activity pause");
        localNavigatorHolder.removeNavigator();
    }

    protected abstract void injectDependencies();

    protected abstract int getLayoutId();

    @Override
    @StateStrategyType(OneExecutionStateStrategy.class)
    public void showToast(String message) {
        Log.i("code", "toast");
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showDialog(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());
        builder.setTitle(title)
                .setMessage(message)
                .setCancelable(false)
                .setPositiveButton("ОК",
                        (dialog, id) -> dialog.cancel());
        AlertDialog alert = builder.create();
        alert.show();
    }
}
