package com.example.logopuzzle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Character> alphabets = new ArrayList();
    Button play,leaderboard,growth,trophy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=findViewById(R.id.play_button);
        leaderboard=findViewById(R.id.rank_button);
        growth=findViewById(R.id.growth_button);
        trophy=findViewById(R.id.trophy_button);

        play.setOnClickListener(this);
        leaderboard.setOnClickListener(this);
        growth.setOnClickListener(this);
        trophy.setOnClickListener(this);
//        String str="hello.png";
//        String strArr[]=str.split("\\.");
//        System.out.println("str="+strArr[0]);
//        char ansArr[]=strArr[0].toCharArray();
//        for (int i=0;i<ansArr.length;i++)
//        {
//            System.out.println("ch="+ansArr[i]);
//            alphabets.add(ansArr[i]);
//        }
//        for(int i=ansArr.length;i<14;i++) {
//            char ch = (char) (new Random().nextInt(122 - 'a') + 97);
//            System.out.println("Alpha=" + ch);
//            alphabets.add(ch);
//        }
//        System.out.println("Before="+alphabets);
//        Collections.shuffle(alphabets);
//        System.out.println("After="+alphabets);

    }

    @Override
    public void onClick(View view) {
        if (view.getId()==play.getId())
        {
            Intent intent = new Intent(MainActivity.this,level_show_activity.class);
            startActivity(intent);
        }
        if (view.getId()==leaderboard.getId())
        {

        }
        if (view.getId()==growth.getId())
        {

        }
        if (view.getId()==trophy.getId())
        {

        }
    }
}