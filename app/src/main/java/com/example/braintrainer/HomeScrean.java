package com.example.braintrainer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



import java.util.ArrayList;
import java.util.Random;

public class HomeScrean extends AppCompatActivity {
Button button0,button1,button2,button3,tryAgainButton;
TextView timerTextView,scoreTextView,functionTextView ,resultTextView;
    private static final String TAG = "HomeScrean";
    int correctLocation;
    int score=0;
    int timeri1=30100;
    int Timeri2=1000;
int numberOfQuestion=0;

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finishActivityFromChild(HomeScrean.this,1);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(timeri1!=0){
        if ((keyCode == KeyEvent.KEYCODE_BACK))
        {
            return false; //I have tried here true also
        }
        return super.onKeyDown(keyCode, event);
    }
    else {
        return true;
        }
    }

    @SuppressLint("SetTextI18n")
public void newQuestion()
{

    tryAgainButton.setVisibility(View.INVISIBLE);
    resultTextView.setVisibility(View.VISIBLE);
    ArrayList<Integer>answer=new ArrayList<>();
    Random random=new Random();
    int a =random.nextInt(21);
    int b=random.nextInt(21);
    functionTextView.setText(a+"+"+b);
    correctLocation=random.nextInt(4);
    answer.clear();
    for (int i = 0; i < 4; i++)
    {
        if(i==correctLocation)
        {  answer.add(a+b);}

        else {
            int wrongAnswer=random.nextInt(41);
            while (wrongAnswer==a+b)
            {
                wrongAnswer=random.nextInt(41);
            }
            answer.add(wrongAnswer);

        }

//            button0.setText(answer.get(0));
//            button1.setText(answer.get(1));
//            button2.setText(answer.get(2));
//            button3.setText(answer.get(3));



    }
    button0.setText(Integer.toString(answer.get(0)));
    button1.setText(Integer.toString(answer.get(1)));
    button2.setText(Integer.toString(answer.get(2)));
    button3.setText(Integer.toString(answer.get(3)));
}


    @SuppressLint("SetTextI18n")
    public void chooseAnswer(View view) {

        if( Integer.toString(correctLocation).equals(view.getTag().toString()))
        {
            resultTextView.setText("Correct");
            score++;
            Log.i(TAG, "chooseAnswer:  Correct");}
        else
        {
            resultTextView.setText("Wrong Answer");
            Log.i(TAG, "chooseAnswer:  Wrong Answer");
        }
        numberOfQuestion++;
        scoreTextView.setText(score+"/"+numberOfQuestion);
        newQuestion();
}

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screan);
        functionTextView=findViewById(R.id.textView_function);
        scoreTextView=findViewById(R.id.textView_score);
        button0=findViewById(R.id.button0);
        button1=findViewById(R.id.button1);
        button2=findViewById(R.id.button2);
        button3=findViewById(R.id.button3);
        resultTextView=findViewById(R.id.result_textview);
        timerTextView=findViewById(R.id.textView_Timer);
        tryAgainButton=findViewById(R.id.againPlay_button);
        newQuestion();
        timer(timeri1,Timeri2);
        sound();

    }


    public void tryAgain(View view) {
    score=0;
    numberOfQuestion=0;
    resultTextView.setText("correct");
        sound();

        scoreTextView.setText(score+"/"+numberOfQuestion);
        resultTextView.setVisibility(View.INVISIBLE);
        tryAgainButton.setVisibility(View.INVISIBLE);
        timer(timeri1,Timeri2);
        newQuestion();
        button0.setVisibility(View.VISIBLE);
        button1.setVisibility(View.VISIBLE);
        button2.setVisibility(View.VISIBLE);
        button3.setVisibility(View.VISIBLE);

    }

    private void timer(int i, int i1) {
        new CountDownTimer(i, i1) {

            @Override
            public void onTick(long millisUntilFinished) {
                timerTextView.setText( String.valueOf(millisUntilFinished/1000+"S"));

            }


            @Override
            public void onFinish() {
                soundFinish();
                resultTextView.setText("Hey Time Finish ");
                tryAgainButton.setVisibility(View.VISIBLE);
                button0.setVisibility(View.INVISIBLE);
                button1.setVisibility(View.INVISIBLE);
                button2.setVisibility(View.INVISIBLE);
                button3.setVisibility(View.INVISIBLE);



            }
        }.start();


    }

    private void soundFinish() {
        MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.finished);
        mediaPlayer.start();
    }

    public void sound()
    {
        {
            MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.counter);
            mediaPlayer.start();

        }
    }

}