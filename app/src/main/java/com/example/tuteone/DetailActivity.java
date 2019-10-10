package com.example.tuteone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public TextView text;
    public TextView headline1;
    public ImageView articleImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        text = findViewById(R.id.textArticle);
        headline1 = findViewById(R.id.headline);
        articleImage = findViewById(R.id.articlePhoto);

        Intent intent = getIntent();
        int articleId = intent.getIntExtra("articleID",1);

        //Get the article where its ID = 1
        Article article1 =  FakeDatabase.getArticleById(articleId);


        //Once grabbed, use get methods to grab all the details needed and display
        headline1.setText(article1.getHeadline());
        text.setText(article1.getContent());
        articleImage.setImageResource(article1.getImageDrawableId());
        //articleImage.setImageResource(article1.getImageDrawableId());


        // Article article1 =
//        text.
//




    }
}
