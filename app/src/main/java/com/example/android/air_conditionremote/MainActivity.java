package com.example.android.air_conditionremote;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView degrees = (TextView) findViewById(R.id.degrees);

        //Reduce Button functionality when pressed
        Button reduceButton = (Button) findViewById(R.id.reduce_button);
        reduceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int d = Integer.parseInt(degrees.getText().toString());
                if(d>0) {
                    d--;
                    degrees.setText(Integer.toString(d));
                }
            }
        });

        //Increment Button functionality when pressed
        Button incrementButton = (Button) findViewById(R.id.increment_button);
        incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int d = Integer.parseInt(degrees.getText().toString());
                if(d<30) {
                    d++;
                    degrees.setText(Integer.toString(d));
                }
            }
        });

        //on/off button functionality when pressed
        final Button onOffButton = (Button) findViewById(R.id.onoff_button);
        onOffButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onOffButton.getText().toString().equals("on"))
                    onOffButton.setText("off");
                else if(onOffButton.getText().toString().equals("off"))
                    onOffButton.setText("on");
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
            case R.id.action_help:
                Intent he = new Intent(getApplicationContext(), HelpActivity.class);
                startActivity(he);
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}
