package com.example.threads.retrofit.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.threads.R;
import com.example.threads.retrofit.model.Article;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {

    private Context context;
    private List<Article> articleList;

    public NewsAdapter(Context context, List<Article> articleList) {
        this.context = context;
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.single_news_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Article article = articleList.get(position);
        holder.title.setText(article.getTitle());
        holder.description.setText(article.getDescription());

    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView title, description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.news_title);
            description = itemView.findViewById(R.id.news_desc);
        }


    }


}
