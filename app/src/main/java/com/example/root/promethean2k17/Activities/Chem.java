package com.example.root.promethean2k17.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.root.promethean2k17.Adapters.Chem_Adapter;
import com.example.root.promethean2k17.Models.Chem_Model;
import com.example.root.promethean2k17.R;
import com.example.root.promethean2k17.configs.Onitemtouchlistener;

import java.util.ArrayList;

public class Chem extends AppCompatActivity {
Chem_Adapter adapter;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chem);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Chem Events");
        recyclerView= findViewById(R.id.chem_recyclerview);

        ArrayList<Chem_Model> arrayList = new ArrayList<>();
        arrayList.add(new Chem_Model("http://promethean2k17.com/app/images/chem/"));
        arrayList.add(new Chem_Model("http://promethean2k17.com/app/images/chem/"));
        arrayList.add(new Chem_Model("http://promethean2k17.com/app/images/chem/"));
        arrayList.add(new Chem_Model("http://promethean2k17.com/app/images/chem/"));
        arrayList.add(new Chem_Model("http://promethean2k17.com/app/images/chem/"));
        arrayList.add(new Chem_Model("http://promethean2k17.com/app/images/chem/"));
        arrayList.add(new Chem_Model("http://promethean2k17.com/app/images/chem/"));
        adapter=new Chem_Adapter(arrayList,this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new Onitemtouchlistener(context, new Onitemtouchlistener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                switch (position){

                    case 0:
                        Intent i1 = new Intent(getApplicationContext(),Event_Registration.class);
                        i1.putExtra("name","ProcessDesignWorkshop");
                        startActivity(i1);
                        break;
                    case 1:
                        Intent i2 = new Intent(getApplicationContext(),Event_Registration.class);
                        i2.putExtra("name","PaperPresentationChem");
                        startActivity(i2);
                        break;
                    case 2:
                        Intent i3 = new Intent(getApplicationContext(),Event_Registration.class);
                        i3.putExtra("name","PosterPresentationChem");
                        startActivity(i3);
                        break;
                    case 3:
                        Intent i4 = new Intent(getApplicationContext(),Event_Registration.class);
                        i4.putExtra("name","TechnicalQuizChem");
                        startActivity(i4);
                        break;
                    case 4:
                        Intent i5 = new Intent(getApplicationContext(),Event_Registration.class);
                        i5.putExtra("name","ChemHunt");
                        startActivity(i5);
                        break;
                    case 5:
                        Intent i6 = new Intent(getApplicationContext(),Event_Registration.class);
                        i6.putExtra("name","Chemystory");
                        startActivity(i6);
                        break;
                    case 6:
                        Intent i7 = new Intent(getApplicationContext(),Event_Registration.class);
                        i7.putExtra("name","ChemFlash");
                        startActivity(i7);
                        break;

                }

            }
        }));



    }
}
