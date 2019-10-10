package com.example.tuteone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;


public class MainActivity extends AppCompatActivity {

public RecyclerView recyclerView;
public ConstraintLayout article11;
public ConstraintLayout article22;

public TextView headline;
public TextView content;
public ImageView newsPhoto;
public Button shareButton1;
public RecyclerView.LayoutManager layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


//
//        article11 = findViewById(R.id.article1);
//        article22 = findViewById(R.id.article2);
//        shareButton1 = findViewById(R.id.shareButton);
//
//
//
//
//        //Set objects
//        Article article1 = FakeDatabase.getArticleById(1);
//        headline = article11.findViewById(R.id.textViewTitle);
//        headline.setText(article1.getHeadline());
//        content = article11.findViewById(R.id.textViewContent);
//        content.setText(article1.getContent());
//        newsPhoto = article11.findViewById(R.id.newsPhoto);
//        newsPhoto.setImageResource(R.drawable.housing);
//
//
//
//        Article article2 = FakeDatabase.getArticleById(2);
//        headline = article22.findViewById(R.id.textViewTitle);
//        headline.setText(article2.getHeadline());
//        content = article22.findViewById(R.id.textViewContent);
//        content.setText(article2.getContent());
//        newsPhoto = article22.findViewById(R.id.newsPhoto);
//        newsPhoto.setImageResource(R.drawable.meeting);
//
//
//
//
//
//        //creating implicit intents
//        article11.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View views) {
//
//                //startActivity(new Intent(MainActivity.this, DetailActivity.class));
//                Intent startIntent = new Intent(getApplicationContext(), DetailActivity.class);
//                startIntent.putExtra("articleID", 1);
//                startActivity(startIntent);
//            }
//
//
//        });
//
//        article22.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View views) {
//
//                //startActivity(new Intent(MainActivity.this, DetailActivity.class));
//                Intent startIntent = new Intent(getApplicationContext(), DetailActivity.class);
//                startIntent.putExtra("articleID", 2);
//                startActivity(startIntent);
//            }
//
//
//        });
//
//
//
//        shareButton1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //Create the implicit intent
//                Intent shareIntent = new Intent(Intent.ACTION_SEND);
//                shareIntent.setType("text/plain");
//                startActivity(shareIntent);
//            }
//        });


        //Week 4:
        //Finding recycler View ID
        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        //Creating layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        //Not sure if correct
        ArticleAdapter articleAdapter = new ArticleAdapter(FakeDatabase.getAllArticles());
        recyclerView.setAdapter(articleAdapter);












    }

    public void displayToast (View v) {
        Toast.makeText(MainActivity.this, "Welcome to the app", Toast.LENGTH_SHORT).show();
    }



}

