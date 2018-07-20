package com.example.dc.emu_dormitory_reservation_app.rate_bookings_activity_1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dc.emu_dormitory_reservation_app.R;

import java.util.ArrayList;

public class RateBookingsRecycleViewAdapter1 extends RecyclerView.Adapter<RateBookingsRecycleViewAdapter1.ViewHolder>{
    private static final String TAG = "RateBookingsRecycleView";
    Context mContext;
    ArrayList<RateBookingsDataModel1> mRateBookingsDataModel = new ArrayList<>(); // this array will contain the data we will pass, using our adapter constructor

    public RateBookingsRecycleViewAdapter1(Context mContext, ArrayList<RateBookingsDataModel1> mRateBookingsDataModel) {
        this.mContext = mContext;
        this.mRateBookingsDataModel = mRateBookingsDataModel;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_rate_bookings_activity_1, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: ");

      //  holder.textViewCategoriesTitle.setText(mCategoriesDataModel.get(position).getCategoryTitle());

       // holder.relativeLayoutCategories.setOnClickListener(new View.OnClickListener() {
          //  @Override
         //   public void onClick(View v) {
             //   Log.d(TAG, "onClick: clicked on: " + mCategoriesDataModel.get(position).getCategoryTitle());
               // Toast.makeText(mContext, mCategoriesDataModel.get(position).getCategoryTitle(), Toast.LENGTH_SHORT).show();

          //  }
      //  });

        holder.textViewDormitoryName.setText(mRateBookingsDataModel.get(position).getDormitoryName());
        holder.textViewDormitoryRoomName.setText(mRateBookingsDataModel.get(position).getDormitoryRoomName());
        holder.textViewBookingDate.setText(mRateBookingsDataModel.get(position).getDate());
        holder.textViewDormitoryRatingValue.setText(mRateBookingsDataModel.get(position).getDormitoryRating());

    }

    @Override
    public int getItemCount() {
        return mRateBookingsDataModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

       /* this are fields from our RateBookingsDataModel
        private String dormitoryName;
        private String dormitoryRoomName;
        private String date;
        private String dormitoryRating;
        private String dormitoryId;*/

        TextView textViewDormitoryName;
        TextView textViewDormitoryRoomName;
        TextView textViewBookingDate;
        TextView textViewDormitoryRatingValue;

        RelativeLayout relativeLayoutRateBooking1;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewDormitoryName = itemView.findViewById(R.id.textViewDormitoryName);
            textViewDormitoryRoomName = itemView.findViewById(R.id.textViewDormitoryRoomName);
            textViewBookingDate = itemView.findViewById(R.id.textViewBookingDate);
            textViewDormitoryRatingValue = itemView.findViewById(R.id.textViewRatingValue);
            relativeLayoutRateBooking1 = itemView.findViewById(R.id.ralativeLayoutRateBookings1);
        }

    }
}
