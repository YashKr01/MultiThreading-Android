package com.example.threads.java;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import androidx.annotation.NonNull;

class LooperThread extends Thread {

    public Handler mHandler;

    @SuppressLint("HandlerLeak")
    public void run() {
        Looper.prepare();

        mHandler = new Handler() {
            public void handleMessage(Message msg) {
                // process incoming messages here
                // this will run in non-ui/background thread

            }
        };

        Looper.loop();
    }
}
