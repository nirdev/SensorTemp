package example.com.sensortemp.sensorRecorder;

import android.app.IntentService;
import android.app.Service;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorManager;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 */
public class AccelerometerRecorder extends BaseSensorRecorder {


    private AccelerometerRecorder(Context context, Service service) {
        super(context, service);
    }

    @Override
    public void onServiceStart(SensorManager senSensorManager) {

    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onServiceStop() {

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
