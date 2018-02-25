package com.mrswimmer.membattle.presentation.intro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import com.mrswimmer.membattle.App;
import com.mrswimmer.membattle.R;
import com.mrswimmer.membattle.presentation.auth.activity.AuthActivity;
import com.mrswimmer.membattle.presentation.main.activity.MainActivity;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String login = App.settings.getString("username", "no");
                Log.i("code", "first: "+login);
                if(login.equals("no")){
                    overridePendingTransition(0,0);
                    TaskStackBuilder.create(getApplicationContext())
                            .addNextIntentWithParentStack(new Intent(getApplicationContext(), AuthActivity.class))
                            .addNextIntent(new Intent(getApplicationContext(), FirstStartActivity.class))
                            .startActivities();
                    finish();
                }
                else {
                    overridePendingTransition(0,0);
                    Intent i = new Intent(Splash.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        }, 2000);
    }
}
