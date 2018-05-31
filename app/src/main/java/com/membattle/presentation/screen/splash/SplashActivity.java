package com.membattle.presentation.screen.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import com.membattle.App;
import com.membattle.R;
import com.membattle.domain.interactor.SettingsService;
import com.membattle.presentation.screen.auth.activity.AuthActivity;
import com.membattle.presentation.screen.main.activity.MainActivity;
import com.membattle.presentation.screen.splash.intro.IntroActivity;
import com.vk.sdk.util.VKUtil;

import javax.inject.Inject;

public class SplashActivity extends Activity {

    @Inject
    SettingsService settingsService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        App.getComponent().inject(this);
        String[] fingerprints = VKUtil.getCertificateFingerprint(this, this.getPackageName());
        Log.i("code", "fingerprint: " + fingerprints[0]);
        new Handler().postDelayed(() -> {
            String login = settingsService.getUsername();
            Log.i("code", "first: " + login);
            if (login.equals("no")) {
                overridePendingTransition(0, 0);
                TaskStackBuilder.create(getApplicationContext())
                        .addNextIntentWithParentStack(new Intent(getApplicationContext(), AuthActivity.class))
                        .addNextIntent(new Intent(getApplicationContext(), IntroActivity.class))
                        .startActivities();
                finish();
            } else {
                overridePendingTransition(0, 0);
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 2000);
    }

}
