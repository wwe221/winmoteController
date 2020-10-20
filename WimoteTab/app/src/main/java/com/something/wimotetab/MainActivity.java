package com.something.wimotetab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;
import com.something.wimotetab.ui.main.MainFragment;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ClThread cl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        ViewPager vp = findViewById(R.id.viewpager);
        PageAdapter adapter = new PageAdapter(getSupportFragmentManager());
        vp.setAdapter(adapter);

        TabLayout tab = findViewById(R.id.tab);
        tab.setupWithViewPager(vp);
        cl = new ClThread();
        cl.start();
        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.baseline_home_black_18dp);
        images.add(R.drawable.baseline_build_circle_black_18dp);
        for(int i=0;i<images.size();i++)tab.getTabAt(i).setIcon(images.get(i));


    }
    public ClThread getCl(){
        return cl;
    }
    public void btclick(View v){
        try {
            cl.sendMsg("1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void btclick2(View v){
        try {
            cl.sendMsg("2");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void btclick3(View v){
        try {
            cl.sendMsg("3");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void btclick4(View v){
        try {
            cl.sendMsg("4");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void btclick5(View v){
        try {
            cl.sendMsg("5");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void btclick6(View v){
        try {
            cl.sendMsg("6");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void btclick7(View v){
        try {
            cl.sendMsg("7");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void btclick8(View v){
        try {
            cl.sendMsg("8");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void leftBtn(View v){
        try {
            cl.sendMsg("9");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void upBtn(View v){
        try {
            cl.sendMsg("10");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void rightBtn(View v){
        try {
            cl.sendMsg("11");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void downBtn(View v){
        try {
            cl.sendMsg("12");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void enterBtn(View v){
        try {
            cl.sendMsg("13");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void powerBtn(View v){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sleep");
        builder.setMessage("Computer gonna Sleep");
        builder.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Sleep.",Toast.LENGTH_LONG).show();
                        try {
                            cl.sendMsg("99");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
        builder.setNegativeButton("Cancle",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"Cancled.",Toast.LENGTH_LONG).show();
                    }
                });
        builder.show();

    }

}
