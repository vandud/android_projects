package ru.vandud.quiz;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.Random;

public class GameActivity extends Activity implements View.OnClickListener {

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
    Random random;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Intent intent = getIntent();

        nameOfGamer = intent.getStringExtra("name");

        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        textView = (TextView) findViewById(R.id.textView);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.incrementProgressBy(1);
        progressBar.setMax(10);
        progressBar.setProgress(0);
        random = new Random();
        counter = 0;
        rightAns = 0;
        counterRightAns = 0;

        generateQA();

    }

    public void generateQA() {
        if (counter < 10) {
            rightAns = random.nextInt(4) + 1;
            textView.setText(Integer.toString(rightAns));
            button1.setText("1");
            button2.setText("2");
            button3.setText("3");
            button4.setText("4");
        } else {
            scoreActivityStart();
        }
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
                System.out.println(">>>error check id clicked button!!!");
                break;
        }
    }

    public void scoreActivityStart() {
        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra("val", Integer.toString(counterRightAns));
        intent.putExtra("name", nameOfGamer);
        this.finish();
        startActivity(intent);
    }

    public void checkAnswer(int clickedButton) {
        counter++;
        progressBar.setProgress(counter);
        if (clickedButton == rightAns) {
            counterRightAns++;
            generateQA();
        } else {
            generateQA();
        }
    }
}
