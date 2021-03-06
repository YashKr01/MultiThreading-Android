package com.example.threads.java;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;

import androidx.annotation.NonNull;

public class HandlerThreadExample extends HandlerThread {

    Handler handler;

    public HandlerThreadExample(String name) {
        super(name);
    }

    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();

        handler = new Handler(getLooper());
        handler.post(new Runnable() {
            @Override
            public void run() {

            }
        });

    }
}
