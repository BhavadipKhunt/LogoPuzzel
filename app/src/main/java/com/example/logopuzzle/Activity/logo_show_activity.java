package com.example.logopuzzle.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.logopuzzle.R;
import com.example.logopuzzle.Adapter.gride_adapter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class logo_show_activity extends AppCompatActivity {
    String level;
    ArrayList<String> imagearr=new ArrayList();
    RecyclerView gridView;
    Toolbar toolbar;
    TextView textView;
    Button back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_show);
        gridView=findViewById(R.id.gride_view_logo);
        level=getIntent().getStringExtra("level");
        String image[];
        toolbar=findViewById(R.id.tool_bar);
        textView=findViewById(R.id.tool_text);
        back=findViewById(R.id.back_button);
     setSupportActionBar(toolbar);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(logo_show_activity.this, level_show_activity.class);
                startActivity(intent);
                finish();
            }
        });

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