package com.example.a02reaganjones.myapplication;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.Image;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements SensorEventListener {


    public static final int FADE_DURATION = 1500;
    public static final int SATART_OFFSET = 1000;
    public static final int VIRATE_TIME = 250;
    public static final int THRESHOLD = 240;
    public static final int SHAKE_COUNT = 2;
    private static Random RANDOM = new Random();
    private Vibrator vibrator;
    private SensorManager sensorManger;
    private Sensor sensor;
    private float lastx, lasty, lastz;
    private int shakeCount = 0;
    private TextView msgTv;
    private ImageView ball;
    private Animation ballAnimation;
    private ArrayList<String> answers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ball = (ImageView) findViewById(R.id.ball);
        msgTv = (TextView) findViewById(R.id.msgTv);

        vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        sensorManger = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManger.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //ballAnimation = AnimationUtils.loadAnimation(this, R.anim.shake);
        //answers = loadAnswers();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    //Creates the array of strings and makes a random one appear on the screen when the method is called
    public void phraseArray(View view) {
        String[] phrases = {"That's your\n prerogative", "You guys, I\n have no idea", "Ask again \n if you will", "Google is your\n greatest resource", "Yes, take\n some initiative", "My boss would kill me\n if you did that",
                "YES MY BROTHA", "Check Schoology", "No, next time read\n the directions", "I made a youtube video\n for this question", "Lets talk\n about that", "If you'll just hold your\n questions for a bit", "STOP PLAYING SNAKE",
                "Well is the bathroom\n pass on the hook?"};
        TextView phraseView = findViewById(R.id.prediction);
        double pick = Math.random();
        pick = pick * 14;
        int pickIndex = (int) pick;
        phraseView.setText(phrases[pickIndex]);
    }

}
