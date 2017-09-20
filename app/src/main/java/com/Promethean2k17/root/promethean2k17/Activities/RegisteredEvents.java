package com.Promethean2k17.root.promethean2k17.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.Promethean2k17.root.promethean2k17.Adapters.Registered_Event_Adapter;
import com.Promethean2k17.root.promethean2k17.Models.Registered_Events_Model;
import com.Promethean2k17.root.promethean2k17.R;
import com.Promethean2k17.root.promethean2k17.configs.Connection;
import com.Promethean2k17.root.promethean2k17.configs.Onitemtouchlistener;
import com.Promethean2k17.root.promethean2k17.configs.Sharedprefs;
import com.Promethean2k17.root.promethean2k17.configs.urls;

import net.steamcrafted.loadtoast.LoadToast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RegisteredEvents extends AppCompatActivity {
    Connection connection;
    TextView noreg;
    Context context;
    List<Registered_Events_Model> list;
    Registered_Event_Adapter adapter;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    LoadToast loadToast;
    Sharedprefs sharedPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered_events);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Registered Events");
        recyclerView= findViewById(R.id.registered_f_recyclerview);
        noreg= findViewById(R.id.noregistrationtext);
        list = new ArrayList<>();
        loadToast=new LoadToast(this);
        loadToast.setText("Loading...");
        connection=new Connection(getApplicationContext());
        sharedPrefs = new Sharedprefs(this);


        String LogedInauthkey= sharedPrefs.getLogedInKey();
        String LogedInemail= sharedPrefs.getEmail();
        String LogedInusername= sharedPrefs.getLogedInUserName();
        if (LogedInauthkey==null || LogedInemail==null || LogedInusername==null){
            sharedPrefs.clearprefs();
            Toast.makeText(getApplicationContext(),"Please Login",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(),Login.class));
            finish();
        }else {
            Boolean checkinternet = (connection.isInternet());
            if (checkinternet) {
                String email=sharedPrefs.getEmail();
                String uname=sharedPrefs.getLogedInUserName();
                getData(LogedInauthkey,LogedInusername,LogedInemail);
            } else {
                Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Home.class));
                finish();
            }
        }
        recyclerView.addOnItemTouchListener(new Onitemtouchlistener(context, new Onitemtouchlistener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int pos) {
                TextView e_name = view.findViewById(R.id.eventname);
                TextView e_id = view.findViewById(R.id.event_reg_id);
                String eventname=e_name.getText().toString();
                String event_reg_id=e_id.getText().toString();

                Intent expand = new Intent(getApplicationContext(), Registered_Event_Indetail.class);
                Log.d("afasdf","intent_putextrats"+pos);
                expand.putExtra("eventname",eventname);
                expand.putExtra("event_reg_id",event_reg_id);
                startActivity(expand);


            }
        }));




    }

    public void getData(String key,String uname,String email) {

        loadToast.show();
Log.d("phone",""+sharedPrefs.getPhone());
        AndroidNetworking.post(urls.event_url)
                .addBodyParameter("UserName",uname)
                .addBodyParameter("phone",sharedPrefs.getPhone())
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("response:",""+response);
                        loadToast.success();
                        parsedata(response);
                    }
                    @Override
                    public void onError(ANError anError) {
                        loadToast.error();
                        Log.d("error",""+anError);
                        Toast.makeText(getApplicationContext(),"Please check your internet connection",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),Home.class));
                    }
                });
    }

    public void parsedata(JSONArray array){

        int j = array.length();
        Log.d("j",""+j);
        for (int i=j-1 ;i>=0;i--) {
            Registered_Events_Model model = new Registered_Events_Model();
            JSONObject json;
            try {
                json = array.getJSONObject(i);
                if(!json.has("AuthKeyError")){
                    if(!json.has("ResultEmptyError")){
                        model.setEventname(json.getString(urls.eventname));
                        model.setEvent_reg_id(json.getString(urls.event_reg_id));
                        list.add(model);
                    }else {
                        Toast.makeText(getApplicationContext(), "No Registrations Done Yet", Toast.LENGTH_SHORT).show();
                        recyclerView.setVisibility(View.GONE);
                        noreg.setVisibility(View.VISIBLE);
                    }
                }else {
                    Toast.makeText(getApplicationContext(), "Invalid Authentication, Please Login", Toast.LENGTH_SHORT).show();
                    sharedPrefs.clearprefs();
                    startActivity(new Intent(getApplicationContext(),Login.class));
                    finish();
                }
            } catch (JSONException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Please try again after sometime", Toast.LENGTH_SHORT).show();
            }
        }
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new Registered_Event_Adapter(list,this);
        recyclerView.setAdapter(adapter);




    }
}
