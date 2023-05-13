package com.example.logopuzzle.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.logopuzzle.R;
import com.example.logopuzzle.Adapter.recycler_adapter;

public class level_show_activity extends AppCompatActivity {
    RecyclerView listView;
    String level[]={"Level 1","Level 2","Level 3","Level 4"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_show);
        listView=findViewById(R.id.Level_list_view);
        recycler_adapter adapter=new recycler_adapter(this,level);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        listView.setLayoutManager(layoutManager);
        listView.setAdapter(adapter);
    }
}