package com.example.cby.mytest;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private HandlerThread handlerThread;
    private Button fixed,cached,scheduled,single;
    private Runnable r1,r2,r3,r4,r5,r6,r7;
    private ExecutorService fixedThreadPool,CachedThreadPool,ScheduledYhreadPoll,SingledThreadPool;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fixed = findViewById(R.id.fixed);
        cached = findViewById(R.id.cached);
        scheduled = findViewById(R.id.scheduled);
        single = findViewById(R.id.single);
        fixed.setOnClickListener(this);
        cached.setOnClickListener(this);
        single.setOnClickListener(this);
        scheduled.setOnClickListener(this);
        r1= new MyRunnable();
        r2= new MyRunnable();
        r3= new MyRunnable();
        r4= new MyRunnable();
        r5= new MyRunnable();
        r6= new MyRunnable();
        r7= new MyRunnable();
        fixedThreadPool = Executors.newFixedThreadPool(5);
        CachedThreadPool = Executors.newCachedThreadPool();
        ScheduledYhreadPoll = Executors.newScheduledThreadPool(3);
        SingledThreadPool = Executors.newSingleThreadExecutor();



    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.fixed:
                Log.i("cby","````````````````````````");
                fixedThreadPool.execute(r1);
                fixedThreadPool.execute(r2);
                fixedThreadPool.execute(r3);
                fixedThreadPool.execute(r4);
                fixedThreadPool.execute(r5);
                fixedThreadPool.execute(r6);
                fixedThreadPool.execute(r7);
                break;
            case R.id.cached:
                Log.i("cby","````````````````````````");
                CachedThreadPool.execute(r1);
                CachedThreadPool.execute(r2);
                CachedThreadPool.execute(r3);
                CachedThreadPool.execute(r4);
                CachedThreadPool.execute(r5);
                CachedThreadPool.execute(r6);
                CachedThreadPool.execute(r7);
                break;
            case R.id.scheduled:
                Log.i("cby","````````````````````````");
                ScheduledYhreadPoll.execute(r1);
                ScheduledYhreadPoll.execute(r2);
                ScheduledYhreadPoll.execute(r3);
                ScheduledYhreadPoll.execute(r4);
                ScheduledYhreadPoll.execute(r5);
                ScheduledYhreadPoll.execute(r6);
                ScheduledYhreadPoll.execute(r7);
                break;
            case R.id.single:
                Log.i("cby","````````````````````````");
                SingledThreadPool.execute(r1);
                SingledThreadPool.execute(r2);
                SingledThreadPool.execute(r3);
                SingledThreadPool.execute(r4);
                SingledThreadPool.execute(r5);
                SingledThreadPool.execute(r6);
                SingledThreadPool.execute(r7);
                break;
        }

    }

    public class  MyRunnable implements Runnable{
        @Override
        public void run() {
            Log.i("cby","current:"+Thread.currentThread().getName()
                    +"时间："+new SimpleDateFormat("yyy-MM-dd hh:mm:ss:SSS").format(System.currentTimeMillis()));
        }
    }



}
