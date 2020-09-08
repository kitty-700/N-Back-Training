package com.example.n_backtraining;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Queue;

import static android.graphics.Color.BLUE;
import static android.graphics.Color.RED;

public class MainActivity extends AppCompatActivity {
    final MainActivity mainActivity = this;
    final int N = 2;
    /* Vars 선언 */
    Queue<Integer> main_queue;
    ArrayList<Integer> acc_num; //accumulated number
    TimeEngine timeEngine;
    WorkEnter workEnter;
    WorkExit workExit;
    int how_time_goes_on;
    int last_pick;
    /* Widget 선언 */
    Button button_O;
    Button button_X;
    Button button_start;
    Button button_end;
    TextView displayed_number;
    TextView displayed_debug;
    TextView displayed_count;
    TextView displayed_past;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        varsControl();
        initWidget();
        initListner();
    }

    void varsControl() {
        workEnter = new WorkEnter(mainActivity);
        workExit = new WorkExit(mainActivity);

    }

    void initWidget() {
        button_O = (Button) findViewById(R.id.O_btn);
        button_X = (Button) findViewById(R.id.X_btn);
        button_start = (Button) findViewById(R.id.training_start_btn);
        button_end = (Button) findViewById(R.id.training_end_btn);
        displayed_number = (TextView) findViewById(R.id.displayed_number);
        displayed_debug = (TextView) findViewById(R.id.displayed_debug);
        displayed_count = (TextView) findViewById(R.id.displayed_count);
        displayed_past = (TextView) findViewById(R.id.displayed_past);
    }

    void initListner() {
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                workEnter.start();
            }
        });
        button_end.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                workExit.end();
            }
        });
        button_O.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (how_time_goes_on - 1 < N)
                    whenWaiting();
                else {
                    if (acc_num.get(how_time_goes_on - 1) == last_pick)
                        whenCorrect();
                    else
                        whenIncorrect();
                }
            }
        });
        button_X.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (how_time_goes_on - 1 < N)
                    whenWaiting();
                else {
                    if (acc_num.get(how_time_goes_on - 1) != last_pick)
                        whenCorrect();
                    else
                        whenIncorrect();
                }
            }
        });
    }
    void whenWaiting() {
        displayed_debug.setText("not yet");
        //Toast.makeText(mainActivity, "아직...", Toast.LENGTH_SHORT);
    }

    void whenCorrect(){
        displayed_debug.setText("Good");
        displayed_debug.setTextColor(RED);
        //Toast.makeText(mainActivity, "Good", Toast.LENGTH_SHORT);

    }
    void whenIncorrect(){
        displayed_debug.setText("Bad");
        displayed_debug.setTextColor(BLUE);
        //Toast.makeText(mainActivity, "Bad", Toast.LENGTH_SHORT);

    }
}