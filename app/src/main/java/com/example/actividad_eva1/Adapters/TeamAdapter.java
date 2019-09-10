package com.example.actividad_eva1.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.actividad_eva1.R;

import java.util.ArrayList;

public class TeamAdapter extends
        RecyclerView.Adapter<TeamAdapter.TeamsViewHolder> implements View.OnClickListener{

    public TeamAdapter(ArrayList<Team> listTeam) {
        this.listTeam = listTeam;
    }

    ArrayList<Team> listTeam;
    private View.OnClickListener listener;


    @NonNull
    @Override
    public TeamsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_view_item, null, false);
        view.setOnClickListener(this);
        return new TeamsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamsViewHolder holder, int i) {
        holder.txtName.setText(listTeam.get(i).getName());
        holder.imgImage.setImageResource(listTeam.get(i).getImage());
    }

    @Override
    public int getItemCount() {
        return listTeam.size();
    }

    public void setOnClickListener(View.OnClickListener listener){
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if(listener!= null){
            listener.onClick(v);
        }
    }

    public class TeamsViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtInfo;
        ImageView imgImage;

        public TeamsViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.name_textview);
            imgImage = itemView.findViewById(R.id.team_image_detail);

        }
    }
}

