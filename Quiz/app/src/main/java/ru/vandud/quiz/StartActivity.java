package ru.vandud.quiz;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartActivity extends Activity implements View.OnClickListener {
    EditText nameField;
    Button button;
    Button addQuestion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        nameField = (EditText) findViewById(R.id.nameField);
        button = (Button) findViewById(R.id.startButton);
        addQuestion = (Button) findViewById(R.id.addQuestion);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addQuestion:
                Intent intentQ = new Intent(this, AddQuestionActivity.class);
                startActivity(intentQ);
                break;
            case R.id.startButton:
                if (!nameField.getText().toString().equals("")) {
                    Intent intent = new Intent(this, GameActivity.class);
                    intent.putExtra("name", nameField.getText().toString());
                    this.finish();
                    startActivity(intent);
                }
                break;
            default:
                break;
        }
    }
}
