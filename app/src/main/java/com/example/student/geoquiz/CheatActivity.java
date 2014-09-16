package com.example.student.geoquiz;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.app.Activity;
import android.util.Log;

/*import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.Toast;
*/



/**
 * Created by student on 9/16/2014.
 */
public class CheatActivity extends Activity {
    private static final String TAG = "CheatActivity";
    private static final String KEY_USED_CHEAT = "usedCheat";

    public static final String EXTRA_ANSWER_IS_TRUE = "com.example.student.geoquiz.answer_is_true";
    public static final String EXTRA_ANSWER_SHOWN = "com.example.student.geoquiz.answer_shown";
    private boolean mAnswerIsTrue;

    private TextView mAnswerTextView;
    private Button mShowAnswer;

    private boolean mAnswerShown;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate called");

        setContentView(R.layout.activity_cheat);

        mAnswerIsTrue = getIntent().getBooleanExtra(EXTRA_ANSWER_IS_TRUE,false);

        mAnswerTextView = (TextView)findViewById(R.id.answerTextView);

        //setAnswerShownResult(false);

        mShowAnswer = (Button)findViewById(R.id.showAnswerButton);
        mShowAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mAnswerIsTrue)
                    mAnswerTextView.setText(R.string.true_button);
                else
                    mAnswerTextView.setText(R.string.false_button);
                setAnswerShownResult(true);
            }
        });

        if(savedInstanceState != null) {
            mAnswerShown = savedInstanceState.getBoolean(KEY_USED_CHEAT, false);
            Log.d(TAG,"onCreate called, answre shown = " + mAnswerShown);
            setAnswerShownResult(mAnswerShown);
        }
    }

    private void setAnswerShownResult(boolean isAnswerShown){
        Intent data = new Intent();
        data.putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown);
        mAnswerShown = isAnswerShown;
        setResult(RESULT_OK,data);
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.i(TAG,"onSaveInstanceState called, shown = " + mAnswerShown);
        savedInstanceState.putBoolean(KEY_USED_CHEAT, mAnswerShown);
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"OnResume called");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d(TAG,"OnPause called");
    }
}
