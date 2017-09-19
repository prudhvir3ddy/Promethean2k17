package com.Promethean2k17.root.promethean2k17.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.Promethean2k17.root.promethean2k17.Adapters.Eee_Adapter;
import com.Promethean2k17.root.promethean2k17.Models.Eee_Model;
import com.Promethean2k17.root.promethean2k17.R;
import com.Promethean2k17.root.promethean2k17.configs.Onitemtouchlistener;

import java.util.ArrayList;

public class Eee extends AppCompatActivity {
    Eee_Adapter adapter;
    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eee);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Eee Events");
        recyclerView= findViewById(R.id.eee_recyclerview);

        ArrayList<Eee_Model> arrayList = new ArrayList<>();
        arrayList.add(new Eee_Model("http://promethean2k17.com/app/images/eee/solar.jpg"));
        arrayList.add(new Eee_Model("http://promethean2k17.com/app/images//eee/matlab.jpg"));
        arrayList.add(new Eee_Model("http://promethean2k17.com/app/images/eee/emcd.jpg"));
        arrayList.add(new Eee_Model("http://promethean2k17.com/app/images/eee/paper.jpg"));
        arrayList.add(new Eee_Model("http://promethean2k17.com/app/images/eee/poster.jpg"));
        arrayList.add(new Eee_Model("http://promethean2k17.com/app/images/eee/quiz.jpg"));
        arrayList.add(new Eee_Model("http://promethean2k17.com/app/images/eee/ttp.jpg"));
        arrayList.add(new Eee_Model("http://promethean2k17.com/app/images/eee/circuit.jpg"));
        arrayList.add(new Eee_Model("http://promethean2k17.com/app/images/eee/peechakucha.jpg"));
        arrayList.add(new Eee_Model("http://promethean2k17.com/app/images/eee/circution.jpg"));
        arrayList.add(new Eee_Model("http://promethean2k17.com/app/images/ece/lab.jpg"));
        arrayList.add(new Eee_Model("http://promethean2k17.com/app/images/eee/greenpaper.jpg"));
        arrayList.add(new Eee_Model("http://promethean2k17.com/app/images/ece/project.jpg"));
        adapter=new Eee_Adapter(arrayList,this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new Onitemtouchlistener(context, new Onitemtouchlistener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                switch (position){

                    case 0:
                        Intent i1=new Intent(getApplicationContext(),Event_Registration.class);
                        i1.putExtra("name","SolarWorkshop");
                        startActivity(i1);
                        break;
                    case 1:
                        Intent i2=new Intent(getApplicationContext(),Event_Registration.class);
                        i2.putExtra("name","MatLabWorkshop");
                        startActivity(i2);
                        break;
                    case 2:
                        Intent i3=new Intent(getApplicationContext(),Event_Registration.class);
                        i3.putExtra("name","EMCDWorkshop");
                        startActivity(i3);
                        break;
                    case 3:
                        Intent i4=new Intent(getApplicationContext(),Event_Registration.class);
                        i4.putExtra("name","TechPaperPresentationEee");
                        startActivity(i4);
                        break;
                    case 4:
                        Intent i5=new Intent(getApplicationContext(),Event_Registration.class);
                        i5.putExtra("name","PosterPresentationEee");
                        startActivity(i5);
                        break;
                    case 5:
                        Intent i6=new Intent(getApplicationContext(),Event_Registration.class);
                        i6.putExtra("name","TechnicalQuizEee");
                        startActivity(i6);
                        break;
                    case 6:
                        Intent i7=new Intent(getApplicationContext(),Event_Registration.class);
                        i7.putExtra("name","TechiTextoPress");
                        startActivity(i7);
                        break;
                    case 7:
                        Intent i8=new Intent(getApplicationContext(),Event_Registration.class);
                        i8.putExtra("name","CircuitLadder");
                        startActivity(i8);
                        break;
                    case 8:
                        Intent i9=new Intent(getApplicationContext(),Event_Registration.class);
                        i9.putExtra("name","PeechaKucha");
                        startActivity(i9);
                        break;
                    case 9:
                        Intent i10=new Intent(getApplicationContext(),Event_Registration.class);
                        i10.putExtra("name","Circution");
                        startActivity(i10);
                        break;
                    case 10:
                        Intent i11=new Intent(getApplicationContext(),Event_Registration.class);
                        i11.putExtra("name","LABVIEWWorkshop");
                        startActivity(i11);
                        break;
                    case 11:
                        Intent i12=new Intent(getApplicationContext(),Event_Registration.class);
                        i12.putExtra("name","GreenPaperPresentationEee");
                        startActivity(i12);
                        break;
                    case 12:
                        Intent i13=new Intent(getApplicationContext(),Event_Registration.class);
                        i13.putExtra("name","ProjectExpo");
                        startActivity(i13);
                        break;

                }

            }
        }));


    }
}
