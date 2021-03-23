package com.example.threads.handler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.threads.R;

public class HandlerActivity extends AppCompatActivity {

    private Button start;
    private ThreadClass thread = new ThreadClass();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hanlder);


        start = findViewById(R.id.button6);
        Log.d("TAG", "onCreate: " + Thread.currentThread().getName());


    }

    public void start(View view) {

//        Thread thread = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                Log.d("TAG", "run: " + Thread.currentThread().getName());
//
//                // posting to main thread
//                Handler handler = new Handler(Looper.getMainLooper());
//                handler.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        start.setText("IN PROGRESS");
//                    }
//                });
//            }
//        });
//        thread.start();

        thread.start();

    }

    public void stop(View view) {
        // quit looper
        thread.looper.quit();
    }

    public void task(View view) {

//        // posting mssg on handler
//        thread.handler.post(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 0; i < 5; i++) {
//                    Log.d("TAG", "run: " + i);
//                    try {
//                        Thread.sleep(900);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        });

        Message message = new Message();
        message.obj = "message";
        thread.handler.sendMessage(message);

    }


}