package com.example.android.footballquizv3;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.android.footballquizv3.databinding.ActivityMainBinding;


public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verifyAnswers();
            }
        });

    }

    private void verifyAnswers(){

        int checkedIdForOne=binding.questionOne.oneOptions.getCheckedRadioButtonId();
        int calculateOneScore=calculateScore(checkedIdForOne,R.id.one_d);

        int checkedIdForTwo=binding.questionTwo.twoOptions.getCheckedRadioButtonId();
        int calculateTwoScore=calculateScore(checkedIdForTwo,R.id.two_a);

        int checkedIdForThree=binding.questionThree.threeOptions.getCheckedRadioButtonId();
        int calculateThreeScore=calculateScore(checkedIdForThree,R.id.three_b);

        int checkedIdForFour=binding.questionFour.fourOptions.getCheckedRadioButtonId();
        int calculateFourScore=calculateScore(checkedIdForFour,R.id.four_a);

        int checkedIdForFive=binding.questionFive.fiveOptions.getCheckedRadioButtonId();
        int calculateFiveScore=calculateScore(checkedIdForFive,R.id.five_b);

        int checkedIdForSix=binding.questionSix.sixOptions.getCheckedRadioButtonId();
        int calculateSixScore=calculateScore(checkedIdForSix,R.id.six_a);

        int checkedIdForSeven=binding.questionSeven.sevenOptions.getCheckedRadioButtonId();
        int calculateSevenScore=calculateScore(checkedIdForSeven,R.id.seven_d);

        int checkedIdForEight=binding.questionEight.eightOptions.getCheckedRadioButtonId();
        int calculateEightScore=calculateScore(checkedIdForEight,R.id.eight_d);

        int checkedIdForNine=binding.questionNine.nineOptions.getCheckedRadioButtonId();
        int calculateNineScore=calculateScore(checkedIdForNine,R.id.nine_c);

        int checkedIdForTen=binding.questionTen.tenOptions.getCheckedRadioButtonId();
        int calculateTenScore=calculateScore(checkedIdForTen,R.id.ten_a);

        int checkedIdForEleven=binding.questionEleven.elevenOptions.getCheckedRadioButtonId();
        int calculateElevenScore=calculateScore(checkedIdForEleven,R.id.eleven_b);

        int checkedIdForTwelve=binding.questionTwelve.twelveOptions.getCheckedRadioButtonId();
        int calculateTwelveScore=calculateScore(checkedIdForTwelve,R.id.twelve_b);

        int checkedIdForThirteen=binding.questionThirteen.thirteenOptions.getCheckedRadioButtonId();
        int calculateThirteenScore=calculateScore(checkedIdForThirteen,R.id.thirteen_b);

        int checkedIdForFourteen=binding.questionFourteen.fourteenOptions.getCheckedRadioButtonId();
        int calculateFourteenScore=calculateScore(checkedIdForFourteen,R.id.fourteen_d);

        int checkedIdForFifteen=binding.questionFifteen.fifteenOptions.getCheckedRadioButtonId();
        int calculateFifteenScore=calculateScore(checkedIdForFifteen,R.id.fifteen_a);

        int checkedIdForSixteen=binding.questionSixteen.sixteenOptions.getCheckedRadioButtonId();
        int calculateSixteenScore=calculateScore(checkedIdForSixteen,R.id.sixteen_a);

        int checkedIdForSeventeen=binding.questionSeventeen.seventeenOptions.getCheckedRadioButtonId();
        int calculateSeventeenScore=calculateScore(checkedIdForSeventeen,R.id.seventeen_b);


        if(calculateOneScore==-1 || calculateTwoScore==-1 || calculateThreeScore==-1 || calculateFourScore==-1 || calculateFiveScore==-1 || calculateSixScore==-1 || calculateSevenScore==-1 || calculateEightScore==-1 || calculateNineScore==-1 || calculateTenScore==-1 || calculateElevenScore==-1 || calculateTwelveScore==-1 || calculateThirteenScore==-1 || calculateFourteenScore==-1 || calculateFifteenScore==-1 || calculateSixteenScore==-1 || calculateSeventeenScore==-1 )
            Toast.makeText(getApplicationContext(),"Attempt all questions!",Toast.LENGTH_SHORT).show();

        else{
            int totalScore=calculateOneScore+calculateTwoScore+calculateThreeScore+calculateFourScore+calculateFiveScore+calculateSixScore+calculateSevenScore+calculateEightScore+calculateNineScore+calculateTenScore+calculateElevenScore+calculateTwelveScore+calculateThirteenScore+calculateFourteenScore+calculateFifteenScore+calculateSixteenScore+calculateSeventeenScore;
          /*  Toast.makeText(getApplicationContext(),""+calculateOneScore,Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(),""+calculateTwoScore,Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(),""+calculateThreeScore,Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(),""+calculateFourScore,Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(),""+calculateFiveScore,Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(),""+calculateSixScore,Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(),""+calculateSevenScore,Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(),""+calculateEightScore,Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(),""+calculateNineScore,Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(),""+calculateTenScore,Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(),""+calculateElevenScore,Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(),""+calculateTwelveScore,Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(),""+calculateThirteenScore,Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(),""+calculateFourteenScore,Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(),""+calculateFifteenScore,Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(),""+calculateSixteenScore,Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(),""+calculateSeventeenScore,Toast.LENGTH_SHORT).show();
           */
            Toast.makeText(getApplicationContext(),"Your Score is:"+(totalScore*10),Toast.LENGTH_SHORT).show();
        }

    }

    private int calculateScore(int checked,int correct){
        int score=1;
        if(checked==correct)
            return score;

        else
            return 0;
    }
}
