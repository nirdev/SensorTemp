package example.com.sensortemp.services;

/**
 * Create sensor listeners as observers inside a service.
 */
public abstract class ServiceObserver {

    protected abstract void onServiceStop();
}
