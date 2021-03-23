package com.example.threads.handler;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

public class ThreadClass extends Thread {

    Handler handler;
    Looper looper;

    @Override
    public void run() {
        super.run();
        Looper.prepare();
        looper = Looper.myLooper();

        handler = new HandlerClass();

        Looper.loop();

    }

}
