package com.example.dc.emu_dormitory_reservation_app;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Choose_room_Adapter extends RecyclerView.Adapter<Choose_room_Adapter.ViewHolder>{
    ArrayList<Choose_room_class> recycle_item = new ArrayList<>();
    private Context mContext;

    public Choose_room_Adapter(Context mContext, ArrayList<Choose_room_class> recycle_item) {
        this.recycle_item = recycle_item;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.choose_room_item,parent, false);
        ViewHolder holder = new ViewHolder(itemView, mContext, recycle_item);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Choose_room_class chooseRoomClass = recycle_item.get(position);

        Glide.with(mContext)
                .load(chooseRoomClass.getRoom_image())
                .into(holder.mroom_image);
       // holder.room_image.setImageDrawable(mContext.getResources().getDrawable(Integer.parseInt(String.valueOf(chooseRoomClass.getRoom_image()))));
        holder.mroom_name.setText(chooseRoomClass.getRoom_name());
        holder.mbed_type.setText(chooseRoomClass.getBedType());
        holder.mroom_size.setText(chooseRoomClass.getRoom_size());
        holder.mroom_left.setText(chooseRoomClass.getRoom_left());
        holder.mroom_price.setText(chooseRoomClass.getRoom_price());

    }

    @Override
    public int getItemCount() {
        return recycle_item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView mroom_image;
        TextView mroom_name,mbed_type,mroom_size,mroom_left,mroom_price;
        LinearLayout parentlayout;


        ArrayList<Choose_room_class> Roomid = new ArrayList<Choose_room_class>();
        Context ctx;
        public ViewHolder(View itemView, Context ctx, ArrayList<Choose_room_class> Roomid) {
            super(itemView);

            this.Roomid = Roomid;
            this.ctx = ctx;
            itemView.setOnClickListener(this);

            mroom_image = itemView.findViewById(R.id.image);
            mroom_name = itemView.findViewById(R.id.room_name);
            mbed_type = itemView.findViewById(R.id.Bed);
            mroom_size = itemView.findViewById(R.id.Room_size);
            mroom_left = itemView.findViewById(R.id.room_left);
            mroom_price = itemView.findViewById(R.id.Price);
            parentlayout = itemView.findViewById(R.id.parentt_layout);

        }


        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Choose_room_class Roomid = this.Roomid.get(position);
            Intent intent = new Intent(this.ctx, Room_detail.class);
            intent.putExtra("Roomid", Roomid.getRoomid());
            intent.putExtra("DormId", Roomid.getDormid());



            /*Bundle bundle=new Bundle();
            bundle.putSerializable("roomQandP",Choose_room.roomQandP);
            bundle.putSerializable("images",Choose_room.images);
            bundle.putSerializable("facilities",Choose_room.facilities);

            intent.putExtras(bundle);*/


            this.ctx.startActivity(intent);
        }
    }


}
