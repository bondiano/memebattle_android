package com.membattle.presentation.splash;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import com.membattle.App;
import com.membattle.R;
import com.membattle.presentation.auth.activity.AuthActivity;
import com.membattle.presentation.main.activity.MainActivity;
import com.membattle.presentation.splash.intro.IntroActivity;

import javax.inject.Inject;

public class SplashActivity extends Activity {

    @Inject
    SharedPreferences settings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        App.getComponent().inject(this);
        new Handler().postDelayed(() -> {
            String login = settings.getString("username", "no");
            Log.i("code", "first: "+login);
            if(login.equals("no")){
                overridePendingTransition(0,0);
                TaskStackBuilder.create(getApplicationContext())
                        .addNextIntentWithParentStack(new Intent(getApplicationContext(), AuthActivity.class))
                        .addNextIntent(new Intent(getApplicationContext(), IntroActivity.class))
                        .startActivities();
                finish();
            }
            else {
                overridePendingTransition(0,0);
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 2000);
    }

}
