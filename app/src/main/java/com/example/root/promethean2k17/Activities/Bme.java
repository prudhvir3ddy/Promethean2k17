package com.example.root.promethean2k17.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.root.promethean2k17.Adapters.Bme_Adapter;
import com.example.root.promethean2k17.Models.Bme_Model;
import com.example.root.promethean2k17.R;
import com.example.root.promethean2k17.configs.Onitemtouchlistener;

import java.util.ArrayList;

public class Bme extends AppCompatActivity {
Bme_Adapter adapter;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bme);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Bme Events");
        recyclerView=(RecyclerView)findViewById(R.id.bme_recyclerview);

        ArrayList<Bme_Model> arrayList = new ArrayList<>();
        arrayList.add(new Bme_Model(R.drawable.cse));
        arrayList.add(new Bme_Model(R.drawable.cse));
        arrayList.add(new Bme_Model(R.drawable.cse));
        arrayList.add(new Bme_Model(R.drawable.cse));
        arrayList.add(new Bme_Model(R.drawable.cse));
        arrayList.add(new Bme_Model(R.drawable.cse));
        arrayList.add(new Bme_Model(R.drawable.cse));
        adapter=new Bme_Adapter(arrayList,this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new Onitemtouchlistener(context, new Onitemtouchlistener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                switch (position){

                    case 0:
                        Intent i1=new Intent(getApplicationContext(),Event_Registration.class);
                        i1.putExtra("name","GuestLectureBme");
                        startActivity(i1);
                        break;
                    case 1:
                        Intent i2=new Intent(getApplicationContext(),Event_Registration.class);
                        i2.putExtra("name","PaperPresentationBme");
                        startActivity(i2);
                        break;
                    case 2:
                        Intent i3=new Intent(getApplicationContext(),Event_Registration.class);
                        i3.putExtra("name","PosterPresentationBme");
                        startActivity(i3);
                        break;
                    case 3:
                        Intent i4=new Intent(getApplicationContext(),Event_Registration.class);
                        i4.putExtra("name","Medquizard");
                        startActivity(i4);
                        break;
                    case 4:
                        Intent i5=new Intent(getApplicationContext(),Event_Registration.class);
                        i5.putExtra("name","SlideOverSlides");
                        startActivity(i5);
                        break;
                    case 5:
                        Intent i6=new Intent(getApplicationContext(),Event_Registration.class);
                        i6.putExtra("name","TheHauntedHospital");
                        startActivity(i6);
                        break;
                    case 6:
                        Intent i7=new Intent(getApplicationContext(),Event_Registration.class);
                        i7.putExtra("name","GuessTheGuilty");
                        startActivity(i7);
                        break;

                }

            }
        }));


    }
    }

