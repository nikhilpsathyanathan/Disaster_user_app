package in.makesimple.dis_userapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ProgressBar;


public class Welcome extends AppCompatActivity {
    public boolean isFirstStart;
    Thread t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_SECURE, WindowManager.LayoutParams.FLAG_SECURE);
        setContentView(R.layout.activity_welcome);

        final ProgressBar pgr = (ProgressBar) findViewById(R.id.progressBar);
        pgr.setVisibility(View.VISIBLE);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                activity();
            }
        }, 1500);

    }


    public void activity() {
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                SharedPreferences getSharedPreferences = PreferenceManager
                        .getDefaultSharedPreferences(getBaseContext());
                isFirstStart = getSharedPreferences.getBoolean("firstStart", true);
                if (isFirstStart) {
                    Intent i = new Intent(Welcome.this, IntroActivity.class);
                    startActivity(i);
                    finish();

                } else {
                    Intent i = new Intent(Welcome.this, MainActivity.class);
                    startActivity(i);
                    finish();
                }

            }
        });
        t.start();
    }

}
