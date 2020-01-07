package com.example.android.air_conditionremote;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
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
                int hour1Int = Integer.parseInt(hour1.toString());
                int hour2Int = Integer.parseInt(hour2.toString());
                int halfhourInt = Integer.parseInt(halfhour.toString());


                if(hour2Int!=0){
                    hour2Int--;
                    hour2.setText(Integer.toString(hour2Int));
                }else if(hour1Int!=0) {
                    if (halfhourInt == 3) {
                        halfhourInt -= 3;
                        halfhour.setText(Integer.toString(halfhourInt));
                    } else if (halfhourInt == 0){
                        hour1Int--;
                        hour1.setText(Integer.toString(hour1Int));
                        halfhourInt+=3;
                        halfhour.setText(Integer.toString(halfhourInt));
                    }
                }else if(hour1Int==0){
                    if(halfhourInt==3){
                        halfhourInt-=3;
                        halfhour.setText(Integer.toString(halfhourInt));
                    }
                }//endif


            }
        });


        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int hour1Int = Integer.parseInt(hour1.toString());
                int hour2Int = Integer.parseInt(hour2.toString());
                int halfhourInt = Integer.parseInt(halfhour.toString());


                if(hour2Int!=0){
                    hour2Int++;
                    hour2.setText(Integer.toString(hour2Int));
                }else if(hour1Int!=0) {
                    if (halfhourInt == 3) {
                        hour1Int++;
                        hour1.setText(Integer.toString(hour1Int));
                        halfhourInt -= 3;
                        halfhour.setText(Integer.toString(halfhourInt));
                    } else if (halfhourInt == 0){
                        halfhourInt+=3;
                        halfhour.setText(Integer.toString(halfhourInt));
                    }
                }else if(hour1Int==0){
                    if(halfhourInt==3){
                        halfhourInt-=3;
                        halfhour.setText(Integer.toString(halfhourInt));
                        hour1Int++;
                        hour1.setText(Integer.toString(hour1Int));
                    }else if(halfhourInt==0){
                        halfhourInt+=3;
                        halfhour.setText(Integer.toString(halfhourInt));
                    }
                }//endif


            }
        });


    }
}
