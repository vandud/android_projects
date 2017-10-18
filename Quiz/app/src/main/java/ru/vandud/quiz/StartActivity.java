package ru.vandud.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {
    EditText nameField;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        nameField = (EditText) findViewById(R.id.nameField);
        button = (Button) findViewById(R.id.startButton);
    }

    @Override
    public void onClick(View v) {
        if (!nameField.getText().toString().equals("")) {
            Intent intent = new Intent(StartActivity.this, GameActivity.class);
            intent.putExtra("name", nameField.getText().toString());
            startActivity(intent);
        }
    }
}
