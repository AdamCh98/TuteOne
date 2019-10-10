package com.example.tuteone;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ArticleAdapter extends RecyclerView.Adapter <ArticleAdapter.ArticleViewHolder> {

public ArrayList<Article> articles;

    public static class ArticleViewHolder extends RecyclerView.ViewHolder {

        public View view;
        public TextView headline;
        public TextView content;
        public Button shareButton;
        public ImageView photo;



        public ArticleViewHolder (View v) {
            super(v);
            view = v;
            headline = v.findViewById(R.id.textViewTitle);
            content = v.findViewById(R.id.textViewContent);
            photo = v.findViewById(R.id.newsPhoto);
            shareButton = v.findViewById(R.id.shareButton);


            //add stuff inside
        }
    }

    public ArticleAdapter(ArrayList<Article> articleList) {
        articles = articleList;

    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.article, parent, false);

        ArticleViewHolder articleViewHolder = new ArticleViewHolder(view);
        return articleViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ArticleViewHolder holder, final int position) {

      //Need to create a Article object that references an object in an Array List.
        Article currentArticle = articles.get(position);

        holder.headline.setText(currentArticle.getHeadline());
        holder.content.setText(currentArticle.getContent());
        holder.photo.setImageResource(currentArticle.getImageDrawableId());

        //view itself;
        holder.view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View views) {

                holder.headline.getContext().startActivity(new Intent(holder.headline.getContext(), DetailActivity.class));
                Intent startIntent = new Intent(holder.headline.getContext(), DetailActivity.class);
                startIntent.putExtra("articleID", (position + 1));
                holder.headline.getContext().startActivity(startIntent);
            }


        });


        //Share button

        holder.shareButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View views) {
                //Create the implicit intent
                Intent shareIntent = new Intent(Intent.ACTION_SEND);
                shareIntent.setType("text/plain");
                holder.headline.getContext().startActivity(shareIntent);
            }
        });




    }

    @Override
    public int getItemCount() {
        return articles.size();
    }
}
