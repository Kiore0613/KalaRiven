package com.example.actividad_eva1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.actividad_eva1.Adapters.Hardware;
import com.example.actividad_eva1.Adapters.HardwareAdapter;

import java.util.ArrayList;

public class HardwareActivity extends AppCompatActivity implements
        HardwareAdapter.OnItemClick
{

    Button backButton, exitButton;
    RecyclerView hardwareRecyclerView;

    public static final String CAT = "category";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware);
        setTitle("Hardware");
        backButton = findViewById(R.id.back_button);
        exitButton = findViewById(R.id.exit_button);
        hardwareRecyclerView = findViewById(R.id.hardware_recyclerview);

        ArrayList<Hardware> hardwares = getIntent().getExtras().getParcelableArrayList(CAT);

        hardwareRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        HardwareAdapter adapter = new HardwareAdapter(hardwares, this);
        hardwareRecyclerView.setAdapter(adapter);
        hardwareRecyclerView.addItemDecoration(
                new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));



    }
    public void exit(View exit_button){
        finishAffinity();
    }

    public void back(View back_button){
        finish();
    }


    @Override
    public void OnContainerClick(Hardware hardware) {
        Intent intent = new Intent(getApplicationContext(), HardwareDetailActivity.class);
        intent.putExtra(CAT, hardware);
        startActivity(intent);
    }


}
