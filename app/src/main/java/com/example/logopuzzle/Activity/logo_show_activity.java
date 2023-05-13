package com.example.logopuzzle.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.logopuzzle.R;
import com.example.logopuzzle.Adapter.gride_adapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class logo_show_activity extends AppCompatActivity {
    String level;
    ArrayList<String> imagearr=new ArrayList();
    RecyclerView gridView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_show);
        gridView=findViewById(R.id.gride_view_logo);
        level=getIntent().getStringExtra("level");
        String image[];
        try {
            if (level.equals("Level 1"))
            {
                image=getAssets().list("level 1UN");
                imagearr=new ArrayList<String>(Arrays.asList(image));
                System.out.println(""+imagearr);
            }
            if (level.equals("Level 2"))
            {
                image=getAssets().list("level 2UN");
                imagearr=new ArrayList<String>(Arrays.asList(image));
            }
            if (level.equals("Level 3"))
            {
                image=getAssets().list("level 3UN");
                imagearr=new ArrayList<String>(Arrays.asList(image));
            }
            if (level.equals("Level 4"))
            {
                image=getAssets().list("level 4UN");
                imagearr=new ArrayList<String>(Arrays.asList(image));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        gride_adapter adapter=new gride_adapter(this,level,imagearr);
        LinearLayoutManager layoutManager= new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(this,2);
        gridView.setLayoutManager(gridLayoutManager);

        gridView.setAdapter(adapter);
    }
}