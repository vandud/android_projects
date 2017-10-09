package ru.vandud.android_clicker;

import android.os.Bundle;
import android.app.Activity;

/**
 * Created by Vandud on 10.10.2017.
 */

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MainView(this));
    }
}
