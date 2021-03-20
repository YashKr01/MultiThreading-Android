package com.example.threads.java;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
            Toast.makeText(context, "BOOT", Toast.LENGTH_SHORT).show();
        } else if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {
            Toast.makeText(context, "AIRPLANE MODE", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "CONNECTIVITY CHANGED", Toast.LENGTH_SHORT).show();
        }
    }



}
