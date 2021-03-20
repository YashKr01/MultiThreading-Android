package com.example.threads;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    ProgressBar progress;
    ProgressBar progressBar;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textView = findViewById(R.id.textView);
        progress = findViewById(R.id.progress);
        progressBar = findViewById(R.id.progressBar);
        button = findViewById(R.id.button);

        textView.setText("");
        progressBar.setVisibility(View.INVISIBLE);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                uploadTask();

            }
        });


    }

    private void uploadTask() {

        MyAsyncTask asyncTask = new MyAsyncTask();
        asyncTask.execute("PASSED STRING");
        //textView.setText("");

    }

    class MyAsyncTask extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            Log.i("TAG", "onPreExecute : " + Thread.currentThread().getName());
            textView.setText("uploading......");
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(String... strings) {

            Log.i("TAG", "doInBackground : Thread" + Thread.currentThread().getName());
            Log.i("TAG", "doInBackground : string passed :" + strings[0]);

            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(i);
            }

            return "Returned String : Uploaded";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            Log.i("TAG", "onProgressUpdate : " + Thread.currentThread().getName());

            progress.setProgress(values[0] + 1);
            button.setBackgroundColor(getResources().getColor(R.color.teal_200));

        }

        @Override
        protected void onPostExecute(String string) {
            //super.onPostExecute(aVoid);

            Log.i("TAG", "onPostExecute : " + Thread.currentThread().getName());
            textView.setText(string);
            progressBar.setVisibility(View.INVISIBLE);
            button.setBackgroundColor(getResources().getColor(R.color.purple_500));

        }
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