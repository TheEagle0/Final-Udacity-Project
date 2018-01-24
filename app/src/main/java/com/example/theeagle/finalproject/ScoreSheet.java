package com.example.theeagle.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreSheet extends AppCompatActivity implements View.OnClickListener {
    private String userName;
    private int rightAnswers;
    private int wrongAnswers;
    private TextView score_tv, name_tv;
    private Button share_btn, startOver_btn;
    private String finalScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_sheet);
        initViews();
        getIntentData();


    }

    private void getIntentData() {
        Intent intent = getIntent();
        userName = intent.getStringExtra("name");
        rightAnswers = intent.getIntExtra("right answers", 0);
        wrongAnswers = intent.getIntExtra("wrong answer", 0);
        updateUi();
    }

    private void updateUi() {
        String wrong = String.valueOf(wrongAnswers);
        String right = String.valueOf(rightAnswers);
        finalScore = right + getString(R.string.right_questions) + "\n" + wrong + getString(R.string.wrong_questions);
        score_tv.setText(finalScore);
        String thanksMessage = getResources().getString(R.string.thank_you) + userName;
        name_tv.setText(thanksMessage);
    }

    private void initViews() {
        score_tv = findViewById(R.id.score_tv);
        name_tv = findViewById(R.id.thanks_tv);
        share_btn = findViewById(R.id.share);
        startOver_btn = findViewById(R.id.start_over);
        listeners();
    }

    private void listeners() {
        startOver_btn.setOnClickListener(this);
        share_btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.share:
                share();
                break;
            case R.id.start_over:
                startOver();
                break;

        }

    }

    private void share() {
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT, finalScore);
        shareIntent.setType("text/plain");
        startActivity(shareIntent);
    }

    private void startOver() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}

