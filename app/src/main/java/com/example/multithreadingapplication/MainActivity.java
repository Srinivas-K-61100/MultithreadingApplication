package com.example.multithreadingapplication;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.multithreadingapplication.R;

public class MainActivity extends Activity {
    Handler hand=new Handler();
    Button clickme;
    TextView timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer=(TextView)findViewById(R.id.timer);
        clickme=(Button)findViewById(R.id.clickme);
        hand.postDelayed(run,100); }
    Runnable run=new Runnable() {
        @Override
        public void run() {
            updateTime();
        }
    };
    public void updateTime()
    {
        timer.setText("" + (Integer.parseInt(timer.getText().toString()) - 1));
        if (Integer.parseInt(timer.getText().toString()) == 0)
        {
            clickme.setVisibility(View.VISIBLE);
        }
        else
        {
            hand.postDelayed(run, 100);
        }
    }
}