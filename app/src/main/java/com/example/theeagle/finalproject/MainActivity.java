package com.example.theeagle.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText name;
    private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

    }

    private void initViews() {
        name = findViewById(R.id.name_et);
        next = findViewById(R.id.start);

        listeners();
    }

    private void listeners() {
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        getName();
        }

    private void getName() {
        if (name.getText().length() < 1) {
            name.setError(getString(R.string.enter_name));
        } else {
            String userName = name.getText().toString().trim();
            startActivity(new Intent(this, Questions.class)
                    .putExtra("name", userName));
            finish();
        }
    }
}
