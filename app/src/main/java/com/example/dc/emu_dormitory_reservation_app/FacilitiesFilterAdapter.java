package com.example.dc.emu_dormitory_reservation_app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.dc.emu_dormitory_reservation_app.Filter_by_activity.Filter_by;

import java.util.ArrayList;

public class FacilitiesFilterAdapter extends RecyclerView.Adapter<FacilitiesFilterAdapter.ViewHolder> {

    private ArrayList<String> RfacilityId = new ArrayList<>();

    public ArrayList<String> getRfacilityId() {
        return RfacilityId;
    }

    public FacilitiesFilterAdapter() {
    }

    private ArrayList<FilterByFacilitiesModel> facilities = new ArrayList<>();
    private Context mContext;

    public FacilitiesFilterAdapter(Context mContext, ArrayList<FilterByFacilitiesModel> facilities) {
        this.facilities = facilities;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public FacilitiesFilterAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.filterbyfacilities, parent, false);
        return new FacilitiesFilterAdapter.ViewHolder(itemView, mContext, facilities);
    }

    @Override
    public void onBindViewHolder(@NonNull FacilitiesFilterAdapter.ViewHolder holder, int position) {
        holder.name.setText(facilities.get(position).getFacilityName());

    }

    @Override
    public int getItemCount() {
        return facilities.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        CheckBox name;
        RelativeLayout parentLayout;

        ArrayList<FilterByFacilitiesModel> FilterId = new ArrayList<FilterByFacilitiesModel>();
        Context ctx;

        public ViewHolder(View itemView, Context ctx, ArrayList<FilterByFacilitiesModel> FilterId) {
            super(itemView);

            this.FilterId = FilterId;
            this.ctx = ctx;


            name = itemView.findViewById(R.id.ifacility);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            FilterByFacilitiesModel filterId = this.FilterId.get(position);
            String Id = filterId.getFacilityId().toString();

            boolean checked = ((CheckBox) v).isChecked();
                if (checked)
                {
                    RfacilityId.add(Id);
                }
                else
                {
                    RfacilityId.remove(Id);
                }

        }
    }
}
