package com.example.n_backtraining;

import android.os.Handler;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class TimeEngine { //타임엔진이 하는 역할 : 1초가 지날 때마다 하는 어플리케이션이 할 일을 정의해준다.
    Timer timer;
    MainActivity m;
    Handler handler = new Handler();
    final int time_delay = 3000;

    TimeEngine(MainActivity mainActivity) {
        this.m = mainActivity;
        timer = new Timer();
        timer.schedule(new RemindTask(),
                0,        //초기 딜레이
                time_delay);  //RemindTask()가 반복적으로 동작할 지연시간
    }//https://blog.naver.com/PostView.nhn?blogId=highkrs&logNo=220283709171

    class RemindTask extends TimerTask {
        public void run() {
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    /* main_queue에 값을 넣음 */
                    m.last_pick = ((int) (Math.random() * 1000)) % 3;
                    m.main_queue.offer(m.last_pick);
                    /* main_queue의 dequeue 값을 acc_num 에 넣음 (없으면 -1)*/
                    if (m.how_time_goes_on < m.N)
                        m.acc_num.add(-1);
                    else
                        m.acc_num.add(m.main_queue.poll());
                    /* main_queue의 마지막 값을 display */
                    m.displayed_past.setText(
                            m.displayed_past.getText()
                            + " "
                            + m.last_pick);
                    m.displayed_number.setText("" + m.last_pick);
                    /* 시간 흐르기 */
                    m.how_time_goes_on++;
                    /* 현재 시간 표기 */
                    m.displayed_count.setText("" + m.how_time_goes_on);
                    /* 정답 내리기 */
                    m.displayed_debug.setText("");
                    /* 시간 지났음을 Toast  */
                    Toast.makeText(m,
                            "Time On",
                                    Toast.LENGTH_SHORT).show();
                }
            }, 700);
        }
    }
}
