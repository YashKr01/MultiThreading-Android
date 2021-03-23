package com.example.threads.handler;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

import androidx.annotation.NonNull;

public class HandlerClass extends Handler {

    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);

        Log.d("TAG", "handleMessage: " + msg.obj.toString());

    }
}
