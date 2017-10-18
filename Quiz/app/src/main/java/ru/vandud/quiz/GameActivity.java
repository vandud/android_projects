package ru.vandud.quiz;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    ProgressBar progressBar;

    String nameOfGamer;
    int counter;
    int rightAns;
    int counterRightAns;
    Random random = new Random();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        textView = (TextView) findViewById(R.id.textView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        nameOfGamer = getIntent().getStringExtra("name");
        counter = 0;

        generateQA();



    }

    public void generateQA() {
        rightAns = random.nextInt(4) + 1;

        textView.setText("Правильный ответ под номером " + Integer.toString(rightAns));

        button1.setText("Ответ 1");
        button2.setText("Ответ 2");
        button3.setText("Ответ 3");
        button4.setText("Ответ 4");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                checkAnswer(1);
                break;
            case R.id.button2:
                checkAnswer(2);
                break;
            case R.id.button3:
                checkAnswer(3);
                break;
            case R.id.button4:
                checkAnswer(4);
                break;
            default:
                break;
        }
    }

    public void checkAnswer(int clickedButton) {
        counter++;
        if (clickedButton == rightAns) {
            counterRightAns++;
            generateQA();
        } else {
            generateQA();
        }
    }

}
