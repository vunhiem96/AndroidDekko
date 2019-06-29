package com.example.nhiem.Controller.Main;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nhiem.Controller.Auth.LoginActivity;
import com.example.nhiem.Controller.Main.Adapter.NewsAdapter;
import com.example.nhiem.Controller.Main.Adapter.PromotionAdapter;
import com.example.nhiem.Model.HomeData;
import com.example.nhiem.Model.News;
import com.example.nhiem.Model.User;
import com.example.nhiem.R;
import com.example.nhiem.Utils.AppConfig;
import com.example.nhiem.Utils.Utli;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class HomeActivity extends AppCompatActivity {

    TextView btnLogout;
    TextView tvUsername, tvPhoneNumber;
    ImageView imgNews1, imgNews2, imgNews3, imgCtth1, imgCtth2;
    TextView tvNews1, tvNews2, tvNews3, tvCtth1, tvCtth2;
    Button btnLinkNew1;
   RecyclerView rvNews;
  HomeData homeData;
  RecyclerView rvPromotion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();
        getData();
        thongTin();
       dangxuat();
        docJson();
        //news();
        configRVNewss();
        configPromo ();
    }
    void configRVNewss() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        rvNews.setLayoutManager(linearLayoutManager);
        NewsAdapter adapter = new NewsAdapter();
        adapter.data = homeData.getHomeResult().getListNews();
        adapter.setContext(this);
        rvNews.setAdapter(adapter);
    }
    void configPromo (){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        rvPromotion.setLayoutManager(linearLayoutManager);
        PromotionAdapter adapter = new PromotionAdapter();
        adapter.dataPromotion = homeData.getHomeResult().getListPromotion();
        adapter.setContext(this);
        rvPromotion.setAdapter(adapter);

    }

    public void docJson() {
        String strHomeData = Utli.loadJSONFromAsset(this);
        Gson gson = new Gson();
        homeData = gson.fromJson(strHomeData, HomeData.class);

//      String newsTitle1 = homeData.getHomeResult().getListNews().get(0).getTitle();// moi
//        String urlnew1 = homeData.getResult().getListNews().get(0).getUrlImage();
//
//        String newsTitle2 = homeData.getResult().getListNews().get(1).getTitle();
//        String urlnew2 = homeData.getResult().getListNews().get(1).getUrlImage();
//
//        String newsTitle3 = homeData.getResult().getListNews().get(2).getTitle();
//        String urlnew3 = homeData.getResult().getListNews().get(2).getUrlImage();
//
//        String ctthTitle1 = homeData.getResult().getListPromotion().get(0).getTitle();
//        String urlImage1 = homeData.getResult().getListPromotion().get(0).getUrlImage();
//
//        String ctthTitle2 = homeData.getResult().getListPromotion().get(1).getTitle();
//        String urlImage2 = homeData.getResult().getListPromotion().get(1).getUrlImage();
//
//
//        tvNews1.setText(newsTitle1);
//        tvNews2.setText(newsTitle2);
//        tvNews3.setText(newsTitle3);
//        tvCtth1.setText(ctthTitle1);
//        tvCtth2.setText(ctthTitle2);
//        Picasso.get().load(urlnew1).placeholder(R.mipmap.img_default).into(imgNews1);
//        Picasso.get().load(urlnew2).placeholder(R.mipmap.img_default).into(imgNews2);
//        Picasso.get().load(urlnew3).placeholder(R.mipmap.img_default).into(imgNews3);
//
//        Picasso.get().load(urlImage1).placeholder(R.mipmap.img_default).into(imgCtth1);
//        Picasso.get().load(urlImage2).placeholder(R.mipmap.img_default).into(imgCtth2); // moi

        /* try {
            JSONObject jsonHomeData = new JSONObject(homeData);
            int status = jsonHomeData.getInt("status");
            int code = jsonHomeData.getInt("code");
            String msg = jsonHomeData.getString("message");
            JSONObject jsonResult = jsonHomeData.getJSONObject("result");
            JSONObject jsonCustomerDetail = jsonResult.getJSONObject("customerDetail");
            String customerName = jsonCustomerDetail.getString("customerName");
            JSONArray jsonArrayNews = jsonResult.getJSONArray("listNews");
            JSONArray jsonArrayCtth = jsonResult.getJSONArray("listPromotion");
            // -------------------
            JSONObject jsonNew1 = jsonArrayNews.getJSONObject(0);
            JSONObject jsonNew2 = jsonArrayNews.getJSONObject(1);
            JSONObject jsonNew3 = jsonArrayNews.getJSONObject(2);

            //
            String newsTitle1 = jsonNew1.getString("title");
            String urlNew1 = jsonNew1.getString("urlImage");

            String newsTitle2 = jsonNew2.getString("title");
            String urlNew2 = jsonNew2.getString("urlImage");

            String newsTitle3 = jsonNew3.getString("title");
            String urlNew3 = jsonNew3.getString("urlImage");
            //

            JSONObject jsonCtth1 = jsonArrayCtth.getJSONObject(0);
            JSONObject jsonCtth2 = jsonArrayCtth.getJSONObject(1);


            String ctthTitle1 = jsonCtth1.getString("title");
            String urlCtth1 = jsonCtth1.getString("urlImage");

            String ctthTitle2 = jsonCtth2.getString("title");
            String urlCtth2 = jsonCtth2.getString("urlImage");



            //
            Picasso.get().load(urlNew1).placeholder(R.mipmap.img_default).into(imgNews1);
            Picasso.get().load(urlNew2).placeholder(R.mipmap.img_default).into(imgNews2);
            Picasso.get().load(urlNew3).placeholder(R.mipmap.img_default).into(imgNews3);

            Picasso.get().load(urlCtth1).placeholder(R.mipmap.img_default).into(imgCtth1);
            Picasso.get().load(urlCtth2).placeholder(R.mipmap.img_default).into(imgCtth2);


            tvNews1.setText(newsTitle1);
            tvNews2.setText(newsTitle2);
            tvNews3.setText(newsTitle3);

            tvCtth1.setText(ctthTitle1);
            tvCtth2.setText(ctthTitle2);



        } catch (JSONException e) {
            e.printStackTrace();
        }*/
    }



    void init() {
        rvPromotion = (RecyclerView) findViewById(R.id.rcv_promotion);
        btnLogout = (TextView) findViewById(R.id.tv_logout);
        tvUsername = findViewById(R.id.tv_user_name);
        tvPhoneNumber = findViewById(R.id.tv_phone_number);
       // imgNews1 = findViewById(R.id.img_news_1);
       // tvNews1 = findViewById(R.id.tv_new_1);
//        imgCtth1 = findViewById(R.id.img_ctth1);
//        imgCtth2 = findViewById(R.id.img_ctth2);
//        tvCtth1 = findViewById(R.id.tv_ctth1);
//        tvCtth2 = findViewById(R.id.tv_ctth2);
     //  btnLinkNew1 = (Button) findViewById(R.id.btn_link_new1);
        rvNews = findViewById(R.id.rv_news);

    }

    private void dangxuat() {
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             onBackPressed();
//                AppConfig.logout(HomeActivity.this);
//                Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
//                startActivity(intent);
//                finish();
            }
        });
    }
    public void onBackPressed() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.app_name);
        builder.setIcon(R.mipmap.ic_launcher);
        builder.setMessage("Bạn có muốn thoát không?")
                .setCancelable(false)
                .setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        AppConfig.logout(HomeActivity.this);
                        Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();

    }

    private void news() {
        btnLinkNew1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://phucha.com/"));
                startActivity(intent);
            }
        });
    }

    private void thongTin() {
        tvUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, user_main.class);
                User user;
                user = new User();
                user.setUsername("Vũ Hữu Nhiệm");
                user.setPhoneNumber("0973833924");
                user.setProfileUrl("https://i.imgur.com/R6JbROY.jpg");
                user.setId(1);
                intent.putExtra("user", user);
                startActivity(intent);

            }
        });
    }

    private void getData() {
        tvUsername.setText(AppConfig.getNameUser(HomeActivity.this));
        tvPhoneNumber.setText(AppConfig.getPhoneNumber(HomeActivity.this));
    }

//    class NewsViewHolder extends RecyclerView.ViewHolder{
//        ImageView imgBg;
//        TextView tvTitle;
//        Button btnDetail;
//
//        public NewsViewHolder(@NonNull View itemView) {
//            super(itemView);
//            imgBg = (ImageView) findViewById(R.id.img_bg);
//            tvTitle = (TextView) findViewById(R.id.tv_title);
//            btnDetail = (Button) findViewById(R.id.btn_detail);
//        }
//    }
}
