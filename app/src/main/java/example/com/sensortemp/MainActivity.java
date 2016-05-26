package example.com.sensortemp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import example.com.sensortemp.services.servicesImpl.SensorRecorderService;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void startPlayer(View v) {
        Intent start = new Intent(this, SensorRecorderService.class);
        startService(start);
    }

    public void stopPlayer(View v) {
        Intent stop = new Intent(this, SensorRecorderService.class);
        stopService(stop);
    }
}


