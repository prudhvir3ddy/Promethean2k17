package com.Promethean2k17.root.promethean2k17.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONArrayRequestListener;
import com.Promethean2k17.root.promethean2k17.R;
import com.Promethean2k17.root.promethean2k17.configs.Connection;
import com.Promethean2k17.root.promethean2k17.configs.Sharedprefs;
import com.Promethean2k17.root.promethean2k17.configs.urls;
import com.facebook.accountkit.Account;
import com.facebook.accountkit.AccountKit;
import com.facebook.accountkit.AccountKitCallback;
import com.facebook.accountkit.AccountKitError;
import com.facebook.accountkit.PhoneNumber;
import com.google.i18n.phonenumbers.NumberParseException;
import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;

import net.steamcrafted.loadtoast.LoadToast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;

public class Check extends AppCompatActivity {
    String phone;
 //   Context ctx;
    Sharedprefs sharedprefs;
    LoadToast loadToast;
    Connection connection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);
        sharedprefs=new Sharedprefs(getApplicationContext());
        loadToast=new LoadToast(Check.this);
        connection=new Connection(getApplicationContext());
        loadToast.setText("Loading...");
        loadToast.show();
        Boolean checkinternet = (connection.isInternet());
        if(checkinternet) {
            AccountKit.getCurrentAccount(new AccountKitCallback<Account>() {
                @Override
                public void onSuccess(Account account) {
                    String accountKitId = account.getId();

                    PhoneNumber phoneNumber = account.getPhoneNumber();
                    if (account.getPhoneNumber() != null) {
                        // if the phone number is available, display it
                        phone = formatPhoneNumber(phoneNumber.toString());

                        sharedprefs.setPhone(phone);


                        AndroidNetworking.initialize(getApplicationContext());
                        AndroidNetworking.post(urls.checkuser_url)
                                .addBodyParameter("phonenumber", phone)
                                .setPriority(Priority.HIGH)
                                .build()
                                .getAsJSONArray(new JSONArrayRequestListener() {
                                    @Override
                                    public void onResponse(JSONArray response) {
                                        loadToast.success();
                                        int j = response.length();
                                        for (int i = 0; i < j; i++) {
                                            JSONObject json;
                                            try {
                                                Log.d("phone:", "" + phone);
                                                json = response.getJSONObject(i);
                                                Log.d("response:", "" + response);
                                                if (!json.has("NoItems")) {
                                                    String fname = json.getString("firstname");
                                                    String lname = json.getString("lastname");
                                                    String id = json.getString("id");
                                                    String email = json.getString("email");
                                                    String collegename = json.getString("collegename");
                                                    String username = json.getString("username");
                                                    sharedprefs.saveprefs(username, email, id, collegename);
                                                    Log.d("username:", "" + sharedprefs.getLogedInUserName());
                                                    startActivity(new Intent(getApplicationContext(), Home.class));
                                                    finish();

                                                } else {
                                                    Toast.makeText(getApplicationContext(), "enter your details", Toast.LENGTH_SHORT).show();
                                                    startActivity(new Intent(getApplicationContext(), user_details.class));
                                                    finish();
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
                                    }
                                });
                    }

                }


                @Override
                public void onError(AccountKitError error) {
                    String toastMessage = error.getErrorType().getMessage();
                    Toast.makeText(getApplicationContext(), toastMessage, Toast.LENGTH_LONG).show();

                }

            });
        }
          else
        {
            Toast.makeText(getApplicationContext(),"please check your internet connection",Toast.LENGTH_SHORT).show();
        }


    }
    public String formatPhoneNumber(String phoneNumber) {
        // helper method to format the phone number for display
        try {
            PhoneNumberUtil pnu = PhoneNumberUtil.getInstance();
            Phonenumber.PhoneNumber pn = pnu.parse(phoneNumber, Locale.getDefault().getCountry());
            phoneNumber = pnu.format(pn, PhoneNumberUtil.PhoneNumberFormat.NATIONAL);
        }
        catch (NumberParseException e) {
            e.printStackTrace();
        }
        return phoneNumber;
    }
}
