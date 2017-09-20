package com.Promethean2k17.root.promethean2k17.Activities;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.Promethean2k17.root.promethean2k17.R;

import com.Promethean2k17.root.promethean2k17.configs.Connection;
import com.Promethean2k17.root.promethean2k17.configs.Sharedprefs;
import com.Promethean2k17.root.promethean2k17.configs.urls;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.facebook.accountkit.AccountKit;

import net.steamcrafted.loadtoast.LoadToast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.OkHttpClient;

public class user_details extends AppCompatActivity {
EditText f_name,l_name,c_name,email;
    Button register;
    Connection connection;
    LoadToast loadToast;
     String formattedPhoneNumber;
    Sharedprefs sharedprefs;
    ProgressBar progressBar;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        ActionBar actionBar=getSupportActionBar();
        actionBar.setTitle("Register");
        progressBar=(ProgressBar)findViewById(R.id.progress);
imageView=(ImageView)findViewById(R.id.introimage) ;
        Glide.with(getApplicationContext()).load("http://promethean2k17.com/app/images/pro2.gif").diskCacheStrategy(DiskCacheStrategy.SOURCE).error(android.R.drawable.ic_dialog_alert).listener(new RequestListener<String, GlideDrawable>() {
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
        sharedprefs=new Sharedprefs(this);
if(sharedprefs.getLogedInUserName()!=null)
    startActivity(new Intent(getApplicationContext(),Home.class));
        AndroidNetworking.initialize(getApplicationContext());

        connection=new Connection(this);
        loadToast=new LoadToast(this);
        loadToast.setText("Loading...");
        email= findViewById(R.id.Email);
        f_name= findViewById(R.id.fname);
        l_name= findViewById(R.id.LastName);
        c_name= findViewById(R.id.CollegeName);
        register= findViewById(R.id.registerbtn);
        formattedPhoneNumber=sharedprefs.getPhone();

//        AccountKit.getCurrentAccount(new AccountKitCallback<Account>() {
//            @Override
//            public void onSuccess(final Account account) {
//                // Get Account Kit ID
//                String accountKitId = account.getId();
//
//                PhoneNumber phoneNumber = account.getPhoneNumber();
//                if (account.getPhoneNumber() != null) {
//                    // if the phone number is available, display it
//                     formattedPhoneNumber = formatPhoneNumber(phoneNumber.toString());
//                    checklogin=new Checklogin(getApplicationContext());
//                    if(checklogin.validate())
//                    {
//
//                    }
//
//                }
//
//
//            }
//
//            @Override
//            public void onError(final AccountKitError error) {
//                // display error
//                String toastMessage = error.getErrorType().getMessage();
//                Toast.makeText(user_details.this, toastMessage, Toast.LENGTH_LONG).show();
//            }
//        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email=email.getText().toString();
                String FirstName=f_name.getText().toString();
                String LastName=l_name.getText().toString();
                String CollegeName=c_name.getText().toString();
                if (namevalidator(FirstName)){
                    Log.d("LOGG","FNAME");

                    if (namevalidator(LastName)){
                        Log.d("LOGG","LNAME");

                        if(isValidEmail(Email)){
                            Log.d("LOGG","Email");

                            if (namevalidator(CollegeName)) {
                                Log.d("LOGG", "CLGNAME");
                                Boolean checkinternet = (connection.isInternet());
                                if (checkinternet) {
                                    Log.d("TAG", "online startted");
                                    register(FirstName, LastName, Email, CollegeName,formattedPhoneNumber);
                                } else {
                                    Toast.makeText(getApplicationContext(), "No Internet Connection", Toast.LENGTH_SHORT).show();
                                    startActivity(new Intent(getApplicationContext(), Login.class));
                                    finish();
                                }
                            }else {
                                c_name.setText(null);
                                c_name.setError("Enter Valid Name(no spaces)");
                            }}else {
                           email.setText(null);
                            email.setError("Enter Valid Email");
                            }}else {
                        l_name.setText(null);
                        l_name.setError("Enter Valid Name (no spaces)");
                    }}
                else {
                    f_name.setText(null);
                    f_name.setError("Enter Valid Name(no spaces)");
                }



            }
        });

    }
//    private String formatPhoneNumber(String phoneNumber) {
//        // helper method to format the phone number for display
//        try {
//            PhoneNumberUtil pnu = PhoneNumberUtil.getInstance();
//            Phonenumber.PhoneNumber pn = pnu.parse(phoneNumber, Locale.getDefault().getCountry());
//            phoneNumber = pnu.format(pn, PhoneNumberUtil.PhoneNumberFormat.NATIONAL);
//        }
//        catch (NumberParseException e) {
//            e.printStackTrace();
//        }
//        return phoneNumber;
//    }

    public void register(String FirstName,String LastName,String Email,String CollegeName,String formattedPhoneNumber)
                    {
                        loadToast.show();
                        OkHttpClient okHttpClient = new OkHttpClient().newBuilder()
                                .connectTimeout(120, TimeUnit.SECONDS)
                                .readTimeout(120, TimeUnit.SECONDS)
                                . writeTimeout(120, TimeUnit.SECONDS)
                                .build();
                        Log.d("entered ","1");
                        final String username=FirstName+LastName;
                        AndroidNetworking.post(urls.registration_url)
                                .addBodyParameter("firstname",FirstName)
                                .addBodyParameter("lastname",LastName)
                                .addBodyParameter("username",username)
                                .addBodyParameter("email",Email)
                                .addBodyParameter("collegename",CollegeName)
                                .addBodyParameter("phonenumber",formattedPhoneNumber)
                                .setPriority(Priority.MEDIUM)
                                .setOkHttpClient(okHttpClient)
                                .build()
                                .getAsJSONArray(new JSONArrayRequestListener() {
                                    @Override
                                    public void onResponse(JSONArray response) {
                                        Log.d("response",""+response);
                                        loadToast.success();
                                        //  Toast.makeText(getApplicationContext(),response.toString(), Toast.LENGTH_SHORT).show();
                                        int j = response.length();
                                        for (int i = 0; i < j; i++) {
                                            JSONObject json;
                                            try {
                                                json = response.getJSONObject(i);


                                                    if (!json.has("InsertionError")){

                                                        if (!json.has("FNameError")){

                                                            if (!json.has("LNameError")){

                                                                if (!json.has("EmailError")){


                                                                            Toast.makeText(getApplicationContext(),"Successfully Registered",Toast.LENGTH_SHORT).show();
                                                                            startActivity(new Intent(getApplicationContext(),Check.class));
                                                                            finish();

                                                                        }else{
                                                                    Toast.makeText(getApplicationContext(), "Invalid Email", Toast.LENGTH_SHORT).show();
                                                                }

                                                            }else{
                                                                Toast.makeText(getApplicationContext(), "Invalid LastName", Toast.LENGTH_SHORT).show();
                                                            }

                                                        }else {

                                                            Toast.makeText(getApplicationContext(), "Invalid FirstName", Toast.LENGTH_SHORT).show();
                                                        }

                                                    }



                                            } catch (JSONException e) {
                                                e.printStackTrace();
                                                Toast.makeText(getApplicationContext(), "Please try after sometime", Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    }
                                    @Override
                                    public void onError(ANError anError) {
                                        loadToast.error();
                                        Log.d("LOG", "RESPONSE" + anError);

                                        Toast.makeText(getApplicationContext(), "Check Your Network Connection", Toast.LENGTH_SHORT).show();
                                    }
                                });

                    }




    public  static boolean isValidEmail(CharSequence target) {

        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }
    public boolean namevalidator(String name){
        Pattern pattern;
        Matcher matcher;
        final String USERNAME_PATTERN = "^[a-zA-Z ]{2,25}$";
        pattern = Pattern.compile(USERNAME_PATTERN);
        matcher = pattern.matcher(name);
        return matcher.matches();
    }

    @Override
    public void onBackPressed() {
        finish();
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

            AccountKit.logOut();
            sharedprefs.clearlogin();
            sharedprefs.clearprefs();
            startActivity(new Intent(getApplicationContext(),Login.class));
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}
