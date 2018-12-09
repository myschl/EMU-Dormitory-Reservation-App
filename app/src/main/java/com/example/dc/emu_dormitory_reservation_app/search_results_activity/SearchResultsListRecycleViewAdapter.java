package com.example.dc.emu_dormitory_reservation_app.search_results_activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dc.emu_dormitory_reservation_app.Dormitory_detail;
import com.example.dc.emu_dormitory_reservation_app.R;
import com.example.dc.emu_dormitory_reservation_app.rate_bookings_activity_2.RateBookingsDataModel2;

import java.util.ArrayList;

public class SearchResultsListRecycleViewAdapter extends RecyclerView.Adapter<SearchResultsListRecycleViewAdapter.ViewHolder>{


    private static final String TAG = "SearchResultsListRecycl";
    Context mContext;
    ArrayList<SearchResultsListDataModel> mSearchResultsListDataModel = new ArrayList<>();

    public SearchResultsListRecycleViewAdapter(Context mContext, ArrayList<SearchResultsListDataModel> mSearchResultsListDataModel) {
        this.mContext = mContext;
        this.mSearchResultsListDataModel = mSearchResultsListDataModel;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_search_results_list, parent, false);
        ViewHolder holder = new ViewHolder(view, mContext, mSearchResultsListDataModel);

        return holder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

      //  Glide.with(mContext).asBitmap().load(mCategoriesDataModel.get(position).getCategoryImageUrl()).into(holder.imageViewCategories);
        Glide.with(mContext).asBitmap().load(mSearchResultsListDataModel.get(position).getDormitoryImageUrl()).into(holder.imageViewDormitoryImage);

        // holder.textViewCategoriesTitle.setText(mCategoriesDataModel.get(position).getCategoryTitle());

      //  holder.relativeLayoutCategories.setOnClickListener(new View.OnClickListener() {
         //   @Override
         //   public void onClick(View v) {
         //       Log.d(TAG, "onClick: clicked on: " + mCategoriesDataModel.get(position).getCategoryTitle());
         //       Toast.makeText(mContext, mCategoriesDataModel.get(position).getCategoryTitle(), Toast.LENGTH_SHORT).show();
//
         //   }
      //  });


        holder.textViewDormitoryName.setText(mSearchResultsListDataModel.get(position).getDormitoryName());
        holder.textViewDormitoryDescription.setText(mSearchResultsListDataModel.get(position).getDormitoryShortDescription());

        holder.textViewRatingValue.setText(mSearchResultsListDataModel.get(position).getDormitoryRating());
        holder.textViewRatingStatus.setText(mSearchResultsListDataModel.get(position).getDormitoryRatingStatus());

        //  holder.imageViewMoreOptions;
      //  holder.ralativeLayoutRateBookings2;
    }

    @Override
    public int getItemCount() {
        return mSearchResultsListDataModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        ImageView imageViewDormitoryImage;
        TextView textViewDormitoryName;
        TextView textViewDormitoryDescription;
        ImageView imageViewMoreOptions;
        TextView textViewRatingValue;
        TextView textViewRatingStatus;
        RelativeLayout ralativeLayoutRateBookings2;


        ArrayList<SearchResultsListDataModel> DormId = new ArrayList<SearchResultsListDataModel>();
        Context ctx;

        public ViewHolder(View itemView, Context ctx, ArrayList<SearchResultsListDataModel> DormId) {
            super(itemView);

            this.DormId = DormId;
            this.ctx = ctx;
            itemView.setOnClickListener(this);

            imageViewDormitoryImage = (ImageView) itemView.findViewById(R.id.imageViewDormitoryImage);
            textViewDormitoryName =  itemView.findViewById(R.id.textViewDormitoryName);
            textViewDormitoryDescription = itemView.findViewById(R.id.textViewDormitoryDescription);
            imageViewMoreOptions = itemView.findViewById(R.id.imageViewMoreOptions);
            textViewRatingValue = itemView.findViewById(R.id.textViewRatingValue);
            textViewRatingStatus = itemView.findViewById(R.id.textViewRatingStatus);
            ralativeLayoutRateBookings2 = itemView.findViewById(R.id.ralativeLayoutRateBookings2);
        }

        @Override
        public void onClick(View v) {

            int position = getAdapterPosition();
            SearchResultsListDataModel dormId = this.DormId.get(position);
            Intent intent = new Intent(this.ctx, Dormitory_detail.class);
            intent.putExtra("DormId", dormId.getDormitoryId());
            this.ctx.startActivity(intent);

        }
    }
}
