package ru.vandud.xylophone;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    Button button7;
    SoundPool soundPool;
    AssetManager assets;
    int[] soundIDList;
    int countLoadedSound;
    Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.button1);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);
        soundPool = new SoundPool(7, AudioManager.STREAM_MUSIC, 0);
        assets = getAssets();
        soundIDList = new int[7];
        mContext = this;

        for(int i = 0; i < 7; i++) {
            soundIDList[i] = loadSound("note" + Integer.toString(i + 1) + ".wav");
        }
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                Log.d("MY", "Complete load sampleID = " + sampleId + " status = " + status);
                if (status == 0) countLoadedSound++;
                if (countLoadedSound == 7) Toast.makeText(mContext, "All files sucessfully loaded", Toast.LENGTH_SHORT).show();
            }
        });
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.button1:
                        playSound(soundIDList[0]);
                        break;
                    case R.id.button2:
                        playSound(soundIDList[1]);
                        break;
                    case R.id.button3:
                        playSound(soundIDList[2]);
                        break;
                    case R.id.button4:
                        playSound(soundIDList[3]);
                        break;
                    case R.id.button5:
                        playSound(soundIDList[4]);
                        break;
                    case R.id.button6:
                        playSound(soundIDList[5]);
                        break;
                    case R.id.button7:
                        playSound(soundIDList[6]);
                        break;
                    default:
                        break;
                }
            }
        };
        button1.setOnClickListener(onClickListener);
        button2.setOnClickListener(onClickListener);
        button3.setOnClickListener(onClickListener);
        button4.setOnClickListener(onClickListener);
        button5.setOnClickListener(onClickListener);
        button6.setOnClickListener(onClickListener);
        button7.setOnClickListener(onClickListener);
    }
    private int loadSound(String name) {
        AssetFileDescriptor afd = null;
        try {
            afd = assets.openFd(name);
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(this, "Couldn't load file '" + name + "'", Toast.LENGTH_SHORT).show();
            return -1;
        }
        return soundPool.load(afd, 1);
    }
    protected void playSound(int sound) {
        if (sound > 0) soundPool.play(sound, 1, 1, 1, 0, 1);
    }
}
