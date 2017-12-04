package ru.vandud.meaningofname;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button button;
    EditText field;
    TextView[] list;
    LinearLayout layout;
    String[] array = {
            "Анормальный",
            "Биквадратный",
            "Выигрышный",
            "Горелый",
            "Дубовый",
            "Ежовый",
            "Живой",
            "Зеленый",
            "Искристый",
            "...",
            "Красивый",
            "Ломкий",
            "Мягкий",
            "Некрасивый",
            "Озябший",
            "Прекрасный",
            "Робкий",
            "Семейный",
            "Трепетный",
            "Умный",
            "Фамильный",
            "Хвастливый",
            "Цифровой",
            "Чмошник",
            "Широкий",
            "Щекотливый",
            "...",
            "...",
            "...",
            "Элегантный",
            "Юркий",
            "Яркий",
            "Ёмкий",
            "-"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        field = (EditText) findViewById(R.id.field);
        layout = (LinearLayout) findViewById(R.id.scrollView);

    }

    public String mainFunction(char letter) {
//        Random random = new Random();
//        Scanner file = null;

//        int randomNum = random.nextInt(5) + 1;
        int lineNum = 0;
        String returnSt = "";

//        try {
//            file = new Scanner(new File("meaningList.txt"));
//        } catch (IOException e) {
//            Toast.makeText(getApplicationContext(), "Error, file not founded", Toast.LENGTH_SHORT).show();
//        }

        if (1040 <= letter && letter <= 1071) {
            lineNum = ((int) letter - 1039) - 1; // * 5 + randomNum;
        } else if (letter == 1025) {
            lineNum = ((int) letter - 1024 + 32) - 1; // * 5 + randomNum;
        } else if (letter == 45) {
            lineNum = array.length - 1;
        } else {
            Toast.makeText(getApplicationContext(), "Uncorrected symbol", Toast.LENGTH_SHORT).show();
        }

        returnSt = array[lineNum];

//        for (int i = 0; i < lineNum; i++) {
//            try {
//                returnSt = file.nextLine();
//            } catch (NullPointerException e) {
//                Toast.makeText(getApplicationContext(), "NPE", Toast.LENGTH_SHORT).show();
//            }
//        }

        return letter + " " + "-" + " " + returnSt;
    }

    @Override
    public void onClick(View v) {

        layout.removeAllViews();



        String name = field.getText().toString().toUpperCase();
        if (name.contains(" ")) {
            name = name.substring(0, name.indexOf(" ")) + name.substring(name.indexOf(" ") + 1, name.length());
        }



        list = new TextView[name.length()];

        for (int i = 0; i < name.length(); i++) {
            list[i] = new TextView(this);
            list[i].setText(mainFunction(name.charAt(i)));
            list[i].setPadding(100,0,0,0);
            list[i].setTextSize(20);
            layout.addView(list[i]);
        }
    }
}
