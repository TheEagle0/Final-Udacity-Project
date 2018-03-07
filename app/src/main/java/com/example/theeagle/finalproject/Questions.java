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
import android.widget.Toast;


public class Questions extends AppCompatActivity implements View.OnClickListener,
        RadioGroup.OnCheckedChangeListener {

    private TextView name_tv;
    private EditText q1_editText;
    private RadioGroup q3RadioGroup, q4RadioGroup, q5RadioGroup, q6RadioGroup, q7RadioGroup;
    private CheckBox q2CheckBox1, q2CheckBox2, q2CheckBox3, q2CheckBox4, q2CheckBox5, q2CheckBox6;
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
        String welcome = String.format(getResources().getString(R.string.hi), userName);
        name_tv.setText(welcome);
    }

    private void initViews() {
        name_tv = findViewById(R.id.name_tv);
        q1_editText = findViewById(R.id.question1);
        q2CheckBox1 = findViewById(R.id.q2_checkBox_1);
        q2CheckBox2 = findViewById(R.id.q2_checkBox_2);
        q2CheckBox3 = findViewById(R.id.q2_checkBox_3);
        q2CheckBox4 = findViewById(R.id.q2_checkBox_4);
        q2CheckBox5 = findViewById(R.id.q2_checkBox_5);
        q2CheckBox6 = findViewById(R.id.q2_checkBox_6);
        q3RadioGroup = findViewById(R.id.q3_radioGroup);
        q4RadioGroup = findViewById(R.id.q4_radioGroup);
        q5RadioGroup = findViewById(R.id.q5_radioGroup);
        q6RadioGroup = findViewById(R.id.q6_radioGroup);
        q7RadioGroup = findViewById(R.id.q7_radioGroup);
        submit = findViewById(R.id.submit);
        listeners();
    }

    private void listeners() {
        submit.setOnClickListener(this);
        q3RadioGroup.setOnCheckedChangeListener(this);
        q4RadioGroup.setOnCheckedChangeListener(this);
        q5RadioGroup.setOnCheckedChangeListener(this);
        q6RadioGroup.setOnCheckedChangeListener(this);
        q7RadioGroup.setOnCheckedChangeListener(this);

    }

    @Override
    public void onClick(View v) {

        getNumberOfPieces();
        startActivity(new Intent(this, ScoreSheet.class)
                .putExtra("right answers", rightAnswers)
                .putExtra("wrong answer", wrongAnswers)
                .putExtra("name", userName));
        finish();
        Toast.makeText(this, getResources()
                        .getString(R.string.the_score, rightAnswers, wrongAnswers),
                Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        if (group == q3RadioGroup) {
            if (checkedId == R.id.q3_radioButton1) {
                rightAnswers++;
            } else {
                wrongAnswers++;
            }
        }
        if (group == q4RadioGroup) {
            if (checkedId == R.id.q4_radioButton2) {
                rightAnswers++;

            } else {
                wrongAnswers++;
            }
        }
        if (group == q5RadioGroup) {
            if (checkedId == R.id.q5_radiobutton1) {
                rightAnswers++;

            } else {
                wrongAnswers++;
            }
        }
        if (group == q6RadioGroup) {
            if (checkedId == R.id.q6_radiobutton3) {
                rightAnswers++;

            } else {
                wrongAnswers++;
            }
        }
        if (group == q7RadioGroup) {
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
        if (q2CheckBox1.isChecked() && q2CheckBox2.isChecked() && q2CheckBox3.isChecked()
                && q2CheckBox4.isChecked()) {
            if (q2CheckBox5.isChecked() || q2CheckBox6.isChecked()) {
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
