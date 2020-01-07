package com.example.android.air_conditionremote;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class SleepActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sleep);

        //Get the "Back Arrow" on Action Bar to show
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        final Button sleepButton = findViewById(R.id.sleep_button);
        sleepButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sleepButton.getText().toString().equals("Turn on"))
                    sleepButton.setText("Turn off");
                else if(sleepButton.getText().toString().equals("Turn off"))
                    sleepButton.setText("Turn on");
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
