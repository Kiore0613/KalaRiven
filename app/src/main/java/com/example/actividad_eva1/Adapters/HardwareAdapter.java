package com.example.actividad_eva1.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.actividad_eva1.R;

import java.util.ArrayList;

public class HardwareAdapter extends RecyclerView.Adapter<HardwareAdapter.ViewHolderHardware> {

    ArrayList<Hardware> hardwareList;
    OnItemClick callback;

    public HardwareAdapter(ArrayList<Hardware> hardwareList, OnItemClick callback) {
        this.hardwareList = hardwareList;
        this.callback = callback;

    }

    public interface OnItemClick {
        void OnContainerClick(Hardware hardware);
    }
    @NonNull
    @Override
    public HardwareAdapter.ViewHolderHardware onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_hardware, parent, false);

        return new ViewHolderHardware(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderHardware holder, final int position) {
        holder.hardwareImage.setImageResource(hardwareList.get(position).getHardware());
        holder.hardwareNameTextView.setText(hardwareList.get(position).getHardwareName());
        holder.hardwareDetailTextView.setText(hardwareList.get(position).getHardwareDetail());


        holder.viewItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.OnContainerClick(hardwareList.get(position));
            }
        });

    }
    @Override
    public int getItemCount() {
        return hardwareList.size();

    }
    public class ViewHolderHardware extends RecyclerView.ViewHolder {

        ImageView hardwareImage;
        TextView hardwareNameTextView, hardwareDetailTextView;
        View viewItem;

        public ViewHolderHardware(View itemView) {
            super(itemView);

            viewItem = itemView.findViewById(R.id.hardware_layout);
            hardwareImage = itemView.findViewById(R.id.hardware_image);
            hardwareDetailTextView = itemView.findViewById(R.id.hardware_detail_textview);
            hardwareNameTextView = itemView.findViewById(R.id.hardware_name_textview);

        }
    }

}
