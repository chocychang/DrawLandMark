package com.edu.ncu.drawlandmark;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class GuessDialogActivity extends AppCompatActivity {

    private TextView tv_image;
    private TextView tv_text;

    public  boolean guess_status;


    public GuessDialogActivity(){

    }

    public GuessDialogActivity(boolean ststus){
        this.guess_status = ststus;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessdialog);

        this.tv_image = (TextView) this.findViewById(R.id.image_dia);
        this.tv_text = (TextView) this.findViewById(R.id.text_dia);


    }


    @Override
    public void onStart(){
        super.onStart();


        //this.guess_status=guess_status;
        //修正
        if(guess_status) {
            tv_image.setText("X");
            tv_image.setTextColor(getResources().getColor(R.color.lightPink));
            tv_text.setText("答錯了！");
            tv_text.setTextColor(getResources().getColor(R.color.lightPink));
        } else {
            tv_image.setText("O");
            tv_image.setTextColor(getResources().getColor(R.color.lightGreen));
            tv_text.setText("答對了！");
            tv_text.setTextColor(getResources().getColor(R.color.lightGreen));

        }


    }


    public boolean setCorrectStatus(){
        guess_status = FALSE;
        return guess_status;
    }

    public boolean setWrongStatus(){
        guess_status = TRUE;
        return guess_status;
    }
}
