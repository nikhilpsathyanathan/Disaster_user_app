package in.makesimple.dis_userapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Contact extends AppCompatActivity {
    public final String AMBUL = "AMBUL";
    public final String POLI = "POLI";
    public final String WOMEN = "WOMEN";
    public EditText police, woman, ambulance;
    public Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        police = (EditText) findViewById(R.id.poli);
        ambulance = (EditText) findViewById(R.id.ambul);
        woman = (EditText) findViewById(R.id.womencell);

        try {
            SharedPreferences getSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            String num1 = getSharedPreferences.getString(POLI, "DEFAULT");
            String num2 = getSharedPreferences.getString(AMBUL, "DEFAULT");
            String num3 = getSharedPreferences.getString(WOMEN, "DEFAULT");

            police.setText(num1);
            ambulance.setText(num2);
            woman.setText(num3);
        } catch (Exception e) {
            e.printStackTrace();

        }
        save = (Button) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Contact.this, "Successfully Saved", Toast.LENGTH_SHORT).show();
                String num_poli = police.getText().toString();
                String num_ambu = ambulance.getText().toString();
                String num_woman = woman.getText().toString();


                SharedPreferences getSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
                SharedPreferences.Editor number = getSharedPreferences.edit();
                number.putString(AMBUL, num_ambu);
                number.putString(POLI, num_poli);
                number.putString(WOMEN, num_woman);
                number.apply();
            }
        });
    }
}
