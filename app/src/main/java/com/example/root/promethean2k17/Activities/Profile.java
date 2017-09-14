package com.example.root.promethean2k17.Activities;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.root.promethean2k17.R;
import com.example.root.promethean2k17.configs.Sharedprefs;

public class Profile extends AppCompatActivity {
TextView username,phonenumber,email,collegename;
    Sharedprefs sharedprefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        sharedprefs=new Sharedprefs(this);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("profile");
        username=(TextView)findViewById(R.id.username);
        phonenumber=(TextView)findViewById(R.id.phonenumber);
        email=(TextView)findViewById(R.id.email);
        collegename=(TextView)findViewById(R.id.collegename);
        username.setText("username:- "+sharedprefs.getLogedInUserName());
        phonenumber.setText("Phonenumber:- "+sharedprefs.getPhone());
        email.setText("email:- "+sharedprefs.getEmail());
        collegename.setText("collegename:- "+sharedprefs.getLogedInCollegeName());

    }
}