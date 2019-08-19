package com.example.actividad_eva1.Adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.support.v7.widget.RecyclerView;
import com.example.actividad_eva1.R;

import java.util.ArrayList;

public class HardwareCategoryAdapter extends RecyclerView.Adapter<HardwareCategoryAdapter.ViewHolderCategory> {

    ArrayList<Category> categoryList;
    OnItemClick callback;

    public HardwareCategoryAdapter(ArrayList<Category> categoryList, OnItemClick callback) {
        this.categoryList = categoryList;
        this.callback = callback;
    }

    public interface OnItemClick {

        void onContainerClick(Category category);
    }
    @NonNull
    @Override
    public HardwareCategoryAdapter.ViewHolderCategory onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_view_category, parent, false);

        return new ViewHolderCategory(view);
    }

    @Override
    public void onBindViewHolder(ViewHolderCategory holder, final int position) {
        holder.categoryImage.setImageResource(categoryList.get(position).getCategory());
        holder.categoryNameTextView.setText(categoryList.get(position).getCategoryName());


        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callback.onContainerClick(categoryList.get(position));
            }
        });

    }
    @Override
    public int getItemCount() {
        return categoryList.size();

    }

    public class ViewHolderCategory extends RecyclerView.ViewHolder {

        ImageView categoryImage;
        TextView categoryNameTextView;
        View container;

        public ViewHolderCategory(View itemView) {
            super(itemView);

            categoryImage = itemView.findViewById(R.id.category_image);
            categoryNameTextView = itemView.findViewById(R.id.category_name_textview);
            container = itemView.findViewById(R.id.container_layout);

        }
    }

}