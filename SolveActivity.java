package com.edu.ncu.drawlandmark;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SolveActivity extends Activity implements View.OnClickListener{

    TextView tv_solve;
    Button bt_leave;
    Button bt_nextQuestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_solve);

        tv_solve = (TextView) findViewById(R.id.tv_solve);
        bt_leave = (Button) findViewById(R.id.bt_leave);
        bt_nextQuestion = (Button) findViewById(R.id.bt_nextquestion);

        Intent intent  = getIntent();
        this.tv_solve.setText(intent.getStringExtra("Solving_MSG"));

        bt_leave.setOnClickListener(this);
        bt_nextQuestion.setOnClickListener(this);

    }

    @Override
    public void onClick(View view){
        Button clicked = (Button) view;
        if(clicked == this.bt_leave){
            Intent intent2 = new Intent(SolveActivity.this, PingxiActivity.class);
            startActivity(intent2);
        } else if(clicked == this.bt_nextQuestion){
            this.finish();
        }
    }
}
