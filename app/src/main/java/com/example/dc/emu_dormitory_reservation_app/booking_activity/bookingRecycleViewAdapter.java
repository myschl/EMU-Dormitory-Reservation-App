package com.example.dc.emu_dormitory_reservation_app.booking_activity;

import android.content.Context;
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
import com.example.dc.emu_dormitory_reservation_app.R;
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
        ViewHolder holder = new ViewHolder(view);

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

    public class ViewHolder extends RecyclerView.ViewHolder{
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


        public ViewHolder(View itemView) {
            super(itemView);
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
    }
}
