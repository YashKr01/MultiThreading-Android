package com.example.threads.handler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.view.View;

import com.example.threads.R;

public class HandlerThreadActivity extends AppCompatActivity {

    HandlerThread handlerThread = new HandlerThread("HandlerThread");
    Handler threadHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler_thread);

        handlerThread.start();
        threadHandler = new Handler(handlerThread.getLooper());

    }

    public void doWork(View view) {
        threadHandler.post(new ExampleRunnable());
    }

    public void removeMessages(View view) {

    }

    static class ExampleRunnable implements Runnable {
        @Override
        public void run() {

            for (int i = 0; i < 5; i++) {
                Log.d("TAG", "run: "+i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handlerThread.quit();
    }
}