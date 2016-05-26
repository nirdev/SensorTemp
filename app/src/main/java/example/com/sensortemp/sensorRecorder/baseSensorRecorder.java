package example.com.sensortemp.sensorRecorder;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

import example.com.sensortemp.services.ServiceObserver;

/**
 * Base class for sensor recorders
 */
public abstract class BaseSensorRecorder extends ServiceObserver implements SensorEventListener {

    protected Context context;
    protected SensorManager sensorManager;

    protected BaseSensorRecorder(Context context) {
        this.context = context;
        sensorManager = (SensorManager) context.getSystemService(Context.SENSOR_SERVICE);
        onServiceStart(sensorManager);
    }

    /**
     * register to desired sensor here via {@link SensorManager}
     */
    public abstract void onServiceStart(SensorManager sensorManager);

    /**
     * get sensor events here - for specific sensor data {@link SensorEvent}
     */
    @Override
    public abstract void onSensorChanged(SensorEvent event);

    /**
     * unregister client's desired listener (@nullable)
     */
    @Override
    public void onServiceStop(){
        sensorManager.unregisterListener(this);
    }

    @Override
    public abstract void onAccuracyChanged(Sensor sensor, int accuracy);


}
