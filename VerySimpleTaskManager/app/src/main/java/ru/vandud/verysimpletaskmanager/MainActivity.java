package ru.vandud.verysimpletaskmanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText textField = (EditText) findViewById(R.id.textField);
    LinearLayout mainLayout = (LinearLayout) findViewById(R.id.mainLayout);


//временная хрень, пока не разобрался как сделать
    ArrayList<String> taskList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addTask(String a) {
//тоже врменно
        taskList.add(a);

    }

    public void syncFrame() {
//здесь тоже исправить
        int len = taskList.size();
        for (int i = 0; i < len; i++) {

        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addTask:
                addTask(textField.getText().toString());
                break;
            default:
                break;
        }
    }
}
