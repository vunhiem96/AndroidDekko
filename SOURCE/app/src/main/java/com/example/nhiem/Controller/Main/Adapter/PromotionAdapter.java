package com.example.nhiem.Controller.Main.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.nhiem.Model.ListPromotion;
import com.example.nhiem.R;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

public class PromotionAdapter extends RecyclerView.Adapter<PromotionAdapter.PromotionViewHolder> {
    Context context;
   public List<ListPromotion> dataPromotion;

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public PromotionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.promotion_item_layout, viewGroup, false);
        PromotionViewHolder promotionViewHolder = new PromotionViewHolder(view);
        return promotionViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PromotionViewHolder promotionViewHolder, int i) {
         ListPromotion listPromotion = dataPromotion.get(i);
         promotionViewHolder.tvTitle.setText(listPromotion.getTitle());
        Picasso.get().load(listPromotion.getUrlImage()).into(promotionViewHolder.imgBg);
    }

    @Override
    public int getItemCount() {
        return dataPromotion.size();
    }

    class PromotionViewHolder extends RecyclerView.ViewHolder{
        ImageView imgBg;
        TextView tvTitle;
        Button btnDetail;

        public PromotionViewHolder(@NonNull View itemView) {
            super(itemView);
            imgBg =  itemView.findViewById(R.id.img_bg);
            tvTitle =  itemView.findViewById(R.id.tv_title);
            btnDetail =  itemView.findViewById(R.id.btn_detail);
        }
    }
}
