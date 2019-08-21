package com.example.actividad_eva1.Adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.actividad_eva1.R;

import java.util.ArrayList;

public class PictureAdapter extends BaseAdapter {

    ArrayList<Picture>pictureList;
    Context context;

    public PictureAdapter(ArrayList<Picture> pictureList, Context context) {
        this.pictureList = pictureList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return pictureList.size();
    }

    @Override
    public Object getItem(int position) {
        return pictureList.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Picture item = (Picture) getItem(position);
        convertView = LayoutInflater.from(context).inflate(R.layout.list_view_item, null);
        ImageView pictureImg = convertView.findViewById(R.id.img_list);
        pictureImg.setImageBitmap(item.getPicture());
        return convertView;
    }
}