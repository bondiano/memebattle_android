package com.membattle.presentation.intro;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.TaskStackBuilder;
import android.util.Log;

import com.membattle.App;
import com.membattle.R;
import com.membattle.presentation.auth.activity.AuthActivity;
import com.membattle.presentation.main.activity.MainActivity;

public class Splash extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(() -> {
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
        }, 2000);
    }
}
