package com.example.nhiem;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.kofigyan.stateprogressbar.StateProgressBar;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;

public class user_main extends AppCompatActivity {
    TextView tvPhonenumber, tvName, tvEdit;
    CircleImageView imgAvatar;
    String[] descriptionData = {"Thành Viên", "Bạc", "Vàng", "Bạch Kim"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);
        init();
        getData();
        StateProgressBar stateProgressBar = (StateProgressBar) findViewById(R.id.spb_member);
        stateProgressBar.setStateDescriptionData(descriptionData);
    }
    void getData(){
        User user= (User) getIntent().getSerializableExtra("user");
        tvPhonenumber.setText(user.getPhoneNumber());
        tvName.setText(user.getUsername());
        Picasso.get().load(user.getProfileUrl()).into(imgAvatar);
    }
    void init(){
        tvPhonenumber = (TextView) findViewById(R.id.tv_phone_number);
        imgAvatar = (CircleImageView) findViewById(R.id.img_avatar);
        tvName = (TextView) findViewById(R.id.tv_name);
        tvEdit = (TextView) findViewById(R.id.tv_edit);

    }
}

        /*tao doi tuong user User là khuân, chỉ tạo không dùng, myuser là đối tượng
        User windsuser= new User();//khai báo + khởi tạo
       /* cach 1 windsuser.id = 1;
        windsuser.phoneNumber="0123";
        windsuser.profileUrl= "http://kjkjkjkjk.jpg";
        windsuser.username="nhiemvh";*/

       /*windsuser.setId(1);
       windsuser.setPhoneNumber("0973933924");
       windsuser.setProfileUrl("http://kjkjkjkjk.jpg");
       windsuser.setUsername("NHiemVH");*/

// Toast.makeText(this, windsuser.username, Toast.LENGTH_LONG).show();
// sử dựng đối tượng khai báo và khởi tạo trong XML
// buoc 1: gan id cho doi tuong trong xml
// buoc 2: tao 1 ten moi va gan lại cho đối tượng đấy
       /* edtPhoneNumber = (EditText) findViewById(R.id.edt_phone_number);
        edtPhoneNumber.setText(windsuser.getPhoneNumber());
        tvUserName = (TextView) findViewById(R.id.tv_username);
        tvUserName.setText(windsuser.getUsername());*/



