package com.example.logopuzzle.Adapter;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.logopuzzle.Activity.logo_play_activity;
import com.example.logopuzzle.Activity.logo_show_activity;
import com.example.logopuzzle.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class gride_adapter extends RecyclerView.Adapter<gride_adapter.user_holder>{
    com.example.logopuzzle.Activity.logo_show_activity logo_show_activity;
    String level;
    ArrayList<String> imagearr;
    public gride_adapter(logo_show_activity logo_show_activity, String level, ArrayList<String> imagearr) {
        this.logo_show_activity=logo_show_activity;
        this.level=level;
        this.imagearr=imagearr;
    }

    @NonNull
    @Override
    public gride_adapter.user_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        view= LayoutInflater.from(logo_show_activity).inflate(R.layout.gride_iteam,parent,false);
        user_holder userHolder=new user_holder(view);

        return userHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull gride_adapter.user_holder holder, int position) {
        InputStream inputStream=null;
        try {
            if (level.equals("Level 1")) {
                inputStream = logo_show_activity.getAssets().open("level 1UN/" + imagearr.get(position));
            }
            if (level.equals("Level 2")) {
                inputStream = logo_show_activity.getAssets().open("level 2UN/" + imagearr.get(position));
            }
            if (level.equals("Level 3")) {
                inputStream = logo_show_activity.getAssets().open("level 3UN/" + imagearr.get(position));
            }
            if (level.equals("Level 4")) {
                inputStream = logo_show_activity.getAssets().open("level 4UN/" + imagearr.get(position));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Drawable drawable = Drawable.createFromStream(inputStream,null);
        holder.imageView.setImageDrawable(drawable);
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(logo_show_activity, logo_play_activity.class);
                intent.putExtra("position",holder.getAdapterPosition());
                intent.putExtra("image",imagearr);
                intent.putExtra("level",level);
                logo_show_activity.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imagearr.size();
    }

    public class user_holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public user_holder(@NonNull View itemView) {

            super(itemView);
            imageView=itemView.findViewById(R.id.Image_view);
        }
    }
}
