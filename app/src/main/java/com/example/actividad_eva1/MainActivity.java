package com.example.actividad_eva1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.actividad_eva1.Adapters.HardwareCategoryAdapter;

public class MainActivity extends AppCompatActivity {

    Button startActivity, exitActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity = findViewById(R.id.start_button);
        exitActivity = findViewById(R.id.exit_button);
    }

    public void start(View start_button){
        Intent intent = new Intent(getApplicationContext(), HardwareCategoryActivity.class);
        startActivity(intent);
    }

    public void exit(View exit_button){
        finishAffinity();
    }

}
