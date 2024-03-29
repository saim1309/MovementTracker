package com.example.movementtrackerlab;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    Sensor accelerometer;
    private SensorManager sensorManager;
    TextView xValue,yValue,zValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        xValue =findViewById(R.id.tvXvalue);
        yValue =findViewById(R.id.tvYvalue);
        zValue =findViewById(R.id.tvZvalue);

        //getting permission from sensor permission from sensor manager
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        //setting sensor type as accelerometer
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        //register listener fot the sensor
        sensorManager.registerListener(MainActivity.this,accelerometer,SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        //in SensorEvent arrray, we get the x index at 0 index, y index at 1st and z at 2nd index
        xValue.setText("X Value: "+ sensorEvent.values[0]);
        yValue.setText("Y Value: "+ sensorEvent.values[1]);
        zValue.setText("Z Value: "+ sensorEvent.values[2]);

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
