package example.com.sensortemp.services;

import android.app.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nir on 5/24/2016.
 */
public abstract class ServiceObservable extends Service {

    private List<ServiceObserver> observers = new ArrayList<>();

    public void attach(ServiceObserver observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for (ServiceObserver observer : observers) {
            observer.onServiceStop();
        }
    }

}
