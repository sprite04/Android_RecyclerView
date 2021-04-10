package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerview.adapter.ModuleAdapter;
import com.example.recyclerview.module.Module;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Module> moduleList;
    ModuleAdapter adapter;
    RecyclerView reModule;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addControls();
    }

    private void addControls() {
        //view binding
        reModule=findViewById(R.id.reModule);

        //prepare date
        moduleList=new ArrayList<>();
        moduleList.add(new Module(R.drawable.android,"ListView trong Android","ListView trong android là thành phần dùng để nhóm nhiều mục ...","Android"));
        moduleList.add(new Module(R.drawable.ios,"Xử lý sự kiện trong iOS","Xử lý sự kiện trong iOS sau khi các bạn đã biết thiết kế giao diện cho các ứng dụng .. ","iOS"));

        //adapter
        adapter=new ModuleAdapter(moduleList);
        reModule.setAdapter(adapter);

        //layout manager
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        //linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);
        reModule.setLayoutManager(linearLayoutManager);
    }
}