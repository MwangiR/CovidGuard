package com.test.blemonitor.data;

import android.content.Context;
import android.content.SharedPreferences;

public class SharePref {
    private static SharePref sharePref=null;
    private Context context;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static final String MyPREFERENCES = "MyPrefs" ;
    private static final String Login = "login";

    public static SharePref getInstance(Context context){
        if(sharePref==null){
            sharePref=new SharePref(context);
        }
        return sharePref;
    }

    public SharePref(Context context) {
        this.context = context;
        sharedPreferences=context.getSharedPreferences(MyPREFERENCES,Context.MODE_PRIVATE);
        editor= sharedPreferences.edit();
    }

    public void setLogin(boolean status){
        editor.putBoolean(Login,status);
        editor.apply();
    }

    public Boolean getLoginStatus(){
        return sharedPreferences.getBoolean(Login,false);
    }

    public void clear(){
        editor.clear();
        editor.apply();
    }
}
