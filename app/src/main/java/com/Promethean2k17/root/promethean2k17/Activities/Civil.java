package com.Promethean2k17.root.promethean2k17.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.Promethean2k17.root.promethean2k17.Adapters.Civil_Adapter;
import com.Promethean2k17.root.promethean2k17.Models.Civil_Model;
import com.Promethean2k17.root.promethean2k17.R;
import com.Promethean2k17.root.promethean2k17.configs.Onitemtouchlistener;

import java.util.ArrayList;

public class Civil extends AppCompatActivity {
Civil_Adapter adapter;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_civil);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Civil Events");
        recyclerView= findViewById(R.id.civil_recyclerview);

        ArrayList<Civil_Model> arrayList = new ArrayList<>();

        arrayList.add(new Civil_Model("http://promethean2k17.com/app/images/civil/aakaar.jpg"));
        arrayList.add(new Civil_Model("http://promethean2k17.com/app/images/civil/sculpt.jpg"));
        arrayList.add(new Civil_Model("http://promethean2k17.com/app/images/civil/paper.jpg"));
        arrayList.add(new Civil_Model("http://promethean2k17.com/app/images/civil/model.jpg"));
        arrayList.add(new Civil_Model("http://promethean2k17.com/app/images/civil/techquiz.jpg"));
        arrayList.add(new Civil_Model("http://promethean2k17.com/app/images/civil/survey.jpg"));
        arrayList.add(new Civil_Model("http://promethean2k17.com/app/images/civil/nirman.jpg"));
        arrayList.add(new Civil_Model("http://promethean2k17.com/app/images/civil/nivaran.jpg"));
        arrayList.add(new Civil_Model("http://promethean2k17.com/app/images/civil/mindchase.jpg"));

        adapter=new Civil_Adapter(arrayList,this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new Onitemtouchlistener(context, new Onitemtouchlistener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                switch (position){

                    case 0:
                        Intent i1 = new Intent(getApplicationContext(),Event_Registration.class);
                        i1.putExtra("name","AakaarWorkshop");
                        startActivity(i1);
                        break;
                    case 1:
                        Intent i2 = new Intent(getApplicationContext(),Event_Registration.class);
                        i2.putExtra("name","sculpt");
                        startActivity(i2);
                        break;
                    case 2:
                        Intent i3 = new Intent(getApplicationContext(),Event_Registration.class);
                        i3.putExtra("name","PaperPresentationCivil");
                        startActivity(i3);
                        break;
                    case 3:
                        Intent i4 = new Intent(getApplicationContext(),Event_Registration.class);
                        i4.putExtra("name","ModelPresentation");
                        startActivity(i4);
                        break;
                    case 4:
                        Intent i5 = new Intent(getApplicationContext(),Event_Registration.class);
                        i5.putExtra("name","TechnicalQuizCivil");
                        startActivity(i5);
                        break;
                    case 5:
                        Intent i6 = new Intent(getApplicationContext(),Event_Registration.class);
                        i6.putExtra("name","QuickSurvey");
                        startActivity(i6);
                        break;
                    case 6:
                        Intent i7 = new Intent(getApplicationContext(),Event_Registration.class);
                        i7.putExtra("name","Nirman");
                        startActivity(i7);
                        break;
                    case 7:
                        Intent i8 = new Intent(getApplicationContext(),Event_Registration.class);
                        i8.putExtra("name","Nivaran");
                        startActivity(i8);
                        break;
                    case 8:
                        Intent i9 = new Intent(getApplicationContext(),Event_Registration.class);
                        i9.putExtra("name","MindChase");
                        startActivity(i9);
                        break;

                }

            }
        }));



    }
}
