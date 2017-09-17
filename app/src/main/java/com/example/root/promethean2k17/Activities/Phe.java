package com.example.root.promethean2k17.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.root.promethean2k17.Adapters.Phe_Adapter;
import com.example.root.promethean2k17.Adapters.Phe_Adapter;
import com.example.root.promethean2k17.Models.Phe_Model;
import com.example.root.promethean2k17.R;
import com.example.root.promethean2k17.configs.Onitemtouchlistener;

import java.util.ArrayList;

public class Phe extends AppCompatActivity {
Phe_Adapter adapter;
    RecyclerView recyclerView;
    Context context;
    LinearLayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phe);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Phe Events");
        recyclerView=(RecyclerView)findViewById(R.id.phe_recyclerview);

        ArrayList<Phe_Model> arrayList = new ArrayList<>();
        arrayList.add(new Phe_Model(R.drawable.cse));
        arrayList.add(new Phe_Model(R.drawable.cse));
        arrayList.add(new Phe_Model(R.drawable.cse));
        arrayList.add(new Phe_Model(R.drawable.cse));
        arrayList.add(new Phe_Model(R.drawable.cse));
        arrayList.add(new Phe_Model(R.drawable.cse));
        adapter=new Phe_Adapter(arrayList,this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new Onitemtouchlistener(context, new Onitemtouchlistener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                switch (position){

                    case 0:
                        Intent i1=new Intent(getApplicationContext(),Event_Registration.class);
                        i1.putExtra("name","PaperPresentationPhe");
                        startActivity(i1);
                        break;
                    case 1:
                        Intent i2=new Intent(getApplicationContext(),Event_Registration.class);
                        i2.putExtra("name","PosterPresentationPhe");
                        startActivity(i2);
                        break;
                    case 2:
                        Intent i3=new Intent(getApplicationContext(),Event_Registration.class);
                        i3.putExtra("name","TechnicalQuizPhe");
                        startActivity(i3);
                        break;
                    case 3:
                        Intent i4=new Intent(getApplicationContext(),Event_Registration.class);
                        i4.putExtra("name","SherLocked");
                        startActivity(i4);
                        break;
                    case 4:
                        Intent i5=new Intent(getApplicationContext(),Event_Registration.class);
                        i5.putExtra("name","NameThePlant");
                        startActivity(i5);
                        break;
                    case 5:
                        Intent i6=new Intent(getApplicationContext(),Event_Registration.class);
                        i6.putExtra("name","MakeaBotWorkshop");
                        startActivity(i6);
                        break;

                }

            }
        }));



    }
}
