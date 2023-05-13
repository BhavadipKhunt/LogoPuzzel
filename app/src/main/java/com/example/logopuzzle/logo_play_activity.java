package com.example.logopuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class logo_play_activity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView;
    String image,level;
    Button hint,cancel,clear;
    Button[] btn=new Button[14];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo_play);
        image=getIntent().getStringExtra("image");
        imageView=findViewById(R.id.play_image_view);
        level=getIntent().getStringExtra("level");
        for (int i=0;i<btn.length;i++)
        {
            int id = getResources().getIdentifier("btn"+i,"id",getPackageName());
            btn[i]=findViewById(id);
            btn[i].setOnClickListener(this);
        }
        hint=findViewById(R.id.hint_button);
        clear=findViewById(R.id.clear_all_button);
        cancel=findViewById(R.id.cancle_button);
        cancel.setOnClickListener(this);
        clear.setOnClickListener(this);

        hint.setOnClickListener(this);
        InputStream stream=null;
        try {

            if (level.equals("Level 1")) {
                stream=getAssets().open("level 1UN/"+image);
            }
            if (level.equals("Level 2")) {
                stream=getAssets().open("level 2UN/"+image);
            }
            if (level.equals("Level 3")) {
                stream=getAssets().open("level 3UN/"+image);
            }
            if (level.equals("Level 4")) {
                stream=getAssets().open("level 4UN/"+image);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Drawable drawable= Drawable.createFromStream(stream,null);
        imageView.setImageDrawable(drawable);
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