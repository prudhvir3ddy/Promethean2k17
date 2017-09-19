package com.Promethean2k17.root.promethean2k17.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.Promethean2k17.root.promethean2k17.Adapters.Team_promethean_Adapter;
import com.Promethean2k17.root.promethean2k17.Models.Team_promethean_Model;
import com.Promethean2k17.root.promethean2k17.R;
import com.Promethean2k17.root.promethean2k17.configs.Connection;
import com.Promethean2k17.root.promethean2k17.configs.urls;

import net.steamcrafted.loadtoast.LoadToast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

public class Team_promethean extends AppCompatActivity {
RecyclerView recyclerView;
    Connection connection;
    Context context;
    List<Team_promethean_Model> list;
    Team_promethean_Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    LoadToast loadToast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_promethean);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Team Promethean");
        recyclerView= findViewById(R.id.team_promethean_recyclerview);
        list = new ArrayList<>();
        loadToast=new LoadToast(this);
        loadToast.setText("Loading...");
        connection=new Connection(getApplicationContext());
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


        Boolean checkinternet =(connection.isInternet());
        if (checkinternet) {
            Log.d("TAG","online startted");
            getData();
        } else {
            Toast.makeText(getApplicationContext(),"No Internet Connection",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(),Home.class));
        }
    }

    public void getData() {
        loadToast.show();
        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                .connectTimeout(120, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                . writeTimeout(120, TimeUnit.SECONDS)
                .build();
        AndroidNetworking.post(urls.teampromethean_url)
                .setPriority(Priority.MEDIUM)
                .setOkHttpClient(okHttpClient)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.d("response",""+response);
                        loadToast.success();
                        parsedata(response);
                    }

                    @Override
                    public void onError(ANError anError) {
                        loadToast.error();
                        Toast.makeText(getApplicationContext(),"Please check your internet connection",Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(getApplicationContext(),Home.class));
                    }
                });

    }

    public void parsedata(JSONArray array){

        int j = array.length();
        for (int i=0;i<j;i++) {
            Team_promethean_Model model = new Team_promethean_Model();
            JSONObject json;
            try {
                json = array.getJSONObject(i);
                model.setTeam_promethean_Image(json.getString(urls.Image));
                model.setTeam_promethean_Name(json.getString("Name"));
                list.add(model);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        adapter = new Team_promethean_Adapter(list,this);
        recyclerView.setAdapter(adapter);


    }
}
