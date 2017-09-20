package com.Promethean2k17.root.promethean2k17.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.Promethean2k17.root.promethean2k17.Adapters.Cse_Adapter;
import com.Promethean2k17.root.promethean2k17.Models.Cse_Model;

import com.Promethean2k17.root.promethean2k17.R;
import com.Promethean2k17.root.promethean2k17.configs.Onitemtouchlistener;

import java.util.ArrayList;

public class Cse extends AppCompatActivity {
Cse_Adapter adapter;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cse);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Cse Events");
        recyclerView= findViewById(R.id.cse_recyclerview);

        ArrayList<Cse_Model> arrayList = new ArrayList<>();
        arrayList.add(new Cse_Model("http://promethean2k17.com/app/images/cse/web.jpg"));
        arrayList.add(new Cse_Model("http://promethean2k17.com/app/images/cse/python.jpg"));
        arrayList.add(new Cse_Model("http://promethean2k17.com/app/images/cse/ibm.jpg"));
        arrayList.add(new Cse_Model("http://promethean2k17.com/app/images/cse/paper.jpg"));
        arrayList.add(new Cse_Model("http://promethean2k17.com/app/images/cse/poster.jpg"));
        arrayList.add(new Cse_Model("http://promethean2k17.com/app/images/cse/techmaze.jpg"));
        arrayList.add(new Cse_Model("http://promethean2k17.com/app/images/cse/codechef.jpg"));
        arrayList.add(new Cse_Model("http://promethean2k17.com/app/images/cse/erudite.jpg"));
        arrayList.add(new Cse_Model("http://promethean2k17.com/app/images/cse/technoladder.jpg"));
        arrayList.add(new Cse_Model("http://promethean2k17.com/app/images/cse/codevyuha.jpg"));
        arrayList.add(new Cse_Model("http://promethean2k17.com/app/images/cse/decoderace.jpg"));
        arrayList.add(new Cse_Model("http://promethean2k17.com/app/images/cse/readyplayer.jpg"));
        arrayList.add(new Cse_Model("http://promethean2k17.com/app/images/cse/coderunner.jpg"));
        arrayList.add(new Cse_Model("http://promethean2k17.com/app/images/cse/mock.jpg"));

        adapter=new Cse_Adapter(arrayList,this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new Onitemtouchlistener(context, new Onitemtouchlistener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                switch (position){

                    case 0:
                        Intent i1 = new Intent(getApplicationContext(),Event_Registration.class);
                        i1.putExtra("name","WeboMaster");
                        startActivity(i1);

                        break;
                    case 1:
                        Intent i12 = new Intent(getApplicationContext(),Event_Registration.class);
                        i12.putExtra("name","PythonWithHandsOn");
                        startActivity(i12);

                        break;
                    case 2:
                        Intent i13 = new Intent(getApplicationContext(),Event_Registration.class);
                        i13.putExtra("name","IBMBlueMix");
                        startActivity(i13);

                        break;
                    case 3:
                        Intent i2 = new Intent(getApplicationContext(),Event_Registration.class);
                        i2.putExtra("name","PaperPresentationCse");
                        startActivity(i2);
                        break;
                    case 4:
                        Intent i3 = new Intent(getApplicationContext(),Event_Registration.class);
                        i3.putExtra("name","PosterPresentationCse");
                        startActivity(i3);
                        break;
                    case 5:
                        Intent i4 = new Intent(getApplicationContext(),Event_Registration.class);
                        i4.putExtra("name","TechMaze");
                        startActivity(i4);
                        break;
                    case 6:
                        Intent i5 = new Intent(getApplicationContext(),Event_Registration.class);
                        i5.putExtra("name","CodeChef");
                        startActivity(i5);
                        break;
                    case 7:
                        Intent i6 = new Intent(getApplicationContext(),Event_Registration.class);
                        i6.putExtra("name","TheErudite");
                        startActivity(i6);
                        break;
                    case 8:
                        Intent i7 = new Intent(getApplicationContext(),Event_Registration.class);
                        i7.putExtra("name","TechnoLadder");
                        startActivity(i7);
                        break;
                    case 9:
                        Intent i8= new Intent(getApplicationContext(),Event_Registration.class);
                        i8.putExtra("name","CodeVyuha");
                        startActivity(i8);
                        break;
                    case 10:
                        Intent i9 = new Intent(getApplicationContext(),Event_Registration.class);
                        i9.putExtra("name","DecodeRace");
                        startActivity(i9);
                        break;
                    case 11:
                        Intent i10 = new Intent(getApplicationContext(),Event_Registration.class);
                        i10.putExtra("name","ReadyPlayerOne");
                        startActivity(i10);
                        break;
                    case 12:
                        Intent i11 = new Intent(getApplicationContext(),Event_Registration.class);
                        i11.putExtra("name","CodeRunner");
                        startActivity(i11);
                        break;
                    case 13:
                        Intent i14=new Intent(getApplicationContext(),Event_Registration.class);
                        i14.putExtra("name","MockInterviewCse");
                        startActivity(i14);

                }

            }
        }));


    }
}
