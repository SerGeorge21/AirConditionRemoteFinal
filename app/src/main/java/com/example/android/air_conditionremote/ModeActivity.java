package com.example.android.air_conditionremote;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class ModeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mode);

        //Get the "Back Arrow" on Action Bar to show
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        final Button heat = findViewById(R.id.heat_mode);
        final Button cool = findViewById(R.id.cool_mode);
        final Button fan = findViewById(R.id.fan_mode);
        final Button dry = findViewById(R.id.dry_mode);
        final Button auto = findViewById(R.id.auto_mode);

        //HEAT BUTTON
       heat.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                heat.setPressed(true);
                cool.setPressed(false);
                fan.setPressed(false);
                dry.setPressed(false);
                auto.setPressed(false);
                return true;
            }
        });

        //COOL BUTTON
        cool.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                heat.setPressed(false);
                cool.setPressed(true);
                fan.setPressed(false);
                dry.setPressed(false);
                auto.setPressed(false);
                return true;
            }
        });

        //FAN BUTTON
        fan.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                heat.setPressed(false);
                cool.setPressed(false);
                fan.setPressed(true);
                dry.setPressed(false);
                auto.setPressed(false);
                return true;
            }
        });
        //DRY BUTTON
        dry.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                heat.setPressed(false);
                cool.setPressed(false);
                fan.setPressed(false);
                dry.setPressed(true);
                auto.setPressed(false);
                return true;
            }
        });
        //AUTO BUTTON
        auto.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                heat.setPressed(false);
                cool.setPressed(false);
                fan.setPressed(false);
                dry.setPressed(false);
                auto.setPressed(true);
                return true;
            }
        });


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Inflate the menu options from res/menu/menu_modes
        //This adds the menu to the app bar.
        getMenuInflater().inflate(R.menu.menu_modes, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //User clicked on a menu option in the app bar overflow menu
        //(thats when this method gets called)
        switch(item.getItemId()){
            //Response to Mode click
            case R.id.action_mode:
                Intent mo = new Intent(getApplicationContext(), ModeActivity.class);
                startActivity(mo);
                return true;
            //Response to Swing click
            case R.id.action_swing:
                Intent sw = new Intent(getApplicationContext(), SwingActivity.class);
                startActivity(sw);
                return true;
            //Response to Timer click
            case R.id.action_timer:
                Intent ti = new Intent(getApplicationContext(), TimerActivity.class);
                startActivity(ti);
                return true;
            //Response to Sleep click
            case R.id.action_sleep:
                Intent sl = new Intent(getApplicationContext(), SleepActivity.class);
                startActivity(sl);
                return true;
            //Response to Fan Control click
            case R.id.action_fan:
                Intent fa = new Intent(getApplicationContext(), FanActivity.class);
                startActivity(fa);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
