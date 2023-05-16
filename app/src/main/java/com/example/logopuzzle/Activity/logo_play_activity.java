package com.example.logopuzzle.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

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

public class logo_play_activity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    ArrayList<String> image;
    String level;
    Button hint,cancel,clear,back;
    TextView[] btn=new TextView[14];
    LinearLayout layout;
    Toolbar toolbar;
    TextView textView;
    ViewPager viewPager;
    int position;
   ArrayList<Character>ansarr=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_play);
        position=getIntent().getIntExtra("position",0);
        image=getIntent().getStringArrayListExtra("image");
        imageView=findViewById(R.id.play_image_view);
        level=getIntent().getStringExtra("level");
        layout=findViewById(R.id.liner_layout);
        toolbar=findViewById(R.id.tool_bar);
        textView=findViewById(R.id.tool_text);
        back=findViewById(R.id.back_button);
        viewPager=findViewById(R.id.viewPager);

        ViewPagerAdapter pagerAdapter=new ViewPagerAdapter(logo_play_activity.this,image,level);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setCurrentItem(position);
        //inflateItem(position);

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
//        for (int i=0;i<btn.length;i++)
//        {
//            int id = getResources().getIdentifier("btn"+i,"id",getPackageName());
//            btn[i]=findViewById(id);
//            btn[i].setOnClickListener(this);
//        }
//        hint=findViewById(R.id.hint_button);
//        clear=findViewById(R.id.clear_all_button);
//        cancel=findViewById(R.id.cancle_button);
//        cancel.setOnClickListener(this);
//        clear.setOnClickListener(this);
//
//        hint.setOnClickListener(this);



    }

    private void inflateItem(int position)
    {

        String str[]=image.get(position).split("\\.");
        char ch[]=str[0].toCharArray();
        for (int i=0;i<ch.length;i++)
        {
            ansarr.add(ch[i]);

        }
        for (int i=ch.length;i<btn.length;i++)
        {
            char c= (char) (new Random().nextInt(122-97)+97);
            System.out.println("c="+c);
            ansarr.add(c);
        }
        System.out.println("before="+ansarr);
        Collections.shuffle(ansarr);
        System.out.println("after="+ansarr);
        Collections.shuffle(ansarr);
        System.out.println("after="+ansarr);
        for (int i=0;i<btn.length;i++)
        {
            btn[i].setText(""+ansarr.get(i).toString());
            System.out.println(""+ansarr.get(i));

        }
    }

    @Override
    public void onClick(View view) {
        for (int i=0;i<btn.length;i++)
        {
            if (view.getId()==btn[i].getId())
            {

            }
        }
    }
}