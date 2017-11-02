package ru.vandud.quiz;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ScoreActivity extends AppCompatActivity {

    TextView name;
    TextView score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        name = (TextView) findViewById(R.id.name);
        score = (TextView) findViewById(R.id.score);

        Intent intent = getIntent();

        name.setText(intent.getStringExtra("name"));
        score.setText(intent.getStringExtra("val"));
    }
}
