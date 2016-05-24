package example.com.sensortemp.services;

import android.app.Service;
import android.hardware.SensorManager;

/**
 * Create sensor listeners as observers inside a service.
 */
public abstract class serviceListener {

    protected Service observedService;
    protected abstract void onServiceStart(SensorManager senSensorManager);
    protected abstract void onServiceStop();
}
