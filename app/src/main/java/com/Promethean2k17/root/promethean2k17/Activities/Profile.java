package com.Promethean2k17.root.promethean2k17.Activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.Promethean2k17.root.promethean2k17.R;
import com.Promethean2k17.root.promethean2k17.configs.Sharedprefs;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;

public class Profile extends AppCompatActivity {
    ImageView imageView;
TextView username,phonenumber,email,collegename;
    Sharedprefs sharedprefs;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("profile");
        progressBar=(ProgressBar)findViewById(R.id.progress);
        sharedprefs=new Sharedprefs(this);
        imageView=(ImageView)findViewById(R.id.header_cover_image);
        Glide.with(getApplicationContext()).load("http://promethean2k17.com/app/images/logo.jpg").diskCacheStrategy(DiskCacheStrategy.SOURCE).error(android.R.drawable.ic_dialog_alert).listener(new RequestListener<String, GlideDrawable>() {
            @Override
            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                return false;
            }

            @Override
            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                progressBar.setVisibility(View.GONE);
                return false;
            }
        }).into(imageView);
        username= findViewById(R.id.username);
        phonenumber= findViewById(R.id.phonenumber);
        email= findViewById(R.id.email);
        collegename= findViewById(R.id.collegename);
        username.setText("username:- "+sharedprefs.getLogedInUserName());
        phonenumber.setText("Phonenumber:- "+sharedprefs.getPhone());
        email.setText("email:- "+sharedprefs.getEmail());
        collegename.setText("collegename:- "+sharedprefs.getLogedInCollegeName());

    }
}
