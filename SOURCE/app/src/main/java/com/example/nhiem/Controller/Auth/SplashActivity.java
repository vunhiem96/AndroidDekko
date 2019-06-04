package com.example.nhiem.Controller.Auth;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.nhiem.Controller.Main.HomeActivity;
import com.example.nhiem.R;
import com.example.nhiem.Utils.AppConfig;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               screenRouter();
            }
        }, 2000);
    }
    void screenRouter(){
        String phoneNumber = AppConfig.getPhoneNumber(this);
        if(phoneNumber == null){
            Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
            startActivity(intent);
        }
        else {
            Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
            startActivity(intent);
        }
    }
}
