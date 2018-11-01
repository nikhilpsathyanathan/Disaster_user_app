package in.makesimple.dis_userapp;

import android.app.Service;
import android.content.Intent;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.IBinder;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.telephony.SmsManager;


public class ShareDataService extends Service {

    Location shareLocation = MainActivity.currentlocation;
    public final String AMBUL = "AMBUL";
    public final String POLI = "POLI";
    public final String WOMEN = "WOMEN";
    public String num1, num2, num3, name;
    public String NAME = "NAME", PHONENUMBER = "PHONENUMBER";

    @Override
    public void onCreate() {
        super.onCreate();

        SharedPreferences getSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        num1 = getSharedPreferences.getString(POLI, "DEFAULT");
        num2 = getSharedPreferences.getString(AMBUL, "DEFAULT");
        num3 = getSharedPreferences.getString(WOMEN, "DEFAULT");
        name = getSharedPreferences.getString(NAME, "DEFAULT");

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        sent_sms();
        stopSelf();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void sent_sms() {
        SmsManager smsManager = SmsManager.getDefault();

        try {
            smsManager.sendTextMessage("+919995275909", null, "Im in danger i need Your HELP \n" + "location  :http://maps.google.com/maps?q=loc:" + shareLocation.getLatitude() + "," + shareLocation.getLongitude() + "(" + "My_location" + ")" + "\nAccuracy " + shareLocation.getAccuracy() + "\nAltitude :" + shareLocation.getAltitude(), null, null);
            smsManager.sendTextMessage("+91" + num1, null, "Im (" + name + ") ,Im in danger i need Your HELP \n" + "MY location  :http://maps.google.com/maps?q=loc:" + shareLocation.getLatitude() + "," + shareLocation.getLongitude() + "(" + "My_location" + ")" + "\nAccuracy " + shareLocation.getAccuracy() + "\nAltitude :" + shareLocation.getAltitude(), null, null);
            smsManager.sendTextMessage("+91" + num2, null, "Im (" + name + ") ,Im in danger i need Your HELP \n" + "MY location  :http://maps.google.com/maps?q=loc:" + shareLocation.getLatitude() + "," + shareLocation.getLongitude() + "(" + "My_location" + ")" + "\nAccuracy " + shareLocation.getAccuracy() + "\nAltitude :" + shareLocation.getAltitude(), null, null);
            smsManager.sendTextMessage("+91" + num3, null, "Im (" + name + ") ,Im in danger i need Your HELP \n" + "MY location  :http://maps.google.com/maps?q=loc:" + shareLocation.getLatitude() + "," + shareLocation.getLongitude() + "(" + "My_location" + ")" + "\nAccuracy " + shareLocation.getAccuracy() + "\nAltitude :" + shareLocation.getAltitude(), null, null);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
