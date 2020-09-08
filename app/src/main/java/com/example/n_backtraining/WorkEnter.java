package com.example.n_backtraining;

import android.view.View;

import java.util.ArrayList;
import java.util.LinkedList;

public class WorkEnter {
    MainActivity mainActivity;
    WorkEnter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }
    void start(){
        /* 변수/객체 셋팅 */
        varsControl();
        /* 위젯 표기 셋팅 */
        widgetControl();
        /* TimeEngine 작동 */
        if (mainActivity.timeEngine == null) {
            mainActivity.timeEngine = new TimeEngine(mainActivity);
        }
    }
    void widgetControl(){
        mainActivity.button_start.setVisibility(View.INVISIBLE);
        mainActivity.button_end.setVisibility(View.VISIBLE);
    }
    void varsControl(){
        mainActivity.how_time_goes_on   = 0;
        mainActivity.main_queue = new LinkedList<Integer>();
        mainActivity.acc_num = new ArrayList<>();    }
}
