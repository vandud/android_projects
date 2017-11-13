package ru.vandud.quiz;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreActivity extends Activity implements View.OnClickListener {

    TextView name;
    TextView score;
    Button restart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        name = (TextView) findViewById(R.id.name);
        score = (TextView) findViewById(R.id.score);
        restart = (Button) findViewById(R.id.restart);

        Intent intent = getIntent();

        name.setText(intent.getStringExtra("name"));
        score.setText(intent.getStringExtra("val"));
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.restart) {
            Intent intent = new Intent(this, GameActivity.class);
            intent.putExtra("name", name.getText().toString());
            this.finish();
            startActivity(intent);
        }
    }
}
