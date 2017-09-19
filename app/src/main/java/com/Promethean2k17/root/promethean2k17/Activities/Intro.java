package com.Promethean2k17.root.promethean2k17.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.Promethean2k17.root.promethean2k17.R;
import com.Promethean2k17.root.promethean2k17.configs.Sharedprefs;
import com.heinrichreimersoftware.materialintro.app.IntroActivity;
import com.heinrichreimersoftware.materialintro.app.NavigationPolicy;
import com.heinrichreimersoftware.materialintro.slide.SimpleSlide;

/**
 * Created by root on 5/9/17.
 */

public class Intro extends IntroActivity {
Sharedprefs sharedprefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setFullscreen(true);
        super.onCreate(savedInstanceState);
        sharedprefs=new Sharedprefs(this);
        setFinishEnabled(true);
        setButtonBackVisible(false);
        setButtonNextVisible(false);

        setNavigationPolicy(new NavigationPolicy() {
            @Override
            public boolean canGoForward(int position) {
                return position != 5;
            }
            @Override
            public boolean canGoBackward(int position) {
                return position != 0;
            }
        });
        addSlide(new SimpleSlide.Builder()
                .title("Promethean'17")
                .description("Welcome")
                .image(R.drawable.promethean)
                .background(R.color.color_canteen)
                .backgroundDark(R.color.color_dark_canteen)
                .build());
        addSlide(new SimpleSlide.Builder()
                // .title("How this app works?")
                .description("How this app works?")
                .image(R.drawable.qstn)
                .background(R.color.color_custom_fragment_2)
                .backgroundDark(R.color.color_dark_custom_fragment_2)
                .build());
        addSlide(new SimpleSlide.Builder()
                .title("Create an Account")
                .description("Register and Login")
                .image(R.drawable.login)
                .background(R.color.color_material_bold)
                .backgroundDark(R.color.color_dark_material_bold)
                .build());
        addSlide(new SimpleSlide.Builder()
                .title("Register Events")
                .description("Go through the various events and register for the events you want to participate in.")
                .image(R.drawable.reg)
                .background(R.color.color_material_motion)
                .backgroundDark(R.color.color_dark_material_motion)
                .build());
        addSlide(new SimpleSlide.Builder()
                .title("Get Unique code")
                .description("Get an Unique code for every event you register")
                .image(R.drawable.getqr)
                .background(R.color.color_custom_fragment_1)
                .backgroundDark(R.color.color_dark_custom_fragment_1)
                .build());

        addSlide(new SimpleSlide.Builder()
                .title("Attend and Verify")
                .description("Show the Unique code at the venue and attend the event")
                .image(R.drawable.scan)
                .background(R.color.color_permissions)
                .backgroundDark(R.color.color_dark_permissions)
                .buttonCtaLabel("Get Started")
                .buttonCtaClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                        if (sharedprefs.getLogedInUserName()==null){
//                            startActivity(new Intent(getApplicationContext(),Login.class));
//                            sharedprefs.setopened();
//                            finish();
//                        }else{
                        sharedprefs.setopened();
                        Log.d("",sharedprefs.getopened());
                            startActivity(new Intent(getApplicationContext(),Login.class));

                            finish();
                        //}
                    }
                })
                .build());
    }
}
