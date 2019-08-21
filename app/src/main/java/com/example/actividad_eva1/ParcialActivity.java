package com.example.actividad_eva1;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.actividad_eva1.Adapters.Picture;
import com.example.actividad_eva1.Adapters.PictureAdapter;

import java.util.ArrayList;

public class ParcialActivity extends AppCompatActivity {
        ListView listViewPicture;
        static final int IMAGE = 1;
        ArrayList<Picture> pictureList;
        Button backButton, exitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcial);
        pictureList = new ArrayList<>();

        backButton = findViewById(R.id.back_button);
        exitButton = findViewById(R.id.exit_button);
        listViewPicture = findViewById(R.id.list_view_main);
        PictureAdapter  picture = new PictureAdapter( pictureList, this);
        listViewPicture.setAdapter(picture);
        picture.notifyDataSetChanged();
    }

    public void btnPicture(View picture_button){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, IMAGE);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == IMAGE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            pictureList.add(new Picture(imageBitmap));

        }
    }
    public void exit(View exit_button){
        finishAffinity();
    }
    public void back(View back_button){
        finish();
    }



}
