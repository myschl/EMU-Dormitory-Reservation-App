package com.example.dc.emu_dormitory_reservation_app.rate_bookings_activity_2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.dc.emu_dormitory_reservation_app.R;
import com.example.dc.emu_dormitory_reservation_app.rate_bookings_activity_1.RateBookingsDataModel1;
import com.example.dc.emu_dormitory_reservation_app.rate_bookings_activity_1.RateBookingsRecycleViewAdapter1;

import java.util.ArrayList;

public class RateBookingsRecycleViewAdapter2 extends RecyclerView.Adapter<RateBookingsRecycleViewAdapter2.ViewHolder>{


    private static final String TAG = "RateBookingsRecycleView";
    Context mContext;
    ArrayList<RateBookingsDataModel2> mRateBookingsDataModel2 = new ArrayList<>();

    public RateBookingsRecycleViewAdapter2(Context mContext, ArrayList<RateBookingsDataModel2> mRateBookingsDataModel2) {
        this.mContext = mContext;
        this.mRateBookingsDataModel2 = mRateBookingsDataModel2;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_rate_bookings_activity_2, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

      //  Glide.with(mContext).asBitmap().load(mCategoriesDataModel.get(position).getCategoryImageUrl()).into(holder.imageViewCategories);
        Glide.with(mContext).asBitmap().load(mRateBookingsDataModel2.get(position).getDormitoryImageUrl()).into(holder.imageViewDormitoryImage);

        // holder.textViewCategoriesTitle.setText(mCategoriesDataModel.get(position).getCategoryTitle());

      //  holder.relativeLayoutCategories.setOnClickListener(new View.OnClickListener() {
         //   @Override
         //   public void onClick(View v) {
         //       Log.d(TAG, "onClick: clicked on: " + mCategoriesDataModel.get(position).getCategoryTitle());
         //       Toast.makeText(mContext, mCategoriesDataModel.get(position).getCategoryTitle(), Toast.LENGTH_SHORT).show();
//
         //   }
      //  });


        holder.textViewDormitoryName.setText(mRateBookingsDataModel2.get(position).getDormitoryName());
        holder.textViewDormitoryDescription.setText(mRateBookingsDataModel2.get(position).getDormitoryShortDescription());

        holder.textViewRatingValue.setText(mRateBookingsDataModel2.get(position).getDormitoryRating());
        holder.textViewRatingStatus.setText(mRateBookingsDataModel2.get(position).getDormitoryRatingStatus());

        //  holder.imageViewMoreOptions;
      //  holder.ralativeLayoutRateBookings2;
    }

    @Override
    public int getItemCount() {
        return mRateBookingsDataModel2.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewDormitoryImage;
        TextView textViewDormitoryName;
        TextView textViewDormitoryDescription;
        ImageView imageViewMoreOptions;
        TextView textViewRatingValue;
        TextView textViewRatingStatus;
        RelativeLayout ralativeLayoutRateBookings2;

        public ViewHolder(View itemView) {
            super(itemView);
            imageViewDormitoryImage = (ImageView) itemView.findViewById(R.id.imageViewDormitoryImage);
            textViewDormitoryName =  itemView.findViewById(R.id.textViewDormitoryName);
            textViewDormitoryDescription = itemView.findViewById(R.id.textViewDormitoryDescription);
            imageViewMoreOptions = itemView.findViewById(R.id.imageViewMoreOptions);
            textViewRatingValue = itemView.findViewById(R.id.textViewRatingValue);
            textViewRatingStatus = itemView.findViewById(R.id.textViewRatingStatus);
            ralativeLayoutRateBookings2 = itemView.findViewById(R.id.ralativeLayoutRateBookings2);
        }
    }
}
