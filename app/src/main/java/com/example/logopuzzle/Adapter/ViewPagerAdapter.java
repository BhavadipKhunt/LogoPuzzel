package com.example.logopuzzle.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.logopuzzle.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ViewPagerAdapter  extends RecyclerView.Adapter<ViewPagerAdapter.UserHolder> {
    Context context;
    ArrayList<String> image;
    String level;
    Button ans_button[];
    int position;
    ArrayList<Character> ansarr=new ArrayList<>();
    ArrayList<Integer> remove =new ArrayList();
    static StringBuffer ans=new StringBuffer();
    String str[];
    char ch[];
    int t=0;
    ViewPager2 viewPager;
    private int cnt=1;
    private int counter=1;
    private int counter1=1;

    public ViewPagerAdapter(Context context, ArrayList<String> image, String level, ViewPager2 viewPager, int position) {
        this.context=context;
        this.image=image;
        this.level=level;
        this.viewPager=viewPager;
        this.position=position;
        //viewPager.setCurrentItem(position,false);
    }
    @NonNull
    @Override
    public ViewPagerAdapter.UserHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.view_pager_item, parent, false);
        UserHolder userHolder=new UserHolder(view);
        System.out.println("posi=="+position);
        if (counter==1) {
            t = 0;
            userHolder.linearLayout.removeAllViews();
            ans.delete(0,t);
            inflateItem(userHolder, position);
        }
            System.out.println("onCreateViewHolder called="+(counter++));

        return userHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewPagerAdapter.UserHolder holder, int position)
    {
        System.out.println("onBindViewHolder called="+(counter1++));
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                t=0;
                ans.delete(0,t);
                holder.linearLayout.removeAllViews();
                inflateItem(holder,position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });



    }
    @Override
    public int getItemCount() {
        return image.size();
    }
    public class UserHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        LinearLayout linearLayout;
        Button hint,clear,delet;
        TextView[] btn=new TextView[14];
        public UserHolder(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.play_image_view);
            linearLayout=itemView.findViewById(R.id.liner_layout);
            hint=itemView.findViewById(R.id.hint_button);
            clear=itemView.findViewById(R.id.cancle_button);
            delet=itemView.findViewById(R.id.clear_all_button);
            for (int i=0;i<btn.length;i++)
            {
                int id = context.getResources().getIdentifier("btn" + i, "id", context.getPackageName());
                btn[i] = itemView.findViewById(id);
            }
        }
    }
    private void inflateItem(UserHolder holder, int position) {
        System.out.println("Fun calls=> "+(cnt++)+"\t Position of Page="+position);
        InputStream stream=null;
        try {

            if (level.equals("Level 1")) {
                stream=context.getAssets().open("level 1UN/"+image.get(position));
            }
            if (level.equals("Level 2")) {
                stream=context.getAssets().open("level 2UN/"+image.get(position));
            }
            if (level.equals("Level 3")) {
                stream=context.getAssets().open("level 3UN/"+image.get(position));
            }
            if (level.equals("Level 4")) {
                stream=context.getAssets().open("level 4UN/"+image.get(position));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("co"+context.getApplicationContext());
        Drawable drawable= Drawable.createFromStream(stream,null);
        holder.imageView.setImageDrawable(drawable);

        str = image.get(position).split("\\.");
        ch = str[0].toCharArray();
        String finalans=str[0];
        Log.d("SSS", "Image Loaded=: "+str[0]);
        for (int i=0;i<ch.length;i++)
        {
            ansarr.add(ch[i]);
        }
        for (int i=ch.length;i<holder.btn.length;i++)
        {
            char c= (char) (new Random().nextInt(122-97)+97);
            ansarr.add(c);
        }
        Collections.shuffle(ansarr);
        Collections.shuffle(ansarr);
        for (int i=0;i<holder.btn.length;i++)
        {
            holder.btn[i].setText(""+ansarr.get(i));
            //System.out.println("c"+ansarr.get(i));

        }

        int finalpos=position;
        ans_button = new Button[str[0].length()];
        for (int i = 0; i < ch.length; i++) {
            ans_button[i] = new Button(context.getApplicationContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            layoutParams.setMargins(5, 5, 5, 5);
            ans_button[i].setLayoutParams(layoutParams);
            ans_button[i].setBackgroundColor(context.getResources().getColor(R.color.purple_200));
            holder.linearLayout.addView(ans_button[i]);
            ansarr.clear();
        }

        for (int i = 0; i < holder.btn.length; i++) {
            holder.btn[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for (int i = 0; i < holder.btn.length; i++) {
                        if (view.getId() == holder.btn[i].getId()) {
                            if (t < ch.length) {
                                ans_button[t].setText("" + holder.btn[i].getText());
                                remove.add(i);
                                ans.append(holder.btn[i].getText());
                                t++;
                                holder.btn[i].setVisibility(View.INVISIBLE);
                                CheckWin(ans);
                            }
                        }
                    }
                }

                private void CheckWin(StringBuffer ans) {
                    if (finalans.equalsIgnoreCase(String.valueOf(ans)))
                    {

                        ans.delete(0,finalans.length());

                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle("Good");
                        builder.setPositiveButton("Next", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                holder.linearLayout.removeAllViews();
                                viewPager.setCurrentItem(finalpos+1);
                            }
                        });
                        builder.show();
                    }
                    else
                    {
                        viewPager.setCurrentItem(finalpos);

                    }
                }
            });

        }
        holder.delet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                for (int i=0;i<finalans.length();i++)
                {
                    holder.btn[remove.get(i)].setVisibility(View.VISIBLE);
                    if (ans_button[i].getText()!="") {
                        holder.btn[remove.get(i)].setText(ans_button[i].getText());
                        ans_button[i].setText("");

                    }
                }
                viewPager.setCurrentItem(finalpos);
                remove.clear();
            }
        });

    }
}
