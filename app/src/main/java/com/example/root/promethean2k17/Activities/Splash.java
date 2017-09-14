package com.example.root.promethean2k17.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.root.promethean2k17.R;
import com.example.root.promethean2k17.configs.Sharedprefs;

public class Splash extends AppCompatActivity {
Sharedprefs sharedprefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sharedprefs=new Sharedprefs(this);
        if(sharedprefs.getopened()==null)
        {
            startActivity(new Intent(Splash.this,Intro.class));
            finish();
        }
        else if (sharedprefs.getlogin()==null){

            startActivity(new Intent(getApplicationContext(),Login.class));
            finish();
        }
        else if(sharedprefs.getLogedInUserName()==null)
        {
            startActivity(new Intent(getApplicationContext(),Check.class));
            finish();
        }
 else {
            startActivity(new Intent(getApplicationContext(),Home.class));
            finish();
        }

    }
}
