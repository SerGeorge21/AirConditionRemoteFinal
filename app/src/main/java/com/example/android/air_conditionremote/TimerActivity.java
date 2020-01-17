package com.example.android.air_conditionremote;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        //Get the "Back Arrow" on Action Bar to show
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        final TextView hour1 = findViewById(R.id.hour1); //monades wrwn
        final TextView hour2 = findViewById(R.id.hour2); //dekades wrwn
        final TextView halfhour = findViewById(R.id.half_hour);


        Button reduce = findViewById(R.id.reduce_clock);
        Button increment = findViewById(R.id.increment_clock);


        reduce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour1Int = Integer.parseInt(hour1.getText().toString());
                int hour2Int = Integer.parseInt(hour2.getText().toString());
                int halfhourInt = Integer.parseInt(halfhour.getText().toString());


                if(hour2Int > 0){
                    if(hour1Int>0){
                        if(halfhourInt==3){
                            halfhourInt=0;
                            halfhour.setText(Integer.toString(halfhourInt));
                        }else if(halfhourInt==0){
                            hour1Int--;
                            hour1.setText(Integer.toString(hour1Int));
                            halfhourInt=3;
                            halfhour.setText(Integer.toString(halfhourInt));
                        }
                    }else if(hour1Int==0){
                        if(halfhourInt==3){
                            halfhourInt=0;
                            halfhour.setText(Integer.toString(halfhourInt));
                        }else if(halfhourInt==0){
                            hour2Int--;
                            hour2.setText(Integer.toString(hour2Int));
                            hour1Int=9;
                            hour1.setText(Integer.toString(hour1Int));
                            halfhourInt=3;
                            halfhour.setText(Integer.toString(halfhourInt));
                        }
                    }
                }else if(hour2Int==0){
                    if(hour1Int>0){
                        if(halfhourInt==3){
                            halfhourInt=0;
                            halfhour.setText(Integer.toString(halfhourInt));
                        }else if(halfhourInt==0){
                            hour1Int--;
                            hour1.setText(Integer.toString(hour1Int));
                            halfhourInt=3;
                            halfhour.setText(Integer.toString(halfhourInt));
                        }
                    }else if(hour1Int==0){
                        if(halfhourInt==3){
                            halfhourInt=0;
                            halfhour.setText(Integer.toString(halfhourInt));
                        }
                    }

                }//end if

            }
        });


        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour1Int = Integer.parseInt(hour1.getText().toString());
                int hour2Int = Integer.parseInt(hour2.getText().toString());
                int halfhourInt = Integer.parseInt(halfhour.getText().toString());


                if(hour2Int==0){
                    if(hour1Int == 9){
                        if(halfhourInt==3) {
                            halfhourInt=0;
                            halfhour.setText(Integer.toString(halfhourInt));
                            hour1Int = 0;
                            hour1.setText(Integer.toString(hour1Int));
                            hour2Int++;
                            hour2.setText(Integer.toString(hour2Int));
                        }else if(halfhourInt==0){
                            halfhourInt=3;
                            halfhour.setText(Integer.toString(halfhourInt));
                        }
                    }else if(hour1Int<9 && hour1Int>=0){
                        if(halfhourInt==0){
                            halfhourInt =3;
                            halfhour.setText(Integer.toString(halfhourInt));
                        }else if(halfhourInt==3){
                            halfhourInt=0;
                            halfhour.setText(Integer.toString(halfhourInt));
                            hour1Int++;
                            hour1.setText(Integer.toString(hour1Int));
                        }
                    }
                }else if(hour2Int==1){
                    if(hour1Int<2){
                        if(halfhourInt==3){
                            halfhourInt=0;
                            halfhour.setText(Integer.toString(halfhourInt));
                            hour1Int++;
                            hour1.setText(Integer.toString(hour1Int));
                        }else if(halfhourInt==0){
                            halfhourInt=3;
                            halfhour.setText(Integer.toString(halfhourInt));
                        }
                    }

                }//end if


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
