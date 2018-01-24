package com.example.theeagle.finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;


public class Questions extends AppCompatActivity implements View.OnClickListener,
        RadioGroup.OnCheckedChangeListener {

    private TextView name_tv;
    private EditText q1_editText;
    private RadioGroup q3_radioGroup, q4_radioGroup, q5_radioGroup, q6_radioGroup, q7_radioGroup;
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6;
    private Button submit;
    private int rightAnswers;
    private int wrongAnswers;
    private String userName;
    private String numberOfPieces;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qustions);
        initViews();
        getUserName();
    }


    private void getUserName() {
        Intent intent = getIntent();
        userName = intent.getStringExtra("name");
        String welcome = getResources().getString(R.string.hi) + userName;
        name_tv.setText(welcome);
    }

    private void initViews() {
        name_tv = findViewById(R.id.name_tv);
        q1_editText = findViewById(R.id.question1);
        checkBox1 = findViewById(R.id.q2_checkBox_1);
        checkBox2 = findViewById(R.id.q2_checkBox_2);
        checkBox3 = findViewById(R.id.q2_checkBox_3);
        checkBox4 = findViewById(R.id.q2_checkBox_4);
        checkBox5 = findViewById(R.id.q2_checkBox_5);
        checkBox6 = findViewById(R.id.q2_checkBox_6);
        q3_radioGroup = findViewById(R.id.q3_radioGroup);
        q4_radioGroup = findViewById(R.id.q4_radioGroup);
        q5_radioGroup = findViewById(R.id.q5_radioGroup);
        q6_radioGroup = findViewById(R.id.q6_radioGroup);
        q7_radioGroup = findViewById(R.id.q7_radioGroup);
        submit = findViewById(R.id.submit);
        listeners();
    }

    private void listeners() {
        submit.setOnClickListener(this);
        q3_radioGroup.setOnCheckedChangeListener(this);
        q4_radioGroup.setOnCheckedChangeListener(this);
        q5_radioGroup.setOnCheckedChangeListener(this);
        q6_radioGroup.setOnCheckedChangeListener(this);
        q7_radioGroup.setOnCheckedChangeListener(this);

    }

    @Override
    public void onClick(View v) {
        getNumberOfPieces();
        startActivity(new Intent(this, ScoreSheet.class)
                .putExtra("right answers", rightAnswers)
                .putExtra("wrong answer", wrongAnswers)
                .putExtra("name", userName));
        finish();

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (group == q3_radioGroup) {
            if (checkedId == R.id.q3_radioButton1) {
                rightAnswers++;
            } else {
                wrongAnswers++;
            }
        }
        if (group == q4_radioGroup) {
            if (checkedId == R.id.q4_radioButton2) {
                rightAnswers++;

            } else {
                wrongAnswers++;
            }
        }
        if (group == q5_radioGroup) {
            if (checkedId == R.id.q5_radiobutton1) {
                rightAnswers++;

            } else {
                wrongAnswers++;
            }
        }
        if (group == q6_radioGroup) {
            if (checkedId == R.id.q6_radiobutton3) {
                rightAnswers++;

            } else {
                wrongAnswers++;
            }
        }
        if (group == q7_radioGroup) {
            if (checkedId == R.id.q7_radioButton1) {
                rightAnswers++;

            } else {
                wrongAnswers++;

            }
        }
    }

    private void getNumberOfPieces() {

        numberOfPieces = q1_editText.getText().toString().trim();
        q1Answer();
    }

    private void q2Answer() {
        if (checkBox1.isChecked() && checkBox2.isChecked() && checkBox3.isChecked()
                && checkBox4.isChecked()) {
            if (checkBox5.isChecked() || checkBox6.isChecked()) {
                wrongAnswers++;
            } else rightAnswers++;

        } else {
            wrongAnswers++;
        }
    }

    private void q1Answer() {
        if (numberOfPieces.equals(Answers.numberOfPieces)) {
            rightAnswers++;
        } else {
            wrongAnswers++;
        }
        q2Answer();
    }
}
