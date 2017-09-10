package com.example.root.promethean2k17.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.root.promethean2k17.configs.Sharedprefs;
import com.facebook.accountkit.AccountKit;
import com.facebook.accountkit.AccessToken;

import com.example.root.promethean2k17.R;
import com.facebook.accountkit.AccountKitLoginResult;
import com.facebook.accountkit.ui.AccountKitActivity;
import com.facebook.accountkit.ui.AccountKitConfiguration;
import com.facebook.accountkit.ui.LoginType;
import com.facebook.appevents.AppEventsLogger;

public class Login extends AppCompatActivity {
    public static int APP_REQUEST_CODE = 11;
    Sharedprefs sharedprefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
       sharedprefs=new Sharedprefs(this);
        AccessToken accessToken = AccountKit.getCurrentAccessToken();

        if (accessToken != null) {
            //Handle Returning User

            launchAccountActivity();
        }

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == APP_REQUEST_CODE)
        {
            AccountKitLoginResult loginResult=data.getParcelableExtra(AccountKitLoginResult.RESULT_KEY);
            if(loginResult.getError()!=null)
            {
                String message=loginResult.getError().getErrorType().getMessage();
                Toast.makeText(this,message,Toast.LENGTH_SHORT);
            }
            else if(loginResult.getAccessToken()!=null)
            {
                sharedprefs.setlogin();
                launchAccountActivity();
            }
        }
    }
    public void phoneLogin(final View view) {
      //  AppEventsLogger logger = AppEventsLogger.newLogger(this);
       // logger.logEvent("onPhoneLogin");
        onlogin(LoginType.PHONE);
    }




    public void emailLogin(final View view) {
        AppEventsLogger logger = AppEventsLogger.newLogger(this);
        logger.logEvent("onEmailLogin");
        onlogin(LoginType.EMAIL);
    }


    public void onlogin(LoginType loginType)
    {
        final Intent intent = new Intent(Login.this,AccountKitActivity.class);
        AccountKitConfiguration.AccountKitConfigurationBuilder configurationBuilder =
                new AccountKitConfiguration.AccountKitConfigurationBuilder(
                        loginType,
                        AccountKitActivity.ResponseType.TOKEN); // or .ResponseType.TOKEN
        // ... perform additional configuration ...Log.d("entered,","2");
        final AccountKitConfiguration configuration = configurationBuilder.build();
        intent.putExtra(
                AccountKitActivity.ACCOUNT_KIT_ACTIVITY_CONFIGURATION,
                configuration);
        startActivityForResult(intent, APP_REQUEST_CODE);
    }

    public void launchAccountActivity()
{
startActivity(new Intent(Login.this,MainActivity.class));
    finish();
}
}
