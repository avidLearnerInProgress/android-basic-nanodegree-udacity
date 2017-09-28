package com.example.android.scorekeeper;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final static int TEAM_A = 0;
    private final static int TEAM_B = 1;
    private int whoIsBatting = -1;
    int runs = 0;
    int wickets = 0;
    int balls = 0;
    int maxBalls = -1;
    private TextView runTextA;
    private TextView wicketTextA;
    private TextView runTextB;
    private TextView wicketTextB;

    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findRadioButtonSelected();
        referenceAndSetListeners();

    }


    private void findRadioButtonSelected() {
        final RadioGroup rg1 = (RadioGroup) findViewById(R.id.radioButtonSelect);
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId) {
                    case R.id.radioButton:
                        whoIsBatting = TEAM_A;
                        //Toast.makeText(getApplicationContext(), "IND"+whoIsBatting, Toast.LENGTH_SHORT).show();
                        break;

                    case R.id.radioButton2:
                        whoIsBatting = TEAM_B;
                        //Toast.makeText(getApplicationContext(), "AUS"+whoIsBatting, Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }


    private void getOvers() {
        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);
        int overs = Integer.valueOf((String) mySpinner.getSelectedItem());
        maxBalls = overs * 6;
        //Toast.makeText(getApplicationContext(),""+maxBalls,Toast.LENGTH_SHORT).show();
    }


    private void onRadioButton1Clicked() {
        RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton);
        RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);
        if (rb1.isChecked() == true) {
            rb1.setChecked(false);
            rb2.setChecked(true);
        }


    }

    private void onRadioButton2Clicked() {
        RadioButton rb1 = (RadioButton) findViewById(R.id.radioButton);
        RadioButton rb2 = (RadioButton) findViewById(R.id.radioButton2);
        if (rb2.isChecked() == true) {
            rb2.setChecked(false);
            rb1.setChecked(true);
        }
    }


    private void updateViews() {

        if (whoIsBatting == -1) {
            Toast.makeText(getApplicationContext(), "__ERROR__" + whoIsBatting, Toast.LENGTH_SHORT).show();
        } else if (whoIsBatting == TEAM_A) {
            runTextA = (TextView) findViewById(R.id.indiaRuns);
            runTextA.setText(String.valueOf(runs));
            wicketTextA = (TextView) findViewById(R.id.indiaWickets);
            wicketTextA.setText(Integer.toString(wickets));
        } else {
            runTextB = (TextView) findViewById(R.id.australiaRuns);
            runTextB.setText(String.valueOf(runs));
            wicketTextB = (TextView) findViewById(R.id.australiaWickets);
            wicketTextB.setText(Integer.toString(wickets));
        }

    }

    private void resetViews() {
        runs = balls = wickets = 0;

        runTextA.setText(String.valueOf(runs));
        wicketTextA.setText(Integer.toString(wickets));
        runTextB.setText(String.valueOf(runs));
        wicketTextB.setText(Integer.toString(wickets));

        Spinner mySpinner = (Spinner) findViewById(R.id.spinner);  //reset overs
        mySpinner.setSelection(0);
    }

    private void resetViewA() {
        runs = 0;
        balls = 0;
        wickets = 0;
        runTextA.setText(String.valueOf(runs));
        wicketTextA.setText(Integer.toString(wickets));

    }

    private void resetViewB() {
        runs = 0;
        balls = 0;
        wickets = 0;
        runTextB.setText(String.valueOf(runs));
        wicketTextB.setText(Integer.toString(wickets));

    }

    private void toggleRadioButton() {
        if (whoIsBatting == TEAM_A) {
            whoIsBatting = TEAM_B;
            onRadioButton1Clicked();
            resetViewB();
        } else {
            whoIsBatting = TEAM_A;
            onRadioButton2Clicked();
            resetViewA();
        }
    }


    public void calculateRuns(int number) {
        getOvers();
        if (balls < maxBalls && maxBalls != -1) {
            balls++;
            runs += number;
            updateViews();
        } else {
            int num1 = Integer.valueOf(runTextA.getText().toString());
            int num2 = Integer.valueOf(runTextB.getText().toString());
            if(num1!=0 && num2!=0){
                if(num1>num2)
                    Toast.makeText(getApplicationContext(), "India Win", Toast.LENGTH_SHORT).show();
                else if(num2>num1)
                    Toast.makeText(getApplicationContext(), "Australia Win", Toast.LENGTH_SHORT).show();
                else if(num1==num2)
                    Toast.makeText(getApplicationContext(), "Match Drawn", Toast.LENGTH_SHORT).show();
            }
            else if(num1==0 && num2!=0){
                Toast.makeText(getApplicationContext(), "Overs Completed, change batting side!", Toast.LENGTH_SHORT).show();
                toggleRadioButton();
            }
            else if(num1!=0 && num2==0){
                Toast.makeText(getApplicationContext(), "Overs Completed, change batting side!", Toast.LENGTH_SHORT).show();
                toggleRadioButton();
            }
        }

    }


    public void onClick(View v) {
        if (whoIsBatting != -1) {
            switch (v.getId()) {
                case R.id.button:
                    calculateRuns(6);
                    break;
                case R.id.button2:
                    calculateRuns(4);
                    break;
                case R.id.button3:
                    calculateRuns(3);
                    break;
                case R.id.button4:
                    calculateRuns(2);
                    break;

                case R.id.button5:
                    calculateRuns(1);
                    break;

                case R.id.button111:
                    calculateRuns(0);
                    break;

                case R.id.button7:
                    runs += 0;
                    if (wickets < 10) {
                        wickets += 1;
                        getOvers();
                        if (balls < maxBalls && maxBalls != -1) {
                            balls++;
                            updateViews();
                        } else {
                            Toast.makeText(getApplicationContext(), "Overs Completed, change batting side!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Team all out", Toast.LENGTH_SHORT).show();
                        toggleRadioButton();
                    }
                    break;

                case R.id.button8:
                    resetViews();
                    break;


            }

        }
    }

    private void referenceAndSetListeners() {
        Button plusSix = (Button) findViewById(R.id.button);
        plusSix.setOnClickListener(this);
        Button plusFour = (Button) findViewById(R.id.button2);
        plusFour.setOnClickListener(this);
        Button plusThree = (Button) findViewById(R.id.button3);
        plusThree.setOnClickListener(this);
        Button plusTwo = (Button) findViewById(R.id.button4);
        plusTwo.setOnClickListener(this);
        Button plusOne = (Button) findViewById(R.id.button5);
        plusOne.setOnClickListener(this);
        Button plusDot = (Button) findViewById(R.id.button111);
        plusDot.setOnClickListener(this);
        Button plusOut = (Button) findViewById(R.id.button7);
        plusOut.setOnClickListener(this);
        Button reset = (Button) findViewById(R.id.button8);
        reset.setOnClickListener(this);

        runTextA = (TextView) findViewById(R.id.indiaRuns);
        runTextB = (TextView) findViewById(R.id.australiaRuns);
        wicketTextA = (TextView) findViewById(R.id.indiaWickets);
        wicketTextB = (TextView) findViewById(R.id.australiaWickets);

    }


}
