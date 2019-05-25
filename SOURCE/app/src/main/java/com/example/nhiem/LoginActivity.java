package com.example.nhiem;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText edtPhoneNumber;
    RelativeLayout rlLogin;
    ImageView imgFB;
    ImageView imgGG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        init();
    }

    void init() {
        edtPhoneNumber = findViewById(R.id.edt_phone_number);
        rlLogin = findViewById(R.id.rl_login_button);
        imgFB = (ImageView) findViewById(R.id.img_fb_login);
        imgGG = (ImageView) findViewById(R.id.img_gg_login);

        rlLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkValid()) {
                    Intent intent = new Intent(LoginActivity.this, user_main.class);

                    User user;
                    user = new User();
                    user.setUsername("Vũ Hữu Nhiệm");
                    user.setPhoneNumber("0973833924");
                    user.setProfileUrl("https://i.imgur.com/R6JbROY.jpg");
                    user.setId(1);
                    intent.putExtra("user", user);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Vui lòng kiểm tra lại số điện thoại", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    boolean checkValid() {
        int phoneLeng = edtPhoneNumber.getText().toString().length();
        return (phoneLeng > 9);


    }
}

