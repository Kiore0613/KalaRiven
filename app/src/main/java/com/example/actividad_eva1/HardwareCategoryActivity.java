package com.example.actividad_eva1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.actividad_eva1.Adapters.Category;
import com.example.actividad_eva1.Adapters.Hardware;
import com.example.actividad_eva1.Adapters.HardwareCategoryAdapter;

import java.util.ArrayList;

public class HardwareCategoryActivity extends AppCompatActivity implements
        HardwareCategoryAdapter.OnItemClick
        {

    RecyclerView categoryRecyclerView;
    ArrayList<Category> categoryList;
    ArrayList<Hardware> pc;
    ArrayList<Hardware> desktop;
    ArrayList<Hardware> mouse;
    ArrayList<Hardware> keyboard;
    ArrayList<Hardware> monitor;

    public static final String CAT = "category";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hardware_category_main);

        categoryRecyclerView = findViewById(R.id.category_recyclerview);

        categoryList = new ArrayList<>();
        pc = new ArrayList<>();
        desktop = new ArrayList<>();
        mouse = new ArrayList<>();
        keyboard = new ArrayList<>();
        monitor = new ArrayList<>();

        fillAdapter();

        categoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        HardwareCategoryAdapter adapter = new HardwareCategoryAdapter(categoryList, this);
        categoryRecyclerView.setAdapter(adapter);
        categoryRecyclerView.addItemDecoration(
                new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
    }



    @Override
    public void onContainerClick(Category category) {
        Intent intent = new Intent(getApplicationContext(), HardwareActivity.class);
        intent.putParcelableArrayListExtra(CAT, category.getHardwares());
        startActivity(intent);
    }

            private void fillAdapter(){

                pc.add(new Hardware( "pc-1", R.drawable.pc1, getResources().getString(R.string.pc1)));
                pc.add(new Hardware( "pc-2", R.drawable.pc2, getResources().getString(R.string.pc2)));
                pc.add(new Hardware( "pc-3", R.drawable.pc3, getResources().getString(R.string.pc3)));
                pc.add(new Hardware( "pc-4", R.drawable.pc4, getResources().getString(R.string.pc4)));
                pc.add(new Hardware( "pc-5", R.drawable.pc5, getResources().getString(R.string.pc5)));

                desktop.add(new Hardware("desktop-1", R.drawable.desktop1, getResources().getString(R.string.desktop1)));
                desktop.add(new Hardware("desktop-2", R.drawable.desktop2, getResources().getString(R.string.desktop2)));
                desktop.add(new Hardware("desktop-3", R.drawable.desktop3, getResources().getString(R.string.desktop3)));
                desktop.add(new Hardware("desktop-4", R.drawable.desktop4, getResources().getString(R.string.desktop4)));
                desktop.add(new Hardware("desktop-5", R.drawable.desktop5, getResources().getString(R.string.desktop5)));

                mouse.add(new Hardware("mouse-1", R.drawable.mouse1, getResources().getString(R.string.mouse1)));
                mouse.add(new Hardware("mouse-2", R.drawable.mouse2, getResources().getString(R.string.mouse2)));
                mouse.add(new Hardware("mouse-3", R.drawable.mouse3, getResources().getString(R.string.mouse3)));
                mouse.add(new Hardware("mouse-4", R.drawable.mouse4, getResources().getString(R.string.mouse4)));
                mouse.add(new Hardware("mouse-5", R.drawable.mouse5, getResources().getString(R.string.mouse5)));

                monitor.add(new Hardware("monitor-1", R.drawable.monitor1, getResources().getString(R.string.monitor1)));
                monitor.add(new Hardware("monitor-2", R.drawable.monitor2, getResources().getString(R.string.monitor2)));
                monitor.add(new Hardware("monitor-3", R.drawable.monitor3, getResources().getString(R.string.monitor3)));
                monitor.add(new Hardware("monitor-4", R.drawable.monitor4, getResources().getString(R.string.monitor4)));
                monitor.add(new Hardware("monitor-5", R.drawable.monitor5, getResources().getString(R.string.monitor5)));

                keyboard.add(new Hardware("keyboard-1", R.drawable.key1, getResources().getString(R.string.key1)));
                keyboard.add(new Hardware("keyboard-2", R.drawable.key2, getResources().getString(R.string.key2)));
                keyboard.add(new Hardware("keyboard-3", R.drawable.key3, getResources().getString(R.string.key3)));
                keyboard.add(new Hardware("keyboard-4", R.drawable.key4, getResources().getString(R.string.key4)));
                keyboard.add(new Hardware("keyboard-5", R.drawable.key5, getResources().getString(R.string.key5)));



                categoryList.add(new Category(R.drawable.pc, pc, "PC"));
                categoryList.add(new Category(R.drawable.desktop, desktop, "DESKTOP"));
                categoryList.add(new Category(R.drawable.mouse, mouse, "MOUSE"));
                categoryList.add(new Category(R.drawable.monitor, monitor, "MONITOR"));
                categoryList.add(new Category(R.drawable.key, keyboard, "KEYBOARD"));
            }
}
