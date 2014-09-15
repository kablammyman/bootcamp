package com.example.student.geoquiz;

/**
 * Created by student on 9/15/2014.
 */
public class TrueFalse {
    private int mQuestion;
    private boolean mTrueQuestion;

    public void setmTrueQuestion(boolean mTrueQuestion) {
        this.mTrueQuestion = mTrueQuestion;
    }

    public boolean ismTrueQuestion() {

        return mTrueQuestion;
    }

    public void setmQuestion(int mQuestion) {

        this.mQuestion = mQuestion;
    }

    public int getmQuestion() {
        return mQuestion;
    }

    public TrueFalse(int question, boolean trueQuestion){
        mQuestion = question;
        mTrueQuestion = trueQuestion;
    }
}
