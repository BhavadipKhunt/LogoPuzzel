package com.example.logopuzzle.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.example.logopuzzle.Adapter.ViewPagerAdapter;
import com.example.logopuzzle.R;


import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class logo_play_activity extends AppCompatActivity  {

    ArrayList<String> image;
    String level;
    Button back;

    Toolbar toolbar;
    TextView textView;
    ViewPager2 viewPager;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_play);
        position=getIntent().getIntExtra("position",0);
        image=getIntent().getStringArrayListExtra("image");

        level=getIntent().getStringExtra("level");

        toolbar=findViewById(R.id.tool_bar);
        textView=findViewById(R.id.tool_text);
        back=findViewById(R.id.back_button);
        viewPager=findViewById(R.id.viewPager);

        ViewPagerAdapter pagerAdapter=new ViewPagerAdapter(logo_play_activity.this,image,level,viewPager,position);
        //viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(position,false);




        setSupportActionBar(toolbar);


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(logo_play_activity.this, logo_show_activity.class);
                intent.putExtra("level",level);
                startActivity(intent);
                finish();
            }
        });



    }


}