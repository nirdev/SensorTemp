package example.com.sensortemp;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class SensorRecorderService extends Service implements SensorEventListener {

    private boolean isPlaying = false;
    Context mContext = null;

    public SensorRecorderService() {
        super();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mContext = getApplicationContext();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        play();
        return START_NOT_STICKY;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor mySensor = event.sensor;
        if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            onSensorChanged(mySensor);
        }
    }

    public void onSensorChanged(Sensor sensor) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    private void play() {
        if (!isPlaying) {
            isPlaying = true;

            Intent i = new Intent(this, MainActivity.class);
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |
                    Intent.FLAG_ACTIVITY_SINGLE_TOP);
            PendingIntent pi = PendingIntent.getActivity(this, 0,
                    i, 0);
            Notification note = new Notification.Builder(mContext)
                    .setContentTitle("ContentTitle")
                    .setContentText("ContentText")
                    .setContentIntent(pi)
                    .setSmallIcon(R.drawable.ic_launcher)
                    .build();

            startForeground(1337, note);
        }
    }

    @Override
    public void onDestroy() {
        stop();
        super.onDestroy();
    }

    private void stop() {

    }
}
