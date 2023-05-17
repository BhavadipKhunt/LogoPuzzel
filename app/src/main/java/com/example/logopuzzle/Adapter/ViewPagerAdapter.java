package com.example.logopuzzle.Adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import com.example.logopuzzle.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class ViewPagerAdapter  extends PagerAdapter implements View.OnClickListener {
    Context context;
    ArrayList<String> image;
    String level;
    
     ArrayList<Character> ansarr=new ArrayList<>();
    private TextView[] btn=new TextView[14];
    String str[];
    char ch;

    public ViewPagerAdapter(Context context, ArrayList<String> image, String level) {
        this.context=context;
        this.image=image;
        this.level=level;
    }

    @Override
    public int getCount() {
        return image.size();
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
       // return super.instantiateItem(container, position);
        View view = LayoutInflater.from(context).inflate(R.layout.view_pager_item, container, false);
        ImageView imageView = view.findViewById(R.id.play_image_view);
        LinearLayout linearLayout=view.findViewById(R.id.liner_layout);
        for (int i=0;i<btn.length;i++)
        {
            int id = context.getResources().getIdentifier("btn"+i,"id",context.getPackageName());
            btn[i]=view.findViewById(id);
            btn[i].setOnClickListener(this);
        }
//        hint=findViewById(R.id.hint_button);
//        clear=findViewById(R.id.clear_all_button);
//        cancel=findViewById(R.id.cancle_button);
//        cancel.setOnClickListener(this);
//        clear.setOnClickListener(this);
//
//        hint.setOnClickListener(this);

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
        imageView.setImageDrawable(drawable);



        inflateItem(position,linearLayout);
        container.addView(view);
        return view;
    }

    private void inflateItem(int position, LinearLayout linearLayout)
    {
        String str[] = image.get(position).split("\\.");
        char ch[]=str[0].toCharArray();
        //System.out.println("string="+str[0]);

        for (int i=0;i<ch.length;i++)
        {
            ansarr.add(ch[i]);
          //  System.out.println("chhhhh====="+ch[i]);

        }
        for (int i=ch.length;i<btn.length;i++)
        {
            char c= (char) (new Random().nextInt(122-97)+97);
            //  System.out.println("c="+c);
            ansarr.add(c);
        }
        //  System.out.println("before="+ansarr);
         Collections.shuffle(ansarr);
        // System.out.println("after="+ansarr);
         Collections.shuffle(ansarr);
        //  System.out.println("after="+ansarr);
        for (int i=0;i<btn.length;i++)
        {
            btn[i].setText(""+ansarr.get(i));
              System.out.println("c"+ansarr.get(i));

        }
        ansarr.clear();
        Button ans_button[] = new Button[str[0].length()];

        for (int i = 0; i < str[0].length(); i++) {
            ans_button[i] = new Button(context.getApplicationContext());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT, 1);
            layoutParams.setMargins(5, 5, 5, 5);
            ans_button[i].setLayoutParams(layoutParams);
            ans_button[i].setBackgroundColor(context.getResources().getColor(R.color.purple_200));
            linearLayout.addView(ans_button[i]);
        }
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return (view==object);
    }
    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);

    }

    @Override
    public void onClick(View view) {

    }
}
