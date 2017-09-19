package com.Promethean2k17.root.promethean2k17.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;


import com.Promethean2k17.root.promethean2k17.Adapters.Ece_Adapter;

import com.Promethean2k17.root.promethean2k17.Models.Ece_Model;
import com.Promethean2k17.root.promethean2k17.R;
import com.Promethean2k17.root.promethean2k17.configs.Onitemtouchlistener;

import java.util.ArrayList;

public class Ece extends AppCompatActivity {
    Ece_Adapter adapter;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ece);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Ece Events");
        recyclerView= findViewById(R.id.ece_recyclerview);

        ArrayList<Ece_Model> arrayList = new ArrayList<>();
        arrayList.add(new Ece_Model("http://promethean2k17.com/app/images/ece/lab.jpg"));
        arrayList.add(new Ece_Model("http://promethean2k17.com/app/images/ece/arandvr.jpg"));
        arrayList.add(new Ece_Model("http://promethean2k17.com/app/images/ece/paper.jpg"));
        arrayList.add(new Ece_Model("http://promethean2k17.com/app/images/ece/arduino.jpg"));
        arrayList.add(new Ece_Model("http://promethean2k17.com/app/images/ece/conspectus.jpg"));
        arrayList.add(new Ece_Model("http://promethean2k17.com/app/images/ece/technofunduzo.jpg"));
        arrayList.add(new Ece_Model("http://promethean2k17.com/app/images/ece/einstien.jpg"));
        arrayList.add(new Ece_Model("http://promethean2k17.com/app/images/ece/fun.jpg"));
        arrayList.add(new Ece_Model("http://promethean2k17.com/app/images/ece/physics.jpg"));
        arrayList.add(new Ece_Model("http://promethean2k17.com/app/images/ece/project.jpg"));
        arrayList.add(new Ece_Model("http://promethean2k17.com/app/images/ece/brain.jpg"));
        arrayList.add(new Ece_Model("http://promethean2k17.com/app/images/ece/mock.jpg"));
        arrayList.add(new Ece_Model("http://promethean2k17.com/app/images/ece/digital.jpg"));
        arrayList.add(new Ece_Model("http://promethean2k17.com/app/images/ece/electro.jpg"));
        arrayList.add(new Ece_Model("http://promethean2k17.com/app/images/ece/circuit.jpg"));
        adapter=new Ece_Adapter(arrayList,this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new Onitemtouchlistener(context, new Onitemtouchlistener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                switch (position){

                    case 0:
                        Intent i1=new Intent(getApplicationContext(),Event_Registration.class);
                        i1.putExtra("name","LABVIEWWorkshop");
                        startActivity(i1);
                        break;
                    case 1:
                        Intent i2=new Intent(getApplicationContext(),Event_Registration.class);
                        i2.putExtra("name","ARandVRWorkshop");
                        startActivity(i2);
                        break;
                    case 2:
                        Intent i3=new Intent(getApplicationContext(),Event_Registration.class);
                        i3.putExtra("name","Transcedence");
                        startActivity(i3);
                        break;
                    case 3:
                        Intent i4=new Intent(getApplicationContext(),Event_Registration.class);
                        i4.putExtra("name","AptiArduino");
                        startActivity(i4);
                        break;
                    case 4:
                        Intent i5=new Intent(getApplicationContext(),Event_Registration.class);
                        i5.putExtra("name","Conspectus");
                        startActivity(i5);
                        break;
                    case 5:
                        Intent i6=new Intent(getApplicationContext(),Event_Registration.class);
                        i6.putExtra("name","TechnoFunduzo");
                        startActivity(i6);
                        break;
                    case 6:
                        Intent i7=new Intent(getApplicationContext(),Event_Registration.class);
                        i7.putExtra("name","EinsteinQuiz");
                        startActivity(i7);
                        break;
                    case 7:
                        Intent i8=new Intent(getApplicationContext(),Event_Registration.class);
                        i8.putExtra("name","FunFromJunk");
                        startActivity(i8);
                        break;
                    case 8:
                        Intent i9=new Intent(getApplicationContext(),Event_Registration.class);
                        i9.putExtra("name","HonestPhysics");
                        startActivity(i9);
                        break;
                    case 9:
                        Intent i10=new Intent(getApplicationContext(),Event_Registration.class);
                        i10.putExtra("name","ProjectExpoEce");
                        startActivity(i10);
                        break;
                    case 10:
                        Intent i11=new Intent(getApplicationContext(),Event_Registration.class);
                        i11.putExtra("name","BrainMarathon");
                        startActivity(i11);
                        break;
                    case 11:
                        Intent i12=new Intent(getApplicationContext(),Event_Registration.class);
                        i12.putExtra("name","Enigma");
                        startActivity(i12);
                        break;
                    case 12:
                        Intent i13=new Intent(getApplicationContext(),Event_Registration.class);
                        i13.putExtra("name","DigitalOmaniac");
                        startActivity(i13);
                        break;
                    case 13:
                        Intent i14=new Intent(getApplicationContext(),Event_Registration.class);
                        i14.putExtra("name","ElectroWizard");
                        startActivity(i14);
                        break;
                    case 14:
                        Intent i15=new Intent(getApplicationContext(),Event_Registration.class);
                        i15.putExtra("name","Circuitrix");
                        startActivity(i15);
                        break;

                }

            }
        }));


    
    }
}
