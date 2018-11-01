package in.makesimple.dis_userapp;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;

import agency.tango.materialintroscreen.SlideFragment;


public class CustomSlide extends SlideFragment {
    private CheckBox checkBox;
    public String NAME = "NAME", PHONENUMBER = "PHONENUMBER";
    public EditText name, phno;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.intro_permission_custom_slide, container, false);
        checkBox = (CheckBox) view.findViewById(R.id.checkBox);
        name = (EditText) view.findViewById(R.id.name);
        phno = (EditText) view.findViewById(R.id.phno);
        return view;
    }

    @Override
    public int backgroundColor() {
        return R.color.white;
    }

    @Override
    public int buttonsColor() {
        return R.color.colorPrimary;
    }

    @Override
    public boolean canMoveFurther() {
        SharedPreferences getSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor number = getSharedPreferences.edit();
        String Sname = name.getText().toString();
        String Sphno = phno.getText().toString();

        number.putString(NAME, Sname);
        number.putString(PHONENUMBER, Sphno);
        number.apply();
        return checkBox.isChecked();
    }

    @Override
    public String cantMoveFurtherErrorMessage() {
        return "provide info";
    }
}