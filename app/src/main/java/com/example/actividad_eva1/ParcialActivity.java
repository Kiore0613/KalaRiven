package com.example.actividad_eva1;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

import com.example.actividad_eva1.Adapters.PictureAdapter;

public class ParcialActivity extends AppCompatActivity {
        ListView listViewPicture;
        PictureAdapter pictureAdapter;
    static final int IMAGE = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parcial);

        listViewPicture = findViewById(R.id.list_view_main);
        pictureAdapter = new PictureAdapter(this, );

    }

    public void btnPhoto(View btn){
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
            imageList.add(new Objeto(imageBitmap));

        }
    }


}
