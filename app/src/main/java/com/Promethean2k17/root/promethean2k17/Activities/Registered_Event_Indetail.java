package com.Promethean2k17.root.promethean2k17.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.Promethean2k17.root.promethean2k17.R;
import com.Promethean2k17.root.promethean2k17.configs.Connection;
import com.Promethean2k17.root.promethean2k17.configs.Sharedprefs;
import com.Promethean2k17.root.promethean2k17.configs.urls;

import net.steamcrafted.loadtoast.LoadToast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Registered_Event_Indetail extends AppCompatActivity {
    ImageView qrcode,g1,g2,g3,g4,r1,r2,r3,r4;
    LoadToast loadToast;
    Sharedprefs sharedPrefs;
    Connection connection;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registered_event_indetail);
        Bundle bundle = getIntent().getExtras();
        String eventname =bundle.getString("eventname");
        String event_reg_id =bundle.getString("event_reg_id");
        qrcode= findViewById(R.id.qrcode_img);
        g1= findViewById(R.id.green1);
        g2= findViewById(R.id.green_2);
        g3= findViewById(R.id.green_3);
        g4= findViewById(R.id.green_4);
        r1= findViewById(R.id.red_1);
        r2= findViewById(R.id.red_2);
        r3= findViewById(R.id.red_3);
        r4= findViewById(R.id.red_4);
        progressBar= findViewById(R.id.progress);
        connection=new Connection(getApplicationContext());
        sharedPrefs = new Sharedprefs(this);
        loadToast = new LoadToast(this);
        loadToast.setText("Loading...");
        if (sharedPrefs.getLogedInKey()==null || sharedPrefs.getEmail()==null || sharedPrefs.getLogedInUserName()==null){
            sharedPrefs.clearprefs();
            Toast.makeText(getApplicationContext(),"Please Login",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(getApplicationContext(),Login.class));
            finish();
        }else {
            Boolean checkinternet = (connection.isInternet());
            if (checkinternet) {
                String key=sharedPrefs.getLogedInKey();
                String uname=sharedPrefs.getLogedInUserName();
                getData(key,uname,eventname,event_reg_id);
            } else {
                Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getApplicationContext(), Home.class));
                finish();
            }
        }

    }


    public void getData(String key,String uname,String eventname,String event_reg_id) {

        loadToast.show();
        AndroidNetworking.post(urls.event_indetails_url)
                .addBodyParameter("UserName",uname)
                .addBodyParameter("EventName",eventname)
                .addBodyParameter("EventRegID",event_reg_id)
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONArray(new JSONArrayRequestListener() {
                    @Override
                    public void onResponse(JSONArray response) {
                        loadToast.success();
                        Log.d("response",""+response);
                        // Toast.makeText(getApplicationContext(),"Response"+response,Toast.LENGTH_SHORT).show();
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
        for (int i = 0; i < j; i++) {
            JSONObject json;
            try {
                json = array.getJSONObject(i);
                if (!json.has("AuthKeyError")) {
                    if (!json.has("ResultEmptyError")) {
                       String url = json.getString("EventImg");
                        String paidstatus = json.getString("PaidStatus");
                        String attendedstatus = json.getString("AttendedStatus");
                        String paybackstatus = json.getString("RefundStatus");
                        String certificatestatus = json.getString("CertificateStatus");
                        //Toast.makeText(getApplicationContext(),url+paidstatus+attendedstatus+paidstatus+certificatestatus,Toast.LENGTH_SHORT).show();
                        Glide.with(getApplicationContext()).load(url).diskCacheStrategy(DiskCacheStrategy.SOURCE).error(R.drawable.promethean).listener(new RequestListener<String, GlideDrawable>() {
                            @Override
                            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                                return false;
                            }
                            @Override
                            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                                progressBar.setVisibility(View.GONE);
                                return false;
                            }
                        }).into(qrcode);

                        if (paidstatus.equals("0")){
                            r1.setVisibility(View.VISIBLE);
                            g1.setVisibility(View.INVISIBLE);
                        }else {
                            r1.setVisibility(View.INVISIBLE);
                            g1.setVisibility(View.VISIBLE);
                        }
                        if (attendedstatus.equals("0")){
                            r2.setVisibility(View.VISIBLE);
                            g2.setVisibility(View.INVISIBLE);
                        }else {
                            r2.setVisibility(View.INVISIBLE);
                            g2.setVisibility(View.VISIBLE);
                        }
                        if (paybackstatus.equals("0")){
                            r3.setVisibility(View.VISIBLE);
                            g3.setVisibility(View.INVISIBLE);
                        }else {
                            r3.setVisibility(View.INVISIBLE);
                            g3.setVisibility(View.VISIBLE);
                        }
                        if (certificatestatus.equals("0")){
                            r4.setVisibility(View.VISIBLE);
                            g4.setVisibility(View.INVISIBLE);
                        }else {
                            r4.setVisibility(View.INVISIBLE);
                            g4.setVisibility(View.VISIBLE);
                        }

                    } else {
                        Toast.makeText(getApplicationContext(), "No Event Details Found", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "AppKeyAuthenticationFailure", Toast.LENGTH_SHORT).show();
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }


    }
}
