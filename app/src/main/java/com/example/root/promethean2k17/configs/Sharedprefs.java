package com.example.root.promethean2k17.configs;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by root on 5/9/17.
 */

public class Sharedprefs {
    Context context;

    public static final String myprefs = "myprefs";
    public static final String LogedInUserName = "UserName";
    public static final String LogedInEmail = "Email";
    public static final String LogedInKey = "Key";
    public static final String ResetEmail = "Email";
    public static final String firstopen=null;
    public static final String Phone="phone";
    public static final String checklog="check";

    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;
   public Sharedprefs(Context context)
    {
        this.context=context;
        sharedpreferences = context.getSharedPreferences(myprefs, Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
    }
    public String getopened(){
        return sharedpreferences.getString(firstopen,null);
    }
    public void setopened(){

        editor.putString(firstopen,"true");
        editor.commit();
    }
    public void saveprefs(String UserName,String Email,String Key){
        editor.putString(LogedInUserName, UserName);
        editor.putString(LogedInEmail, Email);
        editor.putString(LogedInKey,Key);
        editor.commit();
    }
public void setlogin()
{
    editor.putString(checklog,"true");
    editor.commit();
}
public void clearlogin()
{
    editor.putString(checklog,null);
    editor.commit();
}
public String getlogin(){
    return sharedpreferences.getString(checklog,null);
}
    public void clearprefs() {
        editor.putString(LogedInUserName, null);
        editor.putString(LogedInEmail, null);
        editor.putString(LogedInKey,null);
        editor.commit();
    }
    public  String getEmail() {
        return sharedpreferences.getString(LogedInEmail,null);
    }

    public String getLogedInKey() {
        return sharedpreferences.getString(LogedInKey,null);
    }

    public  void setResetEmail(String email) {
        editor.putString(ResetEmail,email);
        editor.commit();
    }

    public  String getResetEmail() {
        return sharedpreferences.getString(ResetEmail,null);
    }

    public void clearResetEmail(){
        editor.putString(ResetEmail,null);
        editor.commit();
    }


    public  String getLogedInUserName() {
        return sharedpreferences.getString(LogedInUserName,null);
    }
}
