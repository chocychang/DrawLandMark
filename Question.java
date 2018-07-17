package com.edu.ncu.drawlandmark;

import java.util.Random;

public class Question {

    String id;
    String question;
    String correct_answer;
    String wrong_answer_1;
    String wrong_answer_2;
    String wrong_answer_3;
    String wrong_answer_4;
    String solve;
    String category;


    public String getQuestion() {
        return this.question;
    }


    public String getAnswer() {
        return this.correct_answer;
    }


    public String getSolve() { return this.solve; }

    public String getId() { return this.id; }

    public String getWrong_answer_1() { return this.wrong_answer_1; }
    public String getWrong_answer_2() { return this.wrong_answer_2; }
    public String getWrong_answer_3() { return this.wrong_answer_3; }
    public String getWrong_answer_4() { return this.wrong_answer_4; }

    public String getCategory(){ return this.category; }
    public String getCorrect_answer(){ return this.correct_answer; }

/*
    private static Random random = new Random();
    private static void shuffleArray(String[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int index = Question.random.nextInt(i + 1);

            String a = arr[index];
            arr[index] = arr[i];
            arr[i] = a;
        }
    }  */

    public Question(){


    }

    public Question(String id, String question, String correct_answer, String wrong_answer_1, String wrong_answer_2,
                    String wrong_answer_3, String wrong_answer_4, String solve, String category) {
        this.id = id;
        this.question = question;
        this.correct_answer = correct_answer;
        this.wrong_answer_1 = wrong_answer_1;
        this.wrong_answer_2 = wrong_answer_2;
        this.wrong_answer_3 = wrong_answer_3;
        this.wrong_answer_4 = wrong_answer_4;
        this.solve = solve;
        this.category = category;
    }

    public Question(String question, String correct_answer, String wrong_answer_1, String wrong_answer_2,
                    String wrong_answer_3, String solve) {
        this.category = category;
        this.question = question;
        this.correct_answer = correct_answer;
        this.solve = solve;

        this. wrong_answer_1 = wrong_answer_1;
        this.wrong_answer_2 = wrong_answer_2;
        this.wrong_answer_3 = wrong_answer_3;




        //Question.shuffleArray( this.answers );
    }

    public Question(String question, String correct_answer, String wrong_answer_1, String wrong_answer_2,
                    String wrong_answer_3) {
        this.question = question;
        this.correct_answer = correct_answer;

        this. wrong_answer_1 = wrong_answer_1;
        this.wrong_answer_2 = wrong_answer_2;
        this.wrong_answer_3 = wrong_answer_3;


    }


}
