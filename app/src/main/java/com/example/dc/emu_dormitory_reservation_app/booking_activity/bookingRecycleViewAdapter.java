package com.example.dc.emu_dormitory_reservation_app.booking_activity;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dc.emu_dormitory_reservation_app.BookingbyCustomerId;
import com.example.dc.emu_dormitory_reservation_app.Choose_room_class;
import com.example.dc.emu_dormitory_reservation_app.R;
import com.example.dc.emu_dormitory_reservation_app.Room_detail;
import com.example.dc.emu_dormitory_reservation_app.search_results_activity.SearchResultsListDataModel;

import java.util.ArrayList;

public class bookingRecycleViewAdapter extends RecyclerView.Adapter<bookingRecycleViewAdapter.ViewHolder> {
    private static final String TAG = "bookingRecycleViewAdapt";
    private Context mContext;
    private ArrayList<BookingbyCustomerId> mBookingsDataModel = new ArrayList<>();

    public bookingRecycleViewAdapter(Context mContext, ArrayList<BookingbyCustomerId> mBookingsDataModel) {
        this.mContext = mContext;
        this.mBookingsDataModel = mBookingsDataModel;
    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_booking_activity_item, parent, false);
        ViewHolder holder = new ViewHolder(view, mContext, mBookingsDataModel);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(mContext).asBitmap().load(mBookingsDataModel.get(position).getDormitoryImageUrl()).into(holder.imageViewDormitoryImage);
        holder.textViewDormitoryName.setText(mBookingsDataModel.get(position).getDormitoryName());
        holder.textViewDormitoryDescription.setText(mBookingsDataModel.get(position).getDormitoryDescription());
        holder.textViewDateOfBooking.setText("Booking date: "+mBookingsDataModel.get(position).getDateOfBooking());
        holder.textViewCheckInDate.setText("Check-in date: "+mBookingsDataModel.get(position).getCheckInDate());
        holder.textViewBookingStatus.setText("Booking status: "+mBookingsDataModel.get(position).getBookingStatus());
        holder.textViewRatingValue.setText(mBookingsDataModel.get(position).getRatingNumber());
        holder.textViewRatingStatus.setText(mBookingsDataModel.get(position).getRatingText());

    }

    @Override
    public int getItemCount() {
        return mBookingsDataModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
      RelativeLayout ralativeLayoutBookingActivity;
      ImageView imageViewDormitoryImage;
      TextView textViewDormitoryName;
      ImageView imageViewMoreOptions;
      TextView  textViewDormitoryDescription;
      TextView  textViewDateOfBooking;
      TextView textViewCheckInDate;
      TextView textViewBookingStatus;
      TextView textViewRatingValue;
      TextView textViewRatingStatus;


        ArrayList<BookingbyCustomerId> Roomid = new ArrayList<BookingbyCustomerId>();
        Context ctx;
        public ViewHolder(View itemView, Context ctx, ArrayList<BookingbyCustomerId> Roomid) {
            super(itemView);

            this.Roomid = Roomid;
            this.ctx = ctx;
            itemView.setOnClickListener(this);

            ralativeLayoutBookingActivity = itemView.findViewById(R.id.ralativeLayoutBookingActivity);
            imageViewDormitoryImage = itemView.findViewById(R.id.imageViewDormitoryImage);
            textViewDormitoryName = itemView.findViewById(R.id.textViewDormitoryName);
            imageViewMoreOptions = itemView.findViewById(R.id.imageViewMoreOptions);
            textViewDormitoryDescription = itemView.findViewById(R.id.textViewDormitoryDescription);
            textViewDateOfBooking = itemView.findViewById(R.id.textViewDateOfBooking);
            textViewCheckInDate = itemView.findViewById(R.id.textViewCheckInDate);
            textViewBookingStatus = itemView.findViewById(R.id.textViewBookingStatus);
            textViewRatingValue = itemView.findViewById(R.id.textViewRatingValue);
            textViewRatingStatus = itemView.findViewById(R.id.textViewRatingStatus);

        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            BookingbyCustomerId Roomid = this.Roomid.get(position);
            Intent intent = new Intent(this.ctx, Room_detail.class);
            intent.putExtra("bookingNo", Roomid.getBookingNumber());
            intent.putExtra("DormId", Roomid.getDormitoryId());
            intent.putExtra("Roomid", Roomid.getRoomId());
            intent.putExtra("bookingst", "booked");
            this.ctx.startActivity(intent);
        }
    }
}
