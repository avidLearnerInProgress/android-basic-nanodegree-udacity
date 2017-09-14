package com.example.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

     int i=0; //Team A
     int j=0; //Team B

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getOverflowMenu();

    }


    public void teamAButton3(View view){
        i+=3;
        displayScoreTeamA(i);
    }
    public void teamAButton2(View view){
        i+=2;
        displayScoreTeamA(i);
    }
    public void teamAFreeThrow(View view){
        i+=1;
        displayScoreTeamA(i);
    }

    private void displayScoreTeamA(int number){
        TextView result=(TextView) findViewById(R.id.scoreTeamA);
        result.setText(""+number);
    }

    public void teamBButton3(View view){
        j+=3;
        displayScoreTeamB(j);
    }
    public void teamBButton2(View view){
        j+=2;
        displayScoreTeamB(j);
    }
    public void teamBFreeThrow(View view){
        j+=1;
        displayScoreTeamB(j);
    }

    private void displayScoreTeamB(int number){
        TextView result=(TextView) findViewById(R.id.scoreTeamB);
        result.setText(""+number);
    }

    public void setReset(View view){
        i=0;
        j=0;
        displayScoreTeamA(i);
        displayScoreTeamB(j);
    }

}
