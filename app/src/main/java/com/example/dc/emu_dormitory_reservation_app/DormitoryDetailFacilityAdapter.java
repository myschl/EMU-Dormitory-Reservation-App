package com.example.dc.emu_dormitory_reservation_app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DormitoryDetailFacilityAdapter  extends RecyclerView.Adapter<DormitoryDetailFacilityAdapter.ViewHolder>{

    private ArrayList<DormitoryDetailFacilitiesModel> images = new ArrayList<>();
    private Context mContext;


    public DormitoryDetailFacilityAdapter(Context mContext, ArrayList<DormitoryDetailFacilitiesModel> images) {
        this.images = images;
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dormitorydemailfacilitiesview, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Glide.with(mContext)
                .asBitmap()
                .load(images.get(position).getImageUrl())
                .into(holder.imageurl);
        holder.name.setText(images.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return images.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageurl;
        TextView  name;
        LinearLayout parentLayout;

        public ViewHolder(View itemView) {
            super(itemView);

            imageurl = itemView.findViewById(R.id.iimage);
            name = itemView.findViewById(R.id.iname);
            parentLayout = itemView.findViewById(R.id.iparentlayout);
        }
    }
}
