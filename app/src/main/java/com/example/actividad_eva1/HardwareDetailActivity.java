package com.example.actividad_eva1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.actividad_eva1.Adapters.Hardware;

public class HardwareDetailActivity extends AppCompatActivity implements View.OnClickListener {

    Button backButton, exitButton;
    TextView hardwareName, hardwareDetail;
    ImageView hardwareImage;
    String name, detail;
    int image;

    public static final String CAT = "category";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware_detail);
        hardwareImage = findViewById(R.id.hardware_image_detail);
        hardwareName = findViewById(R.id.hardware_name_textview);
        hardwareDetail = findViewById(R.id.hardware_detail_textview);
        backButton = findViewById(R.id.back_button);
        exitButton = findViewById(R.id.exit_button);

        setTitle("Hardware Detail");

        Hardware hardware = (getIntent().getExtras()).getParcelable(CAT);
        name = hardware.getHardwareName();
        detail = hardware.getHardwareDetail();
        image = hardware.getHardware();

        hardwareDetail.setText(detail);
        hardwareName.setText(name);
        hardwareImage.setImageResource(image);

        Buttons();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_button:
                finish();
                break;
            case R.id.exit_button:
                finishAffinity();
                break;
        }
    }

    public void Buttons() {
        backButton.setOnClickListener(this);
        exitButton.setOnClickListener(this);
    }

}
