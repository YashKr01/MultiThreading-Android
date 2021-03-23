package com.example.threads.handler;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Process;

public class HandlerThreadClass extends HandlerThread {

    Handler handler;

    public HandlerThreadClass() {
        super("HandlerThread", Process.THREAD_PRIORITY_BACKGROUND);
    }

    @Override
    protected void onLooperPrepared() {
        super.onLooperPrepared();
        handler = new Handler();
    }

    public Handler getHandler() {
        return handler;
    }
}
