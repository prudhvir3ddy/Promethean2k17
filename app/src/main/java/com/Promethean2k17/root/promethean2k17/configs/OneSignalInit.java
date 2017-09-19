package com.Promethean2k17.root.promethean2k17.configs;

import android.app.Application;

import com.onesignal.OneSignal;

/**
 * Created by root on 15/9/17.
 */

public class OneSignalInit extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();

        // Call syncHashedEmail anywhere in your app if you have the user's email.
        // This improves the effectiveness of OneSignal's "best-time" notification scheduling feature.
        // OneSignal.syncHashedEmail(userEmail);
    }

}
