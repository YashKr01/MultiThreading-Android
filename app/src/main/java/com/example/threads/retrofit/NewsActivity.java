package com.example.threads.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.threads.R;
import com.example.threads.retrofit.model.Article;
import com.example.threads.retrofit.model.News;
import com.example.threads.retrofit.network.ApiInterface;
import com.example.threads.retrofit.network.RetrofitInstance;
import com.example.threads.retrofit.news.NewsAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsActivity extends AppCompatActivity {

    NewsAdapter newsAdapter;
    RecyclerView recyclerView;
    List<Article> articleList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);

        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));


        ApiInterface apiInterface = RetrofitInstance.getRetrofitInstance().create(ApiInterface.class);

        Call<News> call = apiInterface.getTopHeadlines("us", "9fb8214bfe174c1c85baf56e2da9a062");
        call.enqueue(new Callback<News>() {
            @Override
            public void onResponse(Call<News> call, Response<News> response) {
                if (response != null && response.body().getArticleList() != null) {
                    articleList.clear();
                    articleList = response.body().getArticleList();
                    newsAdapter = new NewsAdapter(getApplicationContext(), articleList);
                    recyclerView.setAdapter(newsAdapter);
                }
            }

            @Override
            public void onFailure(Call<News> call, Throwable t) {

            }
        });


    }
}