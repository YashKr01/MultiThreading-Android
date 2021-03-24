package com.example.threads.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.Random;

public class BoundService extends Service {

    private static final String TAG = "BoundService";

    IBinder binder = new LocalBinder();
    Random random = new Random();

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, "onBind: Binded");
        return binder;
    }
    
    public class LocalBinder extends Binder{
        BoundService getService(){
            return BoundService.this;
        }
    }
    
    public int getRandom(){
        return random.nextInt();
    }
    
}
