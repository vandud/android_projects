package ru.vandud.quiz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddQuestionActivity extends Activity implements View.OnClickListener {

    EditText questionField;
    EditText answerAField;
    EditText answerBField;
    EditText answerCField;
    EditText answerDField;
    Button back;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addquestion);

        questionField = (EditText) findViewById(R.id.questionField);
        answerAField = (EditText) findViewById(R.id.answerAField);
        answerBField = (EditText) findViewById(R.id.answerBField);
        answerCField = (EditText) findViewById(R.id.answerCField);
        answerDField = (EditText) findViewById(R.id.answerDField);
        back = (Button) findViewById(R.id.back);
        add = (Button) findViewById(R.id.add);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back :
                finish();
                break;
            case R.id.add :
                //куда-то сохраняем данные
                break;
            default:
                break;
        }
    }
}