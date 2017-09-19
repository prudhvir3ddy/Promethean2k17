package com.Promethean2k17.root.promethean2k17.Activities;

import android.content.Context;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.Promethean2k17.root.promethean2k17.Adapters.Mba_Adapter;

import com.Promethean2k17.root.promethean2k17.Models.Mba_Model;
import com.Promethean2k17.root.promethean2k17.R;
import com.Promethean2k17.root.promethean2k17.configs.Onitemtouchlistener;

import java.util.ArrayList;

public class Mba extends AppCompatActivity {
RecyclerView recyclerView;
    Mba_Adapter adapter;
    LinearLayoutManager layoutManager;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mba);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Mba Events");
        recyclerView= findViewById(R.id.mba_recyclerview);

        ArrayList<Mba_Model> arrayList = new ArrayList<>();
        arrayList.add(new Mba_Model("http://promethean2k17.com/app/images/comingsoon.jpg"));
        adapter=new Mba_Adapter(arrayList,this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new Onitemtouchlistener(context, new Onitemtouchlistener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                switch (position){

                    case 0:
                        return;
//                        startActivity(new Intent(getApplicationContext(),Event_Registration.class));


                }

            }
        }));



    }
}
