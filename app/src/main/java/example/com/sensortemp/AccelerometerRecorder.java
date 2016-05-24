package example.com.sensortemp;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;


/**
 * An {@link IntentService} subclass for handling asynchronous task requests in
 * a service on a separate handler thread.
 */
public class AccelerometerRecorder extends Service implements SensorEventListener {

    private boolean isPlaying = false;

    private SensorManager senSensorManager;
    private Sensor senAccelerometer;
    Context mContext = null;

    public AccelerometerRecorder() {
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
        senSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        senAccelerometer = senSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        senSensorManager.registerListener(this, senAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        Log.wtf("here", "flags" + flags);
        play();

        return START_NOT_STICKY;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Sensor mySensor = event.sensor;

        if (mySensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0];
            float y = event.values[1];
            float z = event.values[2];
            Log.wtf("here", " x: " + x + " y: " + y + " z: " + z);
        }
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
//            Notification note=new Notification(R.drawable.stat_notify_chat,
//                    "Can you hear the music?",
//                    System.currentTimeMillis());
//
//            note.setLatestEventInfo(this, "Fake Player",
//                    "Now Playing: \"Ummmm, Nothing\"",
//                    pi);
//            note.flags|=Notification.FLAG_NO_CLEAR;
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
