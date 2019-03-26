package com.example.nailo;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


/**
 * A simple {@link Fragment} subclass.
 */
public class Home_fagm extends Fragment {
    FirebaseDatabase database;
    DatabaseReference myRefr1 ;
    DatabaseReference myRefr2 ;
    DatabaseReference myRefr3 ;
    DatabaseReference myRefr4 ;
    DatabaseReference weatherRef;
    public Home_fagm() {
        // Required empty public constructor
    }

View v;
    int r1=0,r2=0,r3=0,r4=0;
    Switch b1,b2,fan,motor ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
    v= inflater.inflate(R.layout.fragment_home_fagm, container, false);
        final TextView temp=(TextView)v.findViewById(R.id.txtemperature);
        final TextView humid=(TextView)v.findViewById(R.id.textViewhumidity);
        TextView switch1=(TextView)v.findViewById(R.id.textView3);
        b1=(Switch)v.findViewById(R.id.Bulb1);
        b2=(Switch)v.findViewById(R.id.Bulb12);
        fan=(Switch)v.findViewById(R.id.Fan1);
        motor=(Switch)v.findViewById(R.id.motor);
        database = FirebaseDatabase.getInstance();
        myRefr1= database.getReference("relay1/status");
        myRefr2= database.getReference("relay2/status");
        myRefr3= database.getReference("relay3/status");
        myRefr4= database.getReference("relay4/status");
        weatherRef=database.getReference("weather");
        weatherRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
              Float tempdata=dataSnapshot.child("temparature").getValue(Float.class);
              Float humidity=dataSnapshot.child("humidity").getValue(Float.class);
              temp.setText("Temparature  :   "+tempdata);
              humid.setText("Humidity      :   "+humidity);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        b1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {myRefr1.setValue(1);
                }
                else
                {
                    myRefr1.setValue(0);
                }
            }
        });
        b2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    myRefr2.setValue(1);

                }
                else
                    myRefr2.setValue(0);
            }
        });
        fan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    myRefr3.setValue(1);
                else
                    myRefr3.setValue(0);
            }
        });

        motor.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                    myRefr4.setValue(1);
                else
                    myRefr4.setValue(0);
            }
        });
myRefr1.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        r1=dataSnapshot.getValue(Integer.class);
        if(r1==1)
            b1.setChecked(true);
        else
            b1.setChecked(false);
    }


    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});

myRefr2.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        r2=dataSnapshot.getValue(Integer.class);
        if(r2==1)
            b2.setChecked(true);
        else
            b2.setChecked(false);
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }
});

        myRefr3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                r3=dataSnapshot.getValue(Integer.class);
                if(r3==1)
                    fan.setChecked(true);
                else
                    fan.setChecked(false);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        myRefr4.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                r4=dataSnapshot.getValue(Integer.class);
                if(r4==1)
                    motor.setChecked(true);
                else
                    motor.setChecked(false);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        return(v);
    }

}
