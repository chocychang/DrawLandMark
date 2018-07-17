package com.edu.ncu.drawlandmark;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Random;

import static java.lang.Boolean.TRUE;

public class QuePlayActivity extends Activity implements View.OnClickListener {

    private int question_num=0;
    private int correct_num=0;
    private int wrong_num=0;
    private String Id;  //設定題目的id範圍的參數
    private ArrayList<String> questionIds = new ArrayList<>();

    public DatabaseReference fb;

    private TextView tv_question;
    private TextView tv_quiznum;
    private TextView tv_correctnum;
    private TextView tv_wrongnum;
    private Button option_1;
    private Button option_2;
    private Button option_3;
    private Button option_4;

    private static final String TAG = "QuePlayActivity";
    private static Random random = new Random();


    private Queue<Question> questionList = new LinkedList<Question>();
    private Question questioning;

    private GuessDialogActivity guessDialogActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("debug", "PlayActivity.onCreate");
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_play_que);

        //以下為xml檔物件與java做連結
        this.tv_question = (TextView) this.findViewById(R.id.tv_question);
        this.tv_quiznum = (TextView) this.findViewById(R.id.quiznumber);
        this.tv_correctnum = (TextView) this.findViewById(R.id.correct_num);
        this.tv_wrongnum = (TextView) this.findViewById(R.id.wrong_num);
        this.option_1 = (Button) this.findViewById(R.id.btn_option_1);
        this.option_2 = (Button) this.findViewById(R.id.btn_option_2);
        this.option_3 = (Button) this.findViewById(R.id.btn_option_3);
        this.option_4 = (Button) this.findViewById(R.id.btn_option_4);

        this.fb = FirebaseDatabase.getInstance().getReference("questions");



        this.option_1.setOnClickListener(this);
        this.option_2.setOnClickListener(this);
        this.option_3.setOnClickListener(this);
        this.option_4.setOnClickListener(this);
    }

    @Override
    public void onStart(){
        super.onStart();

        this.fb.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
             //   String text =dataSnapshot.getValue(String.class);
                for (DataSnapshot childSnapshot: dataSnapshot.getChildren()) {

                    questionIds.add(childSnapshot.getKey());
                    Question questiontest = childSnapshot.getValue(Question.class);
                    questionList.offer(questiontest);

                    Log.d(TAG,"媽的" + questionList.size());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        questionList.poll();
        questioning = questionList.poll();
        tv_question.setText(questioning.getQuestion());
        option_1.setText( questioning.getCorrect_answer() );
        option_2.setText( questioning.getWrong_answer_1() );
        option_3.setText( questioning.getWrong_answer_2() );
        option_4.setText( questioning.getWrong_answer_3() );

        //setQuestionIndex();

       //setQuestion();
     }

    private void setQuestionIndex(){
       // int questionIndex = random.nextInt(4)+1;
       // this.setQuestion(this.questionList.get(0));
        question_num++;
    }

    private void setQuestion() {
        Question question = this.questionList.poll();
        this.questioning = question;
        // Add value event listener to the post
        // [START post_value_event_listener]
        //this.questioning = question;

        tv_quiznum.setText(getString(R.string.str_quiznumber, question_num));
        tv_question.setText( this.questioning.getQuestion());
         option_1.setText( this.questioning.getCorrect_answer() );
         option_2.setText( this.questioning.getWrong_answer_1() );
         option_3.setText( this.questioning.getWrong_answer_2() );
         option_4.setText( this.questioning.getWrong_answer_3() );

        //String[] answers = active_question.getAnswers();


    }



    @Override
    public void onClick(View view) {
        Button clicked = (Button) view;
        if (clicked.getText().toString() == this.questioning.getAnswer()) {
            if (this.questionList.size() > 0 && question_num>5) {
                correct_num += 1;
                setQuestionIndex();
                this.tv_correctnum.setText(getString(R.string.str_correctnumber, correct_num));
                showGuessDialog();
            } else {
                Toast t = Toast.makeText(this, "You win!", Toast.LENGTH_LONG);
                t.show();
                this.finish();
            }
        } else {
            if (this.questionList.size() > 0) {
                wrong_num += 1;
                this.tv_wrongnum.setText(getString(R.string.str_wrongnumber, wrong_num));
                Toast t = Toast.makeText(this, "You lose!", Toast.LENGTH_LONG);
                t.show();
                setQuestionIndex();
                guessDialogActivity = new GuessDialogActivity(TRUE);
                guessDialogActivity.guess_status=TRUE;
                showGuessDialog();
            } else {
                Toast t = Toast.makeText(this, "You lose!", Toast.LENGTH_LONG);
                t.show();
                this.finish();
            }
        }
    }


    public void showGuessDialog(){
        this.startActivity( new Intent(QuePlayActivity.this, GuessDialogActivity.class));
    }
}

