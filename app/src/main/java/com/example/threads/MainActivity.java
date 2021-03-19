package com.example.threads;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void createThread() {

        Thread thread = new Thread(new Runnable() {
            @SuppressLint("HandlerLeak")
            @Override
            public void run() {

                Handler handler = new Handler(getMainLooper()) {
                    @Override
                    public void handleMessage(@NonNull Message msg) {
                        super.handleMessage(msg);



                    }
                };

                Message msg = new Message();
                msg.obj = "Ali send message";
                handler.sendMessage(msg);

            }
        });

        thread.start();

    }

}