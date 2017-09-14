package com.example.root.promethean2k17.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.root.promethean2k17.Adapters.Mech_Adapter;
import com.example.root.promethean2k17.Models.Mech_Model;
import com.example.root.promethean2k17.R;
import com.example.root.promethean2k17.configs.Onitemtouchlistener;

import java.util.ArrayList;

public class Mech extends AppCompatActivity {
    Mech_Adapter adapter;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mech);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Mech Events");
        recyclerView=(RecyclerView)findViewById(R.id.mech_recyclerview);

        ArrayList<Mech_Model> arrayList = new ArrayList<>();
        arrayList.add(new Mech_Model(R.drawable.cse));
        arrayList.add(new Mech_Model(R.drawable.eee));
        arrayList.add(new Mech_Model(R.drawable.ece));
        arrayList.add(new Mech_Model(R.drawable.mech));
        adapter=new Mech_Adapter(arrayList,this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new Onitemtouchlistener(context, new Onitemtouchlistener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                switch (position){

                    case 0:
                        startActivity(new Intent(getApplicationContext(),Event_Registration.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(),Event_Registration.class));
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(),Event_Registration.class));
                        break;
                    case 3:
                        startActivity(new Intent(getApplicationContext(),Event_Registration.class));
                        break;

                }

            }
        }));


    }
}
