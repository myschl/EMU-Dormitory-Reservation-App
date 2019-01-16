package com.example.dc.emu_dormitory_reservation_app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DormitoryImagesAdapter extends RecyclerView.Adapter<DormitoryImagesAdapter.ViewHolder>{
    private ArrayList<DormitoryImagesModel> mImages = new ArrayList<>();
    private Context mContext;

    public DormitoryImagesAdapter( Context mContext, ArrayList<DormitoryImagesModel> mImages) {
        this.mImages = mImages;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dormitoryimagesadapter, parent, false);
        return new ViewHolder(itemView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DormitoryImagesModel dormitoryImagesModel = mImages.get(position);

        Glide.with(mContext)
                .asBitmap()
                .load(dormitoryImagesModel.getImage())
                .into(holder.image);

    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.iimage);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
