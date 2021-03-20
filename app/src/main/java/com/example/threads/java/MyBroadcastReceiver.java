package com.example.threads.java;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

//        if (Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) {
//            Toast.makeText(context, "BOOT", Toast.LENGTH_SHORT).show();
//        } else if (Intent.ACTION_AIRPLANE_MODE_CHANGED.equals(intent.getAction())) {
//            Toast.makeText(context, "AIRPLANE MODE", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(context, "CONNECTIVITY CHANGED", Toast.LENGTH_SHORT).show();
//        }

        if (ConnectivityManager.CONNECTIVITY_ACTION.equals(intent.getAction())) {
            boolean isChange = intent.getBooleanExtra(ConnectivityManager.EXTRA_NO_CONNECTIVITY, false);
            if (!isChange) {
                Toast.makeText(context, "CONNECTED", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(context, "DISCONNECTED", Toast.LENGTH_SHORT).show();
            }
        }



    }


}
