package com.example.dc.emu_dormitory_reservation_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Dormitory_detail_Adapter extends RecyclerView.Adapter<Dormitory_detail_Adapter.ViewHolder> {
    private ArrayList<DormitoryImagesModel> mImages = new ArrayList<>();
    private Context mContext;

    public Dormitory_detail_Adapter( Context mContext, ArrayList<DormitoryImagesModel> mImages) {
        this.mImages = mImages;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_listitem_detail_dormitory, parent, false);
        return new ViewHolder(itemView, mContext, mImages);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DormitoryImagesModel dormitoryImagesModel = mImages.get(position);
        Glide.with(mContext)
                .asBitmap()
                .load(dormitoryImagesModel.getImage())
                .into(holder.image);
       /* holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(Dormitory_detail_Adapter.this,DormitoryImages.class);
                Bundle bundle=new Bundle();
                bundle.putSerializable("DormImages", mImageUrl);
                i.putExtras(bundle);
                startActivity(i);
               // Toast.makeText(mContext,"welcome",Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView image;
        RelativeLayout parentLayout;

        ArrayList<DormitoryImagesModel> Roomid = new ArrayList<DormitoryImagesModel>();
        Context ctx;

        public ViewHolder(View itemView, Context ctx, ArrayList<DormitoryImagesModel> Roomid) {
            super(itemView);

            this.Roomid = Roomid;
            this.ctx = ctx;
            itemView.setOnClickListener(this);

            image = itemView.findViewById(R.id.image);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            DormitoryImagesModel Roomid = this.Roomid.get(position);
            Intent intent = new Intent(this.ctx, DormitoryImages.class);
            Bundle bundle=new Bundle();
            bundle.putSerializable("DormId", Roomid.getDormId());
            intent.putExtras(bundle);
            this.ctx.startActivity(intent);
        }
    }
}
