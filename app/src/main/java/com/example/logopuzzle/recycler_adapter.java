package com.example.logopuzzle;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class recycler_adapter  extends RecyclerView.Adapter<recycler_adapter.user_holder>{
    level_show_activity level_show_activity;
    String[] level;

    int item_Position;
    public recycler_adapter(level_show_activity level_show_activity, String[] level) {
        this.level_show_activity=level_show_activity;
        this.level=level;
    }

    @NonNull
    @Override
    public recycler_adapter.user_holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(level_show_activity).inflate(R.layout.level_iteam,parent,false);
        user_holder userHolder=new user_holder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        return userHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull recycler_adapter.user_holder holder, int position) {
        holder.textView.setText(""+level[position]);

        System.out.println("======"+position);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent(level_show_activity, logo_show_activity.class);
                intent.putExtra("level",level[holder.getAdapterPosition()]);
                level_show_activity.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return level.length;
    }

    public class user_holder extends RecyclerView.ViewHolder{
        TextView textView,textView1;
        ProgressBar progressBar;
        public user_holder(@NonNull View itemView) {
            super(itemView);
            textView=itemView.findViewById(R.id.level_show_txt);
            textView1=itemView.findViewById(R.id.logo_count_txt);
            progressBar=itemView.findViewById(R.id.progressBar);
        }
    }

}
