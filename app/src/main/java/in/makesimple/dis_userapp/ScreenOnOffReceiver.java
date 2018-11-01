package in.makesimple.dis_userapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

import java.util.Calendar;


public class ScreenOnOffReceiver extends BroadcastReceiver {

    int time1, time2;

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            Calendar c = Calendar.getInstance();
            int count = c.get(Calendar.SECOND);
            time1 = count;
            Log.d("Sreerag", "Screen Off" + count);
            if (time1 - time2 == 0) {
                Log.d("Alert", "Screen Off" + count);
                SharedPreferences getSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                Boolean value = getSharedPreferences.getBoolean("SWITCH", true);
                if (value) {
                    context.startService(new Intent(context, ShareDataService.class));
                }

            }

        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            Calendar c = Calendar.getInstance();
            int count = c.get(Calendar.SECOND);
            time2 = count;
            Log.d("Sreerag", "Screen On" + count);
            if (time1 - time2 == 0) {
                Log.d("alert", "Screen on" + count);
                SharedPreferences getSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                Boolean value = getSharedPreferences.getBoolean("SWITCH", true);
                if (value) {
                    context.startService(new Intent(context, ShareDataService.class));
                }

            }
        }
    }


}