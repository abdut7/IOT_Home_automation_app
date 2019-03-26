package com.example.nailo;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


/**
 * A simple {@link Fragment} subclass.
 */
public class Settings_fgm extends Fragment {

    EditText b1edhh,b1edmm,b1edss,b2edhh,b2edmm,b2edss,b3edhh,b3edmm,b3edss,motorhh,motormm,motorss;
    CheckBox chb1,chb2,chb3,chb4;
    Button bl1,bl2,bl3,bl4;
    public Settings_fgm() {
        // Required empty public constructor
    }

    View v;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        v=inflater.inflate(R.layout.fragment_settings_fgm, container, false);
        // Inflate the layout for this fragment
        b1edhh=(EditText)v.findViewById(R.id.edb1hh);
        b1edmm=(EditText)v.findViewById(R.id.edb1mm);
        b1edss=(EditText)v.findViewById(R.id.edb1ss);
        b2edhh=(EditText)v.findViewById(R.id.edb2hh);
        b2edmm=(EditText)v.findViewById(R.id.edb2mm);
        b2edss=(EditText)v.findViewById(R.id.edb2ss);
        b3edhh=(EditText)v.findViewById(R.id.edb3hh);
        b3edmm=(EditText)v.findViewById(R.id.edb3mm);
        b3edss=(EditText)v.findViewById(R.id.edb3ss);
        motorhh=(EditText)v.findViewById(R.id.edmotorhh);
        motormm=(EditText)v.findViewById(R.id.edmotormm);
        motorss=(EditText)v.findViewById(R.id.edmotorss);
        chb1=(CheckBox)v.findViewById(R.id.chbl1);
        chb2=(CheckBox)v.findViewById(R.id.chbl2);
        chb3=(CheckBox)v.findViewById(R.id.chbl3);
        chb4=(CheckBox)v.findViewById(R.id.chmotor);
        bl1=(Button)v.findViewById(R.id.bt1);
        bl2=(Button)v.findViewById(R.id.bt2);
        bl3=(Button)v.findViewById(R.id.bt3);
        bl4=(Button)v.findViewById(R.id.btmotor);
        chb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    bl1.setEnabled(true);
                else
                    bl1.setEnabled(false);
            }
        });
        chb2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    bl2.setEnabled(true);
                else
                    bl2.setEnabled(false);
            }
        });
        chb3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    bl3.setEnabled(true);
                else
                    bl3.setEnabled(false);
            }
        });
        chb4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    bl4.setEnabled(true);
                else
                    bl4.setEnabled(false);
            }
        });
        final DatabaseReference timer_bulb1_REf= FirebaseDatabase.getInstance().getReference("relay1/Timer");
        final DatabaseReference timer_bulb2_REf= FirebaseDatabase.getInstance().getReference("relay2/Timer");
        final DatabaseReference timer_fan_REf= FirebaseDatabase.getInstance().getReference("relay3/Timer");
        final DatabaseReference timer_motor_REf= FirebaseDatabase.getInstance().getReference("relay4/Timer");
        bl1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer_bulb1_REf.child("HH").setValue(b1edhh.getText().toString());
                timer_bulb1_REf.child("MM").setValue(b1edmm.getText().toString());
                timer_bulb1_REf.child("SS").setValue(b1edss.getText().toString());
                b1edhh.setText("");b1edmm.setText("");b1edss.setText("");
                chb3.setChecked(false);
            }
        });
        bl2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer_bulb2_REf.child("HH").setValue(b2edhh.getText().toString());
                timer_bulb2_REf.child("MM").setValue(b2edmm.getText().toString());
                timer_bulb2_REf.child("SS").setValue(b2edss.getText().toString());
                b2edhh.setText("");b2edmm.setText("");b2edss.setText("");
                chb2.setChecked(false);
            }
        });
        bl3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer_fan_REf.child("HH").setValue(b3edhh.getText().toString());
                timer_fan_REf.child("MM").setValue(b3edmm.getText().toString());
                timer_fan_REf.child("SS").setValue(b3edss.getText().toString());
                b3edhh.setText("");b3edmm.setText("");b3edss.setText("");
                chb3.setChecked(false);
            }
        });

        bl4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer_motor_REf.child("HH").setValue(motorhh.getText().toString());
                timer_motor_REf.child("MM").setValue(motormm.getText().toString());
                timer_motor_REf.child("SS").setValue(motorss.getText().toString());
                b3edhh.setText("");b3edmm.setText("");b3edss.setText("");
                chb3.setChecked(false);
            }
        });



        return v;
    }

}
