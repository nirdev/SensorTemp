package example.com.sensortemp.sensorRecorder.impl;

import android.app.IntentService;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;
import android.util.Log;

import example.com.sensortemp.sensorRecorder.BaseSensorRecorder;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 */
public class AccelerometerRecorder extends BaseSensorRecorder {

    Sensor senAccelerometer;

    public AccelerometerRecorder(Context context) {
        super(context);
    }

    @Override
    public void onServiceStart(SensorManager sensorManager) {
        //Register to sensor system ACCELEROMETER listener
        senAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorManager.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor mySensor = event.sensor;
        if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            Log.wtf("here", "z: " + z);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

//    private void play() {
//        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
//        senAccelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
//        sensorManager.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
//    }
//
//    @Override
//    public void onSensorChanged(SensorEvent event) {
//        Sensor mySensor = event.sensor;
//
//        if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
//            float x = event.values[0];
//            float y = event.values[1];
//            float z = event.values[2];
//        }
//    }
//
//
//    @Override
//    public void onAccuracyChanged(Sensor sensor, int accuracy) {
//
//    }
//
//
//    private void stop() {
//
//    }
}
