package com.example.dc.emu_dormitory_reservation_app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Room_detail_facilities_Adapter extends RecyclerView.Adapter<Room_detail_facilities_Adapter.ViewHolder>{
    private ArrayList<String> mImages = new ArrayList<>();
    private ArrayList<String> mName = new ArrayList<>();
    private Context mContext;

    public Room_detail_facilities_Adapter(Context mContext, ArrayList<String> mImages, ArrayList<String> mName) {
        this.mImages = mImages;
        this.mName = mName;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.room_detail_adapter, parent, false);
        return new Room_detail_facilities_Adapter.ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(mContext)
                .asBitmap()
                .load(mImages.get(position))
                .into(holder.image);
        holder.name.setText(mName.get(position));

    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView image;
        TextView name;
        RelativeLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            name = itemView.findViewById(R.id.facility_name);
            parentLayout = itemView.findViewById(R.id.room_detail_parent);
        }
    }
}