package com.example.root.promethean2k17.Activities;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.root.promethean2k17.Adapters.Home_Adapter;
import com.example.root.promethean2k17.Models.Home_Model;
import com.example.root.promethean2k17.R;

import com.example.root.promethean2k17.configs.Onitemtouchlistener;
import com.example.root.promethean2k17.configs.Sharedprefs;
import com.facebook.accountkit.AccountKit;
import com.gitonway.lee.niftymodaldialogeffects.lib.NiftyDialogBuilder;

import java.util.ArrayList;

import static com.gitonway.lee.niftymodaldialogeffects.lib.Effectstype.Fall;


public class  Home extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
Sharedprefs sharedprefs;
    Home_Adapter adapter;
    RecyclerView recyclerView;
    Context context;
    LinearLayoutManager layoutManager;
    NiftyDialogBuilder dialogBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedprefs=new Sharedprefs(this);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dialogBuilder= NiftyDialogBuilder.getInstance(this);
        recyclerView= findViewById(R.id.home_recyclerview);
        ArrayList<Home_Model> arrayList = new ArrayList<>();
        arrayList.add(new Home_Model(R.drawable.cse));
        arrayList.add(new Home_Model(R.drawable.ece));
        arrayList.add(new Home_Model(R.drawable.eee));
        arrayList.add(new Home_Model(R.drawable.mech));
        arrayList.add(new Home_Model(R.drawable.it));
        arrayList.add(new Home_Model(R.drawable.chem));
        arrayList.add(new Home_Model(R.drawable.civil));
        arrayList.add(new Home_Model(R.drawable.bme));
        arrayList.add(new Home_Model(R.drawable.phe));
        arrayList.add(new Home_Model(R.drawable.mba));
        /*arrayList.add(new Home_Model("https://jbiet-my.sharepoint.com/personal/acm_jbiet_edu_in/_layouts/15/guestaccess.aspx?guestaccesstoken=vki67mtPb6h4EbrJ%2b9BtM5mWe5mkUvBTBnxxo9lW2ak%3d&docid=05bd04c61f773482b9007d29bb5e0647e&rev=1"));
        arrayList.add(new Home_Model("https://jbiet-my.sharepoint.com/personal/acm_jbiet_edu_in/_layouts/15/guestaccess.aspx?guestaccesstoken=g%2frfDnhVTceJXTwDYqeNPXcEMzL5Abf1s%2fdGGqIYIz8%3d&docid=0cd682a6b1b1a479aba374b9af7c1b754&rev=1"));
        arrayList.add(new Home_Model("https://jbiet-my.sharepoint.com/personal/acm_jbiet_edu_in/_layouts/15/guestaccess.aspx?guestaccesstoken=UeXt3YJ1yCvC6pGow0%2fgoLu63gx2LdY3Sy7mqKDNqBA%3d&docid=02015d39fd0634ee4abebf8710c5b621d&rev=1"));
        arrayList.add(new Home_Model("https://jbiet-my.sharepoint.com/personal/acm_jbiet_edu_in/_layouts/15/guestaccess.aspx?guestaccesstoken=ttb6YHhHaUaE8IkeO%2fpyLfCQ6F7l6QN1%2fuUyaLnEWn8%3d&docid=0365c7d66afdc4dcc8dc6f07af45ebc2b&rev=1"));
      */  adapter=new Home_Adapter(arrayList,this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnItemTouchListener(new Onitemtouchlistener(context, new Onitemtouchlistener.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

                switch (position){

                    case 0:
                        startActivity(new Intent(getApplicationContext(),Cse.class));
                        break;
                    case 1:
                        startActivity(new Intent(getApplicationContext(),Ece.class));
                        break;
                    case 2:
                        startActivity(new Intent(getApplicationContext(),Eee.class));
                        break;
                    case 3:
                        startActivity(new Intent(getApplicationContext(),Mech.class));
                        break;
                    case 4:
                        startActivity(new Intent(getApplicationContext(),It.class));
                        break;
                    case 5:
                        startActivity(new Intent(getApplicationContext(),Chem.class));
                        break;
                    case 6:
                        startActivity(new Intent(getApplicationContext(),Civil.class));
                        break;
                    case 7:
                        startActivity(new Intent(getApplicationContext(),Bme.class));
                        break;
                    case 8:
                        startActivity(new Intent(getApplicationContext(),Phe.class));
                        break;
                    case 9:
                        startActivity(new Intent(getApplicationContext(),Mba.class));
                        break;

                }

            }
        }));


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RegisteredEvents.class));
            }
        });

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.logout) {
            dialogBuilder
                    .withTitle("Promethean2k17")
                    .withTitleColor("#FFFFFF")
                    .withDividerColor("#11000000")
                    .withMessage("Are you sure, to logout?")
                    .withMessageColor("#FFFFFFFF")
                    .withDialogColor("#455a64")
                    .withIcon(getResources().getDrawable(R.drawable.promethean))
                    .withDuration(500)
                    .withEffect(Fall)
                    .withButton1Text("Cancel")
                    .withButton2Text("Logout")
                    .isCancelableOnTouchOutside(true)
                    .setButton1Click(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialogBuilder.cancel();
                        }
                    })
                    .setButton2Click(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AccountKit.logOut();
                            sharedprefs.clearlogin();
                            sharedprefs.clearprefs();
                            startActivity(new Intent(Home.this,Login.class));
                            finish();
                        }
                    })
                    .show();

        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
if(id==R.id.nav_sponsors)
{
    startActivity(new Intent(getApplicationContext(),Sponsors.class));
}
        if (id == R.id.nav_map) {
            // Handle the camera action
            startActivity(new Intent(Home.this,MapsActivity.class));
        } else if (id == R.id.nav_profile) {
            startActivity(new Intent(getApplicationContext(),Profile.class));

        } else if (id == R.id.nav_about) {
startActivity(new Intent(getApplicationContext(),About_promethean.class));
        } else if (id == R.id.nav_notifications) {
            startActivity(new Intent(getApplicationContext(),Notifications.class));

        } else if (id == R.id.nav_license) {
            dialogBuilder
                    .withTitle("Open Source Licenses")
                    .withTitleColor("#FFFFFF")
                    .withDividerColor("#11000000")
                    .withMessage(R.string.licenses_text)
                    .withMessageColor("#FFFFFFFF")
                    .withDialogColor("#455a64")
                    .withIcon(getResources().getDrawable(R.drawable.promethean))
                    .withDuration(500)
                    .withEffect(Fall)
                    .withButton1Text("OK")
                    .isCancelableOnTouchOutside(true)
                    .setButton1Click(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            dialogBuilder.cancel();
                        }
                    })
                    .show();
        }else if (id==R.id.nav_regevents){
            startActivity(new Intent(getApplicationContext(),RegisteredEvents.class));
        }
        else if (id==R.id.nav_contributers)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(Home.this);
            builder.setTitle(String.format("%1$s", getString(R.string.app_name)));
            builder.setMessage(getResources().getText(R.string.contributers));
            builder.setPositiveButton("OK", null);
            builder.setIcon(R.drawable.promethean);
            AlertDialog welcomeAlert = builder.create();
            welcomeAlert.show();
            ((TextView) welcomeAlert.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());

        }
        else if(id==R.id.nav_team)
        {
            startActivity(new Intent(getApplicationContext(),Team_promethean.class));
        }
else if (id==R.id.nav_error_labs)
        {
startActivity(new Intent(getApplication(),ELwebview.class));
        }
        else if (id == R.id.nav_report_bug) {
            Intent i = new Intent(Intent.ACTION_SENDTO);
            String uriText = "mailto:" + Uri.encode("prudhvireddy.m01@gmail.com") + "?subject=" +
                    Uri.encode("Reporting A Bug/Feedback") + "&body=" + Uri.encode("Hello, Team Promethean \nI want to report a bug/give feedback corresponding to the app Promethean2017...\n\n-Your name");
            Uri uri = Uri.parse(uriText);
            i.setData(uri);
            startActivity(Intent.createChooser(i, "Send Email"));

        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
