package com.example.dc.emu_dormitory_reservation_app.Home_activity;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dc.emu_dormitory_reservation_app.R;

import java.util.ArrayList;

public class HomeActivityRecycleViewAdapter extends RecyclerView.Adapter<HomeActivityRecycleViewAdapter.ViewHolder> {
    private static final String TAG = "HomeActivityRecycleView";
    private Context mContext;
    private ArrayList<HomeActivityDataModel> mHomeActivityDataModel = new ArrayList<>();

    public HomeActivityRecycleViewAdapter(Context mContext, ArrayList<HomeActivityDataModel> mHomeActivityDataModel) {
        this.mContext = mContext;
        this.mHomeActivityDataModel = mHomeActivityDataModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycleview_home_activity, parent, false);
        ViewHolder holder = new ViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(mContext).asBitmap().load(mHomeActivityDataModel.get(position).getDormitoryImageUrl()).into(holder.imageViewDormitoryImage);
        holder.textViewDormitoryName.setText(mHomeActivityDataModel.get(position).getDormitoryName());
        holder.textViewdeals_text.setText(mHomeActivityDataModel.get(position).getDormitoryDiscountsStartsAt()+ " "+ mHomeActivityDataModel.get(position)+mHomeActivityDataModel.get(position).getDiscountAmountStratsAt());
    }

    @Override
    public int getItemCount() {
        return mHomeActivityDataModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
       RelativeLayout ralativeLayoutHomeActivityRecycleView;
       ImageView imageViewDormitoryImage;
        TextView textViewdeals_text;
       TextView textViewDormitoryName;

        public ViewHolder(View itemView) {
            super(itemView);

            ralativeLayoutHomeActivityRecycleView = itemView.findViewById(R.id.ralativeLayoutHomeActivityRecycleView);
            imageViewDormitoryImage = itemView.findViewById(R.id.imageViewDormitoryImage);
            textViewdeals_text = itemView.findViewById(R.id.textViewdeals_text);
            textViewDormitoryName = itemView.findViewById(R.id.textViewDormitoryName);
        }
    }
}
