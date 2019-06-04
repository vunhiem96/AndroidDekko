package com.example.nhiem.Utils;

import android.content.Context;
import android.content.SharedPreferences;


public class AppConfig {
    public static final String PREF_NAME = "Android005";
    public static void setPhoneNumber(String phoneNumber, Context context){
      context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("phone_number", phoneNumber);
        editor.apply();
    }
    public  static  String  getPhoneNumber(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("phone_number", null);
    }

    public static void setNameUser(String nameUser, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("NameUser", nameUser);
        editor.apply();
    }

    public static void setUrlUser(String urlUser, Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("UrlUser", urlUser);
        editor.apply();
    }
    public static String getNameUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("NameUser", null);
    }

    public static String getUrlUser(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString("UrlUser", null);
    }

    public static void logout(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().remove("PhoneNumber").commit();
    }
}
