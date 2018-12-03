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

public class RoomDetailImagesAdapter extends RecyclerView.Adapter<RoomDetailImagesAdapter.ViewHolder> {
    private ImageView image;
    private ArrayList<RoomDetailImageModel> images = new ArrayList<>();
    private Context mContext;

    public RoomDetailImagesAdapter(Context mContext, ArrayList<RoomDetailImageModel> images) {
        this.images = images;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RoomDetailImagesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.roomimagerecyclerview, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RoomDetailImagesAdapter.ViewHolder holder, int position) {
        Glide.with(mContext)
                .asBitmap()
                .load(images.get(position).getImageUrl())
                .into(holder.imageurl);

    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageurl;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            imageurl = itemView.findViewById(R.id.iimage);
            parentLayout = itemView.findViewById(R.id.iroomdetailimageview);
        }
    }
}
