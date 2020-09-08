package com.example.n_backtraining;

import android.view.View;

public class WorkExit {
    MainActivity mainActivity;
    WorkExit(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }
    void end(){
        /* 변수/객체 셋팅 */
        varsControl();
        /* 위젯 표기 셋팅 */
        widgetControl();
        /* TimeEngine 해제 */
        if (mainActivity.timeEngine == null) {
            mainActivity.timeEngine = new TimeEngine(mainActivity);
        }
        killTimer();
    }
    void widgetControl(){
        mainActivity.button_start.setVisibility(View.VISIBLE);
        mainActivity.button_end.setVisibility(View.INVISIBLE);
        mainActivity.displayed_number.setText("Waiting..");
        mainActivity.displayed_count.setText("");
        mainActivity.displayed_debug.setText("");
        mainActivity.displayed_past.setText("");
    }
    void varsControl() {
        mainActivity.main_queue = null;
        mainActivity.acc_num = null;
        mainActivity.last_pick = 0;
        mainActivity.button_start.setVisibility(View.VISIBLE);
    }
    void killTimer() {
        if (mainActivity.timeEngine !=null && mainActivity.timeEngine.timer != null) {
            mainActivity.timeEngine.timer.cancel();
            mainActivity.timeEngine.timer.purge();
            mainActivity.timeEngine.timer = null;
        }
        mainActivity.timeEngine = null;
    }
}